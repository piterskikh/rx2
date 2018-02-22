package exp;

import rx.ObservableImpl;
import rx.Observer;
import rx.Subscription;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

class Data1 {

    public Data1() {

        r();
    }

    public void test(){

        System.out.println("test");
    }

    private void r() {

        ObservableImpl.OnSubscrabe<BigInteger> onSubscrabe3 = new ObservableImpl.OnSubscrabe<BigInteger>() {
            @Override
            public void call(Observer s) {

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {

                        BigInteger i = BigInteger.ZERO;
                        int p = 0;
                        while (!s.isUnsubscribe()) {
                            lol();
                            s.onNext(i);
                            i = i.add(BigInteger.ONE);
                            p++;


                        }

                    }
                };

                new Thread(runnable).start();

            }
        };


        ObservableImpl<BigInteger> observable2 = ObservableImpl.create(onSubscrabe3);


        Subscription subscripion = observable2.subscribe((BigInteger numero) -> System.out.println(numero));


        sleep(1);
        subscripion.unsubscribe();
    }

    private void lol(){
        System.out.println("qqq");
    }

     private void sleep (int timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException ignored) {

        }
    }



}
