public class Solution {
    public static int trap(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length - 1; i++) {
            int index_max = -1;
            int sumtmp = 0;
            int count = 0;
            int counttmp = 0;
            for (int j = i + 1; j < height.length; j++) {
                if ( index_max == -1 || height[index_max] <= height[j]){
                    index_max = j;
                    sum += sumtmp;
                    count += counttmp;
                    sumtmp = 0;
                    counttmp = 0;
                    if (height[index_max] > height[i]){
                        break;
                    }
                }
                sumtmp += height[i] - height[j];
                counttmp++;
            }
            if (height[i] > height[index_max]){
                sum -= count * (height[i] - height[index_max]);
            }
//            System.out.println(Integer.toString(i) + "-" + Integer.toString(index_max) + "-" + Integer.toString(sum));
            i = index_max - 1;
        }
        return sum;
    }
}