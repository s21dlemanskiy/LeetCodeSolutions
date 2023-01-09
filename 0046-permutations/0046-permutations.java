class Solution {
    static int[] used; // масив содержащий последовательность выбранных эл-ов и их позиций например если used[2] = 3 это занчит что в результат поподет масив который на позиции 3 будет иметь nums[2]
    static List<List<Integer>> result; // список масивов, результат функции permute
    static int[] nums_pub;  // тот же масив nums просто обьявленый в глобальном пространстве
    static int recursion_level; // уровень рекурсии
    public static void confirmResult(){  // добовление последовательности хранящийся в used в result
        int[] tmp_result = new int[used.length];
        for (int i = 0; i < used.length; i++) {
            tmp_result[used[i]] = nums_pub[i];
        }
        result.add(Arrays.stream(tmp_result).boxed().toList());
    }
    public static void recursiveProduct(){  // рекурсивная функция нахождения декартого произведения
        if (recursion_level == nums_pub.length){   // если used уже заполнен то нужно его записать в результат
            confirmResult();
            return;
        }
        for (int i = 0; i < used.length; i++) {  // если в used еще есть -1 нужно их рекурсивно заполнять
            if (used[i] == -1){
                used[i] = recursion_level;    // меняем i-ую -1 на уровень рекусии (от 0 до len(nums) -1 )
                recursion_level++;
                recursiveProduct(); // запускаем рекурсию дальше
                recursion_level--;
                used[i] = -1;          // чистим за собой возвращая i-ую -1
            }
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        recursion_level = 0;
        nums_pub = nums;
        used = new int[nums.length];
        Arrays.fill(used, -1);
        result = new ArrayList<>();
        recursiveProduct();
        return result;
    }
}