package muitithread.future;

/**
 * desc :
 * Created by tiantian on 2018/11/3
 */
public class RealData implements Data {
    protected final String result;

    public RealData(String result) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(result);
        }
        
        this.result = sb.toString();
    }

    @Override
    public String getResult() {
        return result;
    }
}
