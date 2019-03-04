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
                if(matrix[i][j]==-0.0)
                {
                    matrix[i][j]=0.0;
                }
                System.out.print(String.format( "%.4f", matrix[i][j])+"  ");
            }
            System.out.println("|");
        }
        System.out.println("");
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
    
    /**
     * Función para que el usuario sepa si la matriz está vacía
     * (por error o por elección)
    */
    public boolean isVoid()
    {
        return rowCount==0;
    }
    
    /***
     * Función recursiva para obtener la determinante de una matriz
     * @param _m Matriz a obtener determinante o SUBdeterminate
     * @return  El valor de la determinante o SUBdeterminante
     */
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
    
    /**
     * Devuelve la inversa de la matriz actual.
     * @return la inversa (de tamaño n*(n*2)
     */
    public Matrix getInverse()
    {
        if(this.columnCount!=this.rowCount)
        {
            return new Matrix();
        }
        Matrix ans = new Matrix(this.rowCount, this.columnCount*2); 
        ans.convertToInverse(this);
        for (int i = 0; i < ans.rowCount; i++) 
        {
            ans.divideRow(i,ans.matrix[i][i]);
            ans.printMatrix();
            for (int j = 0; j < i; j++)  //Hacer 0's lo de arriba
            {
                System.out.print("Hacer 0 lo de arriba: ");
                ans.subtractRow(j,i,ans.matrix[j][i]);
                ans.printMatrix();
            }
            for (int j = i+1; j < ans.rowCount; j++) //Hacer 0's lo de abajo
            {

                ans.subtractRow(j,i,ans.matrix[j][i]);
                ans.printMatrix();
            }
            
        }
        return ans.getInversePart(); 
    }
    
    /***
     * Reconvierte una matriz de n*(n*2) a n*n
     * que ha sido manipulada para obtener su inversa
     * @return  Solo la parte inversa de la matriz
     */
    public Matrix getInversePart()
    {
        Matrix ans = new Matrix(this.rowCount, this.columnCount/2);
        for (int i = 0; i < this.rowCount; i++) 
        {
            for (int j = 0; j <this.columnCount/2; j++) 
            {
                ans.matrix[i][j] = this.matrix[i][j+this.columnCount/2];
            }
        }
        return ans;
    }
    
    /**
     * Convierte una matrix para ser trabajada con la inversa de
     * una matrix original
     * @param _m  La matriz original
     */
    public void convertToInverse(Matrix _m)
    {
        for (int i = 0; i < _m.rowCount; i++) 
        {
            for (int j = 0; j <_m.columnCount*2; j++) 
            {
                if(j>=_m.columnCount)
                {
                    if((j-_m.columnCount)==i)
                    {
                        this.matrix[i][j] =1.0;
                    }
                    else
                    {
                        this.matrix[i][j] = 0.0;
                    }
                }
                else
                {
                    this.matrix[i][j] = _m.matrix[i][j];
                }
            }
        }
    }
    
    /**
     * Divide una fila completa entre una constante
     * @param _row La fila que será dividida
     * @param divide La constante por la que será dividida 
     */
    public void divideRow(int _row, double divide)
    {
        System.out.println("Se divide la row "+_row+" entre "+divide);
        for (int i = 0; i < this.columnCount; i++) 
        {
            this.matrix[_row][i] /= divide;
        }
    }
    
    /**
     * Le resta a una fila lo que hay en otra por un multiplicador
     * @param _minRow La fila que se verá afectada
     * @param _susRow La fila con que se restará
     * @param _mult  El multiplicador constante
     */
    public void subtractRow(int _minRow, int _susRow, double _mult)
    {
        System.out.println("Se le resta a la fila "+_minRow+" la fila "+_susRow+" "+_mult+" veces");
        for (int i = 0; i < this.columnCount; i++) 
        {
            this.matrix[_minRow][i] -= this.matrix[_susRow][i]*_mult;
        }
    }
}