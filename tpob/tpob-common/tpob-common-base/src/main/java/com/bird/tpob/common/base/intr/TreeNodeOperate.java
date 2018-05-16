package com.bird.tpob.common.base.intr;

public interface TreeNodeOperate<ID,E> extends NodeOperate<ID,E> {

    boolean hasChildren();

    E addElement(E e);



}
