package main.java.bupt.wxy.hihoCoder.tx.day1;

import java.util.Scanner;

public class Main {
    Tire root = new Tire();
    void insert(String str){
        char[] chars = str.toCharArray();
        Tire curr = root;
        int len = chars.length;
        for(int i =0; i<len-1; i++){
            if(curr.nodes[chars[i]-'a']==null){
                curr.nodes[chars[i]-'a'] = new Tire();
            }
            curr.nodes[chars[i]-'a'].prefixCount ++;
            curr = curr.nodes[chars[i]-'a'];
        }

        if(curr.nodes[chars[len-1]-'a']!=null){
            Tire node = curr.nodes[chars[len-1]-'a'];
            node.hasWord = true;
            node.prefixCount ++;
        }else {
            Tire node = new Tire();
            curr.nodes[chars[len-1]-'a'] = node;
            node.hasWord = true;
            node.prefixCount ++;
        }
    }

    boolean esist(String str){
        char[] chars = str.toCharArray();
        Tire curr = root;
        int len = chars.length;
        for(int i=0;i<len;i++){
            if(curr.nodes[chars[i]-'a']==null)return false;
            curr = curr.nodes[chars[i]-'a'];
        }
        return true;
    }

    int query(String str){
        char[] chars = str.toCharArray();
        Tire curr = root;
        int len = chars.length;
        for(int i=0;i<len;i++){
            if(curr.nodes[chars[i]-'a']==null)return 0;
            curr = curr.nodes[chars[i]-'a'];
        }
        return curr.prefixCount;
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for(int i = 0; i<n; i++){
            main.insert(in.nextLine());
        }
        int m = in.nextInt();
        in.nextLine();
        for(int i=0;i<m;i++){
            String[] line = in.nextLine().split(" ");
            if(line[0].equals("query")){
                System.out.println(main.query(line[1]));
            }else {
                if(main.esist(line[1])){
                    System.out.println(1);
                }
                else {
                    main.insert(line[1]);
                    System.out.println(0);
                }
            }
        }
    }
}

class Tire{
    Tire[] nodes;
    boolean hasWord;
    int prefixCount;

    public Tire(){
        nodes = new Tire[26];
        hasWord = false;
        prefixCount = 0;
    }
}
