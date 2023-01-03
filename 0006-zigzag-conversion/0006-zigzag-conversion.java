class Solution {
        public static String convert(String s, int numRows) {
            if (numRows <= 1){
                return s;
            }
            int cicl_len = numRows * 2 - 2;
            StringBuilder result = new StringBuilder("");
            for (int j = 0; j <= cicl_len / 2; j++) {
                for (int i = 0; i < s.length(); i = i + cicl_len) {
                    if (i + j < s.length()) {
                        System.out.println(i + j);
                        result.append(s.charAt(i + j));
                    }
                    if (j != 0 && j != cicl_len / 2 && i + cicl_len - j < s.length()) {
                        result.append(s.charAt(i + cicl_len - j));
                    }

                }
            }
            return result.toString();
        }
    }