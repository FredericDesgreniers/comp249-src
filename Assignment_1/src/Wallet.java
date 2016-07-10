import java.util.Arrays;

/**
 * Created by frede on 2016-07-09.
 */
public class Wallet {
    private Coins coins;
    private CreditCard[] creditCards; //should be using arraylist, but problem asks for array

    /**
     * Default constructor
     */
    public Wallet(){
        this(new Coins(), null);
    }

    /**
     * Assigns Coins and Credit cards to wallet
     * @param coins Coins
     * @param creditCards Array of CreditCards
     */
    public Wallet(Coins coins, CreditCard[] creditCards){

        this.coins = new Coins(coins);

        this.creditCards = new CreditCard[creditCards.length];

        for(int i = 0; i < creditCards.length; i++){                //For the sake of privacy leak. Makes it impossible for anything outside of this class to have access to the credit card objects
            this.creditCards[i] = new CreditCard(creditCards[i]);
        }
    }

    /**
     * Find if the two wallets have an equal ammount of total coins
     * @param wallet wallet to compare to
     * @return true if coin totals are equal
     */
    public boolean equalCoins(Wallet wallet){
        return wallet.coins.coinsTotal() == coins.coinsTotal();
    }

    /**
     * Finds if two wallets have the same amount of coins of each type
     * @param wallet wallet to compare to
     * @return true if coin totals for each coin type are all equal
     */
    public boolean equalCoinsExact(Wallet wallet){
        return wallet.coins.equals(coins);
    }

    /**
     * get total coins value of wallet
     * @return total coins value
     */
    public double totalCoinsValue(){
        return coins.coinsTotal();
    }

    /**
     * get number of credit cards in wallet
     * @return number of credit cards
     */
    public int creditCardNum(){
        if(creditCards == null)
            return 0;
        else
            return creditCards.length;
    }

    /**
     * Adds a new credit card to the wallet
     * @param creditCard new credit card
     * @return number of credit cards in wallet after adding the new one.
     */
    public int addCreditCard(CreditCard creditCard){
        CreditCard[] newCreditCards;
        if(creditCards != null){
            newCreditCards = new CreditCard[creditCards == null? 1 : creditCards.length+1]; //create new array with more size.
            for(int i = 0; i < creditCards.length; i++){ //loop through contents and copy all credit cards to new array
                newCreditCards[i] = creditCards[i];
            }
            newCreditCards[newCreditCards.length - 1] = creditCard; //add the new credit card
        }else{
            newCreditCards = new CreditCard[1];
            newCreditCards[0] = creditCard; //add the new credit card
        }
        creditCards = newCreditCards; //assign new array to variable

        return creditCards.length;
    }

    /**
     * Remove credit card at a certain index
     * @param index index of card to remove
     * @return if removal was successful
     */
    public boolean removeCreditCard(int index){
        CreditCard[] newCreditCards;
        if(creditCards != null && index<creditCards.length){
            newCreditCards = new CreditCard[creditCards.length-1];
            for(int i = 0; i < index; i++){ // add cards before the removed one
                newCreditCards[i] = creditCards[i];
            }
            for(int i = index+1; i < creditCards.length; i++){ //Add cards after the removed one
                newCreditCards[i-1] = creditCards[i];
            }
        }else{
            return false; //no cards to remove
        }
        return true;
    }

    /**
     * Update / change exipiry date of credit card at certain index
     * @param cardIndex credit card index
     * @param month expiry month
     * @param year  expiry year
     */
    public void updateExipiryDate(int cardIndex, int  month, int year){
        if(creditCards != null)
        if(cardIndex > 0 && cardIndex < creditCards.length){
            CreditCard creditCard = creditCards[cardIndex];
            creditCard.setExpiryMonth(month);
            creditCard.setExpiryYear(year);
        }
    }

    /**
     * Add coins to the Coins in wallet
     * @param nickles number of nickles with a value of 0.05$.
     * @param dimes number of dimes with a value of 0.1$.
     * @param quarters number of quarters with a value of 0.25$.
     * @param loonies number of loonies with a value of 1$.
     * @param tooniess number of toonies with a value of 2$.
     */
    public double addCoins(int nickles, int dimes, int quarters, int loonies, int tooniess){
        coins.addCoins(nickles, dimes, quarters, loonies, tooniess);
        return coins.coinsTotal();
    }

    /**
     * Check if two wallet instances are equal
     * An equal wallet will have the same number of total coins and the same number of credit cards
     * @param wallet Wallet to compare too
     * @return true if wallets are equal
     */
    public boolean equals(Wallet wallet){
        return wallet.coins.coinsTotal() == coins.coinsTotal() && wallet.creditCardNum() == creditCardNum();
    }

    /**
     * Override toString with custom format
     * @return formatted String
     */
    public String toString(){
        String s = "%s\n%s";
        String coinsStr = String.format("Coins: \n\t%s", coins);
        String creditCardsStr = "Credit Cards:\n";
        if(creditCardNum() == 0){
            creditCardsStr += "No cards available";
        }else{
            for(int i = 0; i < creditCards.length; i++){
                CreditCard creditCard = creditCards[i];
                creditCardsStr += "\t"+i+": "+creditCard+"\n";
            }
        }
        return String.format(s, coinsStr, creditCardsStr );
    }

    /**
     * Return string with coins breakdown
     * @return formatted string of coins
     */
    public String getCoinBreakdown(){
        return coins.toString();
    }
}
