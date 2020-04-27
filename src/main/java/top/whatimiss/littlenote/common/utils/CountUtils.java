package top.whatimiss.littlenote.common.utils;

import java.math.BigDecimal;

/**
 * @author wcj
 * @create 2020/4/27  上午10:08
 * @description  计算相关的工具类
 */
public class CountUtils {

    public static void main(String[] args) {
        getRateByDecimal(new BigDecimal(35000), new BigDecimal(100000));
    }

    /**
     * 计算两个BigDecimal数值的百分比，不保留小数
     * @param pre
     * @param back
     * @return
     */
    public static String getRateByDecimal(BigDecimal pre, BigDecimal back) {
        return pre.multiply(new BigDecimal(100)).divide(back,2) + "%";
    }

}
