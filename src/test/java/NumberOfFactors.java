import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberOfFactors {

    @Test
    void numberOfFactors() {
        int left = 13;
        int right = 17;
        int answer = 0;

        int count = 1;
        for (int i = left; i <= right; i++) {
            for (int j = 1; j < i; j++) {
                if (i%j==0) count += 1;
            }
            answer = count%2==0 ? answer+i : answer-i;
            count = 1;
        }

        Assertions.assertEquals(43,answer);

    }
}
