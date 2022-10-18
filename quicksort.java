package tietorakenteet;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class quicksort {
	
	private static void quicksort(int[] array, int lowIndex, int highIndex) {
		if(lowIndex >= highIndex) {
			return;
		}
		// valitaan pivotti
		int pivot = array[highIndex];
		int leftPointer = lowIndex;
		int rightPointer = highIndex;
		// alla oleva algoritmi valitsee pivotin jonka jälkeen käy se käy läpi kaikki arvot läpi
		// tuoden muuttujaa lowIndex ja highIndexiä lähemmäksi. Jos leftPointer saa isomman arvon kuin rightPointer
		// while loop menee poikki.
		while (leftPointer < rightPointer) {
			
			while(array[leftPointer] <= pivot && leftPointer < rightPointer) {
				leftPointer++;
				
			}
			while(array[rightPointer] >= pivot && leftPointer < rightPointer) {
				rightPointer--;
			}
			swap(array, leftPointer, rightPointer);
		}
			swap(array, leftPointer, highIndex);
			quicksort(array, lowIndex, leftPointer -1);
			quicksort(array, leftPointer +1,highIndex);
	}
	private static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1]=array[index2];
		array[index2] = temp;
	}

	public static void main(String[] args) {
		// luodaan lista ja arvotaan siihen luvut
		int max = 30000000;
	    int min = 0;
	    int range = max - min + 1;
	    int size = 1000;
	    int[] arr = new int[size];
	    for (int i = 0; i < size; i++) {
	        int rand = (int) (Math.random() * range + min);
	        arr[i] = rand;
	    }
	    	long startTime = System.nanoTime();
			quicksort(arr,0,arr.length -1);
			long endTime   = System.nanoTime();
			long totalTime = endTime - startTime;
			// tulostaminen
			System.out.println(Arrays.toString(arr));
		    System.out.println("ohjelman suorittaminen kesti " + totalTime + " nanosekuntia");
		}
	}

