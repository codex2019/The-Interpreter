package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class BopCode extends ByteCode {
    private String operator;

    @Override
    public void evluate(VirtualMachine vm) {
        int operand1=vm.pop_runStack();
        int operand2=vm.pop_runStack();

        switch(operator){
            case "*":
                vm.push_runStack(operand2*operand1);
                break;
            case "/":
                vm.push_runStack(operand2/operand1);
                break;
            case "+":
                vm.push_runStack(operand2+operand1);
                break;
            case "-":
                vm.push_runStack(operand2-operand1);
                break;
            case "|":
                if(operand2 ==0 && operand1==0)
                    vm.push_runStack(0);
                else
                    vm.push_runStack(1);
                break;
            case "&":
                if(operand2 ==0 && operand1==0)
                    vm.push_runStack(0);
                else
                    vm.push_runStack(1);
                break;
            case "==":
                if(operand2 == operand1)
                    vm.push_runStack(1);
                else
                    vm.push_runStack(0);
                break;
            case "!=":
                if(operand2 != operand1)
                    vm.push_runStack(1);
                else
                    vm.push_runStack(0);
                break;
            case "<":
                if(operand2 < operand1)
                    vm.push_runStack(1);
                else
                    vm.push_runStack(0);
                break;
            case ">":
                if(operand2 > operand1)
                    vm.push_runStack(1);
                else
                    vm.push_runStack(0);
                break;
            case "<=":
                if(operand2 <= operand1)
                    vm.push_runStack(1);
                else
                    vm.push_runStack(0);
                break;
            case ">=":
                if(operand2 >= operand1)
                    vm.push_runStack(1);
                else
                    vm.push_runStack(0);
                break;
            default:
                break;
        }
    }

    @Override
    public void setArg(ArrayList args) {
        operator = (String) args.get(0);
    }

    @Override
    public String toString() {
        return "BOP " + operator;
    }
}

