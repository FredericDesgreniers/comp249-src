
public class IPAddress {

    private int[] ip;

    /**
     * Default constructor.
     */
    public IPAddress() {
        this(0, 0, 0, 0);
    }

    /**
     * Constructor that takes 4 integers for addresses like a.b.c.d and stores
     * them in an array
     *
     * @param a first number in IP (0 to 255)
     * @param b second number in IP (0 to 255)
     * @param c third number in IP (0 to 255)
     * @param d fourth number in IP (0 to 255)
     */
    public IPAddress(int a, int b, int c, int d) {
        //Mod just keeps int in range
        this.ip = new int[]{a % 256, b % 256, c % 256, d % 256};
    }

    /**
     * Setter for IP address
     *
     * @param a first number in IP (0 to 255)
     * @param b second number in IP (0 to 255)
     * @param c third number in IP (0 to 255)
     * @param d fourth number in IP (0 to 255)
     */
    public void setIP(int a, int b, int c, int d) {
        this.ip[0] = a % 256;
        this.ip[1] = b % 256;
        this.ip[2] = c % 256;
        this.ip[3] = d % 256;
    }

    /**
     * Getter for IP address
     *
     * @return array containing for int values in IP address
     */
    public int[] getIP() {
        return this.ip;
    }

    /**
     * Formats IP address as a string with dots between int values
     *
     * @return string representation of IP address such as: 192.168.0.1
     */
    public String getIPString() {
        return ("" + this.ip[0] + "." + this.ip[1] + "." + this.ip[2] 
                + "." + this.ip[3]);
    }

    /**
     * Simulates "pinging" the IP address
     */
    public void Ping() {
        System.out.print("Pinging IP address: " + getIPString());
        System.out.println("...");
        System.out.println("Response Received.");
    }

    /**
     * Override toString method with custom description
     *
     * @return String with custom description
     */
    @Override
    public String toString() {
        return ("The IP address is: " + this.getIPString());
    }

}
