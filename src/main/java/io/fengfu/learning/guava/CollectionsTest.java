package io.fengfu.learning.guava;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

/**
 * Created by fengfu on 2016/12/20.
 */
public class CollectionsTest {
    private static Logger logger = LoggerFactory.getLogger(CollectionsTest.class);

    public void test() {
        ImmutableSet<String> set = ImmutableSet.of("1", "2");
    }

    @Test
    public void testUnion() {
        Set<String> s1 = Sets.newHashSet("1", "2", "3");
        Set<String> s2 = Sets.newHashSet("3", "2", "4");
        Sets.SetView<String> sv = Sets.union(s1, s2);
        assertThat(sv.size() == 4 &&
                sv.contains("2") &&
                sv.contains("3") &&
                sv.contains("4") &&
                sv.contains("1"), is(true));
    }

    @Test
    public void testIntersection() {
        Set<String> s1 = Sets.newHashSet("1", "2", "3");
        Set<String> s2 = Sets.newHashSet("3", "2", "4");
        Sets.SetView<String> sv = Sets.intersection(s1, s2);
        assertThat(sv.size() == 2 && sv.contains("2") &&
                sv.contains("3"), is(true));
    }

    @Test
    public void testUnmodifiableSet(){
        Set<String> set = new HashSet<String>(Arrays.asList(new String[]{"RED", "GREEN"}));
        Set<String> unmodifiableSet = Collections.unmodifiableSet(set);

        logger.info("Set:", unmodifiableSet);

        set.add("YELLOW");

        logger.info("Set:", unmodifiableSet);
    }

    @Test
    public void testFilter () {
        List<String> strings = Lists.newArrayList(
                null, "www", null,
                "leveluplunch", "com", null);

        Collection<String> filterStrings = Collections2.filter(
                strings, new Predicate<String>() {
                    public boolean apply(String input) {
                        return input != null && input.length() >= 3;
                    }
                });

        logger.info("{}",filterStrings);

        assertEquals(3, filterStrings.size());

        strings.add("fengfu");

        logger.info("{}",filterStrings);
    }
}
