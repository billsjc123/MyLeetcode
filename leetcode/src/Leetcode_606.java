
// 傻逼题目写都写不清楚，不做了

// public class Leetcode_606 {
//     public String tree2str(TreeNode t) {
//         if(t==null)
//             return "";
//         String str;
//         str = preOrder(t);
//         return str;
//     }
//     public String preOrder(TreeNode t)
//     {
//         String str = "";
//         if(t==null)
//         {
//             return "";
//         }
//         if(t.left==null && t.right==null)
//         {
//             return Integer.toString(t.val);
//         }
//         str+=Integer.toString(t.val)+'(';
//         str += preOrder(t.left);
//         str += preOrder(t.right);
//         str+=')';
//         return str;
//     }
// }
