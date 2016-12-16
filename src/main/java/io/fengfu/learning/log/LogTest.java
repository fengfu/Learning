package io.fengfu.learning.log;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fengfu.qu on 2015/12/10.
 */
public class LogTest {
    private static Logger logger = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
        User user = new User();
        user.setName("Fengfu.Qu");
        user.setAge(36);
        user.setSex("M");

        logger.info("{}", JSON.toJSONString(user));
    }
}


