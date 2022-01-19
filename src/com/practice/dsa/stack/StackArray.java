package com.practice.dsa.stack;

public class StackArray {

    int capacity;
    int top;
    int arr[];

    StackArray(int size){
        capacity = size;
        arr= new int[size];
        top =-1;
    }

    boolean isFull(){
        return top == capacity -1;
    }

    boolean isEmpty(){
        return top < 0;
    }

    void push(int data){
        if(isFull()){
            System.out.println("Stack overflow");
        }
        else {
            arr[++top] = data;
        }
    }

    int pop(){
        if(isEmpty()){
            System.out.println("Stack underflow");
            return  0;
        }
        else return arr[top--];
    }

    int peek(){
        if(isEmpty()){
            System.out.println("Stack underflow");
            return 0;
        }
        else return arr[top];
    }

    void printStackArray(){
        for(int i = top;i>-1;i--){
            System.out.println(" "+ arr[i]);
        }
    }


    public String infixToPostfix(String exp) {
        String result = "";
        StackArray stackArray = new StackArray(100);

        for(int i = 0;i< exp.length();i++){
            char c = exp.charAt(i);
            if(isOperand(c))
                result = result + c;
            else if(c == '(')
                stackArray.push(c);
            else if(c == ')'){
                while(! stackArray.isEmpty() && stackArray.peek() != '(')
                    result = result + stackArray.pop();
                stackArray.pop();
            }
            else
            {
                while(!stackArray.isEmpty() && precedence(c) <= precedence((char) stackArray.peek())){
                    result += stackArray.pop();
                }
                stackArray.push(c);
            }
        }

        // pop all the element from the stack
        while(!stackArray.isEmpty()){
            if(stackArray.peek() == '(')
                return "Invalid Expression";
            result += stackArray.pop();
        }
        return result;
    }

    private int precedence(char ch) {
        switch (ch){
            case '+' :
            case '-' :
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    private boolean isOperand(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    public String reverseStringUsingStack(String str) {

       StackArray characterStack = new StackArray(str.length());
       String reverseString = "";
       for(int i = 0;i < str.length();i++){
           char c = str.charAt(i);
           characterStack.push(c);
       }
       while(!characterStack.isEmpty()){
           reverseString = reverseString + (char)characterStack.pop();
       }
       return reverseString;
    }

    public void printNextLargerElementArray(int[] arr) {
        if(arr.length == 0)
            return;
        int arrSize = arr.length;
        StackArray integerStack = new StackArray(arrSize);
        integerStack.push(arr[0]);

        for(int i=0;i<arr.length;i++){
            while(!integerStack.isEmpty() && arr[i] > integerStack.peek()){
                integerStack.pop();
                System.out.print(arr[i] + " ");
            }
            integerStack.push(arr[i]);
        }

        while(!integerStack.isEmpty()){
            System.out.println(-1);
            integerStack.pop();
        }
    }


    public static boolean checkIfParenthesisMatching(String delimitercheck) {
        int size = delimitercheck.length();
        StackArray st = new StackArray(size);

        for(int i =0;i<size;i++){
            char ch = delimitercheck.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }else if(ch == ')'){
                    if(st.isEmpty() || st.pop() != '(')
                        return  false;
            }else if(ch == ']'){
                if(st.isEmpty() || st.pop() != '[')
                    return  false;
            }
            else if(ch == '}'){
                if(st.isEmpty() || st.pop() != '{')
                    return  false;
            }
        }
        if(st.isEmpty())
            return true;
        else
            return  false;
    }
}
