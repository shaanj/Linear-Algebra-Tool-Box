import java.util.*;

public class Matrix_Power{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("This program will compute a square matrix to the power of n, where n is an integer.");
        System.out.print("Enter the number of rows of Matrix A: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns of Matrix A: ");
        int cols = sc.nextInt();

        if(rows != cols){
            System.out.println("This is not a square matrix. :/");
        } else {
            System.out.print("Enter the exponent: ");
            int exp = sc.nextInt();

            int dims = rows;
            String[][] given = new String[dims][dims];
            double[][] original = new double[dims][dims];
            double[][] modified = new double[dims][dims];
            
            System.out.println("Enter the contents of Matrix A");
            populate(dims, dims, given, original);
            printMatrix(dims, dims, original, "Matrix A");
            HandOver(dims, modified, original);
            printMatrix(dims, dims, modified, "the modified matrix");


            for(int a = 1; a < exp; a++){
            compute(dims, modified, original);
            }
            printMatrix(dims, dims, modified, "the end Matrix");
        }

    }

    public static double[][] compute(int dims, double[][] modified, double[][] original){
        for(int i = 0; i < dims; i++){
			for(int j = 0; j < dims; j++){
				for(int k = 0; k < dims; k++){
					modified[i][j] += modified[i][k] * original[k][j];									//actual process of multiplying 
				}
			}
        }
        return modified;
    }

    public static double[][] HandOver(int dims, double[][] newMat, double[][] older){
        for(int i = 0; i < dims; i++){
            for(int j = 0; j < dims; j++){
                newMat[i][j] = older[i][j];
            }
        }
        return newMat;
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