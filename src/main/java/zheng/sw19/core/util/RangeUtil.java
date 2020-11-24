package zheng.sw19.core.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class RangeUtil {

    /**
     * @param range1, a range, left inclusive and right exclusive
     * @param range2, a range, left inclusive and right exclusive
     * @return ranges in range2 but not in range1
     */
    public static List<int[]> rangeDifference(int[] range1, int[] range2) {
        if (range1.length < 2) throw new IllegalArgumentException("range1 size: " + range1.length);
        if (range2.length < 2) throw new IllegalArgumentException("range2 size: " + range2.length);
        if (range1[1] <= range1[0])
            throw new IllegalArgumentException("range1 right value less and equal to left value");
        if (range2[1] <= range2[0])
            throw new IllegalArgumentException("range2 right value less and equal to left value");

        List<int[]> result = new ArrayList<>(2);

        if (range1[1] <= range2[0] || range1[0] >= range2[1]) {
            result.add(range2);
        } else {
            if (range1[0] > range2[0]) result.add(new int[]{range2[0], range1[0]});
            if (range2[1] > range1[1]) result.add(new int[]{range1[1], range2[1]});
        }

        result = result.stream().sorted(Comparator.comparingInt(el -> el[0])).collect(Collectors.toList());
        if (result.size() > 2)
            throw new RuntimeException(String.format("range1: [%s, %s] range2: [%s, %s]", range1[0], range1[1], range2[0], range2[1]));
        return result;
    }


    /**
     * @param ranges,  any two range R1 in ranges and R1 != R2 satisfy R1 \intersect R2 = \emptyset
     * @param universe
     * @return list of ranges such that any range in the list is the subset of universe and intersection any of range in the
     * result gives empty set.
     */
    public static List<int[]> allRangeDifference(List<int[]> ranges, int[] universe) {
        ranges = ranges.stream().sorted(Comparator.comparingInt(el -> el[0])).collect(Collectors.toList());
        Stack<int[]> result = new Stack<>();
        result.push(universe);

        for (int[] range : ranges) {
            List<int[]> differences = rangeDifference(range, result.pop());
            if (differences.size() == 0) {
                break;
            } else {
                differences.forEach(result::push);
            }
        }

        return result;
    }

    /**
     * Divide a range with a fixed size n, so that each divided sub-range is small or equal to n
     *
     * The result set has the following property
     *  1. Any r1, r2 in the result and r1 != r2, such that r1 \intersect r2 = \emptyset.
     *  2. Union of all element in the result equal to <code>range</code>
     *  3. Any r in the result set has size small or equal to size.
     *
     * @param range
     * @param size
     * @return
     *

     */
    public static List<int[]> divideRange(int[] range, int size){
        if( size <= 0) throw new IllegalArgumentException("size should be a positive integer, input value: " + size);
        if( range[0] == range[1] ) return new ArrayList<int[]>();

        int start = range[0];
        int end = range[1];
        List<int[]> result = new ArrayList<int[]>((int)((end - start)/size) + 1);

        while( start + size < end ){
            result.add(new int[]{start, start + size});
            start += size;
        }
        result.add(new int[]{start, end});

        return result;
    }
}
