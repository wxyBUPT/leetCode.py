package main.java.bupt.wxy.hihoCoder.mc2016.FontSize;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by xiyuanbupt on 3/31/17.
 */
public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        while (T-->0){
            int N, P, W, H;
            N = in.nextInt();
            P = in.nextInt();
            W = in.nextInt();
            H = in.nextInt();
            int[] char_counts = new int[N];
            int total_count = 0;
            for(int i=0;i<N;i++){
                char_counts[i] = in.nextInt();
                total_count += char_counts[i];
            }
            int max_size = getMaxSize(P, W, H, char_counts, total_count);
            System.out.println(max_size);

        }
    }

    private static int getMaxSize(int P, int W, int H, int[] char_counts, int total_count){
        int end_size = P * W * H / total_count;
        for(int S = end_size; S>0; S--){
            if(match(P, W, H, char_counts, S))return S;
        }
        return 0;
    }

    private static boolean match(int P, int W, int H, int[] char_counts , int S){
        int line_chars = W / S;
        if(line_chars==0)return false;
        int page_lines = H / S;
        int total_lines = P * page_lines;
        int curr_line = 0;

        for(int char_count:char_counts){
            int need_line = char_count / line_chars;
            if(char_count % line_chars != 0){
                need_line ++;
            }
            curr_line = curr_line + need_line;
            if(curr_line > total_lines + 1)return false;
        }
        return curr_line <= total_lines;
    }
}
