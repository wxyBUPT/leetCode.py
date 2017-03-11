package main.java.bupt.wxy.codejam;

import java.io.*;
import java.util.List;

/**
 * Created by xiyuanbupt on 3/5/17.
 */
public class SquareCounting {

    static final int R=1000;
    static final int C=500;
    /**
     * 在下面写代码逻辑
     */
    static private long[][] dp=new long[R+1][C+1];
    static {
        for(int i=1;i<=R;i++){
            dp[i][1]=0;
            dp[i][2]=i-1;
        }
        for(int j=1;j<=C;j++){
            dp[1][j]=0;
            dp[2][j]=j-1;
        }
        for(int i=3;i<=R;i++)
            for(int j=3;j<=C;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+calculateMN(i,j);
            }
    }
    static long handleCase(int m, int n){


        return dp[m][n];
    }

    // 计算如果新加入m 和 n点能够增加多少正方形
    static long calculateMN(int m, int n){

        //垂直的正方形
        long res=0;

        for(int i=1;i<n;i++)
            for(int j=m;j>0;j--){
                if(canMake(m,i,j,n))res++;
                else break;
            }
        return res;
    }

    static boolean canMake(int i, int j, int k, int l){
        return i-l+j>0&&j-i+k>0&&k-l+j>0&&l-i+k>0;
    }


    public static void main(String[] args){
        System.out.println(handleCase(2,4));
        System.out.println(handleCase(3,4));
        System.out.println(handleCase(4,4));
        System.out.println(handleCase(1000,500));
    }

    /**
     * 不必关心文件的打开与关闭, 在里面通过readline和write 以及newline来处理每一行字符串
     * @param in
     * @param out
     */
    static void handleInOut(BufferedReader in, BufferedWriter out) throws IOException {
        int total_test_case=Integer.valueOf(in.readLine());
        int n_test_case=0;
        while (n_test_case<total_test_case){
            n_test_case++;
            String line=in.readLine();
            String[] args=line.split(" ");
            int m=Integer.parseInt(args[0]);
            int n=Integer.parseInt(args[1]);
            long res=handleCase(m,n);
            System.out.println(res);

            // 处理每一个测试用例与输入输出
            //handleCase();

            StringBuilder sb=new StringBuilder();
            sb.append("Case #").append(n_test_case).append(": ");
            sb.append(res);

            out.write(sb.toString());
            out.newLine();
        }
    }
    public static void foo(String[] args) throws IOException{
        final String PROBLEM="StoreCredit/";
        final String CODE_JAM_TEST_CASE_BASE="/Users/xiyuanbupt/py.leetCode/leetcodejava/codeJamTestCase/";
        String path=CODE_JAM_TEST_CASE_BASE+"SquareCounting/A-small-attempt1.in";
        File f=new File(path);
        FileReader reader=new FileReader(f);
        BufferedReader in=new BufferedReader(reader);
        FileWriter write=new FileWriter(CODE_JAM_TEST_CASE_BASE+"SquareCounting/A-small-attempt1.out");
        BufferedWriter out=new BufferedWriter(write);
        handleInOut(in,out);
        in.close();
        reader.close();
        out.close();
        write.close();

        /**
        in.close();
        out.close();
        writer.close();
         **/
        /**
        for (Question dir : Question.values()) {
            // do what you want
            f=new File(CODE_JAM_TEST_CASE_BASE+PROBLEM+dir+".in");
            reader=new FileReader(f);
            in=new BufferedReader(reader);

            writer=new FileWriter(CODE_JAM_TEST_CASE_BASE+PROBLEM+dir+".out");
            out=new BufferedWriter(writer);
            //在下面使用in和out完成逻辑代码
            handleInOut(in,out);
            in.close();
            reader.close();
            out.close();
            writer.close();
            in.close();

        }
         **/
    }
}
