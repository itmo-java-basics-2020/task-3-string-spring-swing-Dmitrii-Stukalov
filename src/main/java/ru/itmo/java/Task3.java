package ru.itmo.java;

import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return new int[]{};
        }
        int lastElement = inputArray[inputArray.length - 1];
        for (int i = 0; i < inputArray.length; ++i) {
            int current = inputArray[i];
            inputArray[i] = lastElement;
            lastElement = current;
        }
        return inputArray;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     * <p>
     * Если входной массив пуст или равен null - вернуть 0
     * <p>
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return 0;
        }
        if (inputArray.length == 1) {
            return inputArray[0];
        }
        int firstMax = 0, secondMax = 0;
        for (int value : inputArray) {
            if (value > firstMax) {
                secondMax = firstMax;
                firstMax = value;
            } else if (value > secondMax) {
                secondMax = value;
            }
        }
        return firstMax * secondMax;
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     * <p>
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null || input.equals("")) {
            return 0;
        }
        int counter = 0;
        for (int i = 0; i < input.length(); ++i) {
            if (input.charAt(i) == 'a' || input.charAt(i) == 'b' || input.charAt(i) == 'A' || input.charAt(i) == 'B') {
                counter++;
            }
        }
        return counter * 100 / input.length();
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null || input.equals("")) {
            return false;
        }
        for (int i = 0; i < input.length() / 2; ++i) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input.equals("")) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int counter = 0;
        char previous = input.charAt(0);
        for (int i = 0; i < input.length(); ++i) {
            if (previous != input.charAt(i)) {
                result.append(previous);
                result.append(counter);
                counter = 0;
                previous = input.charAt(i);
            }
            counter++;
        }
        result.append(previous);
        result.append(counter);
        return result.toString();
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null || one.equals("") || two.equals("") || one.length() != two.length()) {
            return false;
        }
        char[] first = one.toCharArray();
        char[] second = two.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        for (int i = 0; i < first.length; ++i) {
            if (first[i] != second[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.equals("")) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }

        int[] letters = new int[256];
        char[] cs = s.toCharArray();
        for (char c : cs) {
            letters[c]++;
        }

        for (int letter : letters) {
            if (letter > 1) {
                return false;
            }
        }

        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     * <p>
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null || m[0].length == 0) {
            return new int[][]{{}, {}};
        }
        for (int i = 0; i < m.length; ++i) {
            for (int j = i + 1; j < m.length; ++j) {
                int temp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = temp;
            }
        }
        return m;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     * <p>
     * Запрещается пользоваться функций join
     * <p>
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (inputStrings == null || inputStrings.length == 0) {
            return "";
        }
        if (separator == null) {
            separator = ' ';
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < inputStrings.length - 1; ++i) {
            stringBuilder.append(inputStrings[i]);
            stringBuilder.append(separator);
        }
        stringBuilder.append(inputStrings[inputStrings.length - 1]);
        return stringBuilder.toString();
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || prefix == null || inputStrings.length == 0) {
            return 0;
        }
        int counter = 0;
        for (String inputString : inputStrings) {
            if (inputString.startsWith(prefix)) {
                counter++;
            }
        }
        return counter;
    }
}
