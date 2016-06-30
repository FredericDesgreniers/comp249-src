import java.util.Scanner;

/**
 * Created by frede on 2016-06-30.
 */
public class lab1_2 {
    //TEST ARRAYS (as seen on lab sheet)
   static int[][] arr1 = new  int[][]{ {0, 1, 0, 3, 1, 6, 1},
           {0, 1, 6, 8, 6, 0, 1},
           {5, 6, 2, 1, 8, 2, 9},
           {6, 5, 6, 1, 1, 9, 1},
           {1, 3, 6, 1, 4, 0, 7},
           {3, 3, 3, 3, 4, 0, 7}};
    static int[][] arr2 = new  int[][]{ {0, 1, 0, 3, 1, 6, 1},
            {0, 1, 6, 8, 6, 0, 1},
            {5, 5, 2, 1, 8, 2, 9},
            {6, 5, 6, 1, 1, 9, 1},
            {1, 5, 6, 1, 4, 0, 7},
            {3, 5, 3, 3, 4, 0, 7}};

    static int[][] arr3 = new  int[][]{ {0, 1, 0, 3, 1, 6, 1},
            {0, 1, 6, 8, 6, 0, 1},
            {5, 6, 2, 1, 6, 2, 9,},
            {6, 5, 6, 6, 1, 9, 1},
            {1, 3, 6, 1, 4, 0, 7},
            {3, 6, 3, 3 ,4 ,0, 7}};
    public static void main(String[] args){
        int[][] arr = getInputArray();
        printArray(arr);
        isConsecutiveFour(arr);
    }

    /**
     * Get a test array
     * @return Array with all the input values
     */
    public static int[][] getInputArray(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Array width: ");
        int width = scanner.nextInt();

        System.out.print("Array height: ");
        int height = scanner.nextInt();

        int[][] arr = new int[height][width];
        for(int i=0; i < arr.length; i++){
            System.out.println("Row "+i);
            for(int j=0; j < arr[i].length; j++){
                System.out.print("\t"+j+": ");
                int value = scanner.nextInt();
                arr[i][j] = value;
            }
        }
        return arr;
    }

    /**
     * Print the array to better visualize it when debugging
     * @param arr 2D Array to print
     */
    public static void printArray(int[][] arr){
        System.out.println("--------------------");
        for(int[] row : arr){
            for(int value : row){
                System.out.print(value+"\t");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }
    /**
     * Check if 4 consecutive numbers are present in array.
     * @param values Value Array to check
     * @return if their are four consecutive numbers
     */
    public static boolean isConsecutiveFour(int[][] values){
        for(int i=0; i< values.length;i++){
            for(int j=0; j< values[i].length;j++){

                //check for horizontal match
                if(j>=3){
                    if(values[i][j-3] == values[i][j-2] && values[i][j-3] == values[i][j-1] && values[i][j-3] == values[i][j]){
                        System.out.println(values[i][j]);
                        return true;
                    }
                    //check for rows on top
                    if(i >= 3){
                        //diagonal check (towards top left)
                        if(values[i-3][j-3] == values[i-2][j-2] && values[i-3][j-3] == values[i-1][j-1] && values[i-3][j-3] == values[i][j]){
                            System.out.println(values[i][j]);
                            return true;
                        }
                    }

                }
                //check for to make sure theirs at least 3 rows on top
                if(i>=3){
                    //check for vertical match
                    if(values[i-3][j] == values[i-2][j] && values[i-3][j] == values[i-1][j] && values[i-3][j] == values[i][j]){
                        System.out.println(values[i][j]);
                        return true;
                    }
                    //check for diagonal (towards top right) match)
                    if(j<=values[i].length-4){
                        if(values[i-3][j+3] == values[i-2][j+2] && values[i-3][j+3] == values[i-1][j+1] && values[i-3][j+3] == values[i][j]){
                            System.out.println(values[i][j]);
                            return true;
                        }
                    }
                }



            }
        }
        return false;
    }

}
