
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

```java
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

#### max subArray product (我也不知道是啥题, leetcode 上面有一道Minimum Size Subarray Sum)参考下

### OS2

#### Flatten Binary Tree to Linked List

中序遍历, 记录前面的节点



## Onsite

### OS1


