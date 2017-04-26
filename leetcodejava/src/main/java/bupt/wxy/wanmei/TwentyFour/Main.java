package main.java.bupt.wxy.wanmei.TwentyFour;

import java.util.*;

/**
 * Created by xiyuanbupt on 3/29/17.
 54张牌去掉大小王2张牌，剩余52张。任意1－K的4个张牌(即1-13的四个数字)，用+-*\()计算，每张牌（每个数字）只使用一次，使得式子的计算结果为24，
 任意输入4个数字，如果4个数字在每个数字只使用一次的情况下，能算出24，显示“yes”,否则显示“no”

 */
public class Main {
    // 返回所有的组合, 然后用逆波兰表达式计算结果
    // 返回所有逆波兰表达式的组合
    char[] ops = {'+','-','*','/'};
    private List<List<Character>> getAllOps(){
        List<List<Character>> ops = new ArrayList<>();
        opbacktracking(ops, new ArrayList<>(3));
        return ops;
    }

    List<List<Character>> oops = getAllOps();

    void opbacktracking(List<List<Character>> res, List<Character> curr){
        if(curr.size()==3){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(char c:ops){
            curr.add(c);
            opbacktracking(res, curr);
            curr.remove(curr.size()-1);
        }
    }


    private boolean is_24(List<Integer> nums, List<Character> ops){
        int num1;
        int num2;
        num1 = calculate(nums.get(0), nums.get(1), ops.get(0));
        num2 = calculate(num1, nums.get(2), ops.get(1));
        return 24 == calculate(num2, nums.get(3), ops.get(2));
    }

    private int calculate(int num1, int num2, char op){
        if(op=='+')return num1+num2;
        else if(op=='*')return num1*num2;
        else if(op=='/')return num1/num2;
        return num1-num2;
    }


    // 返回所有的组合
    private Set<List<Integer>> getAll(int[] nums){
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        boolean[] visited = new boolean[nums.length];
        backtracking(res, new ArrayList<>(4), nums, visited);
        return res;
    }

    void backtracking(Set<List<Integer>> res, List<Integer> curr, int[] nums , boolean[] visited ){
        if(curr.size()==4){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<nums.length;i++){
            if(!visited[i]){
                curr.add(nums[i]);
                visited[i] = true;
                backtracking(res, curr, nums, visited);
                curr.remove(curr.size()-1);
                visited[i] = false;
            }
        }
    }

    public boolean fin_24(Set<List<Integer>> tmp){
        for(List<Integer> nums:tmp){
            for(List<Character> ops:oops){
                if(is_24(nums, ops))return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Main main = new Main();
        while (in.hasNextInt()){
            int[] nums = new int[4];
            for(int i=0;i<4;i++)nums[i]=in.nextInt();
            Set<List<Integer>> tmp = main.getAll(nums);
            System.out.println(main.fin_24(tmp)?"yse":"no");
        }
    }
}
