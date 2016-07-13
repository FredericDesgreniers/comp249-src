/**
 * Created by frede on 2016-07-07.
 */
public class CreditCard {

    private String type;

    private String cardHolderName;

    private int expiryMonth;

    private int expiryYear;


    /**
     * Default constructor
     */
    public CreditCard(){
        this("n/a", "John Doe", 0, 0);
    }

    /**
     * Assigns credit card values.
     * @param type Type of credit card
     * @param cardHolderName card holder name
     * @param expiryMonth expiry month, between 1 and 12. If not, it is set to 0
     * @param expiryYear expiry year
     */
    public CreditCard(String type, String cardHolderName, int expiryMonth, int expiryYear){
        this.type = type;
        this.cardHolderName = cardHolderName;
        setExpiryMonth(expiryMonth);
        this.expiryYear = expiryYear;
    }

    /**
     * Copy constructor
     * @param creditCard instance to copy from
     */
    public CreditCard(CreditCard creditCard){
        this.type = creditCard.getType();
        this.cardHolderName = creditCard.getCardHolderName();
        this.expiryMonth = creditCard.getExpiryMonth();
        this.expiryYear = creditCard.getExpiryYear();
    }


    /**
     * Getter for credit card type
     * Ex: Visa, Mastercard, ...
     * @return Credit card type
     */
    public String getType() {
        return type;
    }

    /**
     * Getter for card holder name
     * @return card holder name
     */
    public String getCardHolderName() {
        return cardHolderName;
    }

    /**
     * Getter for expiry month
     * value is between 0 and 12
     * @return expiry month
     */
    public int getExpiryMonth() {
        return expiryMonth;
    }
    /**
     * Setter for expiry month
     * If month is not between 1 and 12, it is set to 0
     * @param expiryMonth expiry month
     */
    public void setExpiryMonth(int expiryMonth) {
        this.expiryMonth = (expiryMonth >= 1 && expiryMonth <= 12)? expiryMonth : 0;;
    }

    /**
     * Getter for expiry year
     * @return expiry year
     */
    public int getExpiryYear() {
        return expiryYear;
    }

    /**
     * Setter for expiry years
     * @param expiryYear expiry year
     */
    public void setExpiryYear(int expiryYear) {
        this.expiryYear = expiryYear;
    }

    /**
     * custom toString method
     * @return
     */
    public String toString(){
        String s = "%s - %s - %02d/%d";
        return String.format(s, type, cardHolderName, expiryMonth, expiryYear);
    }
}
