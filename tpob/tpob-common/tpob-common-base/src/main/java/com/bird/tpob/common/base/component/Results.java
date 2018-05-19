package com.bird.tpob.common.base.component;

public class Results {

    public static Result normalResult(Object o) {
        return new R(o, true);
    }

    public static Result abnormalResult(Object o) {
        return new R(o, false);
    }

    private static class R implements Result {
        private final Object o;
        private final boolean normal;

        public R(Object t, boolean normal) {
            this.o = t;
            this.normal = normal;
        }

        public boolean isNormalResult() {
            return normal;
        }

        public <T> T getResultValue() {
            return (T) o;
        }
    }

}
