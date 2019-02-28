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
    private int rowCount;
    private int columnCount;
    public Double[][] matrix;
    
    Matrix(){}
    
    Matrix(int _rowCount, int _columnCount)
    {
        columnCount = _columnCount;
        matrix = new Double[_rowCount][_columnCount];
        rowCount = _rowCount;
    }
    
    Matrix(Double[][] _matrix)
    {
        matrix = new Double[_matrix.length][_matrix[0].length];
        setMatrix(_matrix);
    }
 
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
    
    public boolean setMember(Double value, int _row, int _col)
    {
        if(_row<=rowCount && _col<=columnCount)
        {
            matrix[_row][_col] = value; 
            return true; 
       }
        return false; 
    }

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
    
    public Matrix add(Matrix m1, Matrix m2)
    {
        if(m1.matrix.length == m2.matrix.length && 
        m1.matrix[0].length == m2.matrix[0].length)
        {
            Matrix ans = new Matrix(m1.matrix.length,m1.matrix[0].length);
            for (int i = 0; i < m1.matrix.length; i++) 
            {
                for (int j = 0; j < m1.matrix[0].length; j++) 
                {
                    ans.setMember((m1.matrix[i][j]+m2.matrix[i][j]), i, j);
                }
            }
            return ans;
        }
        return new Matrix(0,0);
    }
    
    public Matrix subtract(Matrix m1, Matrix m2)
    {
        if(m1.matrix.length == m2.matrix.length && 
        m1.matrix[0].length == m2.matrix[0].length)
        {
            Matrix ans = new Matrix(m1.matrix.length,m1.matrix[0].length);
            for (int i = 0; i < m1.matrix.length; i++) 
            {
                for (int j = 0; j < m1.matrix[0].length; j++) 
                {
                    ans.setMember((m1.matrix[i][j]-m2.matrix[i][j]), i, j);
                }
            }
            return ans;
        }
        return new Matrix(0,0);
    }
}