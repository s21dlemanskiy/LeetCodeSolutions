class Solution {
    static int findMatch(String s, String regex, int start){
//        System.out.println("string: '" + s + "'regex: '" + regex + "'");
        mainloop: for (; start <= s.length() - regex.length(); start++) {
            underloop: for (int i = 0; i < regex.length(); i++) {
                char sign = regex.charAt(i);
                if (sign == '?'){
                    continue underloop;
                }
                if (sign == s.charAt(i + start)){
                    continue underloop;
                }
                continue mainloop;
            }
            return start;
        }
        return -1;
    }


    public static boolean isMatch(String s, String p) {
        if (!p.contains("*") && s.length() != p.length()){
            return false;
        }
        while (p.contains("**")){
            p = p.replace("**", "*");
        }

        if (s.length() == 0 || p.length() == 0){
            return s.length() == p.length() || p.equals("*");
        }
        String[] parts = p.split("\\*");
//        System.out.println( Arrays.toString(parts));
        if(p.charAt(p.length() - 1) =='*'){
            String[] n_parts = new String[parts.length + 1];
            for (int i = 0; i < parts.length; i++) {
                n_parts[i] = parts[i];
            }
            parts = n_parts;
            parts[parts.length - 1] = "";
        }
        if(p.charAt(0) =='*'){
            String[] n_parts = new String[parts.length + 1];
            for (int i = 0; i < parts.length; i++) {
                n_parts[i + 1] = parts[i];
            }
            parts = n_parts;
            parts[0] = "";
        }
        int start = parts[0].length();
        if (findMatch(s, parts[0], 0) != 0){
            return false;
        }
        for (int i = 1; i < parts.length - 1; i++) {
            int result  = findMatch(s, parts[i], start);
            if (result == -1){
                return false;
            }
            start = result + parts[i].length();
        }
        int last_elem_start = s.length() - parts[parts.length - 1].length();
        if ((last_elem_start < start && parts.length > 1)|| findMatch(s, parts[parts.length - 1], last_elem_start) == -1){
            return false;
        }
        return true;
    }
}