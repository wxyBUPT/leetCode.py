package main.java.bupt.wxy.hihoCoder.toutiao.Q3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 +-+
 | |

 | |
 +-+
 +-+
 | |

 | |
 +-+
 +-+
 | |

 | |
 +-+
 */
public class Main {

    public static void handleLine(String str){

        Stack<Integer> lefts = new Stack<>();
        char[] chars = str.toCharArray();
        int len = chars.length;
        int[] counts = new int[len];
        int curr = 1;
        for(int i=0;i<len; i++){
            char c = chars[i];
            if(c=='['){
                lefts.push(i);
                curr = 1;
            }else {
                counts[i] = curr;
                counts[lefts.pop()] = curr;
                curr ++;
            }
        }

        int max = 1;
        for(int i:counts){
            max = Math.max(i, max);
        }
        int _count = 2*max - 1;

        for(int i=0;i<len;i++){
            // 左括号外面没有括号
            if(chars[i]=='['&&i==0||counts[i]==counts[i-1]){
                if(counts[i]==max){
                    int l=0;
                    while (l<_count+2){

                    }

                    System.out.print("+");
                    int tmp_count = (_count - counts[i]*2 +1 )/2;
                    for(;l<tmp_count;l++)System.out.print(" ");
                    for(;l<_count-tmp_count;l++)System.out.print("_");
                    for(;l<_count;l++)System.out.print(" ");
                    System.out.println("+");
                    if(counts[i]==1){

                    }
                }else {
                    System.out.println();
                }
            }
            // 左括号外面有括号
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        handleLine(in.nextLine());
    }
}
