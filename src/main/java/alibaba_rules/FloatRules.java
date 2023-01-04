package alibaba_rules;

import java.math.BigDecimal;

public class FloatRules {
    public static void main(String[] args){
        // 浮点数的判断不能使用==，包装类也不能使用equals
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        System.out.println(a == b); // false

        Float A = Float.valueOf(a);
        Float B = Float.valueOf(b);
        System.out.println(A.equals(B));

        // 1. 指定误差范围，两者之差在范围内，则判定它们相等
        float diff = 1e-6f;
        System.out.println(Math.abs(a - b) <= diff);

        // 2. 使用BigDecimal作精确运算
        BigDecimal BD1 = new BigDecimal("1.0");
        BigDecimal BD2 = new BigDecimal("0.9");
        BigDecimal BD3 = new BigDecimal("0.8");
        BigDecimal x = BD1.subtract(BD2);
        BigDecimal y = BD2.subtract(BD3);
        System.out.println(x.equals(y));
    }
}
