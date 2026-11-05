# Task 4: Unit Tests

---

### Domain Testing Approach:

1. **Boundary On-Points**:
   - Points lying exactly on boundary lines/intersections verify the boundary thresholds.
   - Corners (`x == ±3 && y == ±4`) test vertex intersections (`CORNER`).
   - Horizontal border points (`y == ±4, -3 < x < 3`) test horizontal edges (`HORIZONTAL_BORDER`).
   - Vertical border points (`x == ±3, -4 < y < 4`) test vertical edges (`VERTICAL_BORDER`).
2. **Boundary Off-Points & Partitions**:
   - Immediate 1-off points outside the rectangle (`x = ±4`, `y = ±5`, and diagonal `(4, 5)`) test boundary transitions and verify all 5 exterior sub-domains (`OUTSIDE`).
   - The interior representative `(0, 0)` verifies the central interior partition (`INSIDE`).
3. **Robustness Testing (Extreme Boundaries)**:
   - Evaluates data type limits (`Integer.MIN_VALUE`, `Integer.MAX_VALUE`) to guard against arithmetic overflow (e.g., negative sign bit preservation in two's complement).
4. **Defensive / Invalid Input**:
   - Verifies handling of `null` point references with `IllegalArgumentException`.

---

## Test Cases Specification (19 Test Cases)

| TC-ID     | Category / Domain | Condition / Boundary Tested  | Test Point (x, y)        | Testing Role / Technique    | Expected Result                   |
| :-------- | :---------------- | :--------------------------- | :----------------------- | :-------------------------- | :-------------------------------- |
| **TC-01** | Inside            | Central interior / Origin    | `(0, 0)`                 | EP Interior Point           | `INSIDE`                          |
| **TC-02** | Corner            | Top-Right Corner vertex      | `(3, 4)`                 | BVA On-Point / Vertex       | `CORNER`                          |
| **TC-03** | Corner            | Top-Left Corner vertex       | `(-3, 4)`                | BVA On-Point / Vertex       | `CORNER`                          |
| **TC-04** | Corner            | Bottom-Right Corner vertex   | `(3, -4)`                | BVA On-Point / Vertex       | `CORNER`                          |
| **TC-05** | Corner            | Bottom-Left Corner vertex    | `(-3, -4)`               | BVA On-Point / Vertex       | `CORNER`                          |
| **TC-06** | Horizontal Border | Top border center            | `(0, 4)`                 | BVA On-Point ($y = 4$)      | `HORIZONTAL_BORDER`               |
| **TC-07** | Horizontal Border | Bottom border center         | `(0, -4)`                | BVA On-Point ($y = -4$)     | `HORIZONTAL_BORDER`               |
| **TC-08** | Horizontal Border | Top border near corner       | `(2, 4)`                 | BVA On-Point (near TR)      | `HORIZONTAL_BORDER`               |
| **TC-09** | Vertical Border   | Right border center          | `(3, 0)`                 | BVA On-Point ($x = 3$)      | `VERTICAL_BORDER`                 |
| **TC-10** | Vertical Border   | Left border center           | `(-3, 0)`                | BVA On-Point ($x = -3$)     | `VERTICAL_BORDER`                 |
| **TC-11** | Vertical Border   | Right border near corner     | `(3, 3)`                 | BVA On-Point (near TR)      | `VERTICAL_BORDER`                 |
| **TC-12** | Outside           | Beyond right vertical line   | `(4, 0)`                 | BVA 1-off ($x = 4 > 3$)     | `OUTSIDE`                         |
| **TC-13** | Outside           | Beyond left vertical line    | `(-4, 0)`                | BVA 1-off ($x = -4 < -3$)   | `OUTSIDE`                         |
| **TC-14** | Outside           | Above top horizontal line    | `(0, 5)`                 | BVA 1-off ($y = 5 > 4$)     | `OUTSIDE`                         |
| **TC-15** | Outside           | Below bottom horizontal line | `(0, -5)`                | BVA 1-off ($y = -5 < -4$)   | `OUTSIDE`                         |
| **TC-16** | Outside           | Diagonal exterior quadrant   | `(4, 5)`                 | BVA 1-off ($x > 3, y > 4$)  | `OUTSIDE`                         |
| **TC-17** | Robustness        | Extreme negative X bound     | `(Integer.MIN_VALUE, 0)` | Extreme Boundary Robustness | `OUTSIDE`                         |
| **TC-18** | Robustness        | Extreme positive X bound     | `(Integer.MAX_VALUE, 0)` | Extreme Boundary Robustness | `OUTSIDE`                         |
| **TC-19** | Invalid Input     | Null reference check         | `null`                   | Negative Input Handling     | Throws `IllegalArgumentException` |

---

## Traceability & Coverage Matrix

| Requirement / Partition | Covered By Test Case(s)    | Verification Result                                       |
| :---------------------- | :------------------------- | :-------------------------------------------------------- |
| Interior Region         | TC-01                      | Classified as `INSIDE`                                    |
| 4 Corner Vertices       | TC-02, TC-03, TC-04, TC-05 | Classified as `CORNER`                                    |
| Horizontal Edges        | TC-06, TC-07, TC-08        | Classified as `HORIZONTAL_BORDER`                         |
| Vertical Edges          | TC-09, TC-10, TC-11        | Classified as `VERTICAL_BORDER`                           |
| Exterior Cardinal Paths | TC-12, TC-13, TC-14, TC-15 | Classified as `OUTSIDE`                                   |
| Exterior Diagonal Path  | TC-16                      | Classified as `OUTSIDE`                                   |
| Integer Limits / Safety | TC-17, TC-18               | Prevents overflow, returns `OUTSIDE`                      |
| Null Input Validation   | TC-19                      | Raises `IllegalArgumentException("Point cannot be null")` |
