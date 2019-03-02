package effactive.chapter4;

import java.util.Date;

/**
 * desc : 继承的不恰当使用
 * Created by tiantian on 2018/11/23
 */
public class BadExtenddDemo {
    public static void main(String[] args) {
        Sub sub = new Sub();
    }
}

class Super {
    public Super() {
        overideMe();
    }

    public void overideMe() {
        System.out.println("overideMe()");
    }
}

class Sub extends Super {
    final Date date;

    public Sub() {
        this.date = new Date();
    }

    @Override
    public void overideMe() {
        System.out.println(date);
    }
}
