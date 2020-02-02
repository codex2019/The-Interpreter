package interpreter.bytecode;


import interpreter.VirtualMachine;
import java.util.ArrayList;

public class ArgsCode extends ByteCode {

    private int arg;

    @Override
    public void evluate(VirtualMachine vm) {
        vm.set_runStackFrameAt(arg);
    }

    @Override
    public void setArg(ArrayList args) {
        this.arg = Integer.parseInt((String)args.get(0));
    }

    @Override
    public String toString() {
        return "ARGS " + this.arg;
    }
}
