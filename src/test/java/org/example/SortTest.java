package org.example;

import junit.framework.TestCase;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SortTest extends TestCase {

    public void testSortTwo() {
        int[] unorderedArray = new int[] {82, 19};
        int[] orderedArray = new int[] {19, 82};
        int[] expectedArray = new int[] {19, 82};
        Sort.sortTwo(unorderedArray);
        assertTrue(Arrays.equals(unorderedArray,expectedArray));
        assertTrue(Arrays.equals(orderedArray,expectedArray));
    }

    public void testMerge() {
        int[] startingArray = new int[] {19,5,34,81,17,22,6};
        int[] leftHalf = new int[] {5,19,34,81};
        int[] rightHalf = new int[] {6,17,22};
        int[] expectedResult = new int[] {5,6,17,19,22,34,81};
        Sort.merge(startingArray,leftHalf,rightHalf);
        assertTrue(Arrays.equals(startingArray, expectedResult));
    }

    public void testTimedSort() {
        long[] times = new long[5000];
        int arraySize = 3000;
        for (int i = 0; i < times.length; i++) {
            int[] randArray = new int[arraySize];
            int[] sortedArray;
            for (int r = 0; r < randArray.length; r++){
                randArray[r] = (int) (Math.random() * 10000) + 1;
            }

            long startTime = System.currentTimeMillis();
            sortedArray = Sort.fullMergeSort(randArray);
            long timeTaken = System.currentTimeMillis() - startTime;

            boolean isSorted = true;
            for (int s = 0; s < sortedArray.length - 1; s++) {
                if (sortedArray[s] > sortedArray[s + 1]) {
                    isSorted = false;
                    break;
                }
            }
            assertTrue(isSorted);
            times[i] = timeTaken;
        }

        long averageTime = 0;
        for (long l: times) {
            averageTime += l;
        }
        averageTime /= times.length;
        System.out.println("It took " + averageTime + "ms on average to sort a list of " + arraySize + " Items.");
    }
}