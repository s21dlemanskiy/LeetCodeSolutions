
class Solution {


    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> dict1 = new HashMap<Character, Integer>();
        for (char chr:word1.chars().mapToObj((x) -> (char) x).toList()) {
            dict1.put(chr, dict1.getOrDefault(chr, 0) + 1);
        }
        Map<Character, Integer> dict2 = new HashMap<Character, Integer>();
        for (char chr:word2.chars().mapToObj((x) -> (char) x).toList()) {
            dict2.put(chr, dict2.getOrDefault(chr, 0) + 1);
        }
        if (! dict2.keySet().equals(dict1.keySet())){
            return false;
        }
        int[] a = dict1.values().stream().mapToInt((x) -> (int) x).sorted().toArray();
        int[] b = dict2.values().stream().mapToInt((x) -> (int) x).sorted().toArray();
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]){
                return false;
            }
            
        }
        return true;

    }
}