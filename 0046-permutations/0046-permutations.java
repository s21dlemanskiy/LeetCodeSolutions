class Solution {
    static int[] used;
    static List<List<Integer>> result;
    static int[] nums_pub;
    public static void confirmResult(){
        int[] tmp_result = new int[used.length];
        for (int i = 0; i < used.length; i++) {
            tmp_result[used[i]] = nums_pub[i];
        }
        result.add(Arrays.stream(tmp_result).boxed().toList());
    }
    public static void recursiveProduct(int n){
        if (n == nums_pub.length){
            confirmResult();
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (used[i] == -1){
                used[i] = n;
                recursiveProduct(n + 1);
                used[i] = -1;
            }
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        nums_pub = nums;
        used = new int[nums.length];
        Arrays.fill(used, -1);
        result = new ArrayList<>();
        recursiveProduct(0);
        return result;
    }
}