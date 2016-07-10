import java.util.Scanner;

/**
 * Created by frede on 2016-07-07.
 */
public class Driver {

    static Wallet[] wallets;

    static Scanner scanner;

    /**
     * Runs a loop to do the required actions
     */
    public static void run(){
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n" +
                            " Welcome to the Wallet Application"
                +          "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
        while(true) {
            printOptions();

            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.valueOf(input);
                if (choice < 0 || choice > 9)
                    throw new Exception();


            } catch (Exception e) {
                System.out.println("Sorry this is not a valid choice. Try again");
                continue;
            }
            processChoice(choice);
        }
    }

    /**
     * process a choice between 0 and 9
     * @param choice choice index
     */
    public static void processChoice(int choice){
        switch(choice){
            case 0:
                System.out.println("Thank you for using the wallet application!");
                System.exit(0);
                break;
            case 1:
                listWalletsContent();
                break;
            case 2:
                listWalletContent();
                break;
            case 3:
                listSameMoneyWallets(false);
                break;
            case 4:
                listSameMoneyWallets(true);
                break;
            case 5:
                listSameWallets();
                break;
            case 6:
                addCreditCard();
                break;
            case 7:
                removeCreditCard();
                break;
            case 8:
                updateCreditCardExpiryDate();
                break;
            case 9:
                addCoins();
                break;
        }
    }

    /**
     * List all content of all wallets/
     */
    public static void listWalletsContent(){
        System.out.println("Content of each wallet: \n" +
                "--------------------------");
        for(int i = 0; i < wallets.length; i++){
            System.out.println(String.format("Wallet #%d:\n %s___________________________\n",i, wallets[i]));
        }
    }

    /**
     * List content of specific wallet
     */
    public static void listWalletContent(){
        System.out.print("--> Which wallet do you want to see the content of?");

        System.out.println(wallets[getChoice(wallets.length-1)]);
    }

    /**
     * List the wallet pairs with same ammount of money
     * @param dist if the distribution should match,
     */
    public static void listSameMoneyWallets(boolean dist){

        for(int i = 0; i < wallets.length; i++) {

            Wallet wallet = wallets[i];
            for (int j = i + 1; j < wallets.length; j++) {
                if (dist ? wallet.equalCoinsExact(wallets[j]) : wallet.equalCoins(wallets[j])) {

                    System.out.println(String.format("Wallets %d and %d both have %s", i, j, dist ? wallet.getCoinBreakdown() : wallet.totalCoinsValue()));

                }
            }
        }
    }

    /**
     * List the wallet pairs that are equal in coin total and credit card values
     */
    public static void listSameWallets(){
        System.out.println("Wallet pairs with same amount of money and credit cards: ");
        for(int i = 0; i < wallets.length; i++) {

            Wallet wallet = wallets[i];
            for (int j = i + 1; j < wallets.length; j++) {
                if (wallet.equals(wallets[j])) {

                    System.out.println(String.format("\tWallets %d and %d", i, j));

                }
            }
        }
    }

    /**
     * print the choice options.
     */
    public static void printOptions(){
        System.out.println("What would you like to do?\n" +
                "\t1. See the content of all wallets\n" +
                "\t2. See the content of one wallet\n" +
                "\t3. List wallets with same amount of money\n" +
                "\t4. List wallets with same coins\n" +
                "\t5. List wallets with same amount of money and same number of credit cards\n" +
                "\t6. Add a credit card to an existing wallet\n" +
                "\t7. Remove an existing credit card from a wallet\n" +
                "\t8. Update the expiry date of an existing credit card\n" +
                "\t9. Add coins to a wallet\n" +
                "\t0. To quit\n\n" +
                "--> Please enter your choice and press <Enter>:");
    }

    /**
     * Add a credit card to a wallet
     */
    public static void addCreditCard(){
        System.out.println("--> Which wallet do you want to add a credit card too? ");

        Wallet wallet = wallets[getChoice(wallets.length-1)];

        System.out.println("Please enter the following information so we may complete the transaction: ");

        System.out.println("--> Type of credit card (mastercard, visa, etc...): ");
        String type = scanner.nextLine();

        System.out.println("--> Full name on credit card: ");
        String name = scanner.nextLine();

        System.out.println("--> Expiry month number and year (separate by a space): ");
        DateResult dateResult = getDate();
        wallet.addCreditCard(new CreditCard(type,name, dateResult.month, dateResult.year));

        System.out.println(String.format("Wallet now has %d credit cards.", wallet.creditCardNum()));
    }

    /**
     * remove a credit card from a wallet
     */
    public static void removeCreditCard(){
        System.out.print("--> Which wallet do you want to remove the credit card from ");
        Wallet wallet = wallets[getChoice(wallets.length-1)];
        if(wallet.creditCardNum() == 0){
            System.out.println("Sorry, this wallet has no credit cards");
            return;
        }
        System.out.print("--> Which credit card do you want to remove? ");
        int cardChoice = getChoice(wallet.creditCardNum()-1);
        wallet.removeCreditCard(cardChoice);
        System.out.println("Card removed successfully");
    }

    /**
     * update a credit cards expiry date
     */
    public static void updateCreditCardExpiryDate(){
        System.out.print("--> Enter wallet to update credit card in ");
        Wallet wallet = wallets[getChoice(wallets.length-1)];
        System.out.print("--> Enter credit card to update ");
        int cardIndex = getChoice(wallet.creditCardNum()-1);
        System.out.println("--> Enter new expiry month number and year (seperated by space): ");
        DateResult dateResult = getDate();
        wallet.updateExipiryDate(cardIndex, dateResult.month, dateResult.year);
        System.out.println("Expiry date updated.");
    }

    /**
     * add coins to a wallet
     */
    public static void addCoins(){
        System.out.print("Enter wallet to add coins to ");
        Wallet wallet = wallets[getChoice(wallets.length-1)];
        int nickles = 0;
        int dimes = 0;
        int quarters = 0;
        int loonies = 0;
        int toonies = 0;
        System.out.println("--> How many nickles, dimes, quarters, loonies, toonies do you want to add?");
        while (true) {
            try {
                String[] coins = scanner.nextLine().split(" ");
                if (coins.length < 5) {
                    throw new Exception();
                }
                nickles = Integer.valueOf(coins[0]);
                dimes = Integer.valueOf(coins[1]);
                quarters  = Integer.valueOf(coins[2]);
                loonies  = Integer.valueOf(coins[3]);
                toonies  = Integer.valueOf(coins[4]);
            }catch(Exception e){
                System.out.println("Invalid value, try again... ");
                continue; //make it go for another loop to get a valid value
            }
            break; //since their was no error, we can exit the loop since we have a valid value
        }
        wallet.addCoins(nickles, dimes, quarters, loonies, toonies);

        System.out.println(String.format("You now have $%.2f", wallet.totalCoinsValue()));
    }

    /**
     * get a date input in the form month / year
     * @return month / year result
     */
    public static DateResult getDate(){
        DateResult dateResult = new DateResult();

        while(true) {
            String date = scanner.nextLine();
            try{
                String[] dates = date.split(" ");
                if(dates.length < 2){
                    throw new Exception();
                }
                dateResult.month = Integer.valueOf(dates[0]);
                dateResult.year = Integer.valueOf(dates[1]);
                break;
            }catch(Exception e){
                System.out.println("Date not valid, try again: ");
            }
        }

        return dateResult;
    }

    /**
     * Let the user input a choice between 0 and max
     * @param max maximum choice index
     * @return inputted choice
     */
    public static int getChoice(int max){
        int choice;
        while(true){
            System.out.println(String.format("(Enter number %d to %d): ", 0, max));
            try {
                choice = Integer.valueOf(scanner.nextLine());
                if(choice < 0 || choice > max){
                    throw new Exception();
                }
                break;
            }catch(Exception e){
                System.out.print("--> Try again: ");
            }
        }
        return choice;
    }



    public static void main(String[] args){
        scanner = new Scanner(System.in);
        wallets = new Wallet[]{ //hardcoded wallet
                new Wallet(
                        new Coins(20,42,32,2,16),
                        new CreditCard[]{
                                new CreditCard("Visa"," John Doe", 1, 2018),
                                new CreditCard("MasterCard", "John Doe", 3, 2020)
                        }),
                new Wallet(
                        new Coins(20,42,32,2,16),
                        new CreditCard[]{
                                new CreditCard("MasterCard"," Jack White", 2, 2019),
                                new CreditCard("Discovery", "Jack White", 6, 2022)
                        }),
                new Wallet(
                        new Coins(30,32-5,32,7,14),
                        new CreditCard[]{
                                new CreditCard("MasterCard"," Victoria Shimmings", 11, 2016),
                                new CreditCard("Discovery", "Victoria Shimmings", 12, 2028),
                                new CreditCard("Visa", "Victoria Shimmings", 4, 2018)
                        }),
                new Wallet(
                        new Coins(1,2,3,4,5),
                        null),
                new Wallet(
                        new Coins(1,2,3,4,5),
                        null)

        };

        run();
    }

    /**
     * Used to return both month and year at the same time
     */
     static class DateResult {
         int month = 0;
         int year = 0;
    }
}
