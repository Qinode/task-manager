package zheng.sw19.core;

import org.junit.Assert;
import org.junit.Test;
import zheng.sw19.core.util.RangeUtil;

import java.util.List;

public class TestDivideRange {

    /**
     * Empty Range
     */
    @Test
    public void case1() {
        int[] range = new int[]{1, 1};
        List<int[]> r = RangeUtil.divideRange(range, 1);
        Assert.assertEquals(0, r.size());
    }

    /**
     * Non-empty range, step size 1
     */
    @Test
    public void case2() {
        int[] range = new int[]{0, 7};
        int size = 1;
        List<int[]> r = RangeUtil.divideRange(range, size);
        Assert.assertEquals(r.size(), 7);
        Assert.assertEquals(r.get(0)[0], range[0]);
        Assert.assertEquals(r.get(r.size() - 1)[1], range[1]);
        for(int i = 0; i < range[1] - range[0]; i++){
            Assert.assertEquals(r.get(i)[0], r.get(i)[1] - size);
        }
    }

    /**
     * Even range, step size 2
     */
    @Test
    public void case3() {
        int[] range = new int[]{0, 8};
        int size = 2;
        List<int[]> r = RangeUtil.divideRange(range, size);
        Assert.assertEquals(r.size(), 4);
        Assert.assertEquals(r.get(0)[0], range[0]);
        Assert.assertEquals(r.get(r.size() - 1)[1], range[1]);
        for(int i = 0; i < (range[1] - range[0])/size; i++){
            Assert.assertEquals(r.get(i)[0], r.get(i)[1] - size);
        }
    }

    /**
     * Odd range, step size 2
     */
    @Test
    public void case4() {
        int[] range = new int[]{0, 7};
        int size = 2;
        List<int[]> r = RangeUtil.divideRange(range, size);
        Assert.assertEquals(r.size(), 4);
        Assert.assertEquals(r.get(0)[0], range[0]);
        Assert.assertEquals(r.get(r.size() - 1)[1], range[1]);
        for(int i = 0; i < (range[1] - range[0])/size; i++){
            Assert.assertEquals(r.get(i)[0], r.get(i)[1] - size);
        }
    }
}


