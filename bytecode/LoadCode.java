package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class LoadCode extends ByteCode {
    private String id;
    private int arg;

    @Override
    public void evluate(VirtualMachine vm) {
        vm.load_runStack(arg);
    }

    @Override
    public void setArg(ArrayList args) {
        this.arg = Integer.parseInt((String)args.get(0));
        id = (String)args.get(1);
    }

    @Override
    public String toString() {
        return "LOAD " + this.arg + " " + id;
    }
}