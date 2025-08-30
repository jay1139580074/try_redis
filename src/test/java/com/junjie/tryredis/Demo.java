package com.junjie.tryredis;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Vector;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Demo {

    @Test
    void testHash() {
        log.info(String.valueOf("aA".hashCode()));
        log.info(String.valueOf("AA".hashCode()));
        log.info(String.valueOf("Aa".hashCode()));
        log.info(String.valueOf("BB".hashCode()));
    }

    @Test
    void testInteger(){
        // ==  will compare the value and the sapce in the hip, equals will compare value only
        //cache values in the range -128 to 127, thus value large than that, will new from hipe
        Integer in = Integer.valueOf(10);
        var bb = Integer.valueOf(10);
        int cc = 10;

        log.info(String.valueOf(in == bb));
        log.info(String.valueOf(in.equals(bb)));
        log.info(String.valueOf(in == cc));

        log.info("------------------------");

        var aaa = Integer.valueOf(999);
        var bbb = Integer.valueOf(999);
        int ccc = 999;
        log.info(String.valueOf(aaa == bbb));
        log.info(String.valueOf(aaa.equals(bbb)));
        log.info(String.valueOf(aaa == ccc));
    }

    @Test
    void bigDecimal(){
        var v1 = new BigDecimal("1.01");
        var v2 = new BigDecimal("1.010");

        log.info(String.valueOf(v1.compareTo(v2)));
        log.info(String.valueOf(v1.equals(v2)));

        "".equals("");
        Object obj = new Object();
        obj.equals(2);

        StringBuffer sb = new StringBuffer("1");
        sb.append("2");

        StringBuilder ss = new StringBuilder("2");
        ss.append("2");


        CompletableFuture.runAsync(() -> {
            Vector.of(List.of());
        });
    }

    @Test
    void future(){

    }

}
