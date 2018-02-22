package exp;

import io.reactivex.ObservableEmitter;
import org.reactivestreams.Subscriber;

public class Data2 {

    public ObservableEmitter<Integer> subscriber;

    public void setSubscriber(ObservableEmitter subscriber) {
        this.subscriber = subscriber;
    }

    public void sendNum(Integer num) {
        if (subscriber != null)
            subscriber.onNext(num);

    }

}
