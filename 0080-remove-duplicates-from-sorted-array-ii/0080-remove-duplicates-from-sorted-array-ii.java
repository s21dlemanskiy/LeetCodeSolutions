class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 1){
                return 1;
            }
            if (nums.length == 2){
                return 2;
            }

            int i = 2; // position from insert
            int j = 2; // position to insert
            int mem = nums[j];
            while (i < nums.length){
                if (nums[i] != nums[i - 2]){
                    mem = nums[j];
                    nums[j] = nums[i];
                    j++;
                    i++;
                    continue;
                }
                if (i - 2 == j - 1 && nums[i] != mem){
                    mem = nums[j];
                    nums[j] = nums[i];
                    j++;
                    i++;
                    continue;
                }
                i++;
            }
            return j;
        }
    }