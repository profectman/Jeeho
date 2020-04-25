package com.jeeho.common.base.DataStructure.InterviewAlgorithm;


public class NodeNext {

    public class Node{
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    /**
     * 上升左节点的右节点和右节点的左节点到其父节点，再次判断left是否为空，不为空这其next就是其右节点 也就是拉拉链方法
     * @param root
     * @return
     */
    public Node connect(Node root){
        if (null == root) return root;
        Node left = root.left;
        Node right = root.right;
        while (left != null){
            left.next = right;
            left = left.right;
            right = right.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
