import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MadupTest {
    @Test
    void madUp() {
        int[] answer = {};
        String[] ip_addresses = {"115.86.56.15","123.12.2.1.","...","255.255.1.256"};
        String[] registered_list = {"115.86.56.15"};
        String[] banned_list = {"123.12.2.1"};


        for (String ip : ip_addresses) {
            int check = 2;
            String[] split = ip.split("\\.",-1);
            if (split.length>4) {
                check = 1;
            }
            for (int i = 0; i < split.length; i++) {
                String eachString = split[i];
                if (eachString.startsWith("0") && eachString.length() > 1) {
                    check = 1;
                    break;
                }
                if(eachString.equals("")) {
                    check =1;
                    break;
                }
                int eachInt = Integer.parseInt(eachString);
                // 유효한지 검사
                if (eachInt < 0 || eachInt > 255) {
                    check = 1;
                    break;
                }
            }

            for (String registered : registered_list) {
                if (registered.equals(ip)) {
                    check = 0;
                    break;
                }
            }
            for (String ban : banned_list) {
                if (ban.equals(ip)) {
                    check = 3;
                    break;
                }
            }
            System.out.println(check);

        }

    }

    @Test
    void madupT2() {
        String s = "()()()";
        String[] split = s.split("");


    }
}
