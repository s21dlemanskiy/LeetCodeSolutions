class Solution {
        public double myPow(double x, int n) {
            boolean neg = false;
            if (n < 0){
                neg = true;
                n = -n;
            }
            double result = 1.0;
            int counter = 0;
            while (n != 0){
                double tm_result;
                System.out.println(n);
                if (!neg) {
                        tm_result = x;
                    }else{
                        tm_result = 1.0/x;
                    }
                counter++;
                if ((n & 1) == 0){
                    n = n>>>1;
                    continue;
                }else{
                    n = n>>>1;
                }
                for (int i = 0; i < counter - 1; i++) {
                    tm_result *= tm_result;
                }
                System.out.println(tm_result);
                result *= tm_result;
            }
            return result;
        }
    }