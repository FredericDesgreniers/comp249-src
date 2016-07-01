
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author f_desgr
 */
public class lab1_2b {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns of the array: ");
        String input = scanner.nextLine();
        String[] dimensions = input.split(" ");
        
        int rows = Integer.valueOf(dimensions[0]);
        int columns = Integer.valueOf(dimensions[1]);
        
        double[][] arr = new double[rows][columns];
        
        System.out.println("Enter the array: ");
        for(int i = 0; i < rows; i++){
            
            String[] str = scanner.nextLine().split(" ");
            double[] row = new double[columns];
            for(int j = 0; j < columns; j++){
                row[j] = (j < str.length)?Double.valueOf(str[j]):0;
            }
            arr[i] = row;
        }
        int[] location = locateLargest(arr);
        System.out.println("Location of the largest is at ("+location[0]+", "+location[1]+")");
    }
    
    public static int[] locateLargest(double[][] a){
        int[] index = new int[2];
        Double largest = null;
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                if(largest == null || a[i][j] > largest){
                    largest = a[i][j];
                    index[0] = i;
                    index[1] = j;
                }
            }
        }
        return index;
    }
}
