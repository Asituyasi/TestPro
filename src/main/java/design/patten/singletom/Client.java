package design.patten.singletom;

import design.patten.bulider.Car;

/**
 * Created by tiantian on 2018/6/29.
 */
public class Client {
    public static void main(String[] args) {
//        HungrySingleTon singleTon = HungrySingleTon.getInstance();
//        LazySingleton singleton2 = LazySingleton.getInstance();
//        ThreadSafeSingleton singleton3 = ThreadSafeSingleton.getInstance();
//        Season.SPRING.doSomething();
//        Season.WINTER.doSomething();
//        System.out.println(Season.AUTUMN.toString());
//        
//        Season season1 = Season.SPRING;
//        Season season2 = Season.SPRING;
//        System.out.println(season1 == season2);
//        
//        Singleton singleton = Singleton.INSTANCE;
//        singleton.doSomething();
//        singleton.setProperty1("hello");
//        singleton.showProperty1();
        
        Singleton singleton = Singleton.INSTANCE;
        new Thread(new Runnable() {
            @Override
            public void run() {
                singleton.setProperty1("hello6");
                singleton.showProperty1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                singleton.setProperty1("hello2");
                singleton.showProperty1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                singleton.setProperty1("hello3");
                singleton.showProperty1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                singleton.setProperty1("hello4");
                singleton.showProperty1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                singleton.setProperty1("hello5");
                singleton.showProperty1();
            }
        }).start();
    }
}

enum Singleton {
    INSTANCE;
    
    private String property1;
    
    private String property2;
    
    public void doSomething() {
        System.out.println("Singleton do something...");
    }
    
    public void setProperty1(String p) {
        this.property1 = p;
    }
    
    public void showProperty1() {
        System.out.println(property1);
    }
}

enum Season {
    SPRING("春", "春分十里"),
    SUMMER("夏", "炎炎烈日"),
    AUTUMN("秋", "秋高气爽"),
    WINTER("冬", "寒风凛冽") {
        @Override
        public void doSomething(){
            System.out.println("冬天过去了，春天还会远吗。");
        }
    };
    
    private String name;
    private String desc;

    Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public void doSomething() {
        System.out.println("do something");
    }
    
    @Override
    public String toString() {
        return "{Season name: " + name + ", Season desc: " + desc + "}";
    }
    
}


