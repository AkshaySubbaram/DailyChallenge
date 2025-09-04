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

    public static int trap(int[] height) {
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

    public static int maxProduct(int[] nums) {
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

    public static void main(String[] args){
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Trapped water: " + trap(heights));

        int[] nums = {2, 3, -2, 4};
        System.out.println("Max Product: " + maxProduct(nums));
    }


}
