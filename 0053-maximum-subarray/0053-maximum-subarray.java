class Solution {
//    Kadane's Algorithm
    public int maxSubArray(int[] nums) {
        int curr_sum = nums[0]; // наибольшая сумма закачивающаяся на элемене i
        int glob_sum = nums[0]; // наибольшая сумма подстроки
        for (int i = 1; i < nums.length; i++) {
            curr_sum = Math.max(nums[i], nums[i] + curr_sum);  // наибольшая сумма закачивающаяся на элемене i это либо сам этот элемент либо сумма для i-1 эл-та + сам этот элемент
            if(glob_sum < curr_sum) {                          // если текущая сумма больше глобальной обновляем глобальную
                glob_sum = curr_sum;
            }
        }
        return glob_sum;
    }
}