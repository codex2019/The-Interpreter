package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class GotoCode extends ByteCode {

    private String arg;
    private int address;

    @Override
    public void evluate(VirtualMachine vm) {
        vm.setPC(address);
    }

    @Override
    public void setArg(ArrayList args) {
        this.arg = (String)args.get(0);
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public String getArg() {
        return arg;
    }

    @Override
    public String toString() {
        return "GOTO " + this.arg;
    }
}

