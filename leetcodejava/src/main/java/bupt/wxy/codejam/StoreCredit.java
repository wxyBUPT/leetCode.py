package main.java.bupt.wxy.codejam;

import main.java.bupt.wxy.Conf;

import java.io.*;
import java.util.*;

/**
 * Created by xiyuanbupt on 3/4/17.
 Problem

 You receive a credit C at a local store and would like to buy two items. You first walk through the store and create a list L of all available items. From this list you would like to buy two items that add up to the entire value of the credit. The solution you provide will consist of the two integers indicating the positions of the items in your list (smaller number first).

 Input

 The first line of input gives the number of cases, N. N test cases follow. For each test case there will be:

 One line containing the value C, the amount of credit you have at the store.
 One line containing the value I, the number of items in the store.
 One line containing a space separated list of I integers. Each integer P indicates the price of an item in the store.
 Each test case will have exactly one solution.
 Output

 For each test case, output one line containing "Case #x: " followed by the indices of the two items whose price adds up to the store credit. The lower index should be output first.

 Limits

 5 ≤ C ≤ 1000
 1 ≤ P ≤ 1000

 Small dataset

 N = 10
 3 ≤ I ≤ 100

 Large dataset

 N = 50
 3 ≤ I ≤ 2000

 Sample


 Input

 Output
 3
 100
 3
 5 75 25
 200
 7
 150 24 79 50 88 345 3
 8
 8
 2 1 9 4 4 56 90 3
 Case #1: 2 3
 Case #2: 1 4
 Case #3: 4 5
 */

// 2SUM问题
public class StoreCredit {

    static public List<Integer> getIndexs(int[] nums, int sum){
        Map<Integer, Integer> map=new HashMap<>();
        List<Integer> res=new ArrayList<>(2);
        int sameIndex1=-1;
        for(int i=0;i<nums.length;i++){
            if(sum%2==0&&sum/2==nums[i]){
                if(sameIndex1==-1)sameIndex1=i;
                else {
                    res.add(sameIndex1);
                    res.add(i);
                    /**
                    System.out.println("OriSum");
                    System.out.println(sum);
                    System.out.println("ResSum");
                    System.out.println(nums[res.get(0)]+nums[res.get(1)]);
                    System.out.println(res.get(0)+":"+res.get(1));
                    System.out.println();
                     **/
                }
            }
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(sum-nums[i])){
                res.add(i);
                res.add(map.get(sum-nums[i]));
                /**
                System.out.println("OriSum");
                System.out.println(sum);
                System.out.println("ResSum");
                System.out.println(nums[res.get(0)]+nums[res.get(1)]);
                System.out.println(res.get(0)+":"+res.get(1));
                System.out.println();
                 **/
            }
        }
        /**
        System.out.println("OriSum");
        System.out.println(sum);
        System.out.println("ResSum");
        System.out.println(nums[res.get(0)]+nums[res.get(1)]);
        System.out.println(res.get(0)+":"+res.get(1));
        System.out.println();
         **/
        if(sum!=(nums[res.get(0)]+nums[res.get(1)]))System.out.println("Wrone");
        if(res.get(0)==res.get(1))System.out.println("equal");
        return res;
    }

    public static void main(String[] args) throws FileNotFoundException,IOException{
        boolean test=false;
        File f;
        if(test){
            f = new File(Conf.CODE_JAM_TEST_CASE_BASE + "StoreCredit/test.in");
        }else {
            f = new File(Conf.CODE_JAM_TEST_CASE_BASE + "StoreCredit/A-large-practice.in");
        }
        FileReader reader=new FileReader(f);
        BufferedReader in=new BufferedReader(reader);
        /**
        DataInputStream in = new DataInputStream(new FileInputStream(new File(Conf.CODE_JAM_TEST_CASE_BASE+"/StoreCredit/A-small-practice.in")));
         **/
        FileWriter writer;
        if(test){
            writer = new FileWriter(Conf.CODE_JAM_TEST_CASE_BASE + "StoreCredit/test.out");
        }else {
            writer = new FileWriter(Conf.CODE_JAM_TEST_CASE_BASE + "StoreCredit/A-large-practice.out");
        }
        BufferedWriter out=new BufferedWriter(writer);

        int total_test_case=Integer.valueOf(in.readLine());
        int n_test_case=0;
        while (n_test_case<total_test_case){
            n_test_case++;
            int sum=Integer.valueOf(in.readLine());
            int n_nums=Integer.valueOf(in.readLine());
            int[] nums=new int[n_nums];
            String line=in.readLine();
            String[] str_nums=line.split(" ");
            for(int i=0;i<nums.length;i++){
                nums[i]=Integer.valueOf(str_nums[i]);
            }
            List<Integer> res=getIndexs(nums,sum);
            StringBuilder sb=new StringBuilder();

            sb.append("Case #").append(n_test_case).append(": ").append(res.get(0)+1).append(" ").append(res.get(1)+1);
            out.write(sb.toString());
            out.newLine();
        }
        in.close();
        reader.close();
        out.close();
        writer.close();
        in.close();

    }
}
