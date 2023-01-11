 class Solution {
        public static void circle_swap(int[][] matrix, int x, int y){
            // System.out.println(matrix[y][x]);
             int tm = matrix[y][x];
            matrix[y][x] = matrix[matrix.length - 1 - x][y];
            matrix[matrix.length - 1 - x][y] = matrix[matrix.length - 1 - y][matrix.length - 1 - x];
            matrix[matrix.length - 1 - y][matrix.length - 1 - x] = matrix[x][matrix.length - 1 - y];
            matrix[x][matrix.length - 1 - y] = tm;
        }
        public static void rotate(int[][] matrix) {
            for (int y = 0; y < matrix.length / 2; y++) {
                for (int x = 0; x < matrix.length / 2 +  matrix.length % 2; x++) {
                    // System.out.println(String.format("x:%d  y:%d val:%d \n", x, y, matrix[y][x]));
                    circle_swap(matrix, x, y);
                }
            }
        }
    }