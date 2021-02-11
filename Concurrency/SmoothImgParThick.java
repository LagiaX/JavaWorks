package Concurrency;
/**
 * Runnable object with a shared resource
 */

public class SmoothImgParThick implements Runnable {
    
    public int[][] img;
    public int[][] prodImg;
    public int start, end;
    public int size;

    public SmoothImgParThick(int[][] img, int[][] prodImg, int start, int end) {
        size = img.length;
        this.img = img;
        this.prodImg = prodImg;
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i < end; i++) {
            for (int j = 0; j < size; j++) {
                prodImg[i][j] = (4 * img[i][j] - img[(i + 1) % size][j] - img[Math.abs(i - 1) % size][j] - img[i][(j + 1) / size] - img[i][Math.abs(j - 1) % size]) / 8;
            }
        }
    }
}