import org.junit.jupiter.api.Test;

import java.util.*;

public class CarFeeCalculate {
    @Test
    void carFeeCalculate() {

        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> carList = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < records.length; i++) {
            String[] data = records[i].split(" ");
            String time = data[0];
            String carNum = data[1];

            int min = Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);

            if (!map.containsKey(carNum)) {
                map.put(carNum, min);
                if (!list.contains(carNum)) list.add(carNum);
                carList.put(carNum, carList.getOrDefault(carNum, 0));
            } else {
                carList.put(carNum, carList.get(carNum) + min-map.get(carNum));
                map.remove(carNum);
            }
        }

        for (String s : map.keySet()) {
            carList.put(s, carList.get(s) + 1439 - map.get(s));
        }

        for (String car : carList.keySet()) {
            Integer totalMin = carList.get(car);
            int fee = fees[1];
            if (totalMin > fees[0]) {
                fee += (totalMin - fees[0]) / fees[2] * fees[3];
                if ((totalMin - fees[0]) % fees[2] != 0) fee += fees[3];
            }
            carList.put(car, fee);
        }

        Collections.sort(list);
        int[] answer = new int[carList.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = carList.get(list.get(i));
        }

    }
}
