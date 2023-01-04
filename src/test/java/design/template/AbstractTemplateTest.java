package design.template;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractTemplateTest {

    @Test
    void templateMethod() {
        AbstractTemplate template1 = new ConcreteTemplate1();
        AbstractTemplate template2 = new ConcreteTemplate2();
        template1.templateMethod();
        template2.templateMethod();
    }
}