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
    public int columnCount;
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
     * Genera una matrix de tamaño (n-1)(n-1) basado en 
     * otra matriz y un pivote
     * @param _m La matriz de tamaño n*n
     * @param pivRow Ubicación en fila del pivote.
     * @param pivCol  Ubicación en columna dek pivote.
     */
    Matrix(Matrix _m, int pivRow, int pivCol)
    {
        int rows=0, cols=0;
        rowCount = _m.rowCount-1;
        columnCount = _m.columnCount-1;
        matrix = new Double[rowCount][columnCount];
        for (int i = 0; i < _m.rowCount; i++) 
        {
            cols = 0;
            for (int j = 0; j < _m.columnCount; j++) 
            {
                if(i!=pivRow && j!=pivCol)
                {
                    this.matrix[rows][cols] = _m.matrix[i][j];
                    cols++;
                }
            }
            if(i!=pivRow)
            {
                rows++;
            }
        }
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
    
    /**
     * Devuelve la multiplicación de una matriz1 x matriz1 
     * @param m1 matriz 1
     * @param m2 matriz 2
     * @return  matriz1*matriz2 si aplica, sino matriz de 0x0
     */
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
    
    public boolean isVoid()
    {
        return rowCount==0;
    }
    
    public double getDeterminant(Matrix _m)
    {
        if(_m.rowCount==1 && _m.rowCount==_m.columnCount)
        {
            return _m.matrix[0][0];
        }
        else if(_m.rowCount==2 && _m.rowCount == _m.columnCount)
        {
            return _m.matrix[0][0] * _m.matrix[1][1] - _m.matrix[0][1] * _m.matrix[1][0];
        }
        else if(_m.rowCount == _m.columnCount)
        {
            Double acumulate = 0.0;
            for(int i=0; i<_m.rowCount; i++)
            {
                Double sign=1.0;
                if(i%2!=0)
                {
                    sign = -1.0; //Si el rowCount es impar Y el pivote está en posición 
                }
                Matrix _temp = new Matrix(_m,0,i);
                acumulate += (sign * _m.matrix[0][i] * getDeterminant(_temp));
            }
            return acumulate;
        }
        return 0;
    }
}