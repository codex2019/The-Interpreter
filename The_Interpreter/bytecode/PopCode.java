package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class PopCode extends ByteCode {
    
    private int numOfOperand;

    @Override
    public void evluate(VirtualMachine vm) {

        for(int i = 0; i < numOfOperand; i++){
            vm.pop_runStack();
        }
    }

    @Override
    public void setArg(ArrayList args) {
        numOfOperand = Integer.parseInt((String)args.get(0));
    }

    @Override
    public String toString() {
        return "POP " + numOfOperand;
    }
}
