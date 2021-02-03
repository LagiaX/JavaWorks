/**
 * Runnable object with a shared resource
 */
public class MatVectorParThick implements Runnable {
   
    public double[][] matrix;
    public double[] vector;
    public double[] product;

    public int start, end;

    public MatVectorParThick(double[][] matrix, double[] vector, double[] product, int start, int end) {
        this.matrix = matrix;
        this.vector = vector;
        this.product = product;
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i <= end; i++)
            for (int j = 0; j < vector.length; j++)
                product[i] += matrix[i][j] * vector[j];
    }
}
