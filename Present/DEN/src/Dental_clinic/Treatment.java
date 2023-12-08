/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dental_clinic;

/**
 *
 * @author damod
 */
public class Treatment {
     private String Number,Name_Treatment,Time;
      public Treatment(String Number,String Name_Treatment, String Time) {
                  this.Number=Number;
                  this.Name_Treatment=Name_Treatment;
                  this.Time=Time;               
    }

    Treatment() {
    }
       public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }
    public void setName_Treatment(String Name_Treatment){
        this.Name_Treatment=Name_Treatment;        
    }
    public String getName_Treatment(){
        return Name_Treatment;
    }
    public void setTime(String Time){
        this.Time=Time;
    }
    public String getTime(){
        return this.Time;
    }
}
