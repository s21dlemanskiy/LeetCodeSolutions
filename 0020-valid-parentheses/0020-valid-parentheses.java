class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            Map<Character, Character> dict = new HashMap<>();
            dict.put('}', '{');
            dict.put(']', '[');
            dict.put(')', '(');
            for (char i: s.toCharArray()) {
                if (dict.containsKey(i)){
                    if (stack.empty()){
                        return false;
                    }
                    char open_br = dict.get(i);
                    if (stack.pop() != dict.get(i)){
                        return false;
                    }
                    continue;
                } else {
                    stack.push(i);
                    continue;
                }
            }
            return stack.empty();
        }
    }