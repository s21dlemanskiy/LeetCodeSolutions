class Solution {
        public double myPow(double x, int n) {
            boolean neg = false;
            if (n < 0){
                neg = true;
                n = -n;
            }
            double result = 1.0;
            if (neg) {
                x = 1.0/x;
            }
            while (n != 0){
                if ((n & 1) == 0){
                    n = n>>>1;
                    x *= x;
                    continue;
                }else{
                    n = n>>>1;
                }
                result *= x;
                x *= x;
            }
            return result;
        }
    }