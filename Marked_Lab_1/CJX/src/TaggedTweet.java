/**
 * Created by frede on 2016-07-07.
 */
public class TaggedTweet extends Tweet{
    private String tag;


    public TaggedTweet(){
        this("Hello World", "");
    }

    public TaggedTweet(String content){
        this(content, "");
    }

    public TaggedTweet(String content, String tag){
        super(content);
        this.tag = tag;
    }

    /**
     * Getter
     * @return a tag
     */
    public String getTag(){
        return tag;
    }

    /**
     * Setter
     * @param tag
     */
    public void setTag(String tag){
        this.tag = tag;
    }

    /**
     * Get length of tweet, containing both content and hashtag, passing it to isValid(int len)
     */
    public void isValid(){
        int length = getContent().length()+(" #"+tag).length();
        isValid(length);
    }

    /**
     * Override toString method with more information
     * @return
     */
    public String toString(){
        String s = super.toString();
        s += " #"+tag;

        return s;
    }

}
