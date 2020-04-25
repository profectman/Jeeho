package com.jeeho.common.base.DataStructure.InterviewAlgorithm;


public class BuildTree {
   
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] preorder,int[] inorder){
        if (preorder.length <= 0 || inorder.length <=0)
            return null;
        if (preorder.length == 1 && inorder.length == 1)
            return new TreeNode(preorder[0]);
        int index = queryIndex(inorder,preorder[0]);
        int[] l_inorder = spl(inorder,0,index);
        int[] r_inorder = spl(inorder,index + 1,inorder.length - 1 - index);
        int[] l_preorder = spl(preorder,1,index);
        int[] r_preorder = spl(preorder,index + 1 ,inorder.length - 1 - index);
        
        TreeNode root = new TreeNode(preorder[0]);
        root.left = buildTree(l_preorder,l_inorder);
        root.right = buildTree(r_preorder,r_inorder);
        return root;
    }

    public static void main(String args[]){
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        BuildTree buildTree = new BuildTree();
        TreeNode treeNode = buildTree.buildTree(preorder, inorder);
    }
    
    public  int queryIndex(int[] arr,int param){
        int index = -1;
        for (int i = 0;i<arr.length;i++){
            if (param == arr[i])
                index = i;
        }
        return index;
    }

    /**
     * from zero start
     * @param arr
     * @param num
     * @param limit
     * @return
     */
    public  int[] spl(int[] arr,int num,int limit){
        int[] newArr;
        if (limit > 0 )
            newArr = new int[limit];
        else
            return null;
        for (int i = 0;i<limit;i++){
            newArr[i] = arr[num++];
        }
        return newArr;
    }
}
