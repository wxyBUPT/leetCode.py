package main.java.bupt.wxy.mic.professorQ_Software;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /**
     *
     * @param sigCount 初始信号, 一个信号被发送了多少次
     * @param sigMap 一个信号会产生所有的信号
     * @param execute 一个信号激活了哪些触发器
     */
    public void handleCase(Map<Integer,Integer> sigCount, Map<Integer, List<Integer>> sigMap, Map<Integer, List<Integer>> execute){
        Map<Integer, Integer> totalCount = new HashMap<Integer, Integer>(sigCount);

        // 还有未使用的信号
        while (sigCount.size()!=0) {
            Map<Integer, Integer> tmp = sigCount;
            sigCount = new HashMap<Integer, Integer>();
            for(Map.Entry<Integer, Integer> sigEntry:tmp.entrySet()){
                int sig = sigEntry.getKey();
                int count = sigEntry.getValue();
                if(!sigMap.containsKey(sig))continue;
                List<Integer> nextSigs = sigMap.get(sig);

                for(Integer nextSig:nextSigs){
                    // 更新totalCount
                    if(totalCount.containsKey(nextSig)){
                        totalCount.put(nextSig, totalCount.get(nextSig) + count);
                    }else {
                        totalCount.put(nextSig, count);
                    }
                    // 更新下一波的 sigCount
                    if(sigCount.containsKey(nextSig)){
                        sigCount.put(nextSig, sigCount.get(nextSig) + count);
                    }else {
                        sigCount.put(nextSig, count);
                    }
                }
            }
        }
        printRes(totalCount, execute);
    }

    public void printRes(Map<Integer, Integer> totalSigCount, Map<Integer, List<Integer>> execute){

        Map<Integer, Integer> moduleCount = new HashMap<Integer, Integer>();
        for(Map.Entry<Integer, Integer> sigCountEntre:totalSigCount.entrySet()){
            int sig = sigCountEntre.getKey();
            int count = sigCountEntre.getValue();
            if(!execute.containsKey(sig))continue;
            List<Integer> modules = execute.get(sig);
            for(int i:modules){
                if(moduleCount.containsKey(i)){
                    moduleCount.put(i, moduleCount.get(i) + count);
                }else {
                    moduleCount.put(i, count);
                }
            }
        }
        SortedMap<Integer,Integer> orderModuleCount = new TreeMap<Integer, Integer>(moduleCount);
        int end = orderModuleCount.size();
        for(Integer res:orderModuleCount.values()){
            if(--end==0){
                System.out.println(res%142857);
            }else {
                System.out.print(res%142857 + " ");
            }
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Main main = new Main();
        int T = in.nextInt();
        while (T--!=0) {
            int N = in.nextInt();
            int M = in.nextInt();
            int n;
            Map<Integer, Integer> sigCount = new HashMap<Integer, Integer>();
            for (int i = 0; i < M; i++) {
                n = in.nextInt();
                if(sigCount.containsKey(n)){
                    sigCount.put(n, sigCount.get(n) + 1);
                }else {
                    sigCount.put(n, 1);
                }
            }
            Map<Integer, List<Integer>> sigMap = new HashMap<Integer, List<Integer>>();
            Map<Integer, List<Integer>> execute = new HashMap<Integer, List<Integer>>();
            int S, K;
            for (int i = 1; i <= N; i++) {
                S = in.nextInt();
                if (!sigMap.containsKey(S)) sigMap.put(S, new LinkedList<Integer>());
                if (!execute.containsKey(S)) execute.put(S, new LinkedList<Integer>());
                execute.get(S).add(i);
                K = in.nextInt();
                for(int j=0;j<K;j++){
                    sigMap.get(S).add(in.nextInt());
                }
            }
            main.handleCase(sigCount, sigMap, execute);
        }
    }
}
