public class DriverCI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    System.out.print("Initiating an instance of the parent class...");
    Domain d = new Domain();
    System.out.println("done!");
    System.out.println(d);
    d.setDN("google");
    d.setTLD("ca");
    System.out.println(d);
  
    System.out.println("------------------------");

    System.out.print("Initiating an instance of the child class...");
    URL u = new URL("http","google","com");
    System.out.println("done!");
    System.out.println(u);
    u.makeCanadian();
    u.makeSecure();
    System.out.println(u);
  }
}

/*
run:
Initiating an instance of the parent class...done!
The domain name is example.com
The domain name is google.ca
------------------------
Initiating an instance of the child class...done!
The URL is http://google.com
The URL is https://google.ca
*/