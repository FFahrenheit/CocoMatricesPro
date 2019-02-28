/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cocomatricespro;

/**
 *  - > -> M A S T E R   *   C L A S S <- <-  
 * Esta clase maneja las matrices y sus operaciones
 * @author usuario
 */
public class Matrix 
{
    public int rowCount;
    private int columnCount;
    public Double[][] matrix;
    /**
     * Constructor vacío.
     */
    Matrix()
    {
        rowCount = 0;
        columnCount = 0;
    }
    
    /**
     * Constructor que inicializa las dimensiones
     * @param _rowCount numero de filas
     * @param _columnCount  numero de columnas
     */
    Matrix(int _rowCount, int _columnCount)
    {
        columnCount = _columnCount;
        matrix = new Double[_rowCount][_columnCount];
        rowCount = _rowCount;
    }
    
    /**
     * Constructor que convierte un arreglo bidimensional
     * de doubles en matriz
     * @param _matrix Arreglo bidimensional a transformar
     */
    Matrix(Double[][] _matrix)
    {
        matrix = new Double[_matrix.length][_matrix[0].length];
        setMatrix(_matrix);
    }
 
    /**
     * Función que inicializa los valores de una matriz
     * definida con base a un arreglo bidimensional de doubles
     * @param _matrix  Arreglo bidimensional a transoformar en matriz
     */
    public void setMatrix(Double[][] _matrix)
    {
        rowCount = _matrix.length;
        columnCount = _matrix[0].length;
        for(int i=0; i<rowCount;i++)
        {
            for(int j=0; j<columnCount; j++)
            {
                matrix[i][j] =  _matrix[i][j]; 
            }
        }
    }
    
    /**
     * Coloca un valor en la posición deseada de la matriz
     * @param value Valor a color en
     * @param _row la fila deseada y 
     * @param _col la columna deseada 
     * @return true si es aplicable, false sino.
     */
    public boolean setMember(Double value, int _row, int _col)
    {
        if(_row<=rowCount && _col<=columnCount)
        {
            matrix[_row][_col] = value; 
            return true; 
       }
        return false; 
    }

    /**
     * Imprime la matriz con un método muy arcaico
     */
    public void printMatrix()
    {
        for(int i=0; i<rowCount; i++)
        {
            System.out.print("|  ");
            for(int j=0; j<columnCount; j++)
            {
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println("|");
        }
    }
    
    /**
     * Suma dos matrices y las devuelve
     * @param m1 Matriz 1 a sumar
     * @param m2 Matriz 2 a sumar
     * @return  Matriz1 + Matriz2 si aplica, sino una matriz de 0x0
     */
    public Matrix add(Matrix m1, Matrix m2)
    {
        if(m1.rowCount == m2.rowCount && 
        m1.columnCount == m2.columnCount)
        {
            Matrix ans = new Matrix(m1.rowCount,m1.columnCount);
            for (int i = 0; i < m1.rowCount; i++) 
            {
                for (int j = 0; j < m1.columnCount; j++) 
                {
                    ans.setMember((m1.matrix[i][j]+m2.matrix[i][j]), i, j);
                }
            }
            return ans;
        }
        return new Matrix();
    }
    
     /**
     * Resta dos matrices y las devuelve
     * @param m1 Matriz minuendo
     * @param m2 Matriz sustraendo
     * @return  Matriz1 - Matriz2 si aplica, sino una matriz de 0x0
     */
    public Matrix subtract(Matrix m1, Matrix m2)
    {
        if(m1.rowCount == m2.rowCount && 
        m1.columnCount == m2.columnCount)
        {
            Matrix ans = new Matrix(m1.rowCount,m1.columnCount);
            for (int i = 0; i < m1.rowCount; i++) 
            {
                for (int j = 0; j < m1.columnCount; j++) 
                {
                    ans.setMember((m1.matrix[i][j]-m2.matrix[i][j]), i, j);
                }
            }
            return ans;
        }
        return new Matrix();
    }
    
    /**
     * Obtiene la matriz transpuesta
     * @return la matriz transpuesta de la matriz actual
     */
    public Matrix getTransposed()
    {
        Matrix ans = new Matrix(this.columnCount, this.rowCount);
        for (int i = 0; i < this.columnCount; i++) 
        {
            for (int j = 0; j < this.rowCount; j++) 
            {
                ans.setMember(this.matrix[j][i],i,j);
            }
        }
        return ans;
    }
    
    public Matrix dotProduct(Matrix m1, Matrix m2)
    {
        if(m1.rowCount==m2.columnCount)
        {
            Matrix ans = new Matrix(m1.rowCount, m2.columnCount);
            for(int i=0; i<m1.rowCount;i++)
            {
                for (int j = 0; j < m2.columnCount; j++) 
                {
                    Double acum = 0.0;
                    for(int k=0; k<m1.columnCount; k++)
                    {
                        acum+= m1.matrix[i][k] * m2.matrix[k][j];
                    }
                    ans.setMember(acum, i, j);
                }
            }
            return ans;
        }
        return new Matrix();
    }
}