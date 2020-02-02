package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class StoreCode extends ByteCode {
    private String id;
    private int offset;

    @Override
    public void evluate(VirtualMachine vm) {
        vm.store_runStack(offset);
    }

    @Override
    public void setArg(ArrayList args) {
        offset = Integer.parseInt((String)args.get(0));
        id = (String)args.get(1);
    }

    @Override
    public String toString() {
        return "STORE " + offset + " " + id;
    }
}