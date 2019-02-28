/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cocomatricespro;
import java.util.Scanner;
/**
 * Suma
 * Resta
 * Multiplicación
 * Transpuesta
 * Inversa
 * Determinante
 * @author ivxn
 */
public class CocoMatricesPro {

    public static Scanner input;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        input = new Scanner(System.in);
        int menu;
        do
        {
            System.out.println("Ingrese la opción a probar");
            System.out.println("1:Suma\n2:Resta\n3:Multiplicación\n4:Transpuesta");
            System.out.println("5:Inversa\n6:Determinante\n7:Salir");
            System.out.print("Tu elección: ");
            menu = input.nextInt();
            switch(menu)
            {
                case 1:
                    suma();
                    break;
                case 2:
                    resta();
                    break;
                case 7:
                    System.out.println("¡Gracias!");
                    break;
                default:
                    System.out.println("Pruebe de nuevo");
                    break;
            }
            if(menu!=7)
            {
                System.out.print("Presione una tecla para continuar");
                input.nextLine();
            }
        }while(menu!=7);
    }
    
    public static Double[][] askMatrix(int _rows , int _cols)
    {
        Double[][] matrix = new Double[_rows][_cols];
        for(int i=0; i<_rows; i++)
        {
            for (int j = 0; j <_cols; j++) 
            {
                System.out.print("Ingrese el miembro ["+i+"]["+j+"]: ");
                matrix[i][j] = input.nextDouble();
            }
        }
        return matrix;
    }
    
    public static void suma()
    {
        System.out.print("Escriba las dimensiones de la matriz a sumar\nFilas: ");
        int rows = input.nextInt();
        System.out.print("Columnas: ");
        int cols = input.nextInt();
        Matrix matrix1 = new Matrix(askMatrix(rows,cols));
        Matrix matrix2 = new Matrix(askMatrix(rows, cols));
        matrix1.printMatrix();
        System.out.println("        +");
        matrix2.printMatrix();
        Matrix matrix3 = new Matrix();
        System.out.println("        =");
        matrix3 = matrix3.add(matrix1,matrix2);
        if(matrix3.matrix.length>0)
        {
            matrix3.printMatrix();
        }
    }
    
    public static void resta()
    {
        
        System.out.print("Escriba las dimensiones de la matriz a restar\nFilas: ");
        int rows = input.nextInt();
        System.out.print("Columnas: ");
        int cols = input.nextInt();
        Matrix matrix1 = new Matrix(askMatrix(rows,cols));
        Matrix matrix2 = new Matrix(askMatrix(rows, cols));
        matrix1.printMatrix();
        System.out.println("        -");
        matrix2.printMatrix();
        Matrix matrix3 = new Matrix();
        System.out.println("        =");
        matrix3 = matrix3.subtract(matrix1,matrix2);
        if(matrix3.matrix.length>0)
        {
            matrix3.printMatrix();
        }
    }
}