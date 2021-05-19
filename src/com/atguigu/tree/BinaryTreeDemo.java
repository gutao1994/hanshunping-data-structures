package com.atguigu.tree;

public class BinaryTreeDemo {

    public static void main (String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        HeroNode node2_1 = new HeroNode(21, "吴用小弟");
        HeroNode node2_2 = new HeroNode(21, "吴用小弟");

        root.setLeft(node2);
//        node2.setLeft(node2_1);
        root.setRight(node3);
        node3.setLeft(node4);
        node3.setRight(node5);
        node4.setRight(node2_2);
        binaryTree.setRoot(root);

        System.out.println("删除前，前序遍历");
        binaryTree.preOrder();

        binaryTree.delNode(21);

        System.out.println("删除后，前序遍历");
        binaryTree.preOrder();

    }
}

class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法前序遍历");
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法中序遍历");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法后序遍历");
        }
    }

    public boolean delNode(int no) {
        if (this.root != null) {
            if (this.root.getNo() == no) {
                this.root = null;
                return true;
            } else {
                return root.delNode(no);
            }
        }

        return false;
    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + "]";
    }

    public void preOrder() {
        //action
        System.out.println(this);

        //go left
        if (this.left != null) {
            this.left.preOrder();
        }

        //go right
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public void infixOrder() {
        //go left
        if (this.left != null) {
            this.left.infixOrder();
        }

        //action
        System.out.println(this);

        //go right
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public void postOrder() {
        //go left
        if (this.left != null) {
            this.left.infixOrder();
        }

        //go right
        if (this.right != null) {
            this.right.infixOrder();
        }

        //action
        System.out.println(this);
    }

    public boolean delNode(int no) {
        boolean flag = false;

        //action
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return true;
        }

        if (this.right != null && this.right.no == no) {
            this.right = null;
            return true;
        }

        //go left
        if (this.left != null) {
            flag = this.left.delNode(no);
        }

        if (flag) {
            return flag;
        }

        //go right
        if (this.right != null) {
            flag = this.right.delNode(no);
        }

        return flag;
    }



}













