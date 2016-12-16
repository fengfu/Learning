package io.fengfu.learning.string;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fengfu.qu on 2015/12/25.
 */
public class SplitTest {
    private static final Logger logger = LoggerFactory.getLogger(SplitTest.class);

    @Test
    public void test() {
        String demo = "MU370/MU371/MU370/MU371/MU370/MU371/MU370/MU371";
        String[] test1 = demo.split("\\/");
        String[] test2 = StringUtils.split(demo, "\\/");

        for (String ele : test2){
            System.out.println(ele);
        }
    }
}
