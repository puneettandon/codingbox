package com.lld.expenesharing.main.model;

import java.util.ArrayList;
import java.util.List;

public class UserShare {

    private String userId;
    private double share;
    List<Contribution> contributions;

    public UserShare(String userId, double share) {
        this.userId = userId;
        this.share = share;
        contributions = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public double getShare() {
        return share;
    }

    public List<Contribution> getContributions() {
        return contributions;
    }
}
