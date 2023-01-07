public class Solution {
    public static int trap(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length - 1; i++) {  //левая граница нашей water trap
            int index_max = -1;                         //правая граница нашей water trap: это индекс которое либо первое после левой границы с большей высотой чем height[i] или последнее наибольшее после левой границы ( если после левой границы все меньше или равны ей)
            int sumtmp = 0;                             // временная сумма всоты воды если бы левая граница была выше правой. хранится пока не найдем новую правую границу.
            int count = 0;                              // кол-во ячеек между левой и правой границей
            int counttmp = 0;
            for (int j = i + 1; j < height.length; j++) { // проверяемая на место правой границы
                if ( index_max == -1 || height[index_max] <= height[j]){   // если правая граница не установлена или установленая правая граница меньше чем эта то делаем текущее значение правой границей
                    index_max = j;
                    sum += sumtmp;
                    count += counttmp;
                    sumtmp = 0;
                    counttmp = 0;
                    if (height[index_max] > height[i]){                 // если правая граница выше левой заканчиваем (тк для последующих значений она должна быть левой границей)
                        break;
                    }
                }
                sumtmp += height[i] - height[j];
                counttmp++;
            }
            if (height[i] > height[index_max]){                     // если правая граница ниже опускаем уровень воды до нее(ранее мы считали воду по левой границы)
                sum -= count * (height[i] - height[index_max]);
            }
            i = index_max - 1;   // на следующем шаге i будет равно index_max те правая граница станет левой
        }
        return sum;
    }
}