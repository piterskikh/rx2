package exp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Data3 {

    private static BigDecimal addPlusplus(BigDecimal a, BigDecimal b){

        return new BigDecimal(3);
    }


    public static void  readArr(List<Integer> arr){

        arr.forEach(System.out::println);

    }

    private int v = 5;


    public Data3(int v) {
        this.v = v;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public BigDecimal addPlus(BigDecimal a, BigDecimal b){

     return addPlusplus(a, b);

    }

    public Data3 lom (Data3 data){

        return this;
    }
}
