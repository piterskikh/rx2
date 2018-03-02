package exp;

import io.reactivex.Observable;

import java.time.LocalDate;

public class Vacation {

    private final City where;
    private final LocalDate when;

    public Vacation(City where, LocalDate when) {
        this.where = where;
        this.when = when;
    }



    public Observable<Integer> weather(){

        if(where.equals(City.London)) return Observable.just(1);
        return  Observable.just(0);
        }

    public Observable<Integer> flight(){

        if(where.equals(City.Warsaw)) return Observable.just(1);
        if(where.equals(City.London)) return Observable.just(2);
        if(where.equals(City.Paris)) return Observable.just(3);
        return  Observable.just(0);

}

    public Observable<String> hotel(){

        if(where.equals(City.Warsaw)) return Observable.just("Warsaw");
        if(where.equals(City.London)) return Observable.just("London");
        if(where.equals(City.Paris)) return Observable.just("Paris");
        return  Observable.just("None");
    }

}
