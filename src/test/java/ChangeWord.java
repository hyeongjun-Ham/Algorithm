import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ChangeWord {
    public void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;

            int check = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) check++;
            }

            if (check == begin.length() - 1) {
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
        }
    }

    int answer = 0;
    boolean[] visited;

    @Test
    void changeWord() {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        System.out.println(answer);
    }
}
