package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode {
    private Scanner input = new Scanner(System.in);

    @Override
    public void evluate(VirtualMachine vm) {
        System.out.print("<Enter a value here>:");
        vm.push_runStack(input.nextInt());
    }

    @Override
    public void setArg(ArrayList args) {}

    @Override
    public String toString() {
        return "READ";
    }
}
