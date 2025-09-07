import java.util.Arrays;

public class Practice {

//    ToDo: given array of non negative integers representing heights
//    compute how much water can be trapped after raining
//    Example: {0,1,0,2,1,0,1,3,2,1,2,1} -> 6

//    in this case
//    first left = 0 right = 1
//        0<1 so l++
//        1>=1 so r--
//        1<2 so l++
//        0<2 so l++
//        1<2 so l++
//        3>2 so r-- ToDo: each time we should update the position

    private static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int waterTrapped = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    waterTrapped += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    waterTrapped += rightMax - height[right];
                }
                right--;
            }
        }
        return waterTrapped;
    }

//    ToDo: maximum product of element in given sub arr
//    only adjecent elements no random pair

    private static int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int tempMax = Math.max(curr, Math.max(curr * maxSoFar, curr * minSoFar));

            minSoFar = Math.min(curr, Math.min(curr * maxSoFar, curr * minSoFar));
            maxSoFar = tempMax;
            result = Math.max(result, maxSoFar);
        }
        return result;
    }

//    ToDo: identify the first missing positive number from unsorted array
//    Example: {3,1,-2,4} -> 2

    private static void missingNumber() {
        int[] input = {3, 1, -2, 4};
        int n = input.length;

        for (int i = 0; i < n; ) {
            int correctIndex = input[i] - 1;
            if (input[i] > 0 && input[i] <= n && input[i] != input[correctIndex]) {
                int temp = input[i];
                input[i] = input[correctIndex];
                input[correctIndex] = temp;
            } else {
                i++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (input[i] != i + 1) {
                System.out.println("First missing positive: " + (i + 1));
                return;
            }
        }
        System.out.println("First missing positive: " + (n + 1));
    }

//    ToDo: subarray sum = k
//    count number of contigious sub array
//    Ex: {1,1,1} -> k=2

    private static void countFromArray(int[] arr, int target){

        for (int i = 0; i <= arr.length-1; i++){
            if (arr[i] == target){
                System.out.println("Target match found from given array: " + arr[i] + " No addition match found from array");
            }
            for (int j = i+1; j <= arr.length-1; j++){
                int temp = arr[i] + arr[j];
                if (temp == target){
                    System.out.println("Target element match found: " + arr[i] + " + " + arr[j] + " = " + temp);
                    return;
                }
            }
        }

    }

//    ToDo: median of two sorted array
//    Ex: {1,3} -> 2

    private static void median(int[] arr){
        int len = arr.length;

        for (int i = 0; i <= arr.length-1; i++){
            for (int j = i+1; j <= arr.length-1; j++){
                if (arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Sorted array: " + Arrays.toString(arr));

        if (len % 2 == 0 ){
            int temp = (arr[(len/2) - 1] + arr[len/2])/2;
            System.out.println("Median for given array is: " + temp);
        }else {
            int temp = len/2;
            System.out.println("Median for given array is: " + arr[temp]);
        }
    }

//    ToDo: longest consicutive sequence
//    Ex: {100,4,200,1,3,2} -> 1 2 3 4

    private static void longestSeq(int[] arr){
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));

        int longest = 1;
        int current = 1;
        int bestStart = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                current++;
            } else if (arr[i] != arr[i - 1]) {
                current = 1;
            }

            if (current > longest) {
                longest = current;
                bestStart = arr[i] - current + 1;
            }
        }

        System.out.print("Longest consecutive sequence: ");
        for (int i = 0; i < longest; i++) {
            System.out.print((bestStart + i) + " ");
        }
        System.out.println();
    }

//    ToDo: search in rotated sorted array
//    Ex: {4,5,6,7,0,1,2} -> target = 0 -> 4

    private static int rotatedArraySearch(int[] arr, int target){
//      For small array this will be fine but complexity is more
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                index = i;
                break;
            }
        }
        System.out.println("Target found: " + index);

//        optimal solution as per leetcode standards
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                System.out.println("Target found: " + arr[mid] + " at index " + mid);
                return mid;
            }

            if (arr[left] <= arr[mid]) {
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
//        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
//        System.out.println("Trapped water: " + trap(heights));

//        int[] nums = {2, 3, -2, 4};
//        System.out.println("Max Product: " + maxProduct(nums));

//        missingNumber();
//
//        int[] arr = {1, 2, 3, 11, 19, 27, 23, 1};
//        int target = 2;
//        countFromArray(arr, target);

//        int[] arr = {1, 3, 10, 4, 7, 9, 2, 6};
//        median(arr);

//        int[] arr = {100, 4, 200, 1, 3, 2};
//        longestSeq(arr);

        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;
        rotatedArraySearch(arr, target);

    }


}
