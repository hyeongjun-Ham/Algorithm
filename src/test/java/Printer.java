import org.junit.jupiter.api.Test;

import java.util.*;

public class Printer {
    @Test
    void printer() {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queueIdx = new LinkedList<>();
        List<Integer> importance = new ArrayList<>();

        for (int i=0; i< priorities.length; i++) {
            if (!importance.contains(priorities[i])) importance.add(priorities[i]);
            queueIdx.add(i);
            queue.add(priorities[i]);
        }
        importance.sort(Collections.reverseOrder());

        while (!queue.isEmpty()) {
            if (!queue.peek().equals(importance.get(0))) {
                queueIdx.add(queueIdx.poll());
                queue.add(queue.poll());
            } else {
                answer++;
                queue.poll();
                if(queueIdx.peek()==location) break;
                queueIdx.poll();
            }

            if(!queue.contains(importance.get(0))){
                importance.remove(0);
            }
        }
        System.out.println(answer);
    }
}
