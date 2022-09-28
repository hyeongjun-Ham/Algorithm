import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChattingRoom {
    @Test
    void openChattingRoom() {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < record.length; i++) {
            String[] each = record[i].split(" ");
            if (each[0].equals("Enter") || each[0].equals("Change")) {
                map.put(each[1], each[2]);
            }
        }
        for (int i = 0; i < record.length; i++) {
            String[] each = record[i].split(" ");
            if (each[0].equals("Enter")) {
                list.add(map.get(each[1]) + "님이 들어왔습니다.");
            } else if(each[0].equals("Leave")) {
                list.add(map.get(each[1]) + "님이 나갔습니다.");
            }
        }
        System.out.println(list);
    }
}
