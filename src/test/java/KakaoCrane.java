import org.junit.jupiter.api.Test;

import java.util.Stack;

public class KakaoCrane {
    @Test
    void kakaoCrane() {

        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            int move = moves[i];
            int obj = 0;
            for (int j = 0; j < board.length; j++) {
                obj = board[j][move - 1];
                if (obj != 0) {
                    board[j][move - 1] = 0;
                    break;
                }
            }
            if (obj == 0) continue;
            if (stack.empty()) {
                stack.push(obj);
                continue;
            }
            if (obj == stack.peek()) {
                answer++;
                stack.pop();
            } else stack.push(obj);
        }
        System.out.println(stack);
        System.out.println(answer);
    }
}
