package P07Exam.P01Exam.core;

import P07Exam.P01Exam.interfaces.Entity;

public class BinaryTreeNode {
    private Entity entity;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(Entity entity) {
        this.entity = entity;
        this.left = null;
        this.right = null;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }


}
