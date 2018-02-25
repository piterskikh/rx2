package exp;

public class Parent {

    public Childe giveBirth(){

        return  new Childe(this);
    }
}
