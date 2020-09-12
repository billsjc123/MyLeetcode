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
