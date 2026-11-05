package com.autotesting.task4;

public enum RectanglePosition {
    INSIDE("Point is inside the rectangle"),
    OUTSIDE("Point is outside the rectangle"),
    HORIZONTAL_BORDER("Point is on the horizontal border"),
    VERTICAL_BORDER("Point is on the vertical border"),
    CORNER("Point is at a rectangle corner");

    private final String description;

    RectanglePosition(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
