import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Задача 1 (лекция): запускаем isEven один раз, checkAccess 20 раз,
// getGrade в параметризованном тесте.
class Task1LectureBasicMethodsTest {

    private static final Random RANDOM = new Random();

    private static void printStart() {
        System.out.println("========================Test method start");
    }

    private static void printEnd() {
        System.out.println("Test method end");
        System.out.println("========================");
    }

    @Test
    void isEvenOneRandomNumber() {
        printStart();
        int number = 1 + RANDOM.nextInt(100);
        System.out.println("isEven(" + number + ") = " + BasicJavaTasks.isEven(number));
        printEnd();
    }

    @Test
    void checkAccessTwentyRandomAges() {
        printStart();
        for (int i = 1; i <= 20; i++) {
            int age = RANDOM.nextInt(100);
            System.out.println(i + ") checkAccess(" + age + ") = " + BasicJavaTasks.checkAccess(age));
        }
        printEnd();
    }

    @ParameterizedTest
    @MethodSource("randomScores")
    void getGradeRandomScores(int score) {
        printStart();
        System.out.println("getGrade(" + score + ") = " + BasicJavaTasks.getGrade(score));
        printEnd();
    }

    // 10 случайных чисел от 0 до 100
    static List<Integer> randomScores() {
        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            scores.add(RANDOM.nextInt(101));
        }
        return scores;
    }
}
