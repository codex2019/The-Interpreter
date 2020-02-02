package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class ReturnCode extends ByteCode {
    private String function;
    private int returnValue;

    @Override
    public void evluate(VirtualMachine vm) {
        vm.pop_runStackFrame();
        vm.setPC(vm.pop_returnAddrs());
        returnValue = vm.peek_runStack();
    }

    @Override
    public void setArg(ArrayList args) {
        if(!args.isEmpty()){
            function = (String)args.get(0);
        }
    }

    @Override
    public String toString() {
        return "RETURN " + function;
    }
}