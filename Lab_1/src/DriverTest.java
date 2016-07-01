import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by frede on 2016-06-30.
 */
public class DriverTest {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        DriverExam driverExam = new DriverExam();

        //Go through all the questions
        for(int i=0; i < driverExam.getQuestionNum(); i++){
            System.out.print("#"+(i+1)+": ");
            DriverExam.Input input = null;
            //Wait until a valid input is entered. Validated through driverExam class
            while((input = driverExam.validateInput(scanner.nextLine())).isValid() == false){
                System.out.println("Input not valid...");
            }

            driverExam.setQuestion(i,input.getInput());
        }

        Integer[] missed = driverExam.questionMissed(); // Used a couple of times, so local variable
        System.out.println("The student has "+(driverExam.passed()?"passed":"failed")+" with a score of "+driverExam.totalCorrect()+"/"+driverExam.getQuestionNum()+" and a total of "+missed.length+" missed answers!");
        System.out.println("The missed answers were: ");
        //print out missed question indexes
        for(int i : missed)
                System.out.print(i+((i != missed.length - 1)?",":""));
    }



}
