/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author f_desgr
 */
public class Person {
    private String name;
    private String address;
    private String telNumber;
    
    /**
     * default constructor
     */
    public Person(){
        this("John Doe", "n/a", "n/a");
    }
    
    /**
     * Constructor with arguments
     * @param name person name
     * @param address address
     * @param telNumber telephone number
     */
    public Person(String name, String address, String telNumber){
        this.name = name;
        this.address = address;
        this.telNumber  = telNumber;
              
    }
    
    /**
     * Get person name
     * @return name
     */
    public String getName(){
        return this.name; 
    }
    /**
     * Set person name
     * @param name person name
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Get address
     * @return address
     */
    public String getAddress(){
        return this.address;
    }
    /**
     * Set address
     * @param address address 
     */
    public void setAddress(String address){
        this.address = address;
    }
    
    /**
     * Get telephone number
     * @return telephone number
     */
    public String getTelNumber(){
        return this.telNumber;
    }
    /**
     * Set telephone number
     * @param telNumber telephone number
     */
    public void setTelNumber(String telNumber){
        this.telNumber = telNumber;
    }
}
