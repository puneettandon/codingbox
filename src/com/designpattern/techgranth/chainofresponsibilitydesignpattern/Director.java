package com.designpattern.techgranth.chainofresponsibilitydesignpattern;

public class Director extends Managers {

    public Director(int approvalLimit,String managerName) {
        this.approvalLimit = approvalLimit;
        this.managerName  = managerName;
    }

    @Override
    protected void processSalary(int employeeSalary) {
        System.out.println(this.managerName+ " has approved the salary at level 3, for salary amount "+employeeSalary );
    }
}

