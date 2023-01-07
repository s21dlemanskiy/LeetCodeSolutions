class Solution {
    public static boolean isValidSudoku(char[][] board) {
        int[] chars_before = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.'){
                    chars_before[board[i][j] - 49]++;
                }
            }
            for (int j = 0; j < chars_before.length; j++) {
                if(chars_before[j] > 1){
                    return false;
                }
                chars_before[j] = 0;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != '.'){
                    chars_before[board[j][i] - 49]++;
                }
            }
            for (int j = 0; j < chars_before.length; j++) {
                if(chars_before[j] > 1){
                    return false;
                }
                chars_before[j] = 0;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                // System.out.print((i / 3) * 3+ j / 3);
                // System.out.print('-');
                // System.out.println((i % 3) * 3 + j % 3);
                if (board[(i / 3) * 3+ j / 3][(i % 3) * 3 + j % 3] != '.'){
                    chars_before[board[(i / 3) * 3+ j / 3][(i % 3) * 3 + j % 3] - 49]++;
                }
            }
            for (int j = 0; j < chars_before.length; j++) {
                if(chars_before[j] > 1){
                    return false;
                }
                chars_before[j] = 0;
            }
        }
        return true;
    }
}