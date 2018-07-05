package com.udian.conf.job.entity;

/**
 * Created by Administrator on 2018/5/29.
 */

public enum ScheduleStatus {
    /**
     * 正常
     */
    NORMAL(0),
    /**
     * 暂停
     */
    PAUSE(1);

    private int value;

    ScheduleStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

