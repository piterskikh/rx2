
import exp.Data3;
import exp.Sound;
import io.reactivex.Observable;

import static exp.Sound.DI;

import static java.util.concurrent.TimeUnit.SECONDS;


public class Main {


    private static void sleep (int timeout) {
        try {
            SECONDS.sleep(timeout);
        } catch (InterruptedException ignored) {

        }
    }



    public static void main(String[] args) {


      /*  Data2 data2 = new Data2();

        Observable<Integer> observable = Observable.create(subscriber ->{

            System.out.println("Подписка!");

            data2.setSubscriber(subscriber);
           *//* subscriber.onNext(1);

            subscriber.onComplete();*//*

            subscriber.setCancellable(()->System.out.println("Соединение разорвано"));


        });

        Observable<Integer> one =  observable;

        ConnectableObservable<Integer> lazy =  one.publish();



        Disposable subl = lazy.subscribe(n -> System.out.println(n));


        data2.sendNum(0);
        data2.sendNum(1);

        lazy.connect();

        data2.sendNum(2);
        data2.sendNum(3);


        Disposable sub2 = lazy.subscribe(n -> System.out.println(n));

        data2.sendNum(4);
        data2.sendNum(5);

        sub2.dispose();

        data2.sendNum(6);
        data2.sendNum(7);

        subl.dispose();

        data2.sendNum(8);
        data2.sendNum(9);*/

        int nnn =4;

        Integer[] i = {1, 2, 3};

        Observable<Long> te = Observable.timer (1, SECONDS);


        Observable<Integer> obs = Observable.timer (1, SECONDS).flatMap(m->Observable.just(3, 4, 5));

        //Observable<Observable<Data3>> obsData = obs.map(number -> Observable.just(new Data3(number)));


        obs.subscribe(s-> System.out.println(s));

        te.subscribe(System.out::println);


        Observable.just("Lorem", "ipsum", "dolor", "sit", "amet",
                "consectetur", "adipiscing", "elit").delay(word -> Observable.timer(word.length(), SECONDS)).subscribe(System.out::println);



        sleep(15);












    }


    void store(Integer id) {
        upload(id).subscribe(
                bytes -> {}, // игнорируем
                e -> e.printStackTrace(),
                () -> rate(id)
        );
    }



    static Observable<Long> upload(Integer id) {

        return Observable.just(id*1245L);
    }


    Observable<Data3> rate(Integer id) {

        return Observable.just(new Data3(id*100));
    }



    Observable<Sound> toMorseCode(char ch) {

        switch(ch) {
            case 'a':
                return Observable.just(DI);
        }


            return Observable.empty();
    }






}
