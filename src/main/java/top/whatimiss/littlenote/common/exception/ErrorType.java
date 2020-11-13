package top.whatimiss.littlenote.common.exception;


/**
 * @author wcj
 * @create 2020/11/10 下午3:58
 * @description
 */
public interface ErrorType {
    /**
     * 返回code
     *
     * @return
     */
    String getCode();

    /**
     * 返回mesg
     *
     * @return
     */
    String getMesg();
}
