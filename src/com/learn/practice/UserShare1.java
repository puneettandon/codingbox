package com.learn.practice;

import java.util.ArrayList;
import java.util.List;

public class UserShare1 {

    private  String userId;
    private double share;
    List<Contribution1> contributions;

    public UserShare1(String userId, double share) {
        this.userId = userId;
        this.share = share;
        contributions = new ArrayList();
    }

    public String getUserId() {
        return userId;
    }

    public double getShare() {
        return share;
    }

    public List<Contribution1> getContributions() {
        return contributions;
    }
}
