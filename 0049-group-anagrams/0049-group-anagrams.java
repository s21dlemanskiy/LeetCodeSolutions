 class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            ArrayList<List<String>> result = new ArrayList<>();
            boolean[] in_list = new boolean[strs.length];
            String[] sorted_strings = new String[strs.length];
            for (int i = 0; i < strs.length; i++) {
                char[] str = strs[i].toCharArray();
                Arrays.sort(str);
                sorted_strings[i] = new String(str);      // сортируем каждую строку в лексиграфичичском порядке
            }
            for (int i = 0; i < strs.length; i++) {    // по каждой строке добавляя ее и ее анограммы в result
                if (in_list[i]){                       // если мы уже добавили этот элимент в result то пропускаем его
                    continue;
                }
                ArrayList<String> groop = new ArrayList<>();
                groop.add(strs[i]);
                in_list[i] = true;
                for (int j = i + 1; j < strs.length; j++) {
                    if (!in_list[j] && sorted_strings[i].equals(sorted_strings[j])){     // для каждой строки после данной проверяем является ли она ее анограмой
                        groop.add(strs[j]);                                              // если да то добавляем ее в эту же группу
                        in_list[j] = true;
                    }
                }
                result.add(groop);
            }
            return result;
        }
    }