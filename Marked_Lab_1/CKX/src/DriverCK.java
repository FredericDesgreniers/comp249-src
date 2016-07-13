public class DriverCK {

    public static void main(String[] args) {
        
        System.out.print("Initiating an instance of the parent class...");
        IPAddress ip = new IPAddress();
        System.out.println("done!");
        ip.setIP(192, 168, 0, 1);
        System.out.println(ip);
        ip.Ping();
        
        System.out.println("------------------------");
        
        System.out.print("Initiating an instance of the child class...");
        Record r = new Record();
        System.out.println("done!");
        r.setIP(8, 8, 8, 8);
        r.setDomainName("google.ca");
        r.fetchRecord();
        r.addWWW();
        System.out.println(r);

    }
    
}

/*
run:
Initiating an instance of the parent class...done!
The IP address is: 192.168.0.1
Pinging IP address: 192.168.0.1...
Response Received.
------------------------
Initiating an instance of the child class...done!
Fetching record for: google.ca... 
Received address: 8.8.8.8
The IP address for www.google.ca is 8.8.8.8
*/