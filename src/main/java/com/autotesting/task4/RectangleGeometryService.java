package com.autotesting.task4;

public class RectangleGeometryService {

    public static final int X_BOUND = 3;
    public static final int Y_BOUND = 4;

    public RectanglePosition determinePosition(Point point) {
        if (point == null) {
            throw new IllegalArgumentException("Point cannot be null");
        }

        int x = point.getX();
        int y = point.getY();

        if (x > X_BOUND || x < -X_BOUND || y > Y_BOUND || y < -Y_BOUND) {
            return RectanglePosition.OUTSIDE;
        }

        boolean onVerticalBound = (x == X_BOUND || x == -X_BOUND);
        boolean onHorizontalBound = (y == Y_BOUND || y == -Y_BOUND);

        if (onVerticalBound && onHorizontalBound) {
            return RectanglePosition.CORNER;
        }

        if (onVerticalBound) {
            return RectanglePosition.VERTICAL_BORDER;
        }

        if (onHorizontalBound) {
            return RectanglePosition.HORIZONTAL_BORDER;
        }

        return RectanglePosition.INSIDE;
    }
}
