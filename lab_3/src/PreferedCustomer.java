/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author f_desgr
 */
public class PreferedCustomer extends Customer{
    private double moneySpent = 0;
    private double discountLevel = 0;
    
    /**
     * default constructor
     */
    public PreferedCustomer(){
        super();
    }
    
    /**
     * Constructor to set without moneySpent
     * @param name customer name
     * @param address customer address
     * @param telNumber telephone number
     */
    public PreferedCustomer(String name, String address, String telNumber) {
        super(name, address, telNumber);
    }
    
    /**
     * Constructor with money spent
     * @param name name
     * @param address address
     * @param telNumber telephone number
     * @param moneySpent  money spent
     */
    public PreferedCustomer(String name ,String address, String telNumber, double moneySpent){
        super(name,address, telNumber);
        this.moneySpent = moneySpent;
    }
    
    /**
     * Setter for money spent
     * @param moneySpent money spent
     */
    public void setMoneySpent(double moneySpent){
        this.moneySpent = moneySpent;
        calcDiscount();
    }
    
    /**
     * Add to money spent
     * @param money money to add
     */
    public void addMoneySpent(double money){
        moneySpent+= money;
        calcDiscount();
    }
    
    /**
     * Get money spent
     * @return money spent
     */
    public double getMoneySpent(){
        return moneySpent;
    }
    
    /**
     * Get discount level
     * @return 
     */
    public double getDiscountLevel(){
        return discountLevel;
    }
    
    private void calcDiscount(){
        if(moneySpent > 2000)
            discountLevel = 0.1;
        else if(moneySpent > 1500)
            discountLevel = 0.07;
        else if(moneySpent > 1000)
            discountLevel = 0.06;
        else if(moneySpent > 500)
            discountLevel = 0.05;
        else 
            discountLevel = 0;
    }
}
