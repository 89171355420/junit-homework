import java.util.ArrayList;
import java.util.List;

public class BasicJavaTasks {

    // Задача 1
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    // Задача 2
    public static String checkAccess(int age) {
        return age > 18 ? "Allowed" : "Denied";
    }

    // Задача 3
    public static boolean isPositive(int n) {
        return n >= 0 ? true : false;
    }

    // Задача 4
    public static String getGrade(int score) {
        if (score >= 0 && score <= 20) {
            return "E";
        }
        if (score >= 21 && score <= 40) {
            return "D";
        }
        if (score >= 41 && score <= 60) {
            return "C";
        }
        if (score >= 61 && score <= 80) {
            return "B";
        }
        if (score >= 81 && score <= 100) {
            return "A";
        }
        return "Error";
    }

    // Задача 5
    public static String blastOff(int start) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i >= 1; i--) {
            if (i != start) {
                result.append(" ");
            }
            result.append(i);
        }
        result.append(" Поехали!");
        return result.toString();
    }

    // Задача 6
    public static int sumToN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }

    // Задача 7
    public static boolean hasBug(String[] messages) {
        for (String message : messages) {
            if (message != null && message.equalsIgnoreCase("Bug")) {
                return true;
            }
        }
        return false;
    }

    // Задача 8
    public static String getEvenInRange(int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(i);
            }
        }
        return result.toString();
    }

    // Задача 9
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Задача 10
    public static String[] reverse(String[] arr) {
        String[] result = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }
        return result;
    }

    // Задача 11
    public static double calcAverage(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (int number : list) {
            sum = sum + number;
        }
        return (double) sum / list.size();
    }

    // Задача 12
    public static List<String> removeSpecificName(List<String> list, String nameToRemove) {
        List<String> result = new ArrayList<>();
        for (String name : list) {
            if (!name.equals(nameToRemove)) {
                result.add(name);
            }
        }
        return result;
    }
}
