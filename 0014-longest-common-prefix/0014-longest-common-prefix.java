class Solution {
        public static String longestCommonPrefix(String[] strs) {
            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() < prefix.length()) {
                    prefix = strs[i];
                }
            }
            while (prefix.length() > 0){
                boolean is_match = true;
                for (int i = 0; i < strs.length; i++) {
                    if (! strs[i].startsWith(prefix)){
                        prefix = prefix.substring(0, prefix.length() - 1);
                        is_match = false;
                        break;
                    }
                }
                if (is_match){
                    break;
                }
            }
            return prefix;
        }
    }