package com.xyz66.lombok;

import lombok.NonNull;

public class NonNullTest{
    private final String name;
    public NonNullTest(@NonNull String name) {
        this.name = name;
    }
}
