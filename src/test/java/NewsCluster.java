import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsCluster {
    @Test
    void newsCluster() {
        int answer = 0;
        String str1 = "FRANCE";
        String str2 = "french";
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for(int i =0; i<str1.length()-1; i++){
            char first = str1.charAt(i);
            char second = str1.charAt(i+1);
            if(Character.isLetter(first) && Character.isLetter(second)){
                list1.add(String.valueOf(first) + second);
            }

        }
        for(int i =0; i<str2.length()-1; i++){
            char first = str2.charAt(i);
            char second = str2.charAt(i+1);
            if(Character.isLetter(first) && Character.isLetter(second)){
                list2.add(String.valueOf(first) + second);
            }
        }

        if(list1.size()==0 && list2.size()==0) answer = 65536;

        int intersection = 0;
        for (String s : list1) {
            if (list2.contains(s)) {
                intersection++;
                list2.remove(s);
            }
        }

        int sumOfSet = list1.size() + list2.size();

        double ans = intersection / (double) sumOfSet;
        answer = (int) (ans * 65536);
        System.out.println(answer);
    }
}
