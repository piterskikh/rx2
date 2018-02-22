package rx;

import java.util.function.Consumer;

public class ObservableImpl<T> implements Observable<T> {

    public static <K> ObservableImpl<K> just(K i) {
        OnSubscrabe<K> onSubscrabe = new OnSubscrabe<K>() {
            @Override
            public void call(Observer<K> s) {
                s.onNext(i);
            }
        };
        return ObservableImpl.create(onSubscrabe);

    }

    public static <B> ObservableImpl<B> create(OnSubscrabe<B> onSubscrabe) {

        return new ObservableImpl<>(onSubscrabe);
    }


    private  OnSubscrabe onSubscrabe;

    private T val;

    public ObservableImpl(OnSubscrabe onSubscrabe) {
        this.onSubscrabe = onSubscrabe;
    }

    @Override
    public Subscription subscribe(Observer<T> s) {
        onSubscrabe.call(s);
        return s;
    }

    public Subscription subscribe(Consumer<? super T> c) {

        Observer<T> observer = new Subscriber<>(c);


        return subscribe(observer);
    }


    public interface OnSubscrabe<M> {
         void call(Observer<M> s);
    }


    public void setVal(T val){


    }
}
