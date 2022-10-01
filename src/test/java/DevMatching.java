import org.junit.jupiter.api.Test;

import java.util.*;

public class DevMatching {
    Map<String, Integer> map = new HashMap<>();
    @Test
    void devMatching() {
        String[] registered_list = {"bird98", "bird99", "bird101"};
        String new_id = "bird98";

        String answer = "";


        Set<String> list = new HashSet<>();
        for (String regi : registered_list) {
            list.add(regi);
        }

        if (!list.contains(new_id)) {
            answer = new_id;
        } else {
            String number = "";
            String letter = "";
            while (list.contains(new_id)) {
                if (letter.equals("")) {
                    for (int i = 0; i < new_id.length(); i++) {
                        if (new_id.charAt(i) > 57) {
                            letter += new_id.charAt(i);
                        } else {
                            number = new_id.substring(i);
                            break;
                        }
                    }
                }else{
                    number = new_id.substring(letter.length());
                }
                System.out.println(number);
                if (number.equals("")) {
                    new_id = letter + "1";
                } else {
                    new_id = letter + (Integer.parseInt(number) + 1);
                }
            }
            answer = new_id;
            System.out.println(answer);
        }
    }
}
