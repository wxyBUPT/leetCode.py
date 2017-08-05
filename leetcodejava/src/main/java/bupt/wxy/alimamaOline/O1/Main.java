package bupt.wxy.alimamaOline.O1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiyuanbupt on 4/26/17.
 */
public class Main {

    public static boolean filter(String word, String pattern) {
        if (pattern.equals("*")) return true;
        List<String> subPat = split(pattern);
        return backtracking(word, subPat, 0);
    }

    public static List<String> split(String s) {
        List<String> res = new ArrayList<>();
        int start = 0;
        int i = s.indexOf("*");
        while (i != -1) {
            res.add(s.substring(start, i));
            res.add(s.substring(i, i + 1));
            start = i + 1;
            i = s.indexOf("*", start);
        }
        res.add(s.substring(start));
        return res;
    }

    public static boolean backtracking(String word, List<String> patterns, int p_i) {
        if (p_i == patterns.size()) {
            if (word.equals("")) return true;
            else return false;
        }
        if (word.equals("") && p_i < patterns.size()) return false;

        String pattern = patterns.get(p_i);
        if (p_i == patterns.size() - 1) {
            if (pattern.equals("*")) return true;
            return word.length() == pattern.length() && match(word, pattern);
        }

        if (pattern.equals("*")) {
            for (int i = 1; i < word.length(); i++) {
                if (backtracking(word.substring(i), patterns, p_i + 1)) return true;
            }
            return false;
        } else {
            return match(word, pattern) && backtracking(word.substring(pattern.length()), patterns, p_i + 1);
        }
    }

    public static boolean match(String str1, String str2) {
        if (str1.length() < str2.length()) return false;
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        for (int i = 0; i < str2.length(); i++) {
            if (c2[i] != '?' && c2[i] != c1[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String word = "trad-2012-3876-uy";
        String pattern = "t*201?-*?uy";
        System.out.println(filter(word, pattern));
    }
}
