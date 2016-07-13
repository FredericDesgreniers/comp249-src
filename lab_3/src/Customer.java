/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author f_desgr
 */
public class Customer extends Person{
    private boolean onMailingList = false;

    /**
     * Default customer
     */
    public Customer(){
        super();
    }
    
    /**
     * Constructor without mailing list
     * @param name name
     * @param address address
     * @param telNumber  telNumber
     */
    public Customer(String name, String address, String telNumber){
        super(name, address, telNumber);
    }
    
    /**
     * Constructor with mailing list
     * @param name name 
     * @param address address
     * @param telNumber telephone number
     * @param mailingList  should be on mailing list
     */
    public Customer(String name, String address, String telNumber, boolean mailingList){
        super(name, address, telNumber);
        this.onMailingList = mailingList;
    }
    /**
     * Get is on mailing list
     * @return is on mailing list
     */
    public boolean isOnMaillingList(){
        return onMailingList;
    }
    /**
     * Set on mailing list
     * @param mailingList should be on mailing list
     */
    public void setOnMailingList(boolean mailingList){
        this.onMailingList = mailingList;
    }
    
}
