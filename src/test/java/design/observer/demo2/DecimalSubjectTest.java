package design.observer.demo2;

import org.junit.jupiter.api.Test;

import java.util.Observer;

import static org.junit.jupiter.api.Assertions.*;

class DecimalSubjectTest {

    @Test
    void setValue() {
        DecimalSubject decimalSubject = new DecimalSubject();
        new BinaryObserver(decimalSubject);
        new OctalObserver(decimalSubject);
        new HexObserver(decimalSubject);
        decimalSubject.setValue(1);
        decimalSubject.setValue(10);
    }
}