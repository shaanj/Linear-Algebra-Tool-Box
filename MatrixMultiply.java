import java.util.*;

public class MatrixMultiply{
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of rows in Matrix A: ");
		int r1 = sc.nextInt();			//row# for first matrix
		System.out.print("Enter the number of columns in Matrix A: ");
		int c1 = sc.nextInt();			//col# for first matrix
		System.out.print("Enter the number of rows in Matrix B: ");
		int r2 = sc.nextInt();			//row# for second matrix
		System.out.print("Enter the number of columns in Matrix B: ");
		int c2 = sc.nextInt();			//col# for second matrix
		
		if(c1 != r2){																			//when dimensions dont allow multiplication
			System.out.println("Can't multiply these matrices together :/");
		} else {	
			System.out.println("\nOk, these dimensions work!");									//when dims allow multiplication
			String given1[][] = new String[r1][c1];												//string arrays = user input
			String given2[][] = new String[r2][c2];
			double first[][] = new double[r1][c1];												//double arrays = parsed, math done on them
			double second[][] = new double[r2][c2];
			double product[][] = new double[r1][c2];											//answer displayed here

			System.out.println("Enter the contents of Matrix A");	
			populate(r1, c1, given1, first);													//population of A
			printMatrix(r1, c1, first, "Matrix A");												//print
			System.out.println("Enter the contents of Matrix B");									
			populate(r2, c2, given2, second);													//population of B
			printMatrix(r2, c2, second, "Matrix B");											//print

			System.out.println("Enter the scalar for Matrix A. If there is none, enter 1.");           //scalar for the first matrix
    		String scale1 = SCALAR(r1, c1, first, "Matrix A");
   			System.out.println("Enter the scalar for Matrix B. If there is none, enter 1.");           //same logic down here as above
    		String scale2 = SCALAR(r2, c2, second, "Matrix B");

			System.out.println("Expression: (" + scale1 + "A) * (" + scale2 + "B)");
			FillIn(r1, c2, c1, product, first, second);											//method to fill in answer matrix
			printMatrix(r1, c2, product, "the product Matrix");									//print answer matrix
		}
		sc.close();
	}

	public static double[][] FillIn(int rows, int cols2, int cols, double [][] answer, double[][] first, double [][] second){
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols2; j++){
				for(int k = 0; k < cols; k++){
					answer[i][j] += first[i][k] * second[k][j];									//actual process of multiplying 
				}
			}
		}
		return answer;
	}

	public static double[][] populate(int rows, int cols, String[][] given, double[][] doubles){
        Scanner nn = new Scanner(System.in);
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){			                                
                    given[i][j] = nn.next();													//take in user input for as many indexes
    
                    if(given[i][j].contains("/")){                                              //if input has a /, like 9/10      		  
                        String[] splitFraction = given[i][j].split("/");                                
                        double numerator = Double.parseDouble(splitFraction[0]);                    
                        double denominator = Double.parseDouble(splitFraction[1]);                  
                        doubles[i][j] = numerator/denominator;	    
                        doubles[i][j] = Math.round(doubles[i][j] * 1000.000) / 1000.000;                            
                    } else {																	//parsed normally if otherwise, to nearest 3rd
                        doubles[i][j] = Double.parseDouble(given[i][j]);						//decimal place
                        doubles[i][j] = Math.round(doubles[i][j] * 1000.000) / 1000.000; 
                    }
                }
            }
        System.out.println();
        return doubles;
	}
	
	public static double[][] scaling(int rows, int cols, double scalar, double [][]arr){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                arr[i][j] *= scalar;															//scalar multiplication
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
            double denominator = Double.parseDouble(splitFraction[1]);                  //dividing them gives the actual scalar to be used
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
        System.out.println("This is what " + Matrix + " looks like.");			
        for(int i = 0; i < rows; i++){													//method to print the name of matrix and contents
			for(int j = 0; j < cols; j++){
				System.out.print(arr[i][j] + " ");
			}
				System.out.println();
        }
        System.out.println();
		return arr;
    }
}