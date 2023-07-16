import java.util.Arrays;

class Solution {
    public static int gcd(int a,int b){
        return b == 0 ? a : gcd(b,a % b);
    }
    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0){
            return;
        }
        for (int i = 0; i < gcd(k, n); i++) {
            int curr = i;
            int next = (curr + n - k) % n;
            while (next != i){
                swap(nums, curr, next);
                curr = next;
                next = (curr + n - k) % n;
            }
        }
    }
}