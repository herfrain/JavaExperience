package java8_newFeatures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterfaceImplDemo1Test {

    @Test
    void fun1() {
        InterfaceDemo1 interfaceDemo1 = new InterfaceImplDemo1();
        interfaceDemo1.fun1();
        interfaceDemo1.dFun1();
        interfaceDemo1.dFun2();
    }
}