class Solution {
        public static int calculateCapacity(int[] height, int i, int j){
            int container_height = Math.min(height[i], height[j]);
            return Math.abs(container_height * (i - j));

        }

        public static int maxArea(int[] height) {
            Map<Integer, Integer[]> dict = new HashMap<Integer, Integer[]>();
            for (int i = 0; i < height.length; i++) {
                if (! dict.containsKey(height[i])){
                    Integer[] new_elem = {-1, -1};
                    dict.put(height[i], new_elem);
                }
                Integer[] elem = dict.get(height[i]);
                if (elem[0] == -1 || elem[0] > i){
                    elem[0] = i;
                }
                if (elem[1] < i){
                    elem[1] = i;
                }
            }

            int[] curr = {-1, -1};
            int max_capacity = -1;
            for (int i: dict.keySet().stream().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray()) {
                Integer[] elem = dict.get(i);
                if(curr[0] == -1 || elem[0] < curr[0]){
                    curr[0] = elem[0];
                }
                if (elem[1] > curr[1]){
                    curr[1] = elem[1];
                }
                max_capacity = Math.max(max_capacity, calculateCapacity(height, curr[0], curr[1]));
            }
            return max_capacity;
        }
    }