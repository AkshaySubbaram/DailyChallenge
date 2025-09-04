public class Practice {

//    ToDo: given array of non negative integers representing heights
//    compute how much water can be trapped after raining
//    Example: {0,1,0,2,1,0,1,3,2,1,2,1} -> 6

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

    public static void main(String[] args){
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Trapped water: " + trap(heights));
    }
}
