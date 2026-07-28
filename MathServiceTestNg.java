import org.example.MathService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MathServiceTestNg {

    private final MathService mathService = new MathService();

    @Test(description = "Test 1 - вычисление факториала числа")
    public void testFactorial() {
        Assert.assertEquals(mathService.factorial(0), 1);
        Assert.assertEquals(mathService.factorial(1), 1);
        Assert.assertEquals(mathService.factorial(5), 120);
    }

    @Test(description = "Test 1.1 - ошибка факториала", expectedExceptions = IllegalArgumentException.class)
    public void testFactorialException() {
        mathService.factorial(-1);
    }

    @Test(description = "Test 2 - вычисление площади треугольника")
    public void testCalculateTriangleArea() {
        Assert.assertEquals(mathService.calculateTriangleArea(4.0, 5.0), 10.0);
    }

    @Test(description = "Test 2.1 - ошибка площади при нуле", expectedExceptions = IllegalArgumentException.class)
    public void testTriangleAreaZeroException() {
        mathService.calculateTriangleArea(0, 5);
    }

    @Test(description = "Test 2.2 - ошибка площади при минусе", expectedExceptions = IllegalArgumentException.class)
    public void testTriangleAreaNegativeException() {
        mathService.calculateTriangleArea(4, -2);
    }

    @Test(description = "Test 3 - сложение двух чисел")
    public void testAddNumbers() {
        Assert.assertEquals(mathService.addNumbers(7, 3), 10);
        Assert.assertEquals(mathService.addNumbers(0, 0), 0);
    }

    @Test(description = "Test 3.1 - ошибка сложения", expectedExceptions = IllegalArgumentException.class)
    public void testAddNumbersException() {
        mathService.addNumbers(-1, 5);
    }

    @Test(description = "Test 4 - вычитание одного числа из другого")
    public void testSubtractNumbers() {
        Assert.assertEquals(mathService.subtractNumbers(7, 3), 4);
        Assert.assertEquals(mathService.subtractNumbers(3, 5), -2);
    }

    @Test(description = "Test 4.1 - ошибка вычитания", expectedExceptions = IllegalArgumentException.class)
    public void testSubtractNumbersException() {
        mathService.subtractNumbers(5, -3);
    }

    @Test(description = "Test 5 - деление одного числа на другое")
    public void testDivideNumbers() {
        Assert.assertEquals(mathService.divideNumbers(6, 3), 2);
        Assert.assertEquals(mathService.divideNumbers(0, 5), 0);
    }

    @Test(description = "Test 5.1 - деление на ноль", expectedExceptions = ArithmeticException.class)
    public void testDivideByZeroException() {
        mathService.divideNumbers(5, 0);
    }

    @Test(description = "Test 5.2 - ошибка деления при минусе", expectedExceptions = IllegalArgumentException.class)
    public void testDivideNumbersNegativeException() {
        mathService.divideNumbers(-6, 2);
    }

    @Test(description = "Test 6 - умножение одного числа на другое")
    public void testMultiplyNumbers() {
        Assert.assertEquals(mathService.multiplyNumbers(7, 3), 21);
        Assert.assertEquals(mathService.multiplyNumbers(5, 0), 0);
    }

    @Test(description = "Test 6.1 - ошибка умножения", expectedExceptions = IllegalArgumentException.class)
    public void testMultiplyNumbersException() {
        mathService.multiplyNumbers(7, -3);
    }

    @Test(description = "Test 7 - сравнение чисел")
    public void testCompareNumbers() {
        Assert.assertEquals(mathService.compareNumbers(5, 5), "Числа равны");
        Assert.assertEquals(mathService.compareNumbers(10, 5), "Первое число больше второго");
        Assert.assertEquals(mathService.compareNumbers(3, 7), "Второе число больше первого");
    }

    @Test(description = "Test 7.1 - ошибка сравнения", expectedExceptions = IllegalArgumentException.class)
    public void testCompareNumbersException() {
        mathService.compareNumbers(-1, 5);
    }
}
