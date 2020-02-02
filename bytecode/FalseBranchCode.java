package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class FalseBranchCode extends ByteCode {

    private String arg;
    private int address;

    @Override
    public void evluate(VirtualMachine vm) {
        if(vm.pop_runStack() == 0)
            vm.setPC(address);
    }

    @Override
    public void setArg(ArrayList args) {
        this.arg = (String)args.get(0);
    }

    public String getArg() {
        return arg;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "FALSEBRANCH " + arg;
    }
}

