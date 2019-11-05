package solutions;

import domain.Interval;

import java.util.*;

/**
 * @Author: Zuo Yichen
 * @Date: 2019/1/4 16:17
 */
public class MergeIntervals {

    // myself solution, beats 60%
//    public List<Interval> merge(List<Interval> intervals) {
//        if (intervals == null || intervals.size() == 0) {
//            return new ArrayList<>();
//        }
//        List<Interval> res = new LinkedList<>();
//        // sort by start
//        intervals.sort(new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                if(o1.start > o2.start) {
//                    return 1;
//                }
//                if(o1.start < o2.start) {
//                    return -1;
//                }
//                return 0;
//            }
//        });
//        res.add(intervals.get(0));
//        // check if current and previous interval have overlapped part.
//        for (int i = 1; i < intervals.size(); i++) {
//            Interval interval = intervals.get(i);
//            Interval preInterval = res.get(res.size() - 1);
//            if (interval.start > preInterval.end) {
//                res.add(interval);
//            } else {
//                preInterval.end = Math.max(interval.end, preInterval.end);
//            }
//        }
//        return res;
//    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new LinkedList<>();
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        for (int i = 0, j = 0; i < intervals.size(); j++) {
            while (j + 1 < intervals.size() && start[j + 1] <= end[j]) {
                j++;
            }
            res.add(new Interval(start[i], end[j]));
            i = j + 1;
        }
        return res;
    }
}
