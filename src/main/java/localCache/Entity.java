package localCache;

import java.util.concurrent.Future;

public class Entity {

    //键值对的value
    private Object value;
    //定时器Future
    private Future future;

    public Entity(Object value, Future future) {
        this.value = value;
        this.future = future;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Future getFuture() {
        return future;
    }

    public void setFuture(Future future) {
        this.future = future;
    }
}
