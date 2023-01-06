class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index1 = -1;
        int index2;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low  + ((high - low) / 2);
            if (nums[mid] < target) {
                low = mid + 1;
                continue;
            }
            if (nums[mid] > target) {
                high = mid - 1;
                continue;
            }
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) {
                    index1 = mid;
                    break;
                }
                high--;
            }
        }
        if (index1 == -1){
            return new int[]{-1, -1};
        }
        for (index2 = index1; index2 < nums.length; index2++) {
            if (nums[index2] != nums[index1]){
                break;
            }
        }
        index2--;
        return new int[]{index1, index2};
    }
}