package main.java.bupt.wxy.graph;

import java.util.*;

/**
 * Created by xiyuanbupt on 5/14/17.
 582. Kill Process My SubmissionsBack To Contest
 User Accepted: 605
 User Tried: 779
 Total Accepted: 611
 Total Submissions: 1420
 Difficulty: Medium
 Given n processes, each process has a unique PID (process id) and its PPID (parent process id).

 Each process only has one parent process, but may have one or more children processes. This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct positive integers.

 We use two list of integers to represent a list of processes, where the first list contains PID for each process and the second list contains the corresponding PPID.

 Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that will be killed in the end. You should assume that when a process is killed, all its children processes will be killed. No order is required for the final answer.

 Example 1:
 Input:
 pid =  [1, 3, 10, 5]
 ppid = [3, 0, 5, 3]
 kill = 5
 Output: [5,10]
 Explanation:
 3
 /   \
 1     5
 /
 10
 Kill 5 will also kill 10.
 Note:
 The given kill id is guaranteed to be one of the given PIDs.
 n >= 1.
 */
public class KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> childs = new HashMap<>();
        Iterator<Integer> pids = pid.iterator();
        Iterator<Integer> ppids = ppid.iterator();
        while (ppids.hasNext()){
            int p = ppids.next();
            int c = pids.next();
            if(!childs.containsKey(p)){
                childs.put(p, new LinkedList<>());
            }
            childs.get(p).add(c);
        }

        // 层序遍历
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        List<Integer> res = new LinkedList<>();
        int len;
        while ((len = queue.size())>0){
            for(int i=0; i<len; i++){
                int par = queue.poll();
                res.add(par);
                List<Integer> sub = childs.get(par);
                if(sub!=null) {
                    queue.addAll(sub);
                }
            }
        }
        return res;
    }
}
