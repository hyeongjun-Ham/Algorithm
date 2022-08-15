import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TargetNumber {
    static int answer =0;
    @Test
    void targetNumber() {
        int[] numbers = {1,1,1,1,1};
        int target = 3;

        dfs(numbers, target, 0,0);
        Assertions.assertEquals(5,answer);
    }

    private void dfs(int[] numbers, int target, int depth,int sum) {
        if (depth==numbers.length){
            if (target==sum) {
                answer++;
            }
            return ;
        }

        dfs(numbers, target, depth + 1, sum+numbers[depth]);
        dfs(numbers, target, depth + 1, sum-numbers[depth]);
    }
}
