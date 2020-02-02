package interpreter;

import interpreter.bytecode.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;

    private static HashMap<String, Integer> branchAddressMap = new HashMap<String, Integer>();

    public Program(){
        program = new ArrayList<>();
    }

    public void addCode(ByteCode byteCode){
        //check if is a branch type
        if(byteCode instanceof LabelCode){
            LabelCode labelBranch = (LabelCode)byteCode;
            branchAddressMap.put(labelBranch.getArg(), program.size());
        }
        program.add(byteCode);
    }

    protected ByteCode getCode(int pc){
        return this.program.get(pc);
    }

    public int getSize(){
        return this.program.size();
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs(Program program){

        for(int i = 0; i < program.getSize(); i++){
            if (program.getCode(i) instanceof FalseBranchCode) {
                FalseBranchCode false_branch_code = (FalseBranchCode) program.getCode(i);
                false_branch_code.setAddress(branchAddressMap.get(false_branch_code.getArg()));
            } else if (program.getCode(i) instanceof GotoCode) {
                GotoCode goto_code = (GotoCode) program.getCode(i);
                goto_code.setAddress(branchAddressMap.get(goto_code.getArg()));
            } else if (program.getCode(i) instanceof CallCode) {
                CallCode call_code = (CallCode) program.getCode(i);
                call_code.setAddress(branchAddressMap.get(call_code.getArgs()));
            }
        }
    }
}

