import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RoughKeyBoard {

    @Test
    void roughKeyBoard() {

        String[] keymap = {"AGZ", "BSSS"};
        String[] target = {"ASA", "BGZ"};

        int[] answer = new int[target.length];

        Map<Character, Integer> map = new HashMap<>();
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                if (map.containsKey(key.charAt(i)) && map.get(key.charAt(i)) <= i) {
                    continue;
                }
                map.put(key.charAt(i), i + 1);
                System.out.println(map);
            }
        }
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target[i].length(); j++) {
                if(answer[i] == -1) continue;
                if (!map.containsKey(target[i].charAt(j))) {
                    answer[i] = -1;
                }
                answer[i] += map.get(target[i].charAt(j));
            }
        }
        System.out.println(answer[0] + " ------" + answer[1]);

    }
}
