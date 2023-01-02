class Solution {
        public static int lengthOfLongestSubstring(String s) {
            int max_len = 0;
            int start = 0; // start substring
            int end; // end substring
            for (end = 0; end < s.length(); end++) {
                int repeat_index = s.substring(start, end).indexOf(s.charAt(end));
                if (repeat_index != -1){
                     start = repeat_index + start + 1;
                }
                if (end + 1 - start > max_len){
                    max_len = end + 1 - start;
//                    System.out.println(s.substring(start, end + 1));
                }
            }
            return max_len;
        }
    //fdcgb
    }