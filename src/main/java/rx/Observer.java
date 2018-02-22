package rx;

public interface Observer<T> extends Subscription  {

    void onNext(T t);
    void onError(Throwable t);
    void onCompleted();

}
