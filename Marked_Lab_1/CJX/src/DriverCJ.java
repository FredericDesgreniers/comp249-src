public class DriverCJ {

    public static void main(String[] args) {
        System.out.print("Initiating an instance of the parent class...");
        Tweet t = new Tweet();
        System.out.println("done!");   
        t.setContent("If you put a million monkeys at a million keyboards, "
                + "one of them will eventually write a Java program. "
                + "The rest of them will write Perl programs.");
        System.out.println(t);
        t.isValid();
        
        t.setContent("If you put a million monkeys at a million keyboards, "
                + "one of them will eventually write a Java program. "
                + "The rest will write Perl programs.");
        System.out.println(t);
        t.isValid();

        System.out.println("------------------------");
    
        System.out.print("Initiating an instance of the parent class...");
        TaggedTweet tt = new TaggedTweet();
        System.out.println("done!");
        tt.setContent("If you put a million monkeys at a million keyboards, "
                + "one of them will eventually write a Java program. "
                + "The rest will write Perl programs.");
        tt.setTag("geek");
        System.out.println(tt);
        tt.isValid();
       
    
    }
    
}

/*
run:
Initiating an instance of the parent class...done!
The tweet is:
If you put a million monkeys at a million keyboards, one of them will eventually write a Java program. The rest of them will write Perl programs.
This tweet is too long by 5 characters.
The tweet is:
If you put a million monkeys at a million keyboards, one of them will eventually write a Java program. The rest will write Perl programs.
This tweet is valid.
------------------------
Initiating an instance of the parent class...done!
The tweet is:
If you put a million monkeys at a million keyboards, one of them will eventually write a Java program. The rest will write Perl programs. #geek
This tweet is too long by 3 characters.
*/