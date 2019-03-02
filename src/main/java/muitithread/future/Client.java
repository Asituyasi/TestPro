package muitithread.future;

/**
 * desc :
 * Created by tiantian on 2018/11/3
 */
public class Client {

    public Data request(final String queryStr) {
        final FutureData future = new FutureData();
        new Thread(()-> {
            RealData realData = new RealData(queryStr);
            future.setRealData(realData);
        }).start();
        
        return future;
    }

    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        Data data = client.request("name");
        System.out.println("请求完毕");
        
        // sleep代替其他业务逻辑处理过程
        Thread.sleep(2000);

        // 获取真实数据
        System.out.println("数据：" + data.getResult());
    }
}
