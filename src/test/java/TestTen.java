import org.junit.jupiter.api.Test;

import java.util.*;

public class TestTen {
    @Test
    void testTen1() {
        int W = 12;
        int N = 5;

        //가방 무게 뺀 실제 무게
        int ableW = W - 1;

        // 무게 1당 가치 계산
        Map<String, Double> value = new LinkedHashMap<>();
        value.put("camera", (10.0 / 5));
        value.put("smartphone", (20.0 / 2));
        value.put("cup", (5.0 / 3));
        value.put("towel", (7.0 / 4));
        value.put("pants", (11.0 / 6));

        /*
        무게당 가치가 높은 순서 대로 정렬 필요
        높은 순서 대로 가방에 넣음
        */

        int totalWeight =0;
        int totalValue = 0;
        int countObj = 0;
        ArrayList<String> obj = new ArrayList<>();
        while (ableW > 1 && N > countObj) {
            //smartphone
            if (ableW >= 2 && !obj.contains("smartphone")) {
                totalWeight += 2;
                ableW = ableW - 2;
                totalValue += 20;
                countObj++;
                obj.add("smartphone");
                continue;
            }
            //camera
            if (ableW >= 5 && !obj.contains("camera")) {
                totalWeight += 5;
                ableW = ableW - 5;
                totalValue += 10;
                countObj++;
                obj.add("camera");
                continue;
            }
            //pants
            if (ableW >= 6 && !obj.contains("pants")) {
                totalWeight += 6;
                ableW = ableW - 6;
                totalValue += 11;
                countObj++;
                obj.add("pants");
                continue;
            }
            //towel
            if (ableW >= 4 && !obj.contains("towel")) {
                totalWeight += 4;
                ableW = ableW - 4;
                totalValue += 7;
                countObj++;
                obj.add("towel");
                continue;
            }
            //cup
            if (ableW >= 3 && !obj.contains("cup")) {
                totalWeight += 3;
                ableW = ableW - 3;
                totalValue += 5;
                countObj++;
                obj.add("cup");
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(totalWeight);
        ans.add(totalValue);
        ans.add(countObj);

        ArrayList<Object> answer = new ArrayList<>();
        answer.add(ans);
        answer.add(obj);

        System.out.println(answer);

    }

    @Test
    void testTen2() {
        int n = 10;
        int m = 7;
        int result = 0;
        String[] friends = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String[][] movies = {{"a", "c", "d", "h", "i", "j"}, {"a", "d", "i"}, {"a", "c", "f", "g", "h", "i", "j"},
                {"b", "d", "g"}, {"b", "c", "f", "h", "i"}, {"b", "e", "g", "j"}, {"b", "c", "g", "h", "i"}};


        // 좋아하는 사람 많은 영화 구하기
        int index = 0;
        int count = 0;

        for (int i = 0; i < movies.length; i++) {
            if (movies[i] == null) continue;
            int nowCount = movies[i].length;
            count = Math.max(count, nowCount);
            if (count == nowCount) {
                index = i;
            }
        }
        // 좋아하는 영화에 해당하는 사람 지우기
        String[] movieLikesPerson = movies[index];

        // 영화 본사람 체크
        for (String personLike : movieLikesPerson) {
            for (int i = 0; i < friends.length; i++) {
                if (friends[i].equals(personLike)) {
                    friends[i] = "0";
                }
            }
        }
        movies[index] = null;
        // 결과값 1증가
        result += 1;

        // 영화 선택안한 사람 확인
        ArrayList<String> person = new ArrayList<>();
        for (int i = 0; i < friends.length; i++) {
            if(friends[i] != "0") person.add(friends[i]);
        }

        //선택 안한 사람들이 포함된 영화 선택

        //반복



    }
    @Test
    void testTen3() {

    }
}
