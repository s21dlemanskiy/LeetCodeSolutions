class Solution {
        public int search(int[] nums, int target) {
            if (nums.length == 0){
                return -1;
            }
            int sep = nums[0];
            int index = -1;
            int low = 0;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = low  + ((high - low) / 2);
                if(sep <= target && nums[mid] < sep){
                    high = mid - 1;
                    continue;
                }
                if(sep > target && nums[mid] >= sep){
                    low = mid + 1;
                    continue;
                }
                if (nums[mid] < target) {
                    low = mid + 1;
                    continue;
                }
                if (nums[mid] > target) {
                    high = mid - 1;
                    continue;
                }
                if (nums[mid] == target) {
                    index = mid;
                    break;
                }
            }
            return index;
        }
    }