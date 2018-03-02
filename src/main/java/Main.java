
import exp.*;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.BiFunction;



import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static exp.Sound.DI;

import static java.util.concurrent.TimeUnit.SECONDS;


public class Main {


    private static void sleep(int timeout) {
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

        int nnn = 4;

        Integer[] i = {1, 2, 3};

        Observable<Long> te = Observable.timer(1, SECONDS);


        Observable<Integer> obs = Observable.timer(1, SECONDS).flatMap(m -> Observable.just(3, 4, 5));

        //Observable<Observable<Data3>> obsData = obs.map(number -> Observable.just(new Data3(number)));


       /* obs.subscribe(s-> System.out.println(s));

        te.subscribe(System.out::println);


        Observable.just("Lorem", "ipsum", "dolor", "sit", "amet",
                "consectetur", "adipiscing", "elit").delay(word -> Observable.timer(word.length(), SECONDS)).subscribe(System.out::println);*/


        Observable<Integer> integerObservable = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Observable<String> stringObservable = Observable.just("a", "b", "c", "d", "e", "f", "g", "h").delay(2, SECONDS);


        //integerObservable.zipWith(stringObservable, (m, s)-> s+m).doOnDispose(()->System.out.println("Отписка")).subscribe(System.out::println);
        // Observable.zip(stringObservable.filter(s->s.equals("e")), integerObservable, (m, s)-> s+m).subscribe(System.out::println);


        /*Observable<LocalDate> nextTenDays =
                Observable
                        .range(1, 10)
                        .map(d -> LocalDate.now().plusDays(d));


        Observable<City> cityObservable = Observable.just(City.Warsaw, City.London, City.Paris);

        cityObservable.flatMap(city -> nextTenDays.map(day -> new Vacation(city, day)))
                .flatMap(vacation ->
                        Observable.zip(
                                vacation.weather().filter(w->w==1)
                                , vacation.flight()
                                , vacation.hotel()
                                , (w, f, h) -> w + h + f)).subscribe(System.out::println);*/

        /*Observable
                .range(2, 100)
                .scan(BigInteger.ONE, (big, cur) ->
                        big.multiply(BigInteger.valueOf(cur))).subscribe(System.out::println);


        BigDecimal b = new BigDecimal(1);*/

      /*  BiFunction<Data3, Data3, Integer> reducer = new BiFunction<Data3, Data3, Integer>() {


            @Override
            public Integer apply(Data3 data3, Data3 data32) throws Exception {
                return 5;
            }
        };*/

/*
        Observable
                .just(new Data3(1))
                .reduce(new Data3(2), (a, b)->a.lom(b)).subscribe(System.out::println);


        Observable
                .just(new Data3(1))
                .map(Data3::getV).subscribe(System.out::println);*/

        /*Observable
                .just(new BigDecimal(5))
                .reduce(BigDecimal.ZERO, Data3::addPlus);*/
     /*List<Integer> ile =   new ArrayList<>();

     ile.add(1);
        ile.add(2);
        ile.add(3);


        Single<List<Integer>> li = Observable
                . range(10, 20)
                .reduce(ile, (list, item) -> {
                    list.add(item);
                    return list;
                });

        li.subscribe(Data3::readArr);

      */

        /*Observable<Long> ol = Observable
                .rangeLong(0L, 1000000000L)
                .map(x->x).scan((x,y)->y+2);

        ol.subscribe(Main::store);*/

        Observable<Integer> randomlnts = Observable.create(subscriber -> {
            Random random = new Random();
            while (!subscriber.isDisposed()) {
                subscriber.onNext(random.nextInt(1000));
            }
        }) ;



        //sleep(15);
    }

    private  static  void  readArr(ArrayList<Integer> arr){

        arr.forEach(System.out::println);

    }

   static void store(Long id) {
       System.out.println(id);
    }


    static Observable<Long> upload(Integer id) {

        return Observable.just(id * 1245L);
    }


    Observable<Data3> rate(Integer id) {

        return Observable.just(new Data3(id * 100));
    }


    Observable<Sound> toMorseCode(char ch) {

        switch (ch) {
            case 'a':
                return Observable.just(DI);
        }


        return Observable.empty();
    }


}
