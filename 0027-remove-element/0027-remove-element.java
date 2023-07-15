class Solution {
    public static int removeElement(int[] nums, int val) {
        int index = nums.length - 1;
        if (nums.length == 0){
            return 0;
        }
        int i = 0;
        while (i < index){
            if (nums[index] == val){
                index -= 1;
                continue;
            }
            if (nums[i] == val){
                nums[i] = nums[index];
                index -= 1;
            }
            i += 1;
        }
        if (nums[i] == val || index < i){
            return i;
        }else{
            return i + 1;
        }
    }
}