package top.whatimiss.littlenote.kafka.returnresult;

import java.util.Map;

/**
 * @author wcj
 * @create 2020/11/10 下午2:45
 * @description
 */
public class ReturnResult {

    private int resultCode;

    private String resultDecs;

    private Map<String, Object> map;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDecs() {
        return resultDecs;
    }

    public void setResultDecs(String resultDecs) {
        this.resultDecs = resultDecs;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
