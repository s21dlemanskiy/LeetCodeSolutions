class Solution {
        public int firstMissingPositive(int[] nums) {
            nums = Arrays.stream(nums).sorted().filter((x) -> x > 0).toArray();
            if (nums.length == 0 || nums[0] > 1){
                return 1;
            }
            int pos_num = -1;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] - nums[i] >= 2 && (nums[i] + 1) > 0){
                    pos_num = nums[i] + 1;
                    break;
                }
            }
            if (pos_num == -1){
                return nums[nums.length - 1] + 1;
            }
            return pos_num;
        }
    }