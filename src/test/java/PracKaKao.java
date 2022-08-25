import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PracKaKao {

    @Test
    void pracKakao() {
        String S = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
        String C = "example";

        C = C.toLowerCase();
        String[] SList = S.toLowerCase()
                .replaceAll(", ", ",")
                .split(",");

        List<String> emailList = new ArrayList<>();
        for (int i = 0; i < SList.length; i++) {

            char first = SList[i].charAt(0);
            char middle;
            String last;
            String[] name = SList[i].split(" ");

            if (name.length == 2) {
                last = name[1].replace("-", "");
                if (last.length() > 8) last = last.substring(0, 8);

                if (emailList.contains(first + last + "@" + C + ".com")) {
                    int lastIndexOf = emailList.lastIndexOf(first + last + "@" + C + ".com");
                    String searchedId = emailList.get(lastIndexOf)
                            .split("@")[0];
                    char num = searchedId.charAt(searchedId.length() - 1);
                    if (num < 65) {
                        num += 1;
                    }else num = '2';

                    emailList.add(first + last + num + "@" + C + ".com");
                } else emailList.add(first + last + "@" + C + ".com");
            }
            if (name.length == 3) {
                middle = name[1].charAt(0);
                last = name[2].replace("-", "");
                if (last.length() > 8) last = last.substring(0, 8);
                if (emailList.contains(first + middle + last)) {
                    int lastIndexOf = emailList.lastIndexOf(first + middle + last);
                    String searchedId = emailList.get(lastIndexOf)
                            .split("@")[0];
                    char num = searchedId.charAt(searchedId.length() - 1);
                    if (num < 65) {
                        num += 1;
                    }else num = '1';

                    emailList.add(String.valueOf(first) + middle + last + num + "@" + C + ".com");
                } else emailList.add(String.valueOf(first) + middle + last + "@" + C + ".com");
            }
        }
        System.out.println(emailList);
    }
}
