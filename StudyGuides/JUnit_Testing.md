# JUnit Testing

## Intro to TDD

Test-Driven Development is a software development approach that emphasizes writing tests before writing the actual code. It follows a cycle known as the "Red-Green-Refactor" cycle:

- **Red:** Write a failing test for a specific piece of functionality that needs to be implemented.
- **Green:** Write the simplest code to make the failing test pass.
- **Refactor:** Improve the code's structure while keeping the tests passing.

TDD helps ensure that the code is thoroughly tested, supports refactoring, and enhances the overall quality of the software.

**Example of TDD:**
Let's consider developing a simple calculator class with an "add" method using TDD.

1. Write a failing test:

```java
@Test
public void testAdd() {
    Calculator calculator = new Calculator();
    int result = calculator.add(2, 3);
    assertEquals(5, result);
}
```

1. Write the simplest code to make the test pass:

```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}
```

1. Refactor if necessary, keeping the tests passing.

## Unit Testing

Unit testing is the practice of testing individual units or components of a software application in isolation. A unit can be a single function, method, or class. The goal is to ensure that each unit works as expected independently.

**Example of Unit Testing:**
Consider a simple class that calculates the area of a rectangle.

```java
public class Rectangle {
    public int calculateArea(int length, int width) {
        return length * width;
    }
}
```

You would then write unit tests to verify the correctness of the **`calculateArea`** method.

## JUnit Annotations

1. `@Test`: This annotation is used to mark a method as a test method.

```java
import org.junit.jupiter.api.Test;

public class MyTest {

    @Test
    void testAddition() {
        int result = Calculator.add(2, 3);
        assertEquals(5, result);
    }
}
```

2. `@BeforeEach` and `@AfterEach`: These annotations are used to denote methods that should be executed before and after each test method.

```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class MyTest {

    @BeforeEach
    void setUp() {
        // Initialization code before each test
    }

    @AfterEach
    void tearDown() {
        // Cleanup code after each test
    }

    @Test
    void testSomething() {
        // Test code
    }
}
```

3. `@BeforeAll` and `@AfterAll`: These annotations are used to denote methods that should be executed once before and after all test methods in the class.

```java
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class MyTest {

    @BeforeAll
    static void setUpAll() {
        // Initialization code before all tests
    }

    @AfterAll
    static void tearDownAll() {
        // Cleanup code after all tests
    }

    @Test
    void testSomething() {
        // Test code
    }
}
```

4. `@Disabled`: This annotation is used to disable a test method.

```java
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MyTest {

    @Test
    @Disabled("Not implemented yet")
    void testSomething() {
        // Test code
    }
}
```

These are just a few examples of the many annotations available in JUnit 5. Each annotation serves a specific purpose in controlling the behavior of your tests.

## Assert Methods

1. `assertEquals(expected, actual)`:
Checks that two values are equal.

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyTest {

    @Test
    void testAddition() {
        int result = Calculator.add(2, 3);
        assertEquals(5, result);
    }
}
```

2. `assertTrue(condition)` and `assertFalse(condition)`:
Checks if a given condition is true or false.

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MyTest {

    @Test
    void testIsPositive() {
        assertTrue(Calculator.isPositive(5));
        assertFalse(Calculator.isPositive(-5));
    }
}
```

3. `assertNull(actual)` and `assertNotNull(actual)`:
Checks if a value is null or not null.

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MyTest {

    @Test
    void testNullValue() {
        String value = null;
        assertNull(value);
    }

    @Test
    void testNonNullValue() {
        String value = "Hello";
        assertNotNull(value);
    }
}
```

4. `assertSame(expected, actual)` and `assertNotSame(expected, actual)`:
Checks if two references point to the same object or different objects.

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class MyTest {

    @Test
    void testSameObject() {
        String str1 = "Hello";
        String str2 = str1;
        assertSame(str1, str2);
    }

    @Test
    void testDifferentObjects() {
        String str1 = new String("Hello");
        String str2 = new String("Hello");
        assertNotSame(str1, str2);
    }
}
```

5. `assertThrows(exceptionType, executable)`:
Checks if a specific exception is thrown by the provided executable.

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyTest {

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> Calculator.divide(10, 0));
    }
}
```

These are just a few examples of the assertion methods provided by JUnit 5. Using these methods, you can validate various conditions and expectations in your test cases.


### Resources

- [JUnit5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [A Guide to JUnit 5](https://www.baeldung.com/junit-5)