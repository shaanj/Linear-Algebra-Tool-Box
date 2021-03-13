import java.util.*;

public class Transpose{
    public static void main(String []args){
    Scanner sc = new Scanner(System.in);                                            //scanner, for user input
    System.out.println("This program will take a Matrix A, and find it's transpose. 3 x 2 --> 2 x 3");
    System.out.print("Enter the number of rows in Matrix A: ");
	int rows = sc.nextInt();					                                    //giving the rows
	System.out.print("Enter the number of columns in Matrix A: ");
    int cols = sc.nextInt();	
    
    String given[][] = new String[rows][cols];                                      //string array = user input
    double doubles[][] = new double[rows][cols];                                    //these values get shifted
    double transpose[][] = new double[cols][rows];                                  //answer matrix

    System.out.println("Enter the contents of Matrix A: ");
    populate(rows, cols, given, doubles);                                           //population of Matrix A
    printMatrix(rows, cols, doubles, "Matrix A");                                   //printing
    FillIn(rows, cols, doubles, transpose);                                         //filling the answer matrix with indexes
    printMatrix(cols, rows, transpose, "the Transpose Matrix");                     //printing results
    sc.close();
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

    public static double[][] printMatrix(int rows, int cols, double [][]arr, String Matrix){
        System.out.println("This is what " + Matrix + " looks like.");
        for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				System.out.print(arr[i][j] + " ");
			}
				System.out.println();
        }
        System.out.println();
		return arr;
    }

    public static double[][] FillIn(int rows, int cols, double [][] given, double[][] answer){
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				answer[j][i] = given[i][j];									//actual process of multiplying 
			}
		}
		return answer;
	}
}