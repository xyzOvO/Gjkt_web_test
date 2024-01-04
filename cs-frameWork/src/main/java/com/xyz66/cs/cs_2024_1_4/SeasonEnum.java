package com.xyz66.cs.cs_2024_1_4;

/**
 * @author Gjkt
 * @description
 * @since 2024/1/4 10:29
 */
public enum SeasonEnum {
    SPRING(1), SUMMER(2), AUTUMN(3), WINTER(4);
    private int value;
    SeasonEnum(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
