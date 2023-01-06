class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0){
                return 0;
            }

            int i = 1; // position from insert
            int j = 1; // position to insert
            while (i < nums.length){
                if (nums[i] != nums[i - 1]){
                    nums[j] = nums[i];
                    j++;
                }
                i++;
            }
            return j;
        }
    }