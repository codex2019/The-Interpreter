package interpreter;

import interpreter.bytecode.*;
import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean dump;

    protected VirtualMachine(Program program) {
        this.program = program;
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<>();
        isRunning = true;
        dump=true;
    }

    //executes bytescode one at time
    public void executeProgram(){
        while(isRunning){
            ByteCode code = program.getCode(pc);
            code.evluate(this);
            if(dump && !(code instanceof DumpCode)){
                System.out.println(code.toString());
                runStack.dump();
            }
            pc++;
        }
    }

    public void setDumpOn() {
        dump = true;
    }

    public void setDumpOff() {
        dump = false;
    }

    public void setRun(boolean run) {
        isRunning = run;
    }

    public int peek_runStack(){
        return runStack.peek();
    }

    public int pop_runStack(){
        return runStack.pop();
    }

    public void push_runStack(int i) {
        runStack.push(i);
    }

    public void set_runStackFrameAt(int offset) {
        runStack.newFrameAt(offset);
    }

    public void pop_runStackFrame() {
        runStack.popFrame();
    }

    public int store_runStack(int offset) {
        return runStack.store(offset);
    }

    public int load_runStack(int offset) {
        return runStack.load(offset);
    }

    public int pop_returnAddrs() {
        return (int) returnAddrs.pop();
    }

    public void push_returnAddrs(int i) {
        returnAddrs.push(i);
    }

    public int getPC() {
        return pc;
    }

    public void setPC(int pc) {
        this.pc = pc;
    }
}


