package alibaba_rules;

import java.math.BigDecimal;

public class BigDecimalRules {
    public static void main(String[] args){
        // BigDecimal(double)构造函数存在丢失精度的风险
        BigDecimal bd1 = new BigDecimal(0.1f); // 实际存储值为0.10000000149

        // 应该使用BigDecimal(String) 或 BigDecimal.valueOf(double)
        BigDecimal bd2 = new BigDecimal("0.1");
        BigDecimal bd3 = BigDecimal.valueOf(0.1);

        System.out.println(bd1.equals(bd2)); // false，本来应该是相等的，但是bd1精度有损失
        System.out.println(bd2.equals(bd3));
    }
}
