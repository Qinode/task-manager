package zheng.sw19.core;

import org.junit.Assert;
import org.junit.Test;
import zheng.sw19.core.util.RangeUtil;

import java.util.List;

public class TestRangeDifference {
    /**
     * Range 1 |_____|
     * Range 2       |____|
     */
    @Test
    public void testRangeDifference1() {
        int[] range1 = new int[]{0, 1};
        int[] range2 = new int[]{1, 10};

        List<int[]> result = RangeUtil.rangeDifference(range1, range2);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(1, result.get(0)[0]);
        Assert.assertEquals(10, result.get(0)[1]);
    }

    /**
     * Range 1 |_____|
     * Range 2        |____|
     */
    @Test
    public void testRangeDifference2() {
        int[] range1 = new int[]{0, 1};
        int[] range2 = new int[]{2, 10};

        List<int[]> result = RangeUtil.rangeDifference(range1, range2);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(2, result.get(0)[0]);
        Assert.assertEquals(10, result.get(0)[1]);
    }

     /**
     * Range 1      |_____|
     * Range 2 |____|
     */
    @Test
    public void testRangeDifference3() {
        int[] range1 = new int[]{1, 10};
        int[] range2 = new int[]{0, 1};

        List<int[]> result = RangeUtil.rangeDifference(range1, range2);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(0, result.get(0)[0]);
        Assert.assertEquals(1, result.get(0)[1]);
    }

    /**
     * Range 1       |_____|
     * Range 2 |____|
     */
    @Test
    public void testRangeDifference4() {
        int[] range1 = new int[]{2, 10};
        int[] range2 = new int[]{0, 1};

        List<int[]> result = RangeUtil.rangeDifference(range1, range2);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(0, result.get(0)[0]);
        Assert.assertEquals(1, result.get(0)[1]);
    }

    /**
     * Range 1 |_____|
     * Range 2 |_____|
     */
    @Test
    public void testRangeDifference5() {
        int[] range1 = new int[]{2, 10};
        int[] range2 = new int[]{2, 10};

        List<int[]> result = RangeUtil.rangeDifference(range1, range2);
        Assert.assertEquals(0, result.size());
    }


    /**
     * Range 1    |_____|
     * Range 2 |___________|
     */
    @Test
    public void testRangeDifference6() {
        int[] range1 = new int[]{2, 10};
        int[] range2 = new int[]{0, 19};

        List<int[]> result = RangeUtil.rangeDifference(range1, range2);
        Assert.assertEquals(2, result.size());
        Assert.assertEquals(0, result.get(0)[0]);
        Assert.assertEquals(2, result.get(0)[1]);
        Assert.assertEquals(10, result.get(1)[0]);
        Assert.assertEquals(19, result.get(1)[1]);
    }

    /**
     * Range 1 |_____|
     * Range 2    |___________|
     */
    @Test
    public void testRangeDifference7() {
        int[] range1 = new int[]{2, 10};
        int[] range2 = new int[]{4, 19};

        List<int[]> result = RangeUtil.rangeDifference(range1, range2);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(10, result.get(0)[0]);
        Assert.assertEquals(19, result.get(0)[1]);
    }

    /**
     * Range 1          |_____|
     * Range 2 |___________|
     */
    @Test
    public void testRangeDifference8() {
        int[] range1 = new int[]{12, 30};
        int[] range2 = new int[]{4, 19};

        List<int[]> result = RangeUtil.rangeDifference(range1, range2);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(4, result.get(0)[0]);
        Assert.assertEquals(12, result.get(0)[1]);
    }

     /**
     * Range 1          |_____|
     * Range 2 |______________|
     */
    @Test
    public void testRangeDifference9() {
        int[] range1 = new int[]{12, 30};
        int[] range2 = new int[]{4, 30};

        List<int[]> result = RangeUtil.rangeDifference(range1, range2);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(4, result.get(0)[0]);
        Assert.assertEquals(12, result.get(0)[1]);
    }

     /**
     * Range 1 |_____|
     * Range 2    |___________|
     */
    @Test
    public void testRangeDifference10() {
        int[] range1 = new int[]{2, 10};
        int[] range2 = new int[]{2, 19};

        List<int[]> result = RangeUtil.rangeDifference(range1, range2);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(10, result.get(0)[0]);
        Assert.assertEquals(19, result.get(0)[1]);
    }
}
