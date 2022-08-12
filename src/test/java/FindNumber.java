import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindNumber {

    @Test
    void findNumber(){
        int n = 12;
        int answer = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 1) {
                answer = i;
                break;
            }
        }

        Assertions.assertEquals(11,answer);
    }
}
