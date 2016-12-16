package io.fengfu.learning.string;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fengfu.qu on 2015/12/25.
 */
public class SplitDemo {
    private static final Logger logger = LoggerFactory.getLogger(SplitDemo.class);

    public static void main(String[] args) {
        String demo = "MU370/MU371";
        String[] test1 = demo.split("\\/");
        String[] test2 = StringUtils.split(demo, "\\/");


    }
}
