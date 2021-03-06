//在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B
//” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。 
//
// 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜
//色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。 
//
// 返回车能够在一次移动中捕获到的卒的数量。 
// 
//
// 示例 1： 
//
// 
//
// 输入：[[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",
//".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",
//".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".",
//"."],[".",".",".",".",".",".",".","."]]
//输出：3
//解释：
//在本例中，车能够捕获所有的卒。
// 
//
// 示例 2： 
//
// 
//
// 输入：[[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".",
//"p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B",
//"p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".",
//"."],[".",".",".",".",".",".",".","."]]
//输出：0
//解释：
//象阻止了车捕获任何卒。
// 
//
// 示例 3： 
//
// 
//
// 输入：[[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",
//".",".","p",".",".",".","."],["p","p",".","R",".","p","B","."],[".",".",".",".",
//".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","p",".",".",".",
//"."],[".",".",".",".",".",".",".","."]]
//输出：3
//解释： 
//车可以捕获位置 b5，d6 和 f5 的卒。
// 
//
// 
//
// 提示： 
//
// 
// board.length == board[i].length == 8 
// board[i][j] 可以是 'R'，'.'，'B' 或 'p' 
// 只有一个格子上存在 board[i][j] == 'R' 
// 
// Related Topics 数组

package leetcode.editor.cn;


public class AvailableCapturesForRook {
    public static void main(String[] args) {
        Solution solution = new AvailableCapturesForRook().new Solution();
        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};
        int count = solution.numRookCaptures(board);
        System.out.println(count);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Position{
            int i ;
            int j;

            public int getI() {
                return i;
            }

            public void setI(int i) {
                this.i = i;
            }

            public int getJ() {
                return j;
            }

            public void setJ(int j) {
                this.j = j;
            }
        }
        public int numRookCaptures(char[][] board) {
            Position position = findRposition(board);
            int count = 0 , pi = position.getI(), pj = position.getJ();
            for (int i = pi; i >= 0; i--) {
                if (board[i][pj] == 'p') {
                    count++;
                    break;
                }
                if (board[i][pj] == 'B') {
                    break;
                }
            }
            for (int j = pj; j >= 0; j--) {
                if (board[pi][j] == 'p') {
                    count++;
                    break;
                }
                if (board[pi][j] == 'B') {
                    break;
                }
            }
            for (int i = pi; i < 8; i++) {
                if (board[i][pj] == 'p') {
                    count++;
                    break;
                }
                if (board[i][pj] == 'B') {
                    break;
                }
            }
            for (int j = pj; j < 8; j++) {
                if (board[pi][j] == 'p') {
                    count++;
                    break;
                }
                if (board[pi][j] == 'B') {
                    break;
                }
            }
            return count;

        }

        private Position findRposition(char[][] board) {
            Position position = new Position();
            for(int pi = 0; pi < 8; pi++){
                for(int pj =0; pj < 8; pj++){
                    if(board[pi][pj] == 'R') {
                        position.setI(pi);
                        position.setJ(pj);
                        break;
                    }
                }
            }
            return position;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
