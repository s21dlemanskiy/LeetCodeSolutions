class Solution {
        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n = 0;
            int m = 0;
            int[] arr = new int[2];
            int main_langth = nums1.length + nums2.length;
            while (n + m <= main_langth / 2.0) {
                if (n == nums1.length) {
                    arr[0] = arr[1];
                    arr[1] = nums2[m];
                    m++;
                    continue;
                }
                if (m == nums2.length) {
                    arr[0] = arr[1];
                    arr[1] = nums1[n];
                    n++;
                    continue;
                }
                if (nums1[n] > nums2[m]) {
                    arr[0] = arr[1];
                    arr[1] = nums2[m];
                    m++;
                } else {
                    arr[0] = arr[1];
                    arr[1] = nums1[n];
                    n++;
                }
            }
            System.out.println(Integer.toString(arr[0]) + "--" + Integer.toString(arr[1]));
            if (main_langth % 2 == 1) {
                 return arr[1];
            }
            return (arr[0] + arr[1]) / 2.0;
        }
    }