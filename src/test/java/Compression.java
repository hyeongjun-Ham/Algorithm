import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compression {
    @Test
    void compression() {
        String msg = "KAKAO";
        int[] answer = {};

        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < alpha.length(); i++) {
            map.put(String.valueOf(alpha.charAt(i)), i + 1);
        }

        List<Integer> list = new ArrayList<>();
        String sum = "";

        for (int i = 0; i < msg.length(); i++) {
            System.out.println(i);
            for (int j = i; j <msg.length(); j++) {
                sum += msg.charAt(j);
                if (j == msg.length()-1 && map.containsKey(sum)) {
                    list.add(map.get(sum));
                }
                if (!map.containsKey(sum)) {
                    list.add(map.get(sum.substring(0,sum.length()-1)));
                    map.put(sum, map.size()+1);
                    sum = "";
                    break;
                }
                if (j>i) i++;
            }
        }

        System.out.println(map);
        System.out.println(list);
    }
}
