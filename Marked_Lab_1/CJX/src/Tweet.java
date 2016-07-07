
public class Tweet {

    private String content;

    /**
     * Default Constructor.
     */
    public Tweet() {
        this("Hello world.");
    }

    /**
     * Constructor
     * @param c a string for the content of the tweet
     */
    public Tweet(String c) {
        this.content = c;
    }

    /**
     * Setter  
     * @param c a string for the content of the tweet
     */
    public void setContent(String c) {
        this.content = c;
    }

    /**
     * Getter
     * @return a string for the content of the tweet
     */
    public String getContent() {
        return (this.content);
    }

    /**
     * Gets length of tweet as an int and passes it to isValid(int len)
     */
    public void isValid() {
        int len = this.getContent().length();
        this.isValid(len);
    }

    /**
     * Compares value of parameter to 140 characters
     * Tweets are only valid if they are less than or equal to 140 characters
     * @param len length of the content of a tweet
     */
    public void isValid(int len) {
        if (len <= 140) {
            System.out.println("This tweet is valid.");
        } else {
            System.out.println("This tweet is too long by "
                    + (len - 140) + " characters.");
        }
    }

    /**
     * Override toString method with custom description
     *
     * @return String with custom description
     */
    @Override
    public String toString() {
        return ("The tweet is:\n" + this.getContent());
    }
}
