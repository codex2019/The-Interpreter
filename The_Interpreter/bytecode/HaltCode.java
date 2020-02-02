package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class HaltCode extends ByteCode {

    @Override
    public void evluate(VirtualMachine vm) {
        vm.setRun(false);
    }

    @Override
    public void setArg(ArrayList args) {}

    @Override
    public String toString() {
        return "HALT";
    }
}


