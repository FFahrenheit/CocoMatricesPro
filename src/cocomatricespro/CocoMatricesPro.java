/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cocomatricespro;
import java.util.Scanner;
/**
 * Suma * 
 * Resta * 
 * Multiplicación
 * Transpuesta *
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
                case 3:
                    multiplicacion();
                    break;
                case 4:
                    transpuesta();
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
                System.out.print("Presione una tecla y emter para continuar");
                input.next();
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
        System.out.print("Escriba las dimensiones de las matrices a sumar\nFilas: ");
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
        if(matrix3.rowCount>0)
        {
            matrix3.printMatrix();
        }
        else
        {
            System.out.println("No se pueden sumar matrices de distinto tamaño");
        }
    }
    
    public static void resta()
    {
        
        System.out.print("Escriba las dimensiones de las matrices a restar\nFilas: ");
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
        if(matrix3.rowCount>0)
        {
            matrix3.printMatrix();
        }
        else
        {
            System.out.println("No se pueden restar matrices de distinto tamaño");
        }
    }
    public static void transpuesta()
    {
        System.out.print("Ingrese las dimensiones de la matriz a transponer\nFilas: ");
        int rows = input.nextInt();
        System.out.print("Columnas: ");
        int cols = input.nextInt();
        Matrix matrix = new Matrix(askMatrix(rows,cols));
        matrix.printMatrix();
        System.out.println("        MT= ");
        Matrix transpuesta = matrix.getTransposed();
        transpuesta.printMatrix();
    }
    
    public static void multiplicacion()
    {
        System.out.print("Ingrese las dimensiones de la matriz 1 a multiplicar\nFilas: ");
        int rows = input.nextInt();
        System.out.print("Columnas: ");
        int cols = input.nextInt();
        Matrix m1 = new Matrix(askMatrix(rows,cols));
        System.out.print("Ingrese las dimensiones de la matriz 2 a multiplicar\nFilas: ");
        rows = input.nextInt();
        System.out.print("Columnas: ");
        cols = input.nextInt();
        Matrix m2 = new Matrix(askMatrix(rows, cols));
        Matrix m3 = m1.dotProduct(m1, m2);
        m1.printMatrix();
        System.out.println("        *");
        m2.printMatrix();
        if(m3.rowCount>0)
        {
            System.out.println("        =");
            m3.printMatrix();
        }
        else
        {
            System.out.println("Matrices no compatibles");
        }
    }
}