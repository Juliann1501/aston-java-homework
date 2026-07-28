import org.example.MathService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathServiceTest {

    private final MathService mathService = new MathService();

    @Test
    @DisplayName("Test 1 - вычисление факториала числа")
    void testFactorial() {
        assertEquals(1, mathService.factorial(0));
        assertEquals(1, mathService.factorial(1));
        assertEquals(120, mathService.factorial(5));
        assertThrows(IllegalArgumentException.class, () -> mathService.factorial(-1));
    }

    @Test
    @DisplayName("Test 2 - вычисление площади треугольника")
    void testCalculateTriangleArea() {
        assertEquals(10.0, mathService.calculateTriangleArea(4.0, 5.0));
        assertThrows(IllegalArgumentException.class, () -> mathService.calculateTriangleArea(0, 5));
        assertThrows(IllegalArgumentException.class, () -> mathService.calculateTriangleArea(4, -2));
    }

    @Test
    @DisplayName("Test 3 - сложение двух чисел")
    void testAddNumbers() {
        assertEquals(10, mathService.addNumbers(7, 3));
        assertEquals(0, mathService.addNumbers(0, 0));
        assertThrows(IllegalArgumentException.class, () -> mathService.addNumbers(-1, 5));
    }

    @Test
    @DisplayName("Test 4 - вычитание одного числа из другого")
    void testSubtractNumbers() {
        assertEquals(4, mathService.subtractNumbers(7, 3));
        assertEquals(-2, mathService.subtractNumbers(3, 5));
        assertThrows(IllegalArgumentException.class, () -> mathService.subtractNumbers(5, -3));
    }

    @Test
    @DisplayName("Test 5 - деление одного числа на другое")
    void testDivideNumbers() {
        assertEquals(2, mathService.divideNumbers(6, 3));
        assertEquals(0, mathService.divideNumbers(0, 5));
        assertThrows(ArithmeticException.class, () -> mathService.divideNumbers(5, 0));
        assertThrows(IllegalArgumentException.class, () -> mathService.divideNumbers(-6, 2));
    }

    @Test
    @DisplayName("Test 6 - умножение одного числа на другое")
    void testMultiplyNumbers() {
        assertEquals(21, mathService.multiplyNumbers(7, 3));
        assertEquals(0, mathService.multiplyNumbers(5, 0));
        assertThrows(IllegalArgumentException.class, () -> mathService.multiplyNumbers(7, -3));
    }

    @Test
    @DisplayName("Test 7 - сравнение чисел")
    void testCompareNumbers() {
        assertEquals("Числа равны", mathService.compareNumbers(5, 5));
        assertEquals("Первое число больше второго", mathService.compareNumbers(10, 5));
        assertEquals("Второе число больше первого", mathService.compareNumbers(3, 7));
        assertThrows(IllegalArgumentException.class, () -> mathService.compareNumbers(-1, 5));
    }
}
