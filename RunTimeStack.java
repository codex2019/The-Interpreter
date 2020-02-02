package interpreter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class RunTimeStack {

    //Location of Runtime stack
    private ArrayList runTimeStack;

    //Activation record to record each function calls
    private Stack<Integer> framePointer;

    public RunTimeStack(){
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    //Prints the current state of runTimeStack
    public void dump(){

        Iterator it = framePointer.iterator();

        int currFrame = (Integer)it.next();
        int nextFrame = currFrame;

        for (int frameIndex = 0; frameIndex < framePointer.size(); frameIndex++) {

            if (it.hasNext()){
                nextFrame = (Integer) it.next();
            }else{
                nextFrame = runTimeStack.size();
            }

            System.out.print("[");

            for (int i = currFrame; i < nextFrame; i++) {
                System.out.print(runTimeStack.get(i));
                if (i != nextFrame - 1)
                    System.out.print(",");
            }

            System.out.print("]");

            currFrame = nextFrame;
        }

        System.out.println();
    }

    //peek at top of runTimeStack
    public int peek() {
        return (int) runTimeStack.get(runTimeStack.size() - 1);
    }

    //Remove item form top of runTimeStack
    public int pop() {
        int topValue = 0;

        if(!runTimeStack.isEmpty()) {
            topValue = (int) runTimeStack.get(runTimeStack.size() - 1);
            runTimeStack.remove(runTimeStack.size() - 1);
        }
        return topValue;
    }

    /**
     * Creates a new frame for each function call
     * @param offset number of memory slots to be use in RunTimeStack
     */
    public void newFrameAt(int offset) {
        framePointer.push(runTimeStack.size() - offset);
    }

    //Remove the top frame after return function is called
    public void popFrame() {
        //save return value

        int returnValue = (int)runTimeStack.get(runTimeStack.size() - 1);

        while(runTimeStack.size() != framePointer.peek() && !runTimeStack.isEmpty()){
            runTimeStack.remove(runTimeStack.size() - 1);
        }

        if(!framePointer.isEmpty()){
            framePointer.pop();
        }

        runTimeStack.add(returnValue);
    }

    //Stores values into variables
    public int store(int offset){
        int storeValue = (int)runTimeStack.get(runTimeStack.size() - 1);

        if(!runTimeStack.isEmpty()){
            runTimeStack.remove(runTimeStack.size() - 1);
        }

        runTimeStack.set(framePointer.peek() + offset, storeValue);

        return storeValue;
    }

    //Load variables into the RuntimeStack
    public int load(int offset) {

        int loadValue = (int)runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(loadValue);

        return loadValue;
    }

    //Load values into the RuntimeStack
    public Integer push(Integer val) {
        runTimeStack.add(val);
        return val;
    }


}






