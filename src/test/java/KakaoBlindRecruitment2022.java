import org.junit.jupiter.api.Test;

public class KakaoBlindRecruitment2022 {
    @Test
    void kakaoBlindRecruitment2022() {
        int n = 1;
        int k = 3;

        int answer = 0;

        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, n % k);
            n = n / k;
        }
        String changed = sb.toString();
        String sum = "";
        for (int i = 0; i < changed.length(); i++) {
            if (changed.charAt(i) != '0') {
                sum += changed.charAt(i);
                if (i == changed.length() - 1) {
                    if (isCheckPrime(sum)) answer++;
                }
            } else {
                if (!sum.equals("") && Integer.parseInt(sum) >= 2) {
                    if (isCheckPrime(sum)) answer++;
                }
                sum = "";
            }
            System.out.println(answer);
        }
    }

    private boolean isCheckPrime(String sum) {
        long num = Long.parseLong(sum);

        if (num <= 1) return false;
        if (num == 2) return true;
        for (int j = 2; j <= Math.sqrt(num); j++) {
            if (num % j == 0) return false;
        }
        return true;
    }
}
