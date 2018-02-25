
import exp.*;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import rx.ObservableImpl;

import java.time.DayOfWeek;
import java.util.concurrent.TimeUnit;

import static exp.Sound.DI;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;


public class Main {


    private static void sleep(int timeout) {
        try {
            SECONDS.sleep(timeout);
        } catch (InterruptedException ignored) {

        }
    }


    public static void main(String[] args) {


        Data2 data2 = new Data2();

        Observable<Integer> observable = Observable.create(subscriber -> {

            System.out.println("Подписка!");

            data2.setSubscriber(subscriber);


            subscriber.setCancellable(() -> System.out.println("Соединение разорвано"));


        });

        Observable<Integer> one = observable.publish().refCount().delay(5, TimeUnit.SECONDS);

        // ConnectableObservable<Integer> lazy =  one.publish();


        Disposable subl = one.subscribe(n -> System.out.println(n));

        /*System.out.println("Send 0 and 1");
        data2.sendNum(0);
        data2.sendNum(1);

        sleep(7);

        System.out.println("Send 2 and 3");
        data2.sendNum(2);
        data2.sendNum(3);*/

/**
 Disposable sub2 = lazy.subscribe(n -> System.out.println(n));

 data2.sendNum(4);
 data2.sendNum(5);

 sub2.dispose();

 data2.sendNum(6);
 data2.sendNum(7);

 subl.dispose();

 data2.sendNum(8);
 data2.sendNum(9);*/

        int nnn = 4;

        Integer[] i = {1, 2, 3};

        Observable<Long> te = Observable.timer(1, SECONDS);


        Observable<Integer> obs = Observable.timer(1, SECONDS).flatMap(m -> Observable.just(3, 4, 5));

        //Observable<Observable<Data3>> obsData = obs.map(number -> Observable.just(new Data3(number)));


        //   obs.subscribe(s-> System.out.println(s));

        //  te.subscribe(System.out::println);


       /* Observable.just("Lorem", "ipsum", "dolor", "sit", "amet",
                "consectetur", "adipiscing", "elit").delay(word -> Observable.timer(word.length(), SECONDS)).subscribe(System.out::println);
*/

       /* Observable.range(1, 10)
                .flatMap (х ->
                        Observable.just (х) .delay(х, TimeUnit.SECONDS))
                .subscribe(System.out::println);*/


        /*Observable
                .just ("Lorem", "ipsum", "dolor", "sit", "amet","consectetur", "adipiscing", "elit")
                .flatMap (word ->Observable.timer(word.length (), SECONDS).map(x -> word)).subscribe(System.out::println);*/


        // Observable.interval(1,SECONDS).take(5).subscribe(System.out::println);


       /* Observable
                .just(DayOfWeek.SUNDAY, DayOfWeek.MONDAY)
                .flatMap(Main ::loadRecordsFor, 1).subscribe(System.out::println);*/

/*
        Observable<Integer> oneToEight = Observable.range(1, 8);

        Observable<Integer> files = oneToEight.map(x -> 'a'+ x-1);

        oneToEight.map(x -> 'a'+1).subscribe(System.out::println);

                      //  oneToEight.subscribe(System.out::println);*/


        Observable<Integer> integerObservable = Observable.just(1, 2, 3, 4, 5, 6, 7, 8);
        Observable<String> stringObservable = Observable.just("a", "b", "c", "d", "e", "f", "g", "h");


        Observable<String> result = integerObservable.flatMap(u -> stringObservable.map(s->s+u));

        result.subscribe(System.out::println);


        sleep(15);


    }


    static Observable<String> loadRecordsFor(DayOfWeek dow) {
        switch (dow) {
            case SUNDAY:
                return Observable
                        .interval(90, MILLISECONDS)
                        .take(5)
                        .map(i -> "Sun-" + i);
            case MONDAY:
                return Observable
                        .interval(65, MILLISECONDS)
                        .take(5)
                        .map(i -> "Mon-" + i);
            default:
                return Observable.empty();
        }


    }


}
