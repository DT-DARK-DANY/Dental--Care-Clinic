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
public class name_Person  {
    
   private String Number,Name,PhoneNum,Address,JOB,Age;

      public name_Person() {
        
        
    }
      public name_Person(String Number,String Name, String PhoneNum, String Address, String JOB, String Age) {
                  this.Number=Number;
        this.Name=Name;
        this.PhoneNum=PhoneNum;
        this.Address=Address;
        this.JOB=JOB;
        this.Age=Age;
        
    }
   
      public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }


 public void setPhoneNum(String Phonenum){
     this.PhoneNum=Phonenum;
 }
 public String getPhoneNum(){
     return PhoneNum;
 }
    

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getJOB() {
        return JOB;
    }

    public void setJOB(String JOB) {
        this.JOB = JOB;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String Age) {
        this.Age = Age;
    }
}


