
## Onsite

### OS1 
 
#### binary tree leaf to leaf longest path

``` java
    public class LeafToLeafLongest {

        int maxValue;

        public int getLongest(TreeNode root){
            maxValue=Integer.MIN_VALUE;
            getLongestToLeaf(root);
            return maxValue;
        }
        
        // 获得到达leaf 的最长路径, 同时更新通过本节点的最长路径
        public int getLongestToLeaf(TreeNode root){
            if(root==null)return 0;
            int left=getLongestToLeaf(root.left);
            int right=getLongestToLeaf(root.right);
            maxValue=Math.max(maxValue,left+right+root.val);
            return Math.max(left,right)+root.val;
        }
    }
```

#### 上述题目改为不一定为leaftoleaf

```
public class LeafToLeafLongest {

    int maxValue;

    public int getLongest(TreeNode root){
        maxValue=Integer.MIN_VALUE;
        getLongestToLeaf(root);
        return maxValue;
    }
    
    // 获得到达leaf 的最长路径
    public int getLongestToLeaf(TreeNode root){
        if(root==null)return 0;
        // 如果到leaf的路径中包含0了, 那么需要舍弃
        int left=Math.max(0,getLongestToLeaf(root.left));
        int right=Math.max(0,getLongestToLeaf(root.right));
        maxValue=Math.max(maxValue,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}
```


### OS2

#### b

## Onsite

### OS1


