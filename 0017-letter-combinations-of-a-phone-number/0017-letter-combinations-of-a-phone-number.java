 class Solution {
        public static List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            if (digits.length() == 0){
                return result;
            }
            result.add("");
            int j = 97;
            Map<Character, String> dict = new HashMap<>();
            for (int i = 2; i < 10; i++) {
                StringBuilder data = new StringBuilder();
                for (int k = 0; k < ((i == 7 || i == 9) ? 4 : 3); k++) {
                    data.append((char) (j++));
                }
                dict.put(Integer.toString(i).charAt(0), data.toString());
            }
            for (int i = 0; i < digits.length(); i++) {
                List<String> tempresult = result;
                result = new ArrayList<>();
                for (char sign: dict.get(digits.charAt(i)).toCharArray()) {
                    for (String combination: tempresult) {
                        result.add(combination + sign);
                    }
                };
            }
            return result;
        }
    }