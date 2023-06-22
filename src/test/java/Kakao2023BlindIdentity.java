import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

public class Kakao2023BlindIdentity {

    @Test
    void kakao2023BlindIdentity() {
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        Map<String, String> map = new HashMap<>();
        for (String t : terms) {
            String[] split = t.split(" ");
            map.put(split[0], split[1]);
        }

        List<Integer> ans = new ArrayList<>();
        today = today.replace(".", " ");
        String[] splitToday = today.split(" ");
        int todayNum = (Integer.valueOf(splitToday[0]) * 12 * 28) + (Integer.valueOf(splitToday[1]) * 28) + Integer.valueOf(splitToday[2]);

        for (int i = 0; i < privacies.length; i++) {
            String replace = privacies[i].replace(".", " ");
            String[] splitPrivacy = replace.split(" ");

            map.get(splitPrivacy[3]);
            int target = (Integer.valueOf(splitPrivacy[0]) * 12 * 28) +
                    ((Integer.valueOf(splitPrivacy[1]) + Integer.valueOf(map.get(splitPrivacy[3]))) * 28) +
                    Integer.valueOf(splitPrivacy[2]);

            if (todayNum > target) {
                ans.add(i + 1);
            }
        }

        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }

        for (int a : answer) {
            System.out.println(a);
        }
    }
}
