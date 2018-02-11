import io.reactivex.Observable;
import rx.ObservableImpl;
import rx.Observer;

import java.math.BigInteger;


public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");


        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onNext(Integer integer) {
                System.out.println(integer * 2);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

            }
        };



        Observer<BigInteger> observer2 = new Observer<BigInteger>() {
            @Override
            public void onNext(BigInteger integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

            }
        };

        ObservableImpl<Integer> observable1 = ObservableImpl.just(99);

        observable1.subscribe(observer);

       /* observable.setI(5);


        Integer p = observable.getI();*/

        // Observable<Integer> o = Observable.just(5);

        ObservableImpl<BigInteger> observable2 = ObservableImpl.create(observerN -> {
            BigInteger i = BigInteger.ZERO;
            while (true) {
                observerN.onNext(i);
                i = i.add(BigInteger.ONE);

            }



        });


        observable2.subscribe(observer2);

    }
}
