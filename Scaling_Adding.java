import java.util.*;
public class Scaling_Adding{    //this program takes 2 matrices, A and B, and computes expressions like 2A + 5B, or 10A - 3B.
    public static void main (String []args){
    Scanner sc = new Scanner(System.in);                                            //scanner, for user input
    System.out.println("Using Matrices A and B, this program will do expressions like 5A - 3B and 4A + 9B.");
    System.out.print("Enter the number of rows in both matrices: ");
	int rows = sc.nextInt();					                                    //giving the rows
	System.out.print("Enter the number of columns in both matrices: ");
    int cols = sc.nextInt();					                                    //giving the columns
    
    String given1[][] = new String[rows][cols];	                                    //array initialization
    String given2[][] = new String[rows][cols];                                     //String arrays = user input
    double doubles1[][] = new double[rows][cols];	                                //double arrays = math is done on them
    double doubles2[][] = new double[rows][cols];		                                
    double end[][] = new double[rows][cols];	                                    //end is the final matrix, answer displayed
    String A = "Matrix A";                                                          //A and B for formatting in printMatrix
    String B = "Matrix B";                            
    char mathsign = '0';                                                            //used for formatting later

    System.out.println("Enter the contents of Matrix A");
    populate(rows, cols, given1, doubles1);                                         //populate the first doubles array from the string array
    System.out.println("Enter the contents of Matrix B");
    populate(rows, cols, given2, doubles2);                                         //populate the second doubles array from the string array
    System.out.println("Enter the scalar for Matrix A. If there is none, enter 1.");           //scalar for the first matrix
    String first = SCALAR(rows, cols, doubles1, A);
    System.out.println("Enter the scalar for Matrix B. If there is none, enter 1.");           //same logic down here as above
    String second = SCALAR(rows, cols, doubles2, B);
    
    System.out.println("Select 1 to add or Select 2 to subtract the two matrices. Select any other number to exit the program. \n1. Adding   2. Subtracting    Any Other Number. Exit");    
    int addorsub = sc.nextInt();                                                    //1 = add, 2 = sub, 3 = exit, anything else will force an input.
    while(addorsub == 1 || addorsub == 2){                                                                                             
    if(addorsub == 1){                                                              //adding process
        FillIn(rows, cols, doubles1, doubles2, end, '+');
        mathsign = '+';
        System.out.println("\nExpression: " + Math.round(Double.parseDouble(first) * 1000.000) / 1000.000 + "(A) " + mathsign + " " + Math.round(Double.parseDouble(second) * 1000.000) / 1000.000 + "(B)");
        printMatrix(rows, cols, end, "the final Matrix");
    } else if (addorsub == 2){                                                      //subtracting process
        FillIn(rows, cols, doubles1, doubles2, end, '-');
        mathsign = '-';
        System.out.println("\nExpression: " + Math.round(Double.parseDouble(first) * 1000.000) / 1000.000 + "(A) " + mathsign + " " + Math.round(Double.parseDouble(second) * 1000.000) / 1000.000 + "(B)");
        printMatrix(rows, cols, end, "the final Matrix");                           //printing the results
    }
    System.out.println("Select 1 to add or Select 2 to subtract the two matrices. Select any other number to exit the program. \n1. Adding   2. Subtracting    Any Other Number. Exit");     
    addorsub = sc.nextInt();                                                        //same code down here for the end of the loop before going to top again.
    }
    }

    public static double[][] populate(int rows, int cols, String[][] given, double[][] doubles){
        Scanner nn = new Scanner(System.in);
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){			                                
                    given[i][j] = nn.next();	
    
                    if(given[i][j].contains("/")){                                                      
                        String[] splitFraction = given[i][j].split("/");                                
                        double numerator = Double.parseDouble(splitFraction[0]);                    
                        double denominator = Double.parseDouble(splitFraction[1]);                  
                        doubles[i][j] = numerator/denominator;	    
                        doubles[i][j] = Math.round(doubles[i][j] * 1000.000) / 1000.000;                            
                    } else {
                        doubles[i][j] = Double.parseDouble(given[i][j]);
                        doubles[i][j] = Math.round(doubles[i][j] * 1000.000) / 1000.000; 
                    }
                }
            }
        System.out.println();
        return doubles;
    }

    public static double[][] FillIn(int rows, int cols, double[][] first, double[][] second, double[][] answer, char sign){
        if(sign == '+'){
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    answer[i][j] = Math.round((first[i][j] + second[i][j]) * 1000.000 / 1000.000);
                }
            } 
        } else if(sign == '-'){
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){
                    answer[i][j] = Math.round((first[i][j] - second[i][j]) * 1000.000 / 1000.000);
                }
            } 
        }
        return answer;
    }

    public static double[][] scaling(int rows, int cols, double scalar, double [][]arr){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                arr[i][j] *= scalar;
                arr[i][j] = Math.round(arr[i][j] * 1000.000) / 1000.000;
            }
        }
        return arr;
    }

    public static String SCALAR(int rows, int cols, double[][] doubles, String Matrix){
        Scanner scale = new Scanner(System.in);
        String scalar = scale.next();
        if(scalar.contains("/")){                                                      //checks to see if the string has a /
            String[] splitFraction = scalar.split("/");                                //separate the string into numbers, by parsing -->
            double numerator = Double.parseDouble(splitFraction[0]);                    //whatever comes before and after the /
            double denominator = Double.parseDouble(splitFraction[1]);                  //diving them gives the actual scalar to be used
            double realscalar = numerator/denominator;
            scaling(rows, cols, realscalar, doubles);
            System.out.println();
            printMatrix(rows, cols, doubles, Matrix);
        } else {
            double realscalar = Double.parseDouble(scalar);
            scaling(rows, cols, realscalar, doubles);
            System.out.println();                                                       //this is the case if the string does not have a /
            printMatrix(rows, cols, doubles, Matrix);
        }
        return scalar;
    }

    public static double[][] printMatrix(int rows, int cols, double [][]arr, String Matrix){
        System.out.println("This is what " + Matrix + " looks like now!");
        for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				System.out.print(arr[i][j] + " ");
			}
				System.out.println();
        }
        System.out.println();
		return arr;
    }
}