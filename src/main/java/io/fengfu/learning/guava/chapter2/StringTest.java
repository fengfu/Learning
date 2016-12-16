package io.fengfu.learning.guava.chapter2;

import com.google.common.base.Strings;
import org.junit.Test;

/**
 * Created by fengfu.qu on 2016/12/7.
 */
public class StringTest {
    @Test
    public void testPad(){
        String padString = Strings.padEnd("foo",6,'x');
        System.out.println(padString);
    }
}
