class Solution {
        public static int romanToInt(String s) {
            Map<Character, Integer> dict = new HashMap<Character, Integer>();
            int[] val = {1, 5, 10, 50, 100,  500, 1000};
            char[] keys = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
            String signs = "IVXLCDM";
            for (int i = 0; i <= 6; i++) {
                dict.put(keys[i], val[i]);
            }
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                char sign = s.charAt(i);
                if (i < s.length() - 1 && signs.indexOf(s.charAt(i + 1)) > signs.indexOf(sign)){
                    result -= dict.get(sign);
                    continue;
                }
                result += dict.get(sign);

            }
            return result;
        }
    }