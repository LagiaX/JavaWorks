package Concurrency;
/**
 * Usage of SmoothImgParThick class as runnable task for parallelism of thick grain. Task is divided in as many cores are available.
 */
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class usingSmoothImgParThick {

    public static void main(String[] args) throws InterruptedException {
        Scanner keyboard = new Scanner(System.in);

        Date d = new Date();
        DateFormat df = new SimpleDateFormat("HH:mm:ss:SSS");
        long initStopwatch;
        long endStopwatch;

        System.out.print("Image dimensions (n pixels x n pixels): ");
        int size = keyboard.nextInt();

        // Divide the work
        int nCores = Runtime.getRuntime().availableProcessors();
        double Cb = 0;
        int nThreads = (int)(nCores / (1 - Cb));

        int start = 0;
        int part = size / nThreads;
        int end = part;

        int[][] img = new int[size][size];
        int[][] prodImg = new int[size][size];

        Thread[] threads = new Thread[nThreads];

        // Generate random image
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                img[i][j] = (int)((Math.random() * 100) % 21);

        initStopwatch = System.currentTimeMillis(); // Prepare the stopwatch
        d.setTime(initStopwatch); // Start!
        System.out.println("Starting work at " + df.format(d));

        for (int i = 0; i < nThreads; i++) {
            threads[i] = new Thread(new SmoothImgParThick(img, prodImg, start, end));
            start += part;
            if (end + part > size - 1)
                end = size - 1;
            else
                end += part;
        }

        for (int i = 0; i < nThreads; i++)
            threads[i].start();

        for (int i = 0; i < nThreads; i++)
            threads[i].join();
        
        endStopwatch = System.currentTimeMillis(); // Stop!
        d.setTime(endStopwatch);
        System.out.println("Finished work at " + df.format(d) + "\nElapsed time of " + (endStopwatch-initStopwatch) + " milliseconds");
        keyboard.close();
    }
}
