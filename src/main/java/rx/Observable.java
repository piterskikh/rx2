package rx;

public interface Observable<T> {

    Subscription subscribe(Observer<T> s);

}
