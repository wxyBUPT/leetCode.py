import java.util.*;

// 使用回溯法，首先计算出小于n的所有的质数，并使用两点法计算和为n的数

public class Main{

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.print(main.solve(n));
    }

    // 使用两点法
    public int solve(int n){
        List<Integer> zhishus = getZhishu(n);
        int res = 0;
        // 使用两点发计算和
        int i = 0, j=zhishus.size()-1;
        while(i<=j){
            int sum = zhishus.get(i) + zhishus.get(j);
            if(sum==n){
                res ++;
                i++;
            }else if(sum < n){
                i++;
            }
            else{
                j--;
            }
        }
        return res;
    }

    public List<Integer> getZhishu(int n){
        // 返回所有小于n的质数
        List<Integer> res = new ArrayList();
        for(int i = 2; i<n; i++){
            if(isZhishu(i)){
                res.add(i);
            }
        }
        return res;
    }

    private boolean isZhishu(int k){
        int mid = k/2;
        for(int i = mid; i>1; i--){
            if(k % i==0)return false;
        }
        return true;
    }
}