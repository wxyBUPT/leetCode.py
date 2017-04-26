package main.java.bupt.wxy.mic.recruitmentAd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
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

    int[] males;
    int[] females;

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
     * 从 nums 中选出N个元素
     * @param nums
     * @param N
     * @return
     */
    List<List<Integer>> choseNEleInArray(int[] nums, int N){
        List<List<Integer>> res = new LinkedList<>();
        chosNEleBacktracking(0, new ArrayList<>(N), nums, N, res);
        return res;
    }

    void chosNEleBacktracking(int index, List<Integer> curr, int[] nums, int N, List<List<Integer>> res){
        int curr_size = curr.size();
        int nums_len = nums.length;
        if(curr_size + nums_len - index -1 < N)return;
        if(curr_size == N){
            res.add(new ArrayList<Integer>(curr));
            return;
        }

        for(int i = index; i<nums_len; i++){
            curr.add(nums[i]);
            chosNEleBacktracking(i + 1, curr, nums, N, res);
            curr.remove(curr_size - 1);
        }
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

    }
}
