package com.concurrency.problemstatement1;

import com.concurrency.problemstatement1.solution.Printer;
import com.concurrency.problemstatement1.solution.PrinterType;
import com.concurrency.problemstatement1.solution.State;

public class Main {

    public static void main(String[] args) {
        final State state = new State(PrinterType.ODD);
        final Printer oddPrinter = new Printer(1,2,state,PrinterType.ODD,PrinterType.EVEN,10);
        final Printer evenPrinter = new Printer(2,2,state,PrinterType.EVEN,PrinterType.ODD,10);

        final Thread oddThread = new Thread(oddPrinter);
        final Thread evenThread = new Thread(evenPrinter);

        oddThread.start();
        evenThread.start();
    }

}
