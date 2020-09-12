# 好叶子结点对的数量

​		此题的实质实际上是求叶子节点之间的距离。叶子节点之间的距离的计算方法是，找到两个叶子节点的最近的公共祖先节点，分别计算各自到公共祖先结点的距离，并相加。

​		使用递归的思想，如果已经求得了子节点到叶子结点的距离，那么他的父节点到这些叶子节点的距离直接用子节点的距离+1即可。当然，在子节点中计算距离的叶子节点到父节点的部分中不用再次计算，因为他们都在父节点的左子树或右子树，必定不是最小的距离。

​		arr[i]:到当前结点距离为i的结点有arr[i]个。因为题目说distance<=10，因此数组开11个即可，超过10的忽略掉。

```java
fatherDist[i+1] = leftDist[i]+rightDist[i];
```

​		因为要实现递归，因此每一层需要把上一层的arr[]作为返回值，因此需要理解arr[]的意思。比如当前结点为叶子节点，令`toUpperLayer[1]=1`，并不是说当前的距离为1的有一个，因为是作为返回值，因此相当于直接构造了上层的arr[]并返回。

代码：

```java
public class Leetcode_1530 {
    private int result;

    public int countPairs(TreeNode root, int distance) {
        result = 0;
        cntLeaves(root, distance);
        return result;
    }   

    public int[] cntLeaves(TreeNode root,int distance)
    {
        if(root == null)
            return new int[11];
        int []toUpperLayer = new int[11];
        if(root.left == null && root.right == null)
        {
            // There is a leaf node for current node's father at a distance of 1
            toUpperLayer[1]=1;
            return toUpperLayer;
        }
        int []leftDistance = new int [11];
        int []rightDistance = new int [11];
        leftDistance = cntLeaves(root.left, distance);
        rightDistance = cntLeaves(root.right, distance);

        for(int i = 1;i<10;i++)
        {
            for(int j = 1;j<10;j++)
            {
                if(i+j<=distance)
                    result+=leftDistance[i]*rightDistance[j];
            }
        }
        
        // add 1 for current node's father
        for(int i = 0;i<10;i++)
        {
            toUpperLayer[i+1]+=(leftDistance[i]+rightDistance[i]);
        }
        return toUpperLayer;
    }
}
```



