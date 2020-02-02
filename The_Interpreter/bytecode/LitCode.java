package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class LitCode extends ByteCode {
    private int arg;
    private String id;

    @Override
    public void evluate(VirtualMachine vm) {
        vm.push_runStack(arg);
    }

    @Override
    public void setArg(ArrayList args) {

        this.arg = Integer.parseInt((String)args.get(0));

        if(args.size() > 1){
            id = (String) args.get(1);
        }
    }

    public int getArg() {
        return arg;
    }

    public String getID() {
        return id;
    }

    @Override
    public String toString() {
        return "LIT " + arg + " " + id;
    }
}


