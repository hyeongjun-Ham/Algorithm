import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

public class Kakao {

    @Test
    void kakao1() {
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        Map<String, Integer> map = new HashMap<>();

        for (String term : terms) {
            map.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
        }

        List<Integer> list = new ArrayList<>();

        String[] day = today.split("\\.");
        LocalDate date = LocalDate.of(Integer.parseInt(day[0]), Integer.parseInt(day[1]), Integer.parseInt(day[2]));

        int idx = 1;
        for (String pri : privacies) {
            String target = pri.split(" ")[0];
            String type = pri.split(" ")[1];
            String[] targetDay = target.split("\\.");

            LocalDate targetDate = LocalDate.of(Integer.parseInt(targetDay[0]), Integer.parseInt(targetDay[1]), Integer.parseInt(targetDay[2]));
            LocalDate targetDatePlusTerm = targetDate.plusMonths(map.get(type)).minusDays(1);

            if (date.isAfter(targetDatePlusTerm)) {
                list.add(idx);
            }
            idx++;
        }

        int[] answer = {};
        System.out.println(list);
    }

    @Test
    void kakao2() {
        int cap = 4;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};
        long answer = -1L;

        int now = 0;
        for (int i = 0; i < n; i++) {

            now = cap;
            int target = deliveries[n - i - 1];
            int distance = n - i;

            if (now > target) {
                deliveries[n - i - 1] = 0;
                now -= target;
                answer += distance;
            } else {
                now = 0;
                deliveries[n - i - 1] -= now;
            }


        }
    }

    @Test
    void kakao3() {
        long[] numbers = {63, 111, 95, 7, 5, 13};
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, 1);
        for (int i = 0; i < numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);
            if (binary.length() % 2 == 0) {
                if (binary.endsWith("1")) {
                    binary = binary + "0";
                } else binary = "0" + binary;

            }
            System.out.println(binary);

            for (int j = 1; j <= binary.length() / 2; j++) {
                if (binary.charAt(2 * j - 1) == '0') {
                    answer[i] = 0;
                    break;
                }
            }

        }

        System.out.println(Arrays.toString(answer));
    }
}
