package Concurrency;
/**
 * Example of parallelism of thick grain. Task is divided in as many cores are available.
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.*;

public class usingMatVectorParThick {

    public static void main(String[] args) throws InterruptedException {

        Scanner keyboard = new Scanner(System.in);

        Date d = new Date();
        DateFormat df = new SimpleDateFormat("HH:mm:ss:SSS");
        long initStopwatch;
        long endStopwatch;

        System.out.println("Matrix size\n");
        int size = keyboard.nextInt();

        double[][] matrix = new double[size][size];
        double[] vector = new double[size];
        double[] product = new double[size];

        // Divide the work
        int nCores = Runtime.getRuntime().availableProcessors();
        double Cb = 0;
        int nThreads = (int)(nCores / (1 - Cb));

        ThreadPoolExecutor pool = new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

        int start = 0;
        int part = size / nThreads;
        int end = part;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                matrix[i][j] = Math.ceil(Math.random() * 10);
            vector[i] = Math.ceil(Math.random() * 10);
        }

        initStopwatch = System.currentTimeMillis(); // Prepare the stopwatch
        d.setTime(initStopwatch); // Start!
        System.out.println("Starting work at " + df.format(d));

        for (int i = 0; i < nThreads; i++) {
            pool.execute(new Thread(new MatVectorParThick(matrix, vector, product, start, end)));
            start += part;
            if (end + part > size - 1)
                end = size - 1;
            else
                end += part;
         }

         pool.shutdown();
         while (!pool.isTerminated()) {}

         endStopwatch = System.currentTimeMillis(); // Stop!
         d.setTime(endStopwatch);
         System.out.println("Finished work at " + df.format(d) + "\nElapsed time of " + (endStopwatch-initStopwatch) + " milliseconds");
         keyboard.close();
    }
    
}
