class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            ArrayList<List<String>> result = new ArrayList<>();
            boolean[] in_list = new boolean[strs.length];
            String[] sorted_strings = new String[strs.length];
            for (int i = 0; i < strs.length; i++) {
                char[] str = strs[i].toCharArray();
                Arrays.sort(str);
                sorted_strings[i] = new String(str);
            }
            for (int i = 0; i < strs.length; i++) {
                if (in_list[i]){
                    continue;
                }
                ArrayList<String> groop = new ArrayList<>();
                groop.add(strs[i]);
                in_list[i] = true;
                for (int j = i + 1; j < strs.length; j++) {
                    if (sorted_strings[i].equals(sorted_strings[j])){
                        groop.add(strs[j]);
                        in_list[j] = true;
                    }
                }
                result.add(groop);
            }
            return result;
        }
    }