package com.designpattern.techgranth.chainofresponsibilitydesignpattern;

public class HiringManager extends Managers {

    public HiringManager(int approvalLimit,String managerName) {
        this.approvalLimit = approvalLimit;
        this.managerName = managerName;
    }

    @Override
    protected void processSalary(int employeeSalary) {
        System.out.println(this.managerName+ " has approved the salary at level 1, for salary amount "+employeeSalary );
    }
}
