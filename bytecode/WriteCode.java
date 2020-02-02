package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class WriteCode extends ByteCode {

    @Override
    public void evluate(VirtualMachine vm) {
        System.out.println(vm.peek_runStack());
    }

    @Override
    public void setArg(ArrayList args) {}

    @Override
    public String toString() {
        return "WRITE";
    }
}
