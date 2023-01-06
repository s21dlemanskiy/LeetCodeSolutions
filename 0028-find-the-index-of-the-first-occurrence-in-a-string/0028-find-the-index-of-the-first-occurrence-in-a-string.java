class Solution {
        public static int strStr(String haystack, String needle) {
            mainloop:
            for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        continue mainloop;
                    }
                }
                return i;
            }
            return -1;
        }
    }