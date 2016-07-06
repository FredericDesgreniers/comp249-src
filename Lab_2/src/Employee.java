/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  base employe class
 * @author f_desgr
 */
public class Employee { 
    /**
     * Employee name
     */
    protected String name;
    /**
     * Employee number
     * Format: XXX-L X = number, L = letter A-M
     */
    protected String number;
    /**
     * Employee hire date
     */
    protected String hireDate;
    
    public Employee(String name, String number, String hireDate){
        this.name = name;
        this.number = number;
        this.hireDate = hireDate;
    }
    /**
     * get employee name
     * @return employee name
     */
    public String getName(){
        return name;
    }
    /**
     * set employee name
     * @param name Employee name
     * 
     */
    
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * get employee number
     * @return employee number
     */
    public String getNumber(){
        return number;
    }
    
    /**
     * set employee number
     * @param number  employee number
     */
    public void setNumber(String number){
        this.number = number;
    }
    
    /**
     * get hire date
     * @return hire date
     */
    public String getHireDate(){
        return hireDate;
    }
    
    /**
     * set hire date
     * @param hireDate hire date
     */
    public void setHireDate(String hireDate){
        this.hireDate = hireDate;
    }
    
    public String toString(){
        return name+": \n\tNumber: "+number+"\n\tHire date: "+hireDate;
    }
}
