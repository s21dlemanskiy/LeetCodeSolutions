class Solution {
        static boolean recursiveRegex(String s, String regex){
//            System.out.println(s + "---" + regex);
            int j = 0;
            for (int i=0; i<regex.length();i++){
                char sign = regex.charAt(i);
                if (i<regex.length() - 1 && regex.charAt(i + 1) == '*'){
                    for (int appended=0; appended<=s.length() - j; appended++){
                        if(recursiveRegex(s.substring(j + appended), regex.substring(i + 2))){
                            return true;
                        }
                        if (appended<s.length() - j && s.charAt(j + appended) != sign && sign != '.'){
                            break;
                        }
                    }
                    return false;
                }
                if (j >= s.length()){
                    return false;
                }
                if (sign == '.'){
                    j++;
                    continue;
                }
                if (sign == s.charAt(j)){
                    j++;
                    continue;
                }
                return false;
            }
            return j == s.length();
        }


        public static boolean isMatch(String s, String p) {
            return recursiveRegex(s, p);
        }
    }