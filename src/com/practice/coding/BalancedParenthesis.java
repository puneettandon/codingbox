package com.practice.coding;

import java.util.Stack;

public class BalancedParenthesis {

    public static void main(String[] args) {

        String str = "{()}]";
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < str.length();i++){
            char ch = str.charAt(i);
            if(st.empty()){
                st.push(ch);
            }else if(ch == '{' || ch == '(' || ch == '['){
                st.push(ch);
            }else if(ch == '}' && st.peek() == '{'){
                st.pop();
            }else if(ch == ')' && st.peek() == '('){
                st.pop();
            }else if(ch == ']' && st.peek() == '['){
                st.pop();
            }
        }
        if(st.empty()){
            System.out.println("Given string is well formed");
        }else{
            System.out.println("Given string is not well formed");
        }

        balancedParenthesisPr();
    }

    private static void balancedParenthesisPr() {

        String str = "[[{abcd}]]";

        Stack<Character> stack = new Stack();

        for(int i = 0;i < str.length();i++){
            char ch = str.charAt(i);
            if(stack.empty()) stack.push(ch);
            else if(ch == '{' || ch =='[' || ch == '(') stack.push(ch);
            else if(ch == '}' && stack.peek() == '{')  stack.pop();
            else if(ch == ']' && stack.peek() == '[')  stack.pop();
            else if(ch == ')' && stack.peek() == '(')  stack.pop();
        }
        if(stack.empty())
            System.out.println("Parenthesis are balanced");
        else
            System.out.println("Parenthesis are not balanced");

    }
}
