class Solution {
    public String countAndSayFunction(String s) {
        if (s.length() == 0){
            return "1";
        }
        int count = 0;
        char cur_sign = s.charAt(0);
        StringBuilder result = new StringBuilder("");
        for (char i: s.toCharArray()) {
            if (i != cur_sign){
                result.append(Integer.toString(count) + cur_sign);
                cur_sign = i;
                count = 1;
            }else{
                count++;
            }
        }
        result.append(Integer.toString(count) + cur_sign);
        return result.toString();

    }

    public String countAndSay(int n) {
        String s = "";
        for (int i = 0; i < n; i++) {
            s = countAndSayFunction(s);
        }
        return s;
    }
}