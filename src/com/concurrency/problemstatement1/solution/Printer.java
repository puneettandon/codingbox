package com.concurrency.problemstatement1.solution;

public class Printer implements Runnable{

    private final int step;
    private final State state;
    private int currentValue;
    private final PrinterType currentPrinterType;
    private final PrinterType nextPrinterType;
    private final int maxValue;

    public Printer(int startValue,int step, State state, PrinterType currentPrinterType, PrinterType nextPrinterType, int maxValue) {
        this.step = step;
        this.state = state;
        this.currentValue = startValue;
        this.currentPrinterType = currentPrinterType;
        this.nextPrinterType = nextPrinterType;
        this.maxValue = maxValue;
    }


    @Override
    public void run() {
        while(currentValue <= maxValue){
            synchronized (state){
                while(this.currentPrinterType != state.getNextToPrint()){
                    try {
                        state.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(currentPrinterType.toString()+ ": "+currentValue);
                currentValue += step;
                state.setNextToPrint(this.nextPrinterType);
                state.notifyAll();
            }
        }
    }
}
