package main.java.bupt.wxy.mic.recruitment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by xiyuanbupt on 3/29/17.
 */
public class Main {

    int maxA = Integer.MIN_VALUE;
    List<Integer> res = null;
    int totalB;
    boolean[] isMa;
    int[] abi;
    int[] sal;
    int X, Y, N;

    public Main(int totalB, boolean[] isMa, int[] abi, int[] sal, int X, int Y, int N){
        this.totalB = totalB;
        this.isMa = isMa;
        this.abi = abi;
        this.sal = sal;
        this.X = X;
        this.Y = Y;
        this.N = N;

    }

    /**
     * 对人员组成做排列组合
     * 前面位置的参数代表现在的状态
     * @param curr
     * @param currB
     * @param index
     * @param currX
     * @param currA 当前的能力
     * @param currY
     */
    void backtrackint(List<Integer> curr, int currB, int index, int currX, int currA, int currY){
        int k = -3;
        // 先找到几种不能满足条件的情况
        if(currB>totalB || currX > X || currY > Y || (currX + currY + N - index -1)<X+Y)return;
        if(currX==X&&currY==Y){
            if(currA > maxA){
                maxA = currA;
                res = new ArrayList<>(curr);
            }
            return;
        }

        for(int i=index; i<N; i++){
            curr.add(i);
            if(isMa[i]){
                backtrackint(curr, currB + sal[i], i + 1, currX + 1, currA + abi[i], currY);
            }else {
                backtrackint(curr, currB + sal[i], i + 1, currX, currA + abi[i], currY + 1);
            }
            curr.remove(curr.size()-1);
        }
    }

    void printRes(){
        int resAbi = 0;
        int resSal = 0;
        for(int i:res){
            resAbi += abi[i];
            resSal += sal[i];
        }
        System.out.println(resAbi + " " + resSal);
        int len = res.size();
        for(int i=0;i<len-1;i++)System.out.print(res.get(i)+1  + " ");
        System.out.print(res.get(len -1)+1);
    }

    public static void main(String[] args){
        int N, X, Y, B;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        N = in.nextInt();
        X = in.nextInt();
        Y = in.nextInt();
        B = in.nextInt();
        boolean[] isMale = new boolean[N];
        int[] abilitys = new int[N];
        int[] salarys = new int[N];
        for(int i=0;i<N;i++){
            if(in.next().equals("M")){
                isMale[i] = true;
            }
            abilitys[i] = in.nextInt();
            salarys[i] = in.nextInt();
        }
        Main main = new Main(B, isMale, abilitys, salarys, X, Y, N);
        main.backtrackint(new ArrayList<Integer>(X+Y), 0, 0, 0, 0, 0);
        main.printRes();
    }
}
