package wxy.engineering.jdtesting.q1;

import java.util.Scanner;

/**
 * Created by xiyuanbupt on 4/7/17.
 有一条很长的队伍，队伍里面一共有n个人。所有的人分为三类：警察，小偷和普通人。将队伍里面的人从前到后由1到n编号，编号为i的人与编号为j的人的距离为i与j之差的绝对值。
 每一个警察有一个能力值x，表示他能够监视与他距离不超过x的所有人，小偷被警察发现当且仅当他被一个或多个警察监视到。你知道在整条队伍中，一共有多少个小偷会被警察发现吗？

 输入
 输入有两行，第一行一个数n(1<=n<=100000)，接下来一行有一个长度为n的字符串，依次表示队伍中的每一个人。
 如果某一位是1-9的某个数字x，表示这一位是一个能力值为x的警察；如果某一位是字符X表示这一位是小偷；如果某一位是字符#表示这是一个普通人。输入保证不会出现其它字符。
 输出
 输出一个数，整条队伍中被警察发现的小偷总数。

 样例输入
 9
 X1X#2X#XX
 样例输出
 3

 Hint
 在第一组样例中，一共有9个人，第2位是一个能力值为1的警察，他可以发现位置1,3的两个小偷，第5位是一个能力值为2的警察，他可以发现位置3,6的两个小偷。所以本题中，位置为1,3,6的三个小偷被警察发现了，总个数为3。
 */

/**
 * 从前到后扫面, 然后从后到前扫描
 */
public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String line = in.nextLine();
        char[] chars = line.toCharArray();
        System.out.print(solve(chars, n));
    }

    public static int solve(char[] chars, int n){
        boolean[] finded = new boolean[n];
        int maxReach = -1;
        for(int i=0;i<n;i++){
            char c = chars[i];
            if(c == '#'){
                continue;
            } else if(c == 'X'){
                if(i<=maxReach)finded[i] = true;
            }else {
                int reach = c - '0';
                if(reach + i > maxReach)maxReach = reach + i;
            }

        }

        maxReach = n;
        for(int i=n-1; i>-1; i--){
            char c = chars[i];
            if(c == '#')continue;
            else if(c == 'X'){
                if(i>=maxReach)finded[i] = true;
            }else {
                int reach = c - '0';
                if(i - reach < maxReach)maxReach = i - reach;
            }
        }
        int res = 0;
        for(boolean b:finded){
            if(b)res ++;
        }
        return res;
    }
}
