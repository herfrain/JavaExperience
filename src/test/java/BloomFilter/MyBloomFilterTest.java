package BloomFilter;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class MyBloomFilterTest {

    @Test
    void add() {
        MyBloomFilter filter = new MyBloomFilter();
        long n = (long) 1e+8;
        long m = 0L;
        for(long i = 0L; i < n; i++){
            long time = Calendar.getInstance().getTimeInMillis();
            System.out.println(time);
            if(!filter.contains(time)){
                m++;
                filter.add(time);
            }
        }
        System.out.println(m + "/" + n + "=" + (double) m / n);
    }
}