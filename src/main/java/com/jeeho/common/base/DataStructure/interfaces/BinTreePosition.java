package com.jeeho.common.base.DataStructure.interfaces;

public interface BinTreePosition extends Position{

    int getSize();

    void updateSize();

    int getHeight();

    void updateHeight();

    int getDepth();

    void updateDepth();

    boolean isLeaf();

    boolean hasParent();

    BinTreePosition getParent();

    void setParent(BinTreePosition p);

    boolean isLChild();

    boolean hasLChild();

    BinTreePosition getLChild();

    void setLChild(BinTreePosition c);

    boolean isRChild();

    boolean hasRChild();

    BinTreePosition getRChild();

    void setRChild(BinTreePosition c);

    BinTreePosition getPrev();

    BinTreePosition getSucc();

    BinTreePosition attachL(BinTreePosition c);

    BinTreePosition attachR(BinTreePosition c);

    /**
     * 断开当前节点与其父亲节点的关系，并返回当前节点
     * @return
     */
    BinTreePosition secede();

    Iterator elementsPreOrder();

    Iterator elementsPostOrder();

    Iterator elementsInOrder();

    Iterator elementsLevelOrder();
}
