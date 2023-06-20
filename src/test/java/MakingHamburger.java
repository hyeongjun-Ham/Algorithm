import org.junit.jupiter.api.Test;

import java.util.Stack;

public class MakingHamburger {

    @Test
    void makingHamburger() {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int answer = 0;

        StringBuilder str = new StringBuilder();

        for (int in : ingredient) {
            str.append(in);
            if (in == 1 && str.length() > 3) {
                if (str.substring(str.length()-4, str.length()).equals("1231")) {
                    str = new StringBuilder(str.substring(0, str.length() - 4));
                    answer++;
                }
            }
        }
//        System.out.println(answer);
    }
}
