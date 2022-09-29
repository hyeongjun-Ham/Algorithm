import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StockPrice {
    @Test
    void stockPrice() {
        int[] prices = {1, 2, 3, 2, 3};

        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int check = prices[i];

            Queue<Integer> queue = new LinkedList<>();
            for (int j = i+1; j < prices.length; j++) {
                int price = prices[j];
                queue.add(price);

                if (check > price || j == prices.length-1) {
                    answer[i] = queue.size();
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
