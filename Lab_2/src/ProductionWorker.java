/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author f_desgr
 */
public class ProductionWorker extends Employee{
    
    /**
     * shift
     * day = 1
     * night = 2
     */
    private int shift;
    
    /**
     * Pay rate / hour
     */
    private double hourlyPayRate;
    
    
    public ProductionWorker(String name, String number, String hireDate, int shift, double hourlyPayRate) {
        super(name, number, hireDate);
        this.shift = shift;
        this.hourlyPayRate = hourlyPayRate;
    }
    
    /**
     * Get worker shift
     * 1: day
     * 2: night
     * @return 
     */
    public int getShift(){
        return this.shift;
    }
    
    /**
     * set worker shift
     * 1: day
     * 2: night
     * @param shift 
     */
    public void setShift(int shift){
        this.shift = shift;
    }
   
    /**
     * get worker's hourly rate
     * @return  hourly rate
     */
    public double getHourlyPayRate(){
        return this.hourlyPayRate;
    } 
    
    /**
     * set worker's hourly rate
     * @param hourlyPayRate hourly rate
     */
    public void setHourlyPayRate(double hourlyPayRate){
        this.hourlyPayRate = hourlyPayRate;
    }
    
    public String toString(){
        return super.toString()+"\n\tShift: "+shift+"\n\tHourly pay rate: "+hourlyPayRate;
    }
    
    
}
