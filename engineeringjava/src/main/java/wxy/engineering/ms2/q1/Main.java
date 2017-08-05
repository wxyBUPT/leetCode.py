package wxy.engineering.ms2.q1;


/**
 描述
 There are N queens in an infinite chessboard. We say two queens may attack each other if they are in the same vertical line,
 horizontal line or diagonal line even if there are other queens sitting between them.

 Now given the positions of the queens, find out how many pairs may attack each other?

 输入
 The first line contains an integer N.

 Then N lines follow. Each line contains 2 integers Ri and Ci indicating there is a queen in the Ri-th row and Ci-th column.

 No two queens share the same position.

 For 80% of the data, 1 <= N <= 1000

 For 100% of the data, 1 <= N <= 100000, 0 <= Ri, Ci <= 1000000000

 输出
 One integer, the number of pairs may attack each other.

 样例输入
 5
 1 1
 2 2
 3 3
 1 3
 3 1
 样例输出
 10
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * HashMap 简单的应用
 */
public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, Integer> vert = new HashMap<>();
        Map<Integer, Integer> hori = new HashMap<>();
        // 斜率为正 1 直线
        Map<Integer, Integer> slope_pos = new HashMap<>();
        // 斜率为 -1 的直线
        Map<Integer, Integer> slope_neg = new HashMap<>();

        int x, y;
        for(int i = 0;i<n;i++){
            x = in.nextInt();
            y = in.nextInt();
            if(!hori.containsKey(y)){
                hori.put(y, 0);
            }
            hori.put(y, hori.get(y) + 1);
            if(!vert.containsKey(x)){
                vert.put(x, 0);
            }
            vert.put(x, vert.get(x) + 1);
            int pos = y - x;
            if(!slope_pos.containsKey(pos)){
                slope_pos.put(pos, 0);
            }
            slope_pos.put(pos, slope_pos.get(pos)+1);
            int neg = y + x;
            if(!slope_neg.containsKey(neg)){
                slope_neg.put(neg, 0);
            }
            slope_neg.put(neg, slope_neg.get(neg)+1);
        }

        System.out.print(calculateMap(vert) + calculateMap(hori) + calculateMap(slope_neg) + calculateMap(slope_pos));
    }

    static int calculateMap(Map<Integer, Integer> map ){
        int res = 0;
        for(Integer i:map.values()){
            res += (i * (i-1)/2);
        }
        return res;
    }
}
