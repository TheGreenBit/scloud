package com.bird.tpob.common.base.component;


import com.bird.tpob.common.base.error.ErrorCode;
import com.huban.framework.dto.ErrorCode;

import java.io.Serializable;

public class ResponseData {

    //数据状态: sucess, state
    private static final short SUCCESS = 0;            //成功
    private static final short ERROR = 1;

    private static final ImmutableResult IMMUTABLE_SUCCESS_EMPTY_RESULT = new ImmutableResult(SUCCESS, 0, 0, null, null);
    private static final ImmutableResult IMMUTABLE_ERROR_EMPTY_RESULT = new ImmutableResult(ERROR, 0, 0, null, null);

    public static <T> ResultData<T> success() {
        return IMMUTABLE_SUCCESS_EMPTY_RESULT;
    }

    public static <T> ResultData<T> error() {
        return IMMUTABLE_ERROR_EMPTY_RESULT;
    }

    public static <T> ResultData<T> success(T data) {
        return data != null ? new ImmutableResult(SUCCESS, 0, 0, data, null) : IMMUTABLE_SUCCESS_EMPTY_RESULT;
    }

    public static <T> ResultData<T> success(T data, long count) {
        return new ImmutableResult(SUCCESS, 0, (int) count, data, null);
    }

    public static <T> ResultData<T> error(T data, String msg) {
        return new ImmutableResult<>(ERROR, 0, 0, data, msg);
    }

    public static <T> ResultData<T> error(String msg) {
        return new ImmutableResult<>(ERROR, 0, 0, null, msg);
    }

    public static <T> ResultData<T> error(int code) {
        return new ImmutableResult<>(ERROR, code, 0, null, null);
    }

    public static <T> ResultData<T> error(ErrorCode code) {
        return new ImmutableResult<>(ERROR, code.getCode(), 0, null, code.getMsg());
    }

    public static <T> ResultData<T> apply(int applies) {
        short state = applies > 0 ? SUCCESS : ERROR;
        return state == SUCCESS ? IMMUTABLE_SUCCESS_EMPTY_RESULT : IMMUTABLE_ERROR_EMPTY_RESULT;
    }

    public static <T> ResultData<T> apply(int applies, String msg) {
        short state = applies > 0 ? SUCCESS : ERROR;
        return new ImmutableResult<>(state, 0, 0, null, msg);
    }

    private static class ImmutableResult<T> implements ResultData<T>, Serializable {

        public ImmutableResult() {
        }

        protected ImmutableResult(int state, int code, int len, T data, String msg) {
            this.state = state;
            this.code = code;
            this.len = len;
            this.data = data;
            this.msg = msg;
        }

        /**
         * 状态
         */
        protected int state = 0;

        protected int code = 0;

        protected int len = 0;
        /**
         * 数据，真正的结果对象
         */
        protected T data;

        protected String msg;


        @Override
        public T getData() {
            return data;
        }

        @Override
        public boolean isSuccess() {
            return state == SUCCESS;
        }

        @Override
        public int getCode() {
            return code;
        }

        @Override
        public int getState() {
            return state;
        }

        @Override
        public String getMsg() {
            return msg;
        }

        @Override
        public int getLen() {
            return len;
        }

        @Override
        public String toString() {
            return "ResultDTO{" +
                    "data=" + data +
                    ", state=" + state +
                    ", msg='" + msg + '\'' +
                    '}';
        }
    }


    public static <T> MutableResultData<T> mutableSuccess() {
        return new MutableResult<>();
    }

    public static <T> MutableResultData<T> mutableError() {
        return new MutableResult<>(ERROR, 0, 0, null, null);
    }

    public static <T> MutableResultData<T> mutableSuccess(T data) {
        return new MutableResult(SUCCESS, 0, 0, data, null);
    }

    public static <T> MutableResultData<T> mutableSuccess(T data, long count) {
        return new MutableResult(SUCCESS, 0, (int) count, data, null);
    }

    public static <T> MutableResultData<T> mutableError(T data, String msg) {
        return new MutableResult<>(ERROR, 0, 0, data, msg);
    }

    public static <T> MutableResultData<T> mutableError(String msg) {
        return new MutableResult<>(ERROR, 0, 0, null, msg);
    }

    public static <T> MutableResultData<T> mutableError(int code) {
        return new MutableResult<>(ERROR, code, 0, null, null);
    }

    public static <T> MutableResultData<T> mutableError(ErrorCode code) {
        return new MutableResult<>(ERROR, code.getCode(), 0, null, code.getMsg());
    }

    public static <T> MutableResultData<T> mutableApply(int applies) {
        short state = applies > 0 ? SUCCESS : ERROR;
        return new MutableResult<>((short) state, 0, 0, null, null);
    }

    public static <T> MutableResultData<T> mutableApply(int applies, String msg) {
        short state = applies > 0 ? SUCCESS : ERROR;
        return new MutableResult<>((short) state, 0, 0, null, msg);
    }


    private static class MutableResult<T> extends ImmutableResult<T> implements MutableResultData<T>, Serializable {

        public MutableResult() {
        }

        MutableResult(short state, int code, int len, T o, String msg) {
            super(state, code, len, o, msg);
        }

        @Override
        public void setData(T data) {
            this.data = data;
        }

        @Override
        public void setSuccess(boolean b) {
            setState(b ? SUCCESS : ERROR);
        }

        @Override
        public void setCode(int code) {
            this.code = code;
        }

        @Override
        public void setState(int state) {
            this.state = state;
        }

        @Override
        public void setMsg(String msg) {
            this.msg = msg;
        }

        @Override
        public void setLen(int len) {
            this.len = len;
        }

        @Override
        public void setError(String error) {
            this.state = ERROR;
            this.msg = error;
        }
    }

}
