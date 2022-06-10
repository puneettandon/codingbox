package com.lld.movieticketbooking.tdd.test;


import com.lld.movieticketbooking.tdd.src.MyScreen;
import com.lld.movieticketbooking.tdd.src.MySeat;
import com.lld.movieticketbooking.tdd.src.MyTheatre;
import com.lld.movieticketbooking.tdd.src.MyTheatreService;

import java.util.HashMap;

public class BaseTest {

    static String theatreId = "111";
    static String theatreName = "Ajooba";
    static MyTheatre expectedMyTheatre = new MyTheatre(theatreId,theatreName);

    static HashMap<String, MyTheatre> theatres = new HashMap<>();
    static HashMap<String, MyScreen> screens = new HashMap<>();
    private static HashMap<String, MySeat> seats;
    static MyTheatreService mts = new MyTheatreService(theatres, screens, seats);

    static {
        MyTheatre t1 = new MyTheatre(theatreId,theatreName);
        MyTheatre t2 = new MyTheatre(theatreId,theatreName);

        MyScreen s1 = new MyScreen("1","screen1",t1);
        MyScreen s2 = new MyScreen("2","screen2",t1);
        MyScreen s3 = new MyScreen("3","screen3",t2);

        MySeat seat1 = new MySeat("300","1","1");
        MySeat seat2 = new MySeat("301","1","2");
        MySeat seat3 = new MySeat("302","2","1");
        MySeat seat4 = new MySeat("303","3","1");

        theatres.put("111",t1);
        theatres.put("112",t2);

        screens.put("1",s1);
        screens.put("2",s2);
        screens.put("3",s3);

        seats.put("300",seat1);
        seats.put("301",seat2);
        seats.put("302",seat3);
        seats.put("303",seat4);
    }

    public static void main(String[] args) {
        shouldCreateTheatre();
        shouldGetTheatre();
       shouldCreateScreenInTheatre();
        shouldGetScreen();
        shouldCreateSeatInScreen();
    }

    // should create Theatre
    public static void shouldCreateTheatre(){
        System.out.println("shouldCreateTheatre Test.....");
        // given
        String expectedTheatreId = "111";
        String theatreName = "Ajooba";
        // when
        String actualTheatreId = mts.createTheatre(theatreName).getTheatreId();
        // then
        System.out.println(expectedTheatreId.equals(actualTheatreId));
    }

    public static void shouldGetTheatre(){
        System.out.println("shouldGetTheatre Test.....");
        // given
        String theatreId1 = "112";

        //when
        MyTheatre myTheatre = mts.getTheatre(theatreId);

        // then
        System.out.println(expectedMyTheatre.getTheatreId().equals(myTheatre.getTheatreId()));
        System.out.println(expectedMyTheatre.getTheatreName().equals(myTheatre.getTheatreName()));
        System.out.println(expectedMyTheatre.getTheatreId().equals(myTheatre.getTheatreId()));
    }

    public static void shouldCreateScreenInTheatre(){
        System.out.println("shouldCreateScreenInTheatre Test.....");
        // Given
        String screenName = "screen1";
        String theatreId = "111";
        String theatreName = "Ajooba";
        String expectedScreenId = "222";
        // when
        MyTheatre myTheatre = new MyTheatre(theatreId,theatreName);
        String actualScreenId = mts.createScreenInTheatre(screenName,myTheatre).getScreenId();
        // then
        System.out.println(expectedScreenId.equals(actualScreenId));
    }

    public static void shouldGetScreen(){
        System.out.println("shouldGetScreen Test.....");
        // Given
        String screenId = "1";
        String screenName = "screen1";
        MyScreen expectedScreen = new MyScreen(screenId,screenName,expectedMyTheatre);
        // when
        MyScreen actualScreen = mts.getScreen(screenId);
        // then
        System.out.println(expectedScreen.getScreenId().equals(actualScreen.getScreenId()));
        System.out.println(expectedScreen.getScreenName().equals(actualScreen.getScreenName()));
    }

    public static void shouldCreateSeatInScreen(){
        System.out.println("shouldCreateSeatInScreen Test.....");
        // given
        String rowNo = "1";
        String seatNo = "100";
        String screenId = "1";

        String expectedSeatId = "300";
        MyScreen myScreen = new MyScreen(screenId,"screen1",expectedMyTheatre);

        // when
        String actualSeatId = mts.createSeatInScreen(rowNo,seatNo,myScreen).getSeatId();

        // then

        System.out.println(expectedSeatId.equals(actualSeatId));
    }


}
