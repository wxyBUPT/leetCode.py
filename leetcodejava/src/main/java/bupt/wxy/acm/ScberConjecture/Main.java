package main.java.bupt.wxy.acm.ScberConjecture;

/**
 * Created by xiyuanbupt on 3/29/17.
 A. (网预)Saber's Conjecture 第十一届北京邮电大学程序设计竞赛 - 热身赛 (1)
 时间限制 1000 ms 内存限制 65536 KB
 题目描述
 In a parallel universe, young Saber-chan does not have a humongous appetite, instead, she likes studying math in her spare time. This afternoon when Saber-chan is plunged in her study, she came across an interesting conjecture: for any even number n greater than or equal to 4, there exists at least one pair of prime numbers p1 and p2 such that n=p1+p2.

 This conjecture is actually known as the Goldbach's conjecture. It is has not been proved nor refused yet. However in this universe, there are more programmers than mathematicians, people tend to prove math findings by programs. As the King of Knights and King of Britain, Saber-chan orders you to write a program that reports the number of all the pairs of prime numbers satisfying the condition in the conjecture for a given even number.

 A sequence of even numbers is given as input. Corresponding to each number, the program should output the number of pairs mentioned above. Notice that Saber-chan is interested in the number of essentially different pairs and therefore you should not count (p1,p2) and (p2,p1) separately as two different pairs.

 输入格式
 An integer is given in each input line. You may assume that each integer is even, and is greater than or equal to 4 and less than 215. The end of the input is indicated by a number 0.

 输出格式
 Each output line should contain an integer number. No other characters should appear in the output.

 输入样例
 6
 10
 12
 0
 输出样例
 1
 2
 1
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{

    int[] primes;

    int N = 1<<14 + 1;

    private List<Integer> fastPrime(int n){
        List<Integer> res = new ArrayList<Integer>(n/4);
        if(n<2)return res;
        res.add(2);
        for(int j = 3;j<=n; j++){
            boolean isPrime = true;
            for(int num:res){
                if(j%num==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)res.add(j);
        }
        return res;
    }

    public Main(){
        List<Integer> prime_list = fastPrime(N);
        primes = new int[prime_list.size()];
        int i = 0;
        for(int prime:prime_list){
            primes[i++] = prime;
        }
    }

    public int getPairCount(int n){
        int res = 0;
        int i = 0, j=primes.length - 1;
        while (i<=j){
            int sum = primes[i] + primes[j];
            if(sum == n){
                res ++;
                i++;
            }else if(sum<n){
                i++;
            }else {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args){
        Main sc = new Main();
        Scanner in = new Scanner(System.in);
        int n;
        while ((n=in.nextInt())!=0){
            System.out.println(sc.getPairCount(n));
        }
    }
}
