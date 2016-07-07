/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author f_desgr
 */
public class TeamLeader extends ProductionWorker{
    
    protected double monthlyBonus;
    
    protected int requiredTrainingHours;
    
    protected int attendedTrainingHours;
    
    public TeamLeader(String name, String number, String hireDate, int shift, double hourlyPayRate, double monthlyBonus, int requiredTrainingHours, int attendedTrainingHours) {
        super(name, number, hireDate, shift, hourlyPayRate);
        this.monthlyBonus = monthlyBonus;
        this.requiredTrainingHours = requiredTrainingHours;
        this.attendedTrainingHours = attendedTrainingHours;
    }
    
    /**
     * get team leader's monthly bonus
     * @return monthly bonus
     */
    public double getMonthlyBonus(){
        return monthlyBonus;
    }
    
    /**
     * set team leader's monthly bonus
     * @param monthlyBonus monthly bonus
     */
    public void setMonthlyBonus(double monthlyBonus){
        this.monthlyBonus = monthlyBonus;
    }
    
    /**
     * get team leader's required training hours
     * @return required training hours
     */
    public int getRequredTrainingHours(){
        return requiredTrainingHours;
    }
    
    /**
     * set team leader's required training hours
     * @param requiredTrainingHours required training hours
     */
    public void setRequredTrainingHours(int requiredTrainingHours){
        this.requiredTrainingHours = requiredTrainingHours;
    }
    
    /**
     * get team leader's attended training hours
     * @return attended training hours
     */
    public int getAttendedTrainingHours(){
        return attendedTrainingHours;
    }
    
    /**
     * set team leader's attended training hours
     * @param attendedTrainingHours attended training hours
     */
    public void setAttendedTrainingHours(int attendedTrainingHours){
        this.attendedTrainingHours = attendedTrainingHours;
    }
    
    public String toString(){
        return super.toString()+"\n\tMonthly bonus: "+monthlyBonus+"\n\tRequired training hours: "+requiredTrainingHours+"\n\tAttended training hours: "+attendedTrainingHours;
    }
}
