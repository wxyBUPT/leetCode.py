package main.java.bupt.wxy.google.practiveRount2017.countryLeader;
import java.util.Scanner;

/**
 * Created by xiyuanbupt on 5/16/17.
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 0; i<T; i++){
            int N = in.nextInt();
            in.nextLine();
            String[] ques = new String[N];
            for (int j = 0; j<N; j++){
                ques[j] = in.nextLine();
            }
            String s = solve(ques);
            System.out.println("Case #" + (i+1) + ": " + s);
        }
    }

    public static String solve(String[] strings){
        boolean[] max = new boolean[32];
        String maxString = null;
        boolean[] curr = new boolean[32];
        for(String s:strings){
            for(int i = 0; i<32; i++)curr[i] = false;
            for(char c:s.toCharArray()){
                if(c==' ')continue;
                curr[c - 'A'] = true;
            }
            if(bigger(curr, max)){
                System.arraycopy(curr, 0, max, 0, curr.length);
                maxString = s;
            }
        }
        return maxString;
    }

    /**
     * 判断a是否大于b
     * @param a
     * @param b
     * @return
     */
    public static boolean bigger(boolean[] a, boolean[] b){

        for(int i = 0; i<32; i++){
            if(a[i] || b[i])return a[i];
        }
        return false;
    }
}
