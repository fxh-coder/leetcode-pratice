public class LC_wordSearch {
    /**
     * 力扣搜索单词
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int rows = board.length, columns = board[0].length;
        boolean[][] visited = new boolean[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                boolean flag = check(board, visited, i, j, word, 0);
                if(flag)
                    return true;
            }
        }
        return false;
    }

    /**
     * 检查是否含有单词word
     * @param board 给出的二位数组
     * @param visited
     * @param i 行号
     * @param j 列号
     * @param word 单词
     * @param k 检索的单词的第k个字符
     * @return 布尔值
     */
    private boolean check(char[][] board, boolean[][] visited, int i, int j, String word, int k) {
        // 如果当前位字符和给定的board中的 i，j 位置字符不匹配，返回false
        if(board[i][j] != word.charAt(k)) {
            return false;
        } else if(k == word.length() - 1) {
            // 如果当前字符和board中 i，j 位置的字符匹配（因为if条件没有通过），
            // 并且是word的最后一个字符，就返回true
            return true;
        }

        visited[i][j] = true;
        // 四个方向，右、左、下，上
        int[][] directions = {{0, 1},{0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir: directions) {
            // 变换位置，因为走到这里，说明当前的字符匹配上了，并且不是word的最后一个
            // 又因为单词只能连续的出现，所以只能在当前的上下左右四个位置，所以递归查询
            int newI = i + dir[0], newJ = j + dir[1];
            // 判断位置在合法范围内
            if(newI >=0 && newI <board.length && newJ >= 0 && newJ < board[0].length) {
                // 如果没有访问过，则继续
                if(!visited[newI][newJ]) {
                    boolean flag = check(board, visited, newI, newJ, word, k + 1);
                    if(flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        // 这一步很关键，说明当前的字符虽然匹配上了，但是如果能够走到这里，说明接下来的字符没有匹配上
        // 所以为了防止有从下往上合适的，要把当前的visited改为false，以便有从下往上符合的
        visited[i][j] = false;
        return result;
    }
}
