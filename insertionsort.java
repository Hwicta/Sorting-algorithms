package tietorakenteet;

import java.util.Arrays;

public class insertionsort {

	public static void main(String[] args) {
		// listan tekeminen ja täyttö satunnaisilla luvuilla
	    int max = 30000000;
	    int min = 0;
	    int range = max - min + 1;
	    int size = 500;
	    int[] array = new int[size];

	    for (int i = 0; i < size; i++) {
	        int rand = (int) (Math.random() * range + min);
	        array[i] = rand;
	    }
	    // algoritmi alkaa
	    int temp = 0;
	    // aloitetaan ajan otto
	    long startTime = System.nanoTime();
	    for (int i = 0; i < size; i++) {
	        for (int j = 1; j < size - i; j++) {
	            if (array[j - 1] > array[j]) {
	                temp = array[j - 1];
	                array[j - 1] = array[j];
	                array[j] = temp;
	            }
	        }
	    }
	    // lopetetaan ajanotto
	    long endTime   = System.nanoTime();
	    long totalTime = endTime - startTime;
	    // tulostukset
	    System.out.println(Arrays.toString(array));
	    System.out.println("ohjelman suorittaminen kesti " + totalTime + " millisekuntia");
	}
}
