package rx;

import java.util.function.Consumer;

public class Subscriber<T> implements Observer<T> {

   private boolean isUnsubscribed = false;

   private Consumer onNext;

    public Subscriber(Consumer onNext) {
        this.onNext = onNext;
    }

    @Override
    public void onNext(T t) {
      onNext.accept(t);
    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void unsubscribe() {
        if(!isUnsubscribed)
        isUnsubscribed = !isUnsubscribed;
    }

    @Override
    public boolean isUnsubscribe() {
        return isUnsubscribed;
    }
}
