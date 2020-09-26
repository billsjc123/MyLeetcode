import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Leetcode_1443 {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        for(int i = 0;i<n;i++)
        {
            map.put(i, new ArrayList<Integer>());
        }

        // 如何从输入用例中判断谁是父节点？
        HashSet<Integer> exists = new HashSet<Integer>();
        exists.add(0);
        for(int[] edge : edges)
        {
            int parent,child;
            if(exists.contains(edge[0]))
            {
                parent = edge[0];
                child = edge[1];
            }
            else
            {
                parent = edge[1];
                child = edge[0];
            }
            List<Integer> l = map.get(parent);
            l.add(child);
            if(!exists.contains(edge[0]))
                exists.add(edge[0]);
            if(!exists.contains(edge[1]))
                exists.add(edge[1]);
        }
        return greedyPath(0, map, hasApple);
    }
    public int greedyPath(int curNode,HashMap<Integer,List<Integer>> map,List<Boolean> hasApple)
    {
        // 当前是叶子节点
        if(map.get(curNode).isEmpty())
        {
            if(hasApple.get(curNode) && curNode!=0) return 2;
            else return 0;
        }

        // 如果子节点中有叶子节点，则必须经过该节点
        List<Integer> children = map.get(curNode);
        int childTime = 0;
        for (int child : children) {
            childTime += greedyPath(child, map, hasApple);
        }
        // 如果任何一个子树中有苹果，则必须经过该节点
        if(childTime!=0){
            if(curNode!=0)return childTime+2;
            else return childTime;
        }
        // 如果没有一个子树有苹果，则需要判断是否需要经过该节点
        else{
            if(hasApple.get(curNode) && curNode!=0) return 2;
            else return 0;
        }

    }
}