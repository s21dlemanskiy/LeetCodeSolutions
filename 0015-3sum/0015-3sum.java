class Solution {
        public static List<List<Integer>> threeSum(int[] nums) {
            nums = Arrays.stream(nums).sorted().toArray();
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]){
                    continue;
                }
                int j = i + 1;
                int k = nums.length - 1;
                while (j != k){
                    if (j > i + 1 && nums[j] == nums[j - 1]){
                        j++;
                        continue;
                    }
                    if (k < nums.length - 1 && nums[k] == nums[k + 1]){
                        k--;
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> r = new ArrayList<Integer>();
                        r.add(nums[i]);
                        r.add(nums[j]);
                        r.add(nums[k]);
                        result.add(r);
                        j++;
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] > 0) {
                        k--;
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] < 0) {
                        j++;
                        continue;
                    }

                }
            }
            return result;
        }
    }