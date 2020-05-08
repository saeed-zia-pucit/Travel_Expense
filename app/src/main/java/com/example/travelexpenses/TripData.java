package com.example.travelexpenses;

import java.util.ArrayList;

public class TripData {
  static  ArrayList<TripModel> trip_list=new ArrayList<>();
  static  ArrayList<ExpenseModel>expense_list=new ArrayList<>();

    public static ArrayList<ExpenseModel> getExpense_list() {
        return expense_list;
    }

    public static void setExpense_list(ArrayList<ExpenseModel> expense_list) {
        TripData.expense_list = expense_list;
    }

    //    public TripData(ArrayList<TripModel> trip_list) {
//        this.trip_list = trip_list;
//    }
public  ArrayList<String>getTripNames(){
    ArrayList<String> names=new ArrayList<String>();
    for(TripModel tripModel: trip_list){
        names.add(tripModel.trip_name);
    }
    return names;
}

    public ArrayList<TripModel> getTrip_list()
    {
        return trip_list;
    }

    public  void add_trip(TripModel tripModel){

        for(TripModel tripModel1: trip_list){
          if(tripModel.getTrip_name().equals(tripModel1.getTrip_name())){
              return;
          }

        }

        trip_list.add(tripModel);
    }
    public  void add_expense(ExpenseModel expenseModel){
        expense_list.add(expenseModel);
    }
    public void saveDeposit(ExpenseModel expenseModel){
        for(ExpenseModel expense :expense_list){
            if(expense.trip_name.equals(expenseModel.getTrip_name())&& expense.category.equals(expenseModel.category)){
               int e1=Integer.parseInt(expense.exp1)-Integer.parseInt(expenseModel.exp1);
               int e2=Integer.parseInt(expense.exp2)-Integer.parseInt(expenseModel.exp2);
                expense.setExp1(e1+"");
               expense.setExp2(e2+"");
                break;

            }
        }
    }
}
