package com.jeeho.common.base.DataStructure.InterviewAlgorithm;

import java.util.*;

/**
 * 二叉树的右视图
 * 广度优先遍历
 */
public class RightSideView {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> rightSideView(TreeNode root){
        HashMap<Integer,Integer> rightmostValueAtDepth = new HashMap<>();
        int max_depth = -1;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        nodeQueue.add(root);
        depthQueue.add(0);
        while (!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.remove();
            int depth = depthQueue.remove();

            if (null != node){
                max_depth =Math.max(max_depth,depth);

                rightmostValueAtDepth.put(depth,node.val);

                nodeQueue.add(root.left);
                nodeQueue.add(root.right);
                depthQueue.add(depth + 1);
                depthQueue.add(depth + 1);
            }
        }
        List<Integer> rightView = new ArrayList<>();
        for (int i = 0 ; i <= max_depth; i++){
            rightView.add(rightmostValueAtDepth.get(i));
        }
        return rightView;
    }

}
