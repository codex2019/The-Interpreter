package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public abstract class ByteCode {
    //evluates byteCode
    public abstract void evluate(VirtualMachine vm);
    //Set data field
    public abstract void setArg(ArrayList args);
}


