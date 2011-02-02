/*
 * Klasa twarzaca macierz sasiedztwa 
 */
package robotinternetowy.persistence;
/**
 *
 * @author yarpo
 */
public class Matrix
{
    private int[][] matrix;
    private int n;

    public Matrix (int _n)
    {
        n = _n;
        matrix = new int[n][n];
       
    }

    public int[][] getMatrix ()
    {
        return matrix;
    }

    public int getSize ()
    {
        return n;
    }

    public void setRow (int k, int[] row)
    {
        for (int i = 0; i < n; i++)
        {
            matrix[k][i] = row[i];
        }
    }

    public void print ()
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(matrix[i][j] + " \t");
            }
            System.out.println("");
        }
    }
}
