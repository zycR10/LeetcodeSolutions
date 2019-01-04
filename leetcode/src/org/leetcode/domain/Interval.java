package org.leetcode.domain;

/**
 * @Author: Zuo Yichen
 * @Date: 2019/1/4 16:17
 */
public class Interval {
    public int start;
    public int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
