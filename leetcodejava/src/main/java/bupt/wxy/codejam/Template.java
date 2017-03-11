package main.java.bupt.wxy.codejam;

import main.java.bupt.wxy.Conf;

import java.io.*;
import java.util.List;

/**
 * Created by xiyuanbupt on 3/5/17.
 */
public class Template {

    /**
     * 不必关心文件的打开与关闭, 在里面通过readline和write 以及newline来处理每一行字符串
     * @param in
     * @param out
     */
    static void handleInOut(BufferedReader in, BufferedWriter out) throws IOException{
        int total_test_case=Integer.valueOf(in.readLine());
        int n_test_case=0;
        while (n_test_case<total_test_case){
            n_test_case++;

            // 处理每一个测试用例与输入输出
            handleCase();

            StringBuilder sb=new StringBuilder();
            sb.append("Case #").append(n_test_case).append(": ");

            out.write(sb.toString());
            out.newLine();
        }
    }

    /**
     * 在下面写代码逻辑
     */
    static void handleCase(){

    }


    public enum Question{
        TEST("Test"),
        SMALL("A-small-practice"),
        LARGE("A-large-practice");

        private final String text;
        private Question(final String text){
            this.text=text;
        }

        @Override
        public String toString(){
            return text;
        }
    }

    public static void main(String[] args) throws IOException{
        final String PROBLEM="StoreCredit/";
        final String CODE_JAM_TEST_CASE_BASE="/Users/xiyuanbupt/py.leetCode/leetcodejava/codeJamTestCase/";
        File f;
        FileReader reader;
        BufferedReader in;
        FileWriter writer;
        BufferedWriter out;
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
    }
}
