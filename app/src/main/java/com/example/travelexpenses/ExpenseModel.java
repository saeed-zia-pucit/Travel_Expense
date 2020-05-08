package com.example.travelexpenses;

public class ExpenseModel {
    String trip_name,category,exp1,exp2;

    public ExpenseModel(String trip_name, String category, String exp1, String exp2) {
        this.trip_name = trip_name;
        this.category = category;
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    public String getTrip_name() {
        return trip_name;
    }

    public void setTrip_name(String trip_name) {
        this.trip_name = trip_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getExp1() {
        return exp1;
    }

    public void setExp1(String exp1) {
        this.exp1 = exp1;
    }

    public String getExp2() {
        return exp2;
    }

    public void setExp2(String exp2) {
        this.exp2 = exp2;
    }
}
