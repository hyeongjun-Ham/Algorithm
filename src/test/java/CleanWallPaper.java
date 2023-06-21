import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CleanWallPaper {

    @Test
    void cleanWallPaper() {
        String[] wallpaper = {".#...", "..#..", "...#."};
        int[] answer = new int[4];
        answer[0] = wallpaper.length;
        answer[1] = wallpaper[0].length();
        for (int i = 0; i < wallpaper.length; i++) {
            String line = wallpaper[i];
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == '#') {
                    answer[0] = Math.min(answer[0],i);
                    answer[1] = Math.min(answer[1],j);
                    answer[2] = Math.max(answer[2],i+1);
                    answer[3] = Math.max(answer[3],j+1);

                }
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
