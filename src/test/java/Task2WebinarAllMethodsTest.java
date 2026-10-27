import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

// Задача 2 (вебинар): проверяем все 12 методов из ДЗ 1.
// Результат сравниваем с эталоном и печатаем TEST PASSED или TEST FAILED.
class Task2WebinarAllMethodsTest {

    private static final Random RANDOM = new Random();
    private static final String[] NAMES = {"Ann", "Bob", "Tom", "Zoe", "Leo", "Mia"};

    private static void report(String testName, boolean passed, String details) {
        System.out.println("[" + testName + "] " + details);
        if (passed) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    // 4 теста с @Test

    @Test
    void testIsEven() {
        int number = 1 + RANDOM.nextInt(100);
        boolean expected = number % 2 == 0;
        boolean actual = BasicJavaTasks.isEven(number);
        report("isEven", actual == expected, "isEven(" + number + ") = " + actual + ", ожидалось " + expected);
    }

    @Test
    void testCheckAccess() {
        int age = RANDOM.nextInt(100);
        String expected = age > 18 ? "Allowed" : "Denied";
        String actual = BasicJavaTasks.checkAccess(age);
        report("checkAccess", expected.equals(actual), "checkAccess(" + age + ") = " + actual + ", ожидалось " + expected);
    }

    @Test
    void testIsPositive() {
        int number = -100 + RANDOM.nextInt(201);
        boolean expected = number >= 0;
        boolean actual = BasicJavaTasks.isPositive(number);
        report("isPositive", actual == expected, "isPositive(" + number + ") = " + actual + ", ожидалось " + expected);
    }

    @Test
    void testGetGrade() {
        int score = RANDOM.nextInt(101);
        String expected = expectedGrade(score);
        String actual = BasicJavaTasks.getGrade(score);
        report("getGrade", expected.equals(actual), "getGrade(" + score + ") = " + actual + ", ожидалось " + expected);
    }

    // эталон для getGrade
    private static String expectedGrade(int score) {
        if (score < 0 || score > 100) {
            return "Error";
        }
        if (score <= 20) {
            return "E";
        }
        if (score <= 40) {
            return "D";
        }
        if (score <= 60) {
            return "C";
        }
        if (score <= 80) {
            return "B";
        }
        return "A";
    }

    // 4 теста с @RepeatedTest

    @RepeatedTest(5)
    void testBlastOff() {
        int start = 1 + RANDOM.nextInt(10);
        String expected = expectedBlastOff(start);
        String actual = BasicJavaTasks.blastOff(start);
        report("blastOff", expected.equals(actual),
                "blastOff(" + start + ") = \"" + actual + "\", ожидалось \"" + expected + "\"");
    }

    private static String expectedBlastOff(int start) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i >= 1; i--) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(i);
        }
        result.append(" Поехали!");
        return result.toString();
    }

    @RepeatedTest(5)
    void testSumToN() {
        int n = 1 + RANDOM.nextInt(100);
        int expected = 0;
        for (int i = 1; i <= n; i++) {
            expected += i;
        }
        int actual = BasicJavaTasks.sumToN(n);
        report("sumToN", expected == actual, "sumToN(" + n + ") = " + actual + ", ожидалось " + expected);
    }

    @RepeatedTest(5)
    void testHasBug() {
        String[] words = {"Bug", "bug", "Info", "Error", "Fix", "BUG"};
        String[] messages = new String[1 + RANDOM.nextInt(6)];
        for (int i = 0; i < messages.length; i++) {
            messages[i] = words[RANDOM.nextInt(words.length)];
        }

        boolean expected = false;
        for (String message : messages) {
            if (message.equalsIgnoreCase("Bug")) {
                expected = true;
                break;
            }
        }
        boolean actual = BasicJavaTasks.hasBug(messages);
        report("hasBug", expected == actual, "hasBug(" + Arrays.toString(messages) + ") = " + actual + ", ожидалось " + expected);
    }

    @RepeatedTest(5)
    void testGetEvenInRange() {
        int start = RANDOM.nextInt(21);
        int end = start + 1 + RANDOM.nextInt(10);

        StringBuilder expectedBuilder = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                if (expectedBuilder.length() > 0) {
                    expectedBuilder.append(" ");
                }
                expectedBuilder.append(i);
            }
        }
        String expected = expectedBuilder.toString();
        String actual = BasicJavaTasks.getEvenInRange(start, end);
        report("getEvenInRange", expected.equals(actual),
                "getEvenInRange(" + start + ", " + end + ") = \"" + actual + "\", ожидалось \"" + expected + "\"");
    }

    // 4 параметризованных теста

    @ParameterizedTest
    @MethodSource("randomArraysForMax")
    void testFindMax(int[] array, int expected) {
        int actual = BasicJavaTasks.findMax(array);
        report("findMax", actual == expected, "findMax(" + Arrays.toString(array) + ") = " + actual + ", ожидалось " + expected);
    }

    static List<Arguments> randomArraysForMax() {
        List<Arguments> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int[] array = new int[1 + RANDOM.nextInt(10)];
            for (int k = 0; k < array.length; k++) {
                array[k] = -50 + RANDOM.nextInt(101);
            }
            int expected = array[0];
            for (int value : array) {
                if (value > expected) {
                    expected = value;
                }
            }
            data.add(Arguments.of(array, expected));
        }
        return data;
    }

    @ParameterizedTest
    @MethodSource("randomArraysForReverse")
    void testReverse(String[] array, String[] expected) {
        String[] actual = BasicJavaTasks.reverse(array);
        report("reverse", Arrays.equals(expected, actual),
                "reverse(" + Arrays.toString(array) + ") = " + Arrays.toString(actual) + ", ожидалось " + Arrays.toString(expected));
    }

    static List<Arguments> randomArraysForReverse() {
        List<Arguments> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String[] array = new String[1 + RANDOM.nextInt(8)];
            for (int k = 0; k < array.length; k++) {
                array[k] = NAMES[RANDOM.nextInt(NAMES.length)];
            }
            String[] expected = new String[array.length];
            for (int k = 0; k < array.length; k++) {
                expected[k] = array[array.length - 1 - k];
            }
            data.add(Arguments.of(array, expected));
        }
        return data;
    }

    @ParameterizedTest
    @MethodSource("randomNumbersForAverage")
    void testCalcAverage(List<Integer> numbers, double expected) {
        double actual = BasicJavaTasks.calcAverage(numbers);
        boolean passed = Math.abs(actual - expected) < 0.000001;
        report("calcAverage", passed, "calcAverage(" + numbers + ") = " + actual + ", ожидалось " + expected);
    }

    static List<Arguments> randomNumbersForAverage() {
        List<Arguments> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Integer> numbers = new ArrayList<>();
            int size = 1 + RANDOM.nextInt(10);
            double sum = 0;
            for (int k = 0; k < size; k++) {
                int number = 1 + RANDOM.nextInt(100);
                numbers.add(number);
                sum += number;
            }
            data.add(Arguments.of(numbers, sum / numbers.size()));
        }
        return data;
    }

    @ParameterizedTest
    @MethodSource("randomListsForRemoveName")
    void testRemoveSpecificName(List<String> list, String nameToRemove, List<String> expected) {
        List<String> actual = BasicJavaTasks.removeSpecificName(list, nameToRemove);
        report("removeSpecificName", expected.equals(actual),
                "removeSpecificName(" + list + ", \"" + nameToRemove + "\") = " + actual + ", ожидалось " + expected);
    }

    static List<Arguments> randomListsForRemoveName() {
        List<Arguments> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<String> list = new ArrayList<>();
            int size = 2 + RANDOM.nextInt(5);
            for (int k = 0; k < size; k++) {
                list.add(NAMES[RANDOM.nextInt(NAMES.length)]);
            }
            String nameToRemove = NAMES[RANDOM.nextInt(NAMES.length)];
            List<String> expected = new ArrayList<>();
            for (String name : list) {
                if (!name.equals(nameToRemove)) {
                    expected.add(name);
                }
            }
            data.add(Arguments.of(list, nameToRemove, expected));
        }
        return data;
    }
}
