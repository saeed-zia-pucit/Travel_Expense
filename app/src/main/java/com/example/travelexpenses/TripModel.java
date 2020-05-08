package com.example.travelexpenses;

public class TripModel {
    String trip_name,mem1,mem2,trip_detail;
    int exp1,exp2;


    public void setExp1(int exp1) {
        this.exp1 = exp1;
    }

    public void setExp2(int exp2) {
        this.exp2 = exp2;
    }

    public TripModel(String trip_name, String trip_detail, String mem1, String mem2, int exp1, int exp2) {
        this.trip_name = trip_name;
        this.mem1 = mem1;
        this.mem2 = mem2;
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.trip_detail=trip_detail;

    }

    public String getTrip_name() {
        return trip_name;
    }

    public String getMem1() {
        return mem1;
    }

    public String getMem2() {
        return mem2;
    }

    public int getExp1() {
        return exp1;
    }

    public int getExp2() {
        return exp2;
    }
    public String getTrip_detail() {
        return trip_detail;
    }

    public void setTrip_detail(String trip_detail) {
        this.trip_detail = trip_detail;
    }

}
