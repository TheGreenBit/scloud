package com.bird.tpob.common.base.component;

import java.io.Serializable;

public interface MutableResultData<T> extends ResultData<T>, Serializable {
    void setData(T data);

    void setSuccess(boolean b);

    void setCode(int code);

    void setState(int state);

    void setMsg(String msg);

    void setLen(int len);

    void setError(String error);
}
