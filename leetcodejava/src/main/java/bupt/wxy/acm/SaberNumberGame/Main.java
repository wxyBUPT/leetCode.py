package main.java.bupt.wxy.acm.SaberNumberGame;

import java.util.*;

public class Main {

    static Set<Character> digits = new HashSet<Character>();
    static {
        for(int i=0;i<10;i++){
            digits.add((char)('0'+i));
        }
    }

    public int getUnique(int n, String str1, String str2){
        int[] id = new int[n];
        for(int i=0;i<n;i++)id[i]=i;
        return 1;
    }

    public void unionByString(int[] id, String str){

    }

    private int find(int[] id, int p){
        while (p!=id[p])p=id[p];
        return p;
    }

    private void union(int[] id, int p, int q){
        int pId = find(id, p);
        int qId = find(id, q);
        if(pId == qId)return;
        id[pId] = qId;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main main = new Main();
        int T = in.nextInt();
        in.nextLine();
        while (T>0){
            T--;
            int n = in.nextInt();
            in.nextLine();
            System.out.println(main.getUnique(n, in.nextLine(), in.nextLine()));
        }
    }
}
