package muitithread;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * desc :
 * Created by tiantian on 2018/10/30
 */
public class AtomicReferenceTest {
    static AtomicStampedReference<Integer> money = new AtomicStampedReference(19, 0);

    public static void main(String[] args) {
        // 模拟多个线程为用户充值
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                int stamp = money.getStamp(); 
                while (true) {
                    while (true) {
                        Integer m = money.getReference();
                        if (m < 20) {
                            if (money.compareAndSet(m, m+20, stamp, stamp+1)){
                                System.out.println("余额小于20元，充值成功， 余额：" + money.getReference() +"元");
                            }
                            try {
                                Thread.sleep(400);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                        } else {
                            //System.out.println("余额大于20元，无须充值");
                            break;
                        }
                    }
                }
            }).start();
        }
        
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                while (true) {
                    Integer m = money.getReference();
                    final int stamp = money.getStamp();
                    if (m > 10) {
                        System.out.println("余额大于10元");
                        if (money.compareAndSet(m, m-10, stamp, stamp+1)) {
                            System.out.println("成功消费10元： 余额：" + money.getReference());
                        }
                        break;
                    } else {
                        System.out.println("没有足够的金额啦");
                        break;
                    }
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
