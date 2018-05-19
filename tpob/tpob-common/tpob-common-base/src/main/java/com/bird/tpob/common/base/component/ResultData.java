package com.bird.tpob.common.base.component;

import java.io.Serializable;

public interface ResultData<T> extends Serializable{
    T getData();

    boolean isSuccess();

    int getCode();

    int getState();

    String getMsg();

    int getLen();
}
