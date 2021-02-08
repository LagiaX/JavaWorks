package Concurrency;
/**
 * Example of parallel threads working at the same time. There is no critical region.
 */

public class scaleVectorParallel extends Thread {

    public static int[] sharedVector;

    int start, end;

    public scaleVectorParallel(int[] vect, int start, int end) {
        if (sharedVector == null)
            sharedVector = vect;
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i < end; i++)
            sharedVector[i] *= 20;
    }

    public static void display(int start, int end) {
        for (int i = start; i < end; i++)
            System.out.print(sharedVector[i] + " ");
        System.out.println("");
    }

    public static void main(String[] args) throws InterruptedException {

        int size = 100000;
        int[] vector = new int[size];

        for (int i = 0; i < vector.length; i++)
            vector[i] = (int)Math.ceil(Math.random() * 100);

        int task = vector.length / 4; // Divide the work in four smaller tasks

        scaleVectorParallel[] threads = new scaleVectorParallel[4]; // Create four threads, each one will do one task

        int start = 0;
        int end = task;

        for (int i = 0; i < 4; i++) { // Assign all four tasks
            threads[i] = new scaleVectorParallel(vector, start, end);
            start += task;
            end += task;
            if (end > size)
                end = size; 
        }

        System.out.print("Start of the vector: ");
        display(0, 5);
        System.out.print("End of the vector: ");
        display(size-5, size);

        for (int i = 0; i < 4; i++) // Launch the threads
            threads[i].start();

        for (int i = 0; i < 4; i++) // Stop the main thread until all threads are done
            threads[i].join();

        System.out.print("Start of the vector: ");
        display(0, 5);
        System.out.print("End of the vector: ");
        display(size-5, size);
        System.out.println("Vector successfully scaled by 20.");
    }
}