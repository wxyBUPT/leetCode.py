package main.java.bupt.wxy.wangyi;
import java.util.*;

public class Test{

    static Set<Integer> used = new HashSet<>();
    static List<List<Integer>> tasks = new ArrayList<>(6);
    static {
        for(int i=0;i<6;i++)tasks.add(new ArrayList<>());
    }
    static int res = 0;

    static void backtracking(int i){
        if(i==6){
            res++;
            return;
        }
        List<Integer> workers = tasks.get(i);
        for(Integer worker:workers){
            if(!used.contains(worker)){
                used.add(worker);
                backtracking(i+1);
                used.remove(workers);
            }

        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++){
            String line = in.nextLine();
            for(char c:line.toCharArray()){
                tasks.get(c-'0').add(i);
            }
        }
        backtracking(0);
        System.out.println(res);
    }
}