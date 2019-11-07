/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @since JDK 1.8
 */
public class Demo4 {

    public class Solution {
        public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
            return reConstructBinaryTree(pre,in,0,pre.length-1,0,in.length-1);
        }
        public TreeNode reConstructBinaryTree(int [] pre,int [] in,int preLeft,int preRight,int inLeft,int inRight){
            if(preLeft>preRight || inLeft>inRight){
                return null;
            }
            //新建Node
            TreeNode root =new TreeNode(pre[preLeft]);
            for(int i = inLeft; i<=inRight;i++){
                if(pre[preLeft] == in[i]){
                    //左子树递归
                    root.left=reConstructBinaryTree(pre,in,preLeft+1,preLeft+i-inLeft,inLeft,i-1);
                    //右子树递归
                    root.right=reConstructBinaryTree(pre,in,preLeft+i-inLeft+1,preRight,i+1,inRight);
                }
            }
            return root;
        }
    }

    public class TreeNode {
         int val;
          TreeNode left;
          TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
