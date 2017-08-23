package bupt.wxy.tree;

/**
 * Created by xiyuanbupt on 3/12/17.
 536. Construct Binary Tree from String
 Difficulty: Medium
 You need to construct a binary tree from a string consisting of parenthesis and integers.

 The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis.
 The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.

 You always start to construct the left child node of the parent first if it exists.

 Example:
 Input: "4(2(3)(1))(6(5))"
 Output: return the tree root node representing the following tree:

 4
 /   \
 2     6
 / \   /
 3   1 5
 */
public class ConstructBinaryTreeFromString {

    // 这种题目就要争取一次性通过, 如果第一次有bug了, 之后的思维就混乱了
    public TreeNode str2tree(String s) {
        if(s.length()==0)return null;
        int weight=1;
        if(s.charAt(0)=='-'){
            weight=-1;
            s=s.substring(1);
        }
        int leftStart=1;
        while (leftStart<s.length()&&s.charAt(leftStart)!='(')leftStart++;
        TreeNode root=new TreeNode(weight*Integer.parseInt(s.substring(0,leftStart)));
        if(leftStart==s.length())return root;
        String remain=s.substring(leftStart);
        int leftEnd=getEndBracketPosition(remain);
        root.left=str2tree(remain.substring(1,leftEnd));
        if(leftEnd==remain.length()-1)return root;
        root.right=str2tree(remain.substring(leftEnd+2,remain.length()-1));
        return root;
    }

    private int getEndBracketPosition(String s){
        if(s.length()==0)return 0;
        int len=s.length();
        int leftBracketCount=0;
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            if(c=='(')leftBracketCount++;
            else if(c==')'){
                if(leftBracketCount==1)return i;
                else leftBracketCount--;
            }
        }
        return s.length()-1;
    }
}
