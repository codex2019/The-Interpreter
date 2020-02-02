package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class DumpCode extends ByteCode {

    private String dumpStatus;

    @Override
    public void evluate(VirtualMachine vm) {
        if("ON".equals(dumpStatus))
            vm.setDumpOn();
        else
            vm.setDumpOff();
    }

    @Override
    public void setArg(ArrayList args) {
        dumpStatus = (String)args.get(0);
    }

}