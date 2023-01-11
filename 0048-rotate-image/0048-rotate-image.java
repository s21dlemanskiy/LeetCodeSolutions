 class Solution {
        public static void circle_swap(int[][] matrix, int x, int y){// в функцию передается координата точки лежащий в левой верхней четверти и она производит циклическое ее смещение
            int tm = matrix[y][x];
            matrix[y][x] = matrix[matrix.length - 1 - x][y];
            matrix[matrix.length - 1 - x][y] = matrix[matrix.length - 1 - y][matrix.length - 1 - x];
            matrix[matrix.length - 1 - y][matrix.length - 1 - x] = matrix[x][matrix.length - 1 - y];
            matrix[x][matrix.length - 1 - y] = tm;
        }
        public static void rotate(int[][] matrix) {
            for (int y = 0; y < matrix.length / 2; y++) {                             // перебераем все х и у в первой получетверти
                for (int x = 0; x < matrix.length / 2 +  matrix.length % 2; x++) {    // спорные х и у которые относятся к левой верхней и левой нижней не берем, а те которые к правой верхней и левой верхней берем
                    circle_swap(matrix, x, y);
                }
            }
        }
    }