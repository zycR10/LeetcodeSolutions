package org.leetcode.solutions;

import org.leetcode.domain.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Zuo Yichen
 * @Date: 2019/1/4 16:17
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return new ArrayList<>();
        }
        List<Interval> res = new LinkedList<>();
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start > o2.start) {
                    return 1;
                }
                if(o1.start < o2.start) {
                    return -1;
                }
                return 0;
            }
        });
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            Interval preInterval = res.get(res.size() - 1);
            if (interval.start > preInterval.end) {
                res.add(interval);
            } else {
                preInterval.end = Math.max(interval.end, preInterval.end);
            }
        }
        return res;
    }
}
