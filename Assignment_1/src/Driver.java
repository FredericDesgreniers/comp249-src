/**
 * Created by frede on 2016-07-07.
 */
public class Driver {
    public static void main(String[] args){
        Coins coins = new Coins(1,3,5,4,2);
        System.out.println(coins);

        CreditCard creditCard = new CreditCard("Visa", "Frederic Desgreniers", 3, 2018);
        System.out.println(creditCard);

        CreditCard[] cards = new CreditCard[]{new CreditCard("MasterCard","John doe",2,3341), new CreditCard("Visa","Jessica White",23,123)};
        Wallet wallet = new Wallet(coins,cards);
        System.out.println(wallet);
    }
}
