# Automated Testing S7 Project

This project provides the environment and boilerplate for completing the automated testing and software testing tasks from the assignment.

## Tech Stack
- **Language**: Java 17+ (Compatible with JDK 17, 21, 23, 24)
- **UI Automation**: Selenium WebDriver 4.26+
- **Driver Management**: WebDriverManager 5.9+
- **Testing Framework**: JUnit 5 (Jupiter Engine & Parameterized Tests)
- **Assertions**: AssertJ 3.26+
- **Build Tool**: Apache Maven

---

## Directory Structure

```
AutoTesting S7/
├── pom.xml                                   # Maven configuration and dependencies
├── README.md                                 # Project documentation
├── .gitignore                                # Git ignore configuration
├── docs/                                     # Assignment documentation & written tasks
│   ├── task1-smoke-test-cases.md             # Task 1: Smoke test cases for admin login
│   ├── task2-bug-reports.md                  # Task 2: Bug reports & enhancements template
│   ├── task3-locators.md                     # Task 3: XPath and CSS locators
│   └── task4-domain-testing.md               # Task 4: Domain testing decision table & values
└── src/
    ├── main/java/com/autotesting/
    │   ├── task4/                            # Task 4 Java application
    │   │   ├── Point.java                    # 2D Point model
    │   │   ├── RectanglePosition.java        # Position enum (INSIDE, OUTSIDE, CORNER, etc.)
    │   │   ├── RectangleGeometryService.java # Business logic service
    │   │   └── RectangleApp.java             # Interactive CLI application
    │   └── ui/                               # Selenium UI Automation framework
    │       ├── driver/
    │       │   └── WebDriverFactory.java     # WebDriver initialization and configuration
    │       └── pages/
    │           ├── BasePage.java             # Base Page Object with helper methods
    │           └── LoginPage.java            # Page Object for Restful Booker login
    └── test/java/com/autotesting/
        ├── task4/
        │   └── RectangleGeometryServiceTest.java # Task 4 Unit & Parameterized tests
        └── ui/
            ├── BaseUiTest.java               # Base class managing WebDriver lifecycle
            └── LoginSmokeTest.java           # Selenium UI smoke tests
```

---

## Getting Started

### 1. Build the Project
Compile the code and verify dependencies:
```bash
mvn clean compile
```

### 2. Run Tests
Run the test suite using Maven Surefire:
```bash
mvn test
```

To run a specific test class:
```bash
mvn test -Dtest=RectangleGeometryServiceTest
```

### 3. Run Task 4 Console Application
Run the interactive console application for rectangle position checking:
```bash
mvn compile exec:java
```
Or directly from your IDE by running [`RectangleApp.java`](src/main/java/com/autotesting/task4/RectangleApp.java).

---

## Tasks Overview & Locations

| Task | Description | Location in Project |
|---|---|---|
| **Task 1** | Smoke test cases for `https://automationintesting.online/` | [`docs/task1-smoke-test-cases.md`](docs/task1-smoke-test-cases.md) & [`LoginSmokeTest.java`](src/test/java/com/autotesting/ui/LoginSmokeTest.java) |
| **Task 2** | Two bug reports / enhancements | [`docs/task2-bug-reports.md`](docs/task2-bug-reports.md) |
| **Task 3** | XPath and CSS locators (Common & Individual) | [`docs/task3-locators.md`](docs/task3-locators.md) |
| **Task 4** | Console app, domain testing table, and parameterized unit tests | [`docs/task4-domain-testing.md`](docs/task4-domain-testing.md), [`src/main/java/com/autotesting/task4/`](src/main/java/com/autotesting/task4/), [`src/test/java/com/autotesting/task4/`](src/test/java/com/autotesting/task4/) |
