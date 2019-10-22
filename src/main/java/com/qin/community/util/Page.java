package com.qin.community.util;

/**
 * @program: community
 * @description: 分页
 * @author: qin
 * @create: 2019-10-07 20:46
 **/

public class Page {
    int start;
    int count;
    int total;

    public Page(int start, int count) {
        super();
        this.start = start;
        this.count = count;
    }
    public boolean isHasPreviouse(){
        return start!=0;
    }
    public boolean isHasNext(){
        return start != getLast();
    }
    public int getTotalPage(){
        int totalPage;
        // 假设总数是50，是能够被5整除的，那么就有10页
        if (0 == total % count) {
            totalPage = total /count;
        }
            // 假设总数是51，不能够被5整除的，那么就有11页
        else {
            totalPage = total / count + 1;
        }

        if(0==totalPage) {
            totalPage = 1;
        }
        return totalPage;

    }
    private int getLast() {
        int last;
        if (0==total%count){
            last=total-count;
        }else {
            last=total-total%count;
        }
        last=last<0?0:last;
        return last;
    }
}
