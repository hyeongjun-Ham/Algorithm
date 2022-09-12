import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon {
    @Test
    void baekjoon(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] in = new int[6];
        for(int i =0; i<6; i++){
            in[i] = sc.nextInt();
        }

        int[] chess = {1,1,2,2,2,8};

        int[] answer = new int[6];
        for(int i =0; i<6; i++){
            answer[i] = chess[i]-in[i];
        }
        System.out.println(Arrays.toString(answer));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String next = sc.nextLine();
        String[] s = next.split(" ");

        int[] chess = {1,1,2,2,2,8};

        int[] answer = new int[6];
        String ans = "";
        for(int i =0; i<6; i++){
            answer[i] = chess[i]-Integer.parseInt(s[i]);

            if(i!=5){
                ans += answer[i] + " ";
            }else ans += answer[i];
        }
        System.out.println(ans);
    }
}
