package com.pwc;

public interface Constants {
    /**
     * THRESHOLDS
     */
    public static final double FREEZING_THRESHOLDS = 0;
    public static final double BOILING_THRESHOLDS = 100;
    public static final double FLUCTUATION_THRESHOLDS = 0.5;
    public static final double UNFREEZING_THRESHOLDS = FREEZING_THRESHOLDS + FLUCTUATION_THRESHOLDS;
    public static final double UNBOILING_THRESHOLDS = BOILING_THRESHOLDS - FLUCTUATION_THRESHOLDS;

    /**
     * Status
     */
    public static final String FREEZING = "freezing";
    public static final String BOILING = "boiling";
    public static final String UNFREEZING = "unfreezing";
    public static final String UNBOILING = "unboiling";
}
