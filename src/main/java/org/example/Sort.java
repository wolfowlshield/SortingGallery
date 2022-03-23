package org.example;

public class Sort {

    /**
     * Should take in an array of two ints and changes it
     * to arrray with the numbers from smallest to largest.
     * @param nums
     */
    public static void sortTwo(int[] nums) {
        if (nums[0] > nums[1]) {
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
        }
    }

    /**
     * This function should take the two arrays and merge them into the inputArray.
     * The result should be in order from smallest to largest, with all the numbers from both arrays included.
     * @param inputArray - The original array that will come back changed.
     * @param array1 - A sorted list of numbers that is the size of half the length of the inputArray
     * @param array2 - A sorted list of numbers that is the size of half the length of the inputArray
     */
    public static void merge(int[] inputArray, int[] array1, int [] array2) {
        int placeOne = 0;
        int placeTwo = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (!(placeOne >= array1.length || placeTwo >= array2.length)) {
                if (array1[placeOne] > array2[placeTwo]) {
                    inputArray[i] = array2[placeTwo];
                    placeTwo++;
                } else {
                    inputArray[i] = array1[placeOne];
                    placeOne++;
                }
            } else if (placeOne >= array1.length) {
                inputArray[i] = array2[placeTwo];
                placeTwo++;
            } else {
                inputArray[i] = array1[placeOne];
                placeOne++;
            }
        }
        printIntArray(inputArray);
    }

    public static void printIntArray(int[] nums) {
        for (int i: nums) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    public static int[] fullMergeSort(int[] nums) {
        // if nums is only 2 length
            // Sort two and return
        // if nums is only 1 length
            // return
        // merge(first half of nums, second half of nums)

        if (nums.length == 2) {
            sortTwo(nums);
            printIntArray(nums);
            return nums;
        }
        if (nums.length == 1) {
            printIntArray(nums);
            return nums;
        }
        int[] firstHalf = new int[nums.length / 2];
        int[] secondHalf = new int[nums.length - nums.length / 2];

        System.arraycopy(nums, 0, firstHalf, 0, firstHalf.length);
        System.arraycopy(nums, firstHalf.length, secondHalf, 0, secondHalf.length);

        merge(nums, fullMergeSort(firstHalf), fullMergeSort(secondHalf));
        return nums;
    }
}
