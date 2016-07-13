/**
 * Created by frede on 2016-07-07.
 */
public class Coins {
    /**
     * Coins values
     */
    public static final double COIN_NICKEL = 0.05, COIN_DIME = 0.1, COIN_QUARTER = 0.25, COIN_LOONIE = 1, COIN_TOONIE = 2;

    private int nickles;

    private int dimes;

    private int quarters;

    private int loonies;

    private int toonies;

    /**
     * Default constructor
     */
    public Coins(){

    }

    /**
     * Assign the number of coins of each type.
     * @param nickles number of nickles with a value of 0.05$.
     * @param dimes number of dimes with a value of 0.1$.
     * @param quarters number of quarters with a value of 0.25$.
     * @param loonies number of loonies with a value of 1$.
     * @param tooniess number of toonies with a value of 2$.
     */
    public Coins(int nickles, int dimes, int quarters, int loonies, int tooniess){

        this.nickles = nickles;
        this.dimes = dimes;
        this.quarters = quarters;
        this.loonies = loonies;
        this.toonies = tooniess;
    }

    /**
     * Copy constructor
     * @param coins Coins instance to copy from
     */
    public Coins(Coins coins){
        this.nickles = coins.getNickles();
        this.dimes = coins.getDimes();
        this.quarters = coins.getQuarters();
        this.loonies = coins.getLoonies();
        this.toonies = coins.getToonies();
    }

    /**
     * Add a number of coins
     * @param nickles number of nickles with a value of 0.05$.
     * @param dimes number of dimes with a value of 0.1$.
     * @param quarters number of quarters with a value of 0.25$.
     * @param loonies number of loonies with a value of 1$.
     * @param tooniess number of toonies with a value of 2$.
     */
    public void addCoins(int nickles, int dimes, int quarters, int loonies, int tooniess){
        this.nickles += nickles;
        this.dimes += dimes;
        this.quarters += quarters;
        this.loonies += loonies;
        this.toonies += tooniess;
    }

    /**
     * Get the value of all the coins added up.
     * @return The value of all the coins added up in double form.
     */
    public double coinsTotal(){
        return nickles * COIN_NICKEL
                + dimes * COIN_DIME
                + quarters * COIN_QUARTER
                + loonies * COIN_LOONIE
                + toonies * COIN_TOONIE;
    }

    /**
     * Getter for number of nickles.
     * They have a values of 0.05$
     * @return number of nickles with a value of 0.05$.
     */
    public int getNickles() {
        return nickles;
    }

    /**
     * Setter for number of nickles.
     * They have a values of 0.05$.
     * @param nickles as number of nickles with a value of 0.05$.
     */
    public void setNickles(int nickles) {
        this.nickles = nickles;
    }

    /**
     * Geter for number of dimes.
     * They have a values of 0.1$.
     * @return number of dimes with a value of 0.1$.
     */
    public int getDimes() {
        return dimes;
    }

    /**
     * Setter for number of dimes.
     * They have a values of 0.1$.
     * @param dimes as number of dimes with a value of 0.1$.
     */
    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    /**
     * Getter for number of quarters.
     * They have a values of 0.25$.
     * @return number of quarters with a value of 0.25$.
     */
    public int getQuarters() {
        return quarters;
    }

    /**
     * Setter for number of quarters.
     * They have a values of 0.25$.
     * @param quarters as number of quarters with a value of 0.25$.
     */
    public void setQuarters(int quarters) {
        this.quarters = quarters;
    }

    /**
     * Getter for number of loonies.
     * They have a values of 1$.
     * @return number of loonies with a value of 1$.
     */
    public int getLoonies() {
        return loonies;
    }

    /**
     * Setter for number of loonies.
     * They have a values of 1$
     * @param loonies as number of loonies with a value of 1$.
     */
    public void setLoonies(int loonies) {
        this.loonies = loonies;
    }

    /**
     * Getter for number of toonies.
     * They have a values of 2$.
     * @return number of toonies with a value of 2$.
     */
    public int getToonies() {
        return toonies;
    }

    /**
     * Setter for number of toonies.,
     * They have a values of 2$
     * @param toonies as number of toonies with a value of 2$.
     */
    public void setToonies(int toonies) {
        this.toonies = toonies;
    }

    /**
     * Compare with another Coins instance to see if all coin values are equal.
     * @param coins Other Coins instance to compare too.
     * @return
     */
    public boolean equals(Coins coins){
        return coins.nickles == nickles
                && coins.dimes == dimes
                && coins.quarters == quarters
                && coins.loonies == loonies
                && coins.toonies == toonies;
    }

    /**
     * Custom toString method
     * @return
     */
    public String toString(){
        String s = "| %d x 5¢ | %d x 10¢ | %d x 25¢ | %d x 1$ | %d x 2$ | --> $%.2f";
        return String.format(s,nickles, dimes, quarters, loonies, toonies,coinsTotal());
    }


}
