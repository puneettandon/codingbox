package com.learn.practice;

import com.lld.expenesharing.main.model.ExpenseGroup;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Set;

public class BillSharing1 {

    static ExpenseService1 expenseService;
    static UserService1 userService;

    public static void main(String[] args) throws ExpenseSettledException1, ContributionExceededException1, InvalidExpenseState1 {

        expenseService = new ExpenseService1();
        userService = new UserService1();

        createTestUsers();

        Expense1 expense = createLunchExpense();

        try{
            bifurcateExpense(expense.getId());
        }  catch (ExpenseDoesNotExistsException1 expenseDoesNotExistsException){
            System.out.println(expenseDoesNotExistsException.getMessage());
        }

        expense.setExpenseStatus(ExpenseStatus1.PENDING);

        Set<User1> users = expense.getExpenseGroup().getGroupMemebers();
        for(User1 user : users){
            contributeToExpense(expense.getId(),user.getEmail());
        }


    }

    private static void contributeToExpense(String expenseId, String email) throws ExpenseSettledException1, ContributionExceededException1, InvalidExpenseState1 {
        Contribution1 contribution1 = new Contribution1();
        Expense1 expense1 = ExpenseRepository1.expenseMap.get(expenseId);
        ExpenseGroup1 expenseGroup1 = expense1.getExpenseGroup();
        UserShare1 userShare1 = expenseGroup1.getUserContributions().get(email);
        contribution1.setContributionValue(userShare1.getShare());
        contribution1.setContributionDate(LocalDate.now());
        contribution1.setTransactionId("T"+ Instant.EPOCH);
        contribution1.setTransactionDescription("Transaction from UPI");
        userService.contributeToExpense(expenseId,email,contribution1);

    }

    private static void bifurcateExpense(String expenseId) throws ExpenseDoesNotExistsException1{

        expenseService.addUsersToExpense(expenseId,"puneet@gmail.com");
        expenseService.addUsersToExpense(expenseId, "neha@gmail.com");
         expenseService.addUsersToExpense(expenseId, "kamal@gmail.com");
          expenseService.addUsersToExpense(expenseId, "jyothi@gmail.com");

          expenseService.assignExpenseShare(expenseId,ExpenseRepository1.expenseMap.get(expenseId).getUserId(),100);
          expenseService.assignExpenseShare(expenseId,"neha@gmail.com",100);
           expenseService.assignExpenseShare(expenseId,"kamal@gmail.com",100);
            expenseService.assignExpenseShare(expenseId,"jyothi@gmail.com",200);

    }

    private static Expense1 createLunchExpense() {
        Expense1 expense = expenseService.createExpense("Team Lunch",
                "Team Lunch Biryani Zone", LocalDateTime.of(2020, Month.APRIL,18,8,0),
                500,"puneet@gmail.com");

        return expense;
    }

    private static void createTestUsers() {
        User1 user1 = userService.createUser("puneet@gmail.com","puneet","98998989899");
        User1 user2 = userService.createUser("ajay@gmail.com", "ajay", "6112482630");
        User1 user3 = userService.createUser("amit@gmail.com", "amit", "2509699232");
        User1 user4 = userService.createUser("kamal@gmail.com", "kamal", "5816355154");
        User1 user5 = userService.createUser("neha@gmail.com", "neha", "7737316054");
        User1 user6 = userService.createUser("kajal@gmail.com", "kajal", "4813053349");
        User1 user7 = userService.createUser("jyothi@gmail.com", "jyothi", "3974178644");
        User1 user8 = userService.createUser("subin@gmail.com", "subin", "4768463294");
        User1 user9 = userService.createUser("deepak@gmail.com", "deepak", "4829338803");
        User1 user10 = userService.createUser("vishnu@gmail.com", "vishnu", "3384071602");
        User1 user11 = userService.createUser("mayank@gmail.com", "mayank", "2376951206");
        User1 user12 = userService.createUser("anu@gmail.com", "anu", "8478577491");
        User1 user13 = userService.createUser("kavya@gmail.com", "kavya", "7505888698");

    }
}
