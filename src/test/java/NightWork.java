import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class NightWork {
    @Test
    void nightWork() {
        int n = 3;
        int[] works = {1,1};

        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int work : works) pq.add(work);

        while(n!=0){
            pq.add(pq.poll()-1);
            n--;
            if(pq.peek()==0) {
                answer = 0;
                break;
            }
        }
        for (Integer it : pq) {
            answer += (long) it * it;
        }
        System.out.println(answer);
    }
}
