import org.junit.jupiter.api.Test;

import java.util.*;

public class Prac {
    @Test
    void prac() {
        int[] grade = {3, 2, 1, 2};
        int[] answer = new int[grade.length];

        boolean[] checked = new boolean[grade.length];

        for (int i = 0; i < grade.length; i++) {
            if (checked[i]) continue;

            int rank = 1;
            int gra = grade[i];

            for (int j = 0; j < grade.length; j++) {
                if (gra < grade[j]) rank += 1;
            }
            for (int j = 0; j < grade.length; j++) {
                if (gra == grade[j]) {
                    answer[j] = rank;
                    checked[j] = true;
                }
            }
        }

        System.out.println(answer[0]);
        System.out.println(answer[1]);
        System.out.println(answer[2]);
        System.out.println(answer[3]);

    }

    @Test
    void prac2() {
        String[] card = {"ABACDEFG", "NOPQRSTU", "HIJKLKMM"};
        String[] word = {"GPQM", "GPMZ", "EFU", "MMNA"};
        String[] answer = {};

        List<String> list = new ArrayList<>();

        for (int i = 0; i < word.length; i++) {
            int count1 = 0;
            int count2 = 0;
            int count3 = 0;
            String[] clone = Arrays.copyOf(card, card.length);
            for (int j = 0; j < word[i].length(); j++) {
                char c = word[i].charAt(j);
                String s = String.valueOf(c);
                if (!clone[0].contains(s) && !clone[1].contains(s) && !clone[2].contains(s)) {
                    count1 = 0;
                    break;
                }
                if (clone[0].contains(s)) {
                    count1 += 1;
                    clone[0] = clone[0].replaceFirst(s, "");
                }
                if (clone[1].contains(s)) {
                    count2 += 1;
                    clone[1] = clone[1].replaceFirst(s, "");
                }
                if (clone[2].contains(s)) {
                    count3 += 1;
                    clone[2] = clone[2].replaceFirst(s, "");
                }
            }
            if (!(count1 == 0 || count2 == 0 || count3 == 0)) {
                list.add(word[i]);
            }

        }
        if (list.size() == 0) list.add("-1");
        answer = list.toArray(new String[list.size()]);

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    @Test
    void prac3() {
        int[][] monsters = {{-4, 4}, {-2, 2}, {6, 2}, {0, -2}};
        int[][] bullets = {{3, 1}, {-1, 1}, {-1, 1}, {0, -4}, {2, -3}};
        int answer = 0;

        boolean[] killed = new boolean[monsters.length];

        gcd(bullets);
        gcd(monsters);

        for (int i = 0; i < bullets.length; i++) {
            for (int j = 0; j < monsters.length; j++) {
                if (!killed[j] && monsters[j][0] == bullets[i][0] && monsters[j][1] == bullets[i][1]) {
                    answer += 1;
                    killed[j] = true;
                    break;
                }
            }
        }
        if (answer == 0) answer = -1;
        System.out.println(answer);
    }

    private void gcd(int[][] bullets) {
        for (int i = 0; i < bullets.length; i++) {

            if (bullets[i][0] == 0) {
                bullets[i][1] = bullets[i][1] / Math.abs(bullets[i][1]);
                continue;
            }
            if (bullets[i][1] == 0) {
                bullets[i][0] = bullets[i][0] / Math.abs(bullets[i][0]);
                continue;
            }

            int max = Math.abs(Math.max(bullets[i][0], bullets[i][1]));
            int min = Math.abs(Math.min(bullets[i][0], bullets[i][1]));

            while (max % min > 0) {
                int tmp = max % min;
                max = min;
                min = tmp;
            }
            bullets[i][0] = bullets[i][0] / min;
            bullets[i][1] = bullets[i][1] / min;
        }
    }

    @Test
    void prac4() {
        int N = 3;
        int[][] bus_stop = {{1, 2}};

        int[][] answer = new int[N][N];
        int[][] maps = new int[N][N];

        for (int[] i : bus_stop) {
            int x = i[0] - 1;
            int y = i[1] - 1;
            maps[x][y] = -1;
        }
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length; j++) {
                int[][] visited = new int[maps.length][maps[0].length];
                int bfs = bfs(maps, visited, i, j);
                answer[i][j] = bfs;
            }
        }


        System.out.println(Arrays.deepToString(maps));
        System.out.println(Arrays.deepToString(answer));
    }

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public int bfs(int[][] maps, int[][] visited, int x, int y) {

        visited[x][y] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int count = 0;

        while (x > -1) {
            if (maps[x][y] == -1) break;
            int[] current = queue.remove();
            int cX = current[0];
            int cY = current[1];

            for (int i = 0; i < 4; i++) {
                int nX = cX + dx[i];
                int nY = cY + dy[i];

                if (nX < 0 || nX > maps.length - 1 || nY < 0 || nY > maps[0].length - 1)
                    continue;

                if (maps[nX][nY] == -1) {
                    count = visited[cX][cY];
                    x = -2;
                    break;
                }

                if (visited[nX][nY] == 0 && maps[nX][nY] == 0) {
                    visited[nX][nY] = visited[cX][cY] + 1;
                    queue.add(new int[]{nX, nY});
                }

            }
        }
        return count;
    }


}
