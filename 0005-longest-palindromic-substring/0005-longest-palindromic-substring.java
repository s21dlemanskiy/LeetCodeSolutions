class Solution {
        public static int[] expandWhilePalindrom(int left, int right, String s){
            while (true){
                if(left - 1 >= 0 && right + 1 < s.length() && (s.charAt(left - 1) == s.charAt(right + 1))){
                    left--;
                    right++;
                }
                else{
                    break;
                }
            }
            return new int[]{left, right};
        }
        public static String longestPalindrome(String s) {
            int max_length = 1;
            if (s.length() == 0){
                return "";
            }
            String str =  "";
            for (int i=0; i<s.length(); i++){
                if (i+1 < s.length() && s.charAt(i+1) == s.charAt(i)){
                    int[] result = expandWhilePalindrom(i, i+1, s);
                    int left = result[0];
                    int right = result[1];
                    if (max_length < right + 1 - left) {
                        max_length = right + 1 - left;
                        str = s.substring(left, right + 1);
                        System.out.println(str);
                    }
                }
                if (i+2 < s.length() && s.charAt(i+2) == s.charAt(i)){
                    int[] result = expandWhilePalindrom(i, i+2, s);
                    int left = result[0];
                    int right = result[1];
                    if (max_length < right + 1 - left) {
                        max_length = right + 1 - left;
                        str = s.substring(left, right + 1);
                        System.out.println(str);
                    }
                }
            }
            if (max_length == 1){
                return new String(String.valueOf(s.charAt(0)));
            }
            return str;
        }
        //xdsgfswafewf 
    }