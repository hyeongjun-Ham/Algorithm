import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


//https://school.programmers.co.kr/learn/courses/30/lessons/17681

public class SecretMap {
    @Test
    void secretMap() {

        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        String[] answer = new String[n];

        //이진수로 바꾸기
        List<String> arr1List = toBi(arr1, n);
        List<String> arr2List = toBi(arr2, n);

        for (int i = 0; i < n; i++) {
            String arr1Each = arr1List.get(i);
            String arr2Each = arr2List.get(i);
            String[] splitArr1 = arr1Each.split("");
            String[] splitArr2 = arr2Each.split("");
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (splitArr1[j].equals("1") || splitArr2[j].equals("1")) {
                    sb.append("#");
                } else sb.append(" ");
            }
            answer[i] = sb.toString();
        }
    }

    public List<String> toBi(int[] arr, int n) {
        List<String> list = new ArrayList<>();
        for (int i : arr) {
            String bi = "";
            while (i > 0) {
                bi = i % 2 + bi;
                i /= 2;
            }

            while (bi.length() < n) {
                bi = "0" + bi;
            }
            list.add(bi);
        }
        return list;
    }
}
