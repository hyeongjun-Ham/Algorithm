import org.junit.jupiter.api.Test;
import java.util.*;

public class ProTest {


    @Test
    void Solution() {

        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        int answer = 0;
        long[] sum = new long[tangerine.length];

        for (int i = 0; i < tangerine.length; i++) {
            sum[tangerine[i] - 1]++;
        }
        Arrays.sort(sum);

        for (int i = sum.length - 1; i >= 0; i--) {
            k -= sum[i];
            answer++;
            if (k <= 0) break;
        }

        System.out.println(answer);
    }

}
