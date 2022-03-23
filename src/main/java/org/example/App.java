package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int[] randArray = new int[30];
        for (int i = 0; i < randArray.length; i ++) {
            randArray[i] = (int) (Math.random() * 32) + 1;
        }

        System.out.println("Unsorted: ");
        for (int i: randArray) {
            System.out.println(i);
        }

        System.out.println("Sorting: ");
        int[] sorted = Sort.fullMergeSort(randArray);

        System.out.println("Sorted: ");
        Sort.printIntArray(sorted);
    }
}
