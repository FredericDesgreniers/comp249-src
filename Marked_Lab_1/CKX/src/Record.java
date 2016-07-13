/**
 * Created by frede on 2016-07-07.
 */
public class Record extends IPAddress{
    private String domainName;

    /**
     * Default constructor
     */
    public Record(){
        super();
        this.domainName = "www.example.com";
    }

    /**
     * Constructor that takes 4 integers for addresses like a.b.c.d and stores them in an array
     * @param a first number in IP (0 to 255)
     * @param b second number in IP (0 to 255)
     * @param c third number in IP (0 to 255)
     * @param d fourth number in IP (0 to 255)
     */
    public Record(int a, int b, int c, int d){
        this(a,b,c,d,"www.example.com");
    }

    /**
     * Constructor that takes 4 integers for addresses like a.b.c.d and stores them in an array
     * along with a string that represents the domain nae associated with the ip
     *
     * @param a first number in IP (0 to 255)
     * @param b second number in IP (0 to 255)
     * @param c third number in IP (0 to 255)
     * @param d fourth number in IP (0 to 255)
     * @param domainName
     */
    public Record(int a, int b, int c, int d, String domainName){
        super(a,b,c,d);
        this.domainName = domainName;
    }

    /**
     * Getter for domain anme
     * @return a string with the domain name
     */
    public String getDomainName(){
        return domainName;
    }

    /**
     * Setter for domain name
     * @param domainName a string with the domain anem
     */
    public void setDomainName(String domainName){
        this.domainName = domainName;
    }

    /**
     * Fetch the dns record for the specified domain name
     */
    public void fetchRecord(){
        System.out.printf("Fetching record for: %s... \n" +
                "Received address: %s\n", domainName, this.getIPString());
    }

    /**
     * Add www to the domain name if not present
     */
    public void addWWW(){
        if(!(domainName.startsWith("www.") || domainName.startsWith("http://www."))){
            domainName = "www."+domainName;
        }
    }

    /**
     * Override toString method with a more detailed version
     * @return String with custom description
     */
    public String toString(){
        return String.format("The IP address for %s is %s.",domainName, getIPString());
    }

}

