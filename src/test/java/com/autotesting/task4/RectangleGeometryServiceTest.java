package com.autotesting.task4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("RectangleGeometryService Unit Tests")
public class RectangleGeometryServiceTest {

    private RectangleGeometryService service;

    @BeforeEach
    void setUp() {
        service = new RectangleGeometryService();
    }

    // TC-01: Inside 

    @Nested
    @DisplayName("Interior Region (TC-01)")
    class InteriorTests {

        @Test
        @DisplayName("TC-01: Origin (0, 0) should be INSIDE")
        void shouldClassifyOriginAsInside() {
            assertThat(service.determinePosition(new Point(0, 0)))
                    .isEqualTo(RectanglePosition.INSIDE);
        }
    }

    // TC-02 to TC-05: Corners 

    @Nested
    @DisplayName("Corner Vertices (TC-02 to TC-05)")
    class CornerTests {

        @ParameterizedTest(name = "{2}: Point ({0}, {1}) should be CORNER")
        @CsvSource({
                " 3,  4, TC-02: Top-Right",
                "-3,  4, TC-03: Top-Left",
                " 3, -4, TC-04: Bottom-Right",
                "-3, -4, TC-05: Bottom-Left"
        })
        void shouldClassifyCorners(int x, int y, String label) {
            assertThat(service.determinePosition(new Point(x, y)))
                    .isEqualTo(RectanglePosition.CORNER);
        }
    }

    // TC-06 to TC-08: Horizontal Borders 

    @Nested
    @DisplayName("Horizontal Borders (TC-06 to TC-08)")
    class HorizontalBorderTests {

        @ParameterizedTest(name = "{2}: Point ({0}, {1}) should be HORIZONTAL_BORDER")
        @CsvSource({
                "0,  4, TC-06: Top border center",
                "0, -4, TC-07: Bottom border center",
                "2,  4, TC-08: Top border near corner"
        })
        void shouldClassifyHorizontalBorders(int x, int y, String label) {
            assertThat(service.determinePosition(new Point(x, y)))
                    .isEqualTo(RectanglePosition.HORIZONTAL_BORDER);
        }
    }

    // TC-09 to TC-11: Vertical Borders 

    @Nested
    @DisplayName("Vertical Borders (TC-09 to TC-11)")
    class VerticalBorderTests {

        @ParameterizedTest(name = "{2}: Point ({0}, {1}) should be VERTICAL_BORDER")
        @CsvSource({
                " 3, 0, TC-09: Right border center",
                "-3, 0, TC-10: Left border center",
                " 3, 3, TC-11: Right border near corner"
        })
        void shouldClassifyVerticalBorders(int x, int y, String label) {
            assertThat(service.determinePosition(new Point(x, y)))
                    .isEqualTo(RectanglePosition.VERTICAL_BORDER);
        }
    }

    // TC-12 to TC-16: Exterior Regions 

    @Nested
    @DisplayName("Exterior Regions (TC-12 to TC-16)")
    class ExteriorTests {

        @ParameterizedTest(name = "{2}: Point ({0}, {1}) should be OUTSIDE")
        @CsvSource({
                " 4,  0, TC-12: Beyond right vertical",
                "-4,  0, TC-13: Beyond left vertical",
                " 0,  5, TC-14: Above top horizontal",
                " 0, -5, TC-15: Below bottom horizontal",
                " 4,  5, TC-16: Diagonal exterior quadrant"
        })
        void shouldClassifyOutsidePoints(int x, int y, String label) {
            assertThat(service.determinePosition(new Point(x, y)))
                    .isEqualTo(RectanglePosition.OUTSIDE);
        }
    }

    // TC-17 to TC-18: Robustness / Extreme Boundaries 

    @Nested
    @DisplayName("Robustness / Extreme Boundaries (TC-17 to TC-18)")
    class RobustnessTests {

        @ParameterizedTest(name = "{2}: Point ({0}, {1}) should be OUTSIDE")
        @CsvSource({
                "-2147483648, 0, TC-17: Integer.MIN_VALUE for x",
                " 2147483647, 0, TC-18: Integer.MAX_VALUE for x"
        })
        void shouldHandleExtremeCoordinatesWithoutOverflow(int x, int y, String label) {
            assertThat(service.determinePosition(new Point(x, y)))
                    .isEqualTo(RectanglePosition.OUTSIDE);
        }
    }

    // TC-19: Invalid Input 

    @Nested
    @DisplayName("Defensive Handling (TC-19)")
    class DefensiveTests {

        @Test
        @DisplayName("TC-19: determinePosition should throw IllegalArgumentException when point is null")
        void shouldThrowExceptionForNullPoint() {
            assertThatThrownBy(() -> service.determinePosition(null))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Point cannot be null");
        }
    }
}
