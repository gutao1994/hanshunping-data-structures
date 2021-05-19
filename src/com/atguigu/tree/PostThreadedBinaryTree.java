package com.atguigu.tree;

public class PostThreadedBinaryTree {

    private Node preNode;   //线索化时记录前一个节点

    //节点存储结构
    static class Node {
        String data;        //数据域
        Node left;          //左指针域
        Node right;         //右指针域
        Node parent;        //父节点的指针（为了后序线索化使用）
        boolean isLeftThread = false;   //左指针域类型  false：指向子节点、true：前驱或后继线索
        boolean isRightThread = false;  //右指针域类型  false：指向子节点、true：前驱或后继线索

        Node(String data) {
            this.data = data;
        }
    }

    static Node createBinaryTree(String[] array, int index) {
        Node node = null;

        if(index < array.length) {
            node = new Node(array[index]);
            node.left = createBinaryTree(array, index * 2 + 1);
            node.right = createBinaryTree(array, index * 2 + 2);

            //记录节点的父节点（后序线索化遍历时使用）
            if(node.left != null) {
                node.left.parent = node;
            }

            if(node.right != null) {
                node.right.parent = node;
            }
        }

        return node;
    }

    void postThreadOrder(Node node) {
        if(node == null) {
            return;
        }

        //处理左子树
        postThreadOrder(node.left);
        //处理右子树
        postThreadOrder(node.right);

        //左指针为空,将左指针指向前驱节点
        if(node.left == null) {
            node.left = preNode;
            node.isLeftThread = true;
        }

        //前一个节点的后继节点指向当前节点
        if(preNode != null && preNode.right == null) {
            preNode.right = node;
            preNode.isRightThread = true;
        }
        preNode = node;
    }

    void postThreadList(Node root) {
        Node node = root;
        while(node != null && !node.isLeftThread) { //找后序遍历方式开始的节点
            node = node.left;
        }

        Node preNode = null;
        while(node != null) {
            if(node.isRightThread) { //右节点是线索
                System.out.print(node.data + ", ");
                preNode = node;
                node = node.right;
            } else if (node.right == preNode) { //如果上个处理的节点是当前节点的右节点
                System.out.print(node.data + ", ");
                if(node == root) {
                    return;
                }

                preNode = node;
                node = node.parent;
            } else if (node.left == preNode) { //如果从左节点的进入
                if (node.right == null) {
                    System.out.print(node.data + ", ");
                    return;
                }

                node = node.right;
                while(!node.isLeftThread) {
                    node = node.left;
                }
            }

            else if (node.right != null) { //左节点遍历完之后
                node = node.right;
                while(!node.isLeftThread) {
                    node = node.left;
                }
            }
        }
    }

    public void postList(Node node) {
        if (node.left != null)
            postList(node.left);

        if (node.right != null)
            postList(node.right);

        System.out.print(node.data + ", ");
    }

    public static void main(String[] args) {
//        String[] array = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
//        Node root = createBinaryTree(array, 0);

        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");

        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node3.right = node5;
        node2.parent = node1;
        node3.parent = node2;
        node4.parent = node2;
        node5.parent = node3;

        Node root = node1;


        PostThreadedBinaryTree tree = new PostThreadedBinaryTree();

        System.out.println("递归后序遍历二叉树结果：");
        tree.postList(root);

        System.out.println();

        tree.postThreadOrder(root);
        System.out.println("后序按后继节点遍历线索二叉树结果：");
        tree.postThreadList(root);
    }



}





