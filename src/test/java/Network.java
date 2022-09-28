import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Network {
    @Test
    void network() {
        int answer = 0;
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        boolean[] visited = new boolean[n];

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i, computers, visited);
            }
        }
        System.out.println(answer);
    }

    private void dfs(int i, int[][] computers, boolean[] visited) {
        visited[i] = true;
        for (int j = 0; j < computers.length; j++) {
            if (i != j && !visited[j] && computers[i][j] == 1) {
                dfs(j, computers, visited);
            }
        }
    }
}
