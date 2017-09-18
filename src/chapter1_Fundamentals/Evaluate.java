package chapter1_Fundamentals;

import java.util.Scanner;
import java.util.Stack;

import edu.princeton.cs.algs4.StdIn;

/**
 * DijkstraË«Õ»ÇóÖµËã·¨
 * @author Administrator
 *
 */
public class Evaluate {
    public static void main(String[] args) {
        //cretate two statcks,one to save the operator,another to save the value
        Stack<String > operator = new Stack<>();
        Stack<Double> value = new Stack<>();
        //a stack to save the parenthesis
        Stack<String> parenthesis = new Stack<>();
        //input the expresstion from keyboard and compute the value of the expression
        Scanner input = new Scanner(System.in);
        System.out.print("Please the enter the expression that you want to compute:");
        String expression = input.next();
        for(int i = 0; i < expression.length(); i++) {
            String s = expression.substring(i,i+1);
            //judge what you input
            if(s.equals("("))
                parenthesis.push(s);//ignore the left parenthesis
            else if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt"))
                operator.push(s);//if s is the operator,then push it to th stack of operator
            else if(s.equals(")")) {// is the right parenthesis
                //pop the left parenthesis from the parenthesis stack
                parenthesis.pop();
                //pop a operator from the stack of operator
                String opr = operator.pop();
                //then pop the Operand from the stack of value according to the operator
                double val = value.pop();
                switch(opr) {
                    case "+":
                        val += value.pop();
                        break;
                    case "-":
                        val -= value.pop();
                        break;
                    case "*":
                        val *= value.pop();
                        break;
                    case "/":
                        val /= value.pop();
                        break;
                    case "sqrt":
                        val = Math.sqrt(val);
                        break;
                    default:
                        break;
                }
                value.push(val);//push the result to the value stack
            }
            else 
                try {
                    value.push(Double.parseDouble(s));//push the number to the value stack
                }catch(Exception e) {
                    e.printStackTrace();
                }
        }
        if(parenthesis.isEmpty() && value.size() == 1) //is the parenthsis stack empty
            System.out.println("The value of the expression is:" + value.pop() );
        else//parentheses do not match
            System.out.println("The expression is illegal");
    }
}
