import org.junit.jupiter.api.Test;

public class KakaoBlindRecruitment2018 {
    @Test
    void kakaoBlindRecruitment2018() {
        int n = 2;  // 진법
        int t = 4;  // 말해야 하는 수
        int m = 2;  // 사람 수
        int p = 1;  // 순서


        String answer = "";
        int wordLength = t * m;
        String[] overTen = {"A", "B", "C", "D", "E", "F"};

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (sb.length() <= wordLength) {

            if (i <n) {
                if (i >= 10) {
                    String over = overTen[i - 10];
                    sb.append(over);
                }else sb.append(i);
                i++;
                continue;
            }

            StringBuilder str = new StringBuilder();
            int num = i;
            while (num > 0) {
                int add = num % n;
                if (add >= 10) {
                    String over = overTen[add - 10];
                    str.insert(0, over);
                }else str.insert(0, add);
                num = num / n;
            }
            sb.append(str);
            i++;
        }

        for (int j = 0; j < sb.length(); j++) {
            if (j % m == p-1) {
                answer += sb.charAt(j);
                if (answer.length()==t) break;
            }
        }
        System.out.println(sb);
        System.out.println(answer);
    }
}
