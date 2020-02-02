package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class LabelCode extends ByteCode {

    private String arg;

    @Override
    public void evluate(VirtualMachine vm) {
    }

    @Override
    public void setArg(ArrayList args) {
        this.arg = (String)args.get(0);
    }

    public String getArg() {
        return arg;
    }

    @Override
    public String toString() {
        return "LABEL " + this.arg;
    }
}