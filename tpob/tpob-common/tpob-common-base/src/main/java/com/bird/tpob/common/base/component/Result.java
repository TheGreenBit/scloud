package com.bird.tpob.common.base.component;

public interface Result {

    boolean isNormalResult();

    <T> T getResultValue();

}
