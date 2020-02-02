package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class CallCode extends ByteCode {

    private String arg;
    private int address;

    @Override
    public void evluate(VirtualMachine vm) {
        vm.push_returnAddrs(vm.getPC());
        vm.setPC(address);
    }

    @Override
    public void setArg(ArrayList args) {
        this.arg = (String) args.get(0);
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public String getArgs() {
        return arg;
    }

    public void setArgs(String label) {
        this.arg = label;
    }

    @Override
    public String toString() {
        return "CALL " + this.arg;
    }
}

