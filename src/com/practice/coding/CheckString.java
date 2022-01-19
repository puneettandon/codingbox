package com.practice.coding;

public class CheckString {

    public  static final String USER_LEVEL = "ADMIN";

    public static void main(String[] args) {

        String userLevel = getUserLevel();

        checkForNullMethodB(userLevel);
        checkForNullMethodC(userLevel);
        checkForNullMethodA(userLevel);

    }

    private static void checkForNullMethodC(String level) {
        try{
            if(String.valueOf(level).equals(USER_LEVEL)){
                System.out.println("USER LEVEL ADMIN  ....C");
            }
        }catch (NullPointerException nullPointerException){
            System.out.println("Null pointer");
        }
    }


    private static void checkForNullMethodA(String level) {
        try {
            if(level != null && level.equals(USER_LEVEL)){
                System.out.println("USER LEVEL ADMIN....A");
            }
        }catch (NullPointerException nullPointerException){
            System.out.println("Null pointer");
        }
    }

    private static void checkForNullMethodB(String level) {
        try {
            if(USER_LEVEL.equals(level)){
                System.out.println("USER Level admin....B");
            }
        }catch (NullPointerException nullPointerException){
            System.out.println("Null pointer");
        }
    }

    private static String getUserLevel() {
        return  null;
    }


}
