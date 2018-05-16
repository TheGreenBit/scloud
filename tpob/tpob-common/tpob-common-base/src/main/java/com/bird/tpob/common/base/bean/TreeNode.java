package com.bird.tpob.common.base.bean;


import java.util.List;

public class TreeNode<E,ID> {
    private static final long serialVersionUID = -5703964834600572016L;

    /**
     * ID
     */
    private ID id;

    /**
     * 父ID
     */
    private ID pid;

    /**
     * 是否含有子节点
     */
    private boolean hasChild = false;

    /**
     * 子节点集合
     */
    private List<E> children;
}
