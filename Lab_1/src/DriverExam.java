import javax.xml.stream.events.Characters;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

/**
 * Keeps track fo anwsers on an exam
 */
public class DriverExam {
    public static final char[] ANSWERS = new char[]{'B', 'D', 'A', 'A', 'C','A', 'B', 'A', 'C', 'D', 'B', 'C', 'D', 'A', 'D', 'C', 'C', 'B', 'D', 'A'};
    /**
     * array of entered answers
     */
    private char[] questions;

    /**
     * Caches correct to prevent multiple comaprisons
     */
    private int correctCache;

    /**
     * Caches incorrect to prevent multiple comparisons
     */
    private int incorrectCache;
    /**
     * Caches missed num to rpevent multiple comarisons
     */
    private Integer[] missedCache;
    /**
     * true if cache is wrong since an answer has changed
     */
    boolean changed;


    public DriverExam(){
        questions = new char[20];
    }

    /**
     * Set an answer for a question
     * @param index
     * @param answer
     */
    public void setQuestion(int index, char answer){
        if(index >=0 && index < questions.length){
            questions[index] = answer;
            changed = true; //makes sure not to use the cached values.
        }
    }

    /**
     * Get number of questions requireds
     * @return
     */
    public int getQuestionNum(){
        return ANSWERS.length;
    }

    /**
     * return weither the student passed the exam.
     * @return
     */
    public boolean passed(){
        int correct = totalCorrect();
        if(correct >= 15){
            return true;
        }
        return false;
    }

    /**
     * Get total number of correct answers
     * @return
     */
    public int totalCorrect(){
        update();
        return correctCache;

    }

    /**
     * Get total number of incorrect answers
     * @return
     */
    public int totalIncorect(){
        update();
        return incorrectCache;
    }
    /**
     * Get total number of missed answers
     * @return
     */
    public Integer[] totalMissed(){
        update();
        return missedCache;
    }

    /**
     * Validates an input string.
     *
     * Must be A, B, C, D or empty
     * @param input input String
     * @return
     */
    public  Input validateInput(String input){
        if(input.length() > 1) return new Input((char)0, false); //if length is more then 1, it's not a char
        if(input.length() == 0){ //if length is 0, question is missed and thus is valid
            return new Input((char)0, true);
        }else{
            char c = input.charAt(0);
            return new Input(c,(c == 'A' || c=='B' || c=='C' || c=='D'));
        }
    }
    /**
     * Updates stats if changed
     */
    private void update(){
        //only bother re-counting all the variables if something has changed. Not used in demo but whatever
        if(changed){
            System.out.println("Updating from cache...");
            int correct = 0;
            int incorrect = 0;
            List<Integer> missed = new ArrayList<Integer>(); //No idea how many ints their are, so must be in List

            for(int i = 0; i < questions.length; i++){
                if(questions[i] == ANSWERS[i]){ //question matches answer array
                    correct++;
                }else if (questions[i] == 0){ //question is empty and thus missed
                    missed.add(i);
                }else{
                    incorrectCache++; //question is answered but incorrect.
                }
            }
            correctCache = correct;
            incorrectCache = incorrect;
            missedCache = missed.toArray(new Integer[missed.size()]); //Convert from Integer List to Integer 2D Array

            changed = false;
        }
    }



    /**
     * Allows to see if an input is valid
     */
    public static class Input{
        private char input;
        private boolean valid;

        public Input(char input, boolean valid){
            this.input = input;
            this.valid = valid;
        }

        /**
         * Get input.
         * @return input
         */
        public char getInput(){
            return input;
        }

        /**
         * return if the input is valid in the context of the exam.
         *
         * Valid inputs are empty, A, B, C and Ds
         * @return
         */
        public boolean isValid(){
            return valid;
        }
    }


}
