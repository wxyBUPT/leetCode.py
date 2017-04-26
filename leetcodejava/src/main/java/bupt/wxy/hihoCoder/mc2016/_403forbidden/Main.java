package main.java.bupt.wxy.hihoCoder.mc2016._403forbidden;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = in.nextInt();
        int M = in.nextInt();
        in.nextLine();
        boolean[] allowed = new boolean[N];
        int[] masks = new int[N];
        BitSet[] bitSets = new BitSet[N];
        for(int i=0;i<N;i++){
            String line = in.nextLine();
            String[] contents = line.split(" ");
            if(contents[0].equals("allow")){
                allowed[i] = true;
            }

            String[] ip_may_have_mask = contents[1].split("/");
            if(ip_may_have_mask.length==1){
                masks[i] = 32;
            }else {
                masks[i] = Integer.parseInt(ip_may_have_mask[1]);
            }
            bitSets[i] = ip2bitSet(ip_may_have_mask[0]);
        }

        // 一个一个比较
        for(int i=0;i<M;i++){
            String ip = in.nextLine();
            BitSet bit_ip = ip2bitSet(ip);
            boolean printed = false;
            for(int j=0;j<N;j++){
                if(bitSets[i].get(0, masks[i]).equals(bit_ip.get(0, masks[i]))){
                    printed = true;
                    if(allowed[i])System.out.println("YES");
                    else System.out.println("NO");
                    break;
                }
            }
            if(!printed)System.out.println("YES");
        }
    }

    /**
     * 假设输入是一个合法的ip值
     * @param ip_str
     * @return
     */
    private static BitSet ip2bitSet(String ip_str){
        BitSet bitSet = new BitSet(32);
        String[] ips = ip_str.split("\\.");
        for(int i=3;i>=0;i--){
            int base = i * 8;
            int ip = Integer.parseInt(ips[i]);
            for(int j=7;j>=0;j--){
                int k = ip&1;
                ip >>= 1;
                bitSet.set(base + j,  k==1);
            }
        }
        return bitSet;
    }
}