package zheng.sw19.core;

import org.junit.Assert;
import org.junit.Test;
import zheng.sw19.core.util.RangeUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestAllRangesDifference {

    @Test
    public void testAllRangesDifference1 () {
        int[] universe = new int[]{0, 10};
        List<int[]> ranges = Arrays.asList(new int[]{0, 10});

        List<int[]> result = RangeUtil.allRangeDifference(ranges, universe);
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testAllRangesDifference2 () {
        int[] universe = new int[]{0, 5};
        List<int[]> ranges = Arrays.asList(
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{3, 4},
                new int[]{4, 5}
                );

        List<int[]> result = RangeUtil.allRangeDifference(ranges, universe);
        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testAllRangesDifference3 () {
        int[] universe = new int[]{0, 6};
        List<int[]> ranges = Arrays.asList(
                new int[]{0, 1},
                new int[]{2, 3},
                new int[]{5, 6}
                );

        List<int[]> result = RangeUtil.allRangeDifference(ranges, universe);
        Assert.assertEquals(2, result.size());
    }

    @Test
    public void testAllRangesDifference4 () {
        int[] universe = new int[]{0, 10};
        List<int[]> ranges = Arrays.asList(
                new int[]{5, 6},
                new int[]{7, 8},
                new int[]{9, 10}
                );

        List<int[]> result = RangeUtil.allRangeDifference(ranges, universe);
        Assert.assertEquals(3, result.size());
    }


    @Test
    public void testAllRangesDifference5 () {
        int[] universe = new int[]{0, 10};
        List<int[]> ranges = Arrays.asList(
                new int[]{0, 3},
                new int[]{5, 8},
                new int[]{8, 9}
                );

        List<int[]> result = RangeUtil.allRangeDifference(ranges, universe);
        Assert.assertEquals(2, result.size());
    }

    @Test
    public void testAllRangesDifference6 () {
        int[] universe = new int[]{0, 10};
        List<int[]> ranges = Arrays.asList(
                new int[]{-1, 3},
                new int[]{5, 6},
                new int[]{7, 8},
                new int[]{9, 11}
                );

        List<int[]> result = RangeUtil.allRangeDifference(ranges, universe);
        Assert.assertEquals(3, result.size());
    }


    @Test
    public void testAllRangesDifference7 () {
        int[] universe = new int[]{0, 10};
        List<int[]> ranges = Collections.emptyList();

        List<int[]> result = RangeUtil.allRangeDifference(ranges, universe);
        Assert.assertEquals(1, result.size());
    }
}
