package homework11;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        task1("Hello");
        task1("І розморозь зором зорі");
        task2("goodbye");
        task3("Привіт друзі");
        task4("");
        task4("   ");
        task4("  d ");
        task5("fff123 ?? aa");
        task6("ла ла ла");
        task7("Hello12345");
        task8("listen", "silent");
        task8("hello", "world");
        task9("aabcccccaaa");
        task9("abc");
        task10("abcdef", "zbcdf");
        task10("hello", "yellow");
    }

    public static void task1 (String str) {
        String str_reversed = new String();
        for (int i = str.length() -1 ; i >= 0; i --) {
            str_reversed += str.charAt(i);
        }
        str = str.replaceAll(" ", "");
        str_reversed = str_reversed.replaceAll(" ", "");
        if (str.equalsIgnoreCase(str_reversed)){
            System.out.println("Стрічка паліндром");
        }else {
            System.out.println("Стрічка НЕ паліндром");
        }
    }

    public static void task2 (String str) {
        int vowels = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a'|| str.charAt(i) == 'e'|| str.charAt(i) == 'i'||str.charAt(i) == 'o'||str.charAt(i) == 'u') {
                vowels ++;
            }
        }
        System.out.println("This string has " + vowels + " vowels");
    }

    public static void task3 (String str) {
        String str_reversed = new String();
        for (int i = str.length() -1 ; i >= 0; i --) {
            str_reversed += str.charAt(i);
        }
        System.out.println(str_reversed);
    }

    public static void task4 (String str) {
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                num ++;
            }
        }
        if (num == str.length()) {
            System.out.println("Рядок порожній або складається з пробілів");
        }else {
            System.out.println("В рядку не тільки пробіли");
        }
    }

    public static void task5 (String str) {
        int letters = 0;
        for (int i = 0; i < str.length(); i++){
            if (Character.isLetter(str.charAt(i))){
                letters ++;
            }
        }
        System.out.println("В цьому рядку " + letters + " літер");
    }

    public static void task6 (String str) {
        int spaces = 0;
        for (int i =0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaces ++;
            }
        }
        int words = spaces +1;
        System.out.println("В цьому рядку " + words + " слів");
    }

    public static void task7 (String str) {
        StringBuilder new_string = new StringBuilder(str);
        for (int i = 0; i < new_string.length(); i++) {
            if (Character.isDigit(new_string.charAt(i))) {
                new_string.setCharAt(i, '*');
            }
        }
        System.out.println(new_string);
    }

    public static void task8 (String str1, String str2) {
        str1 = str1.toLowerCase().replaceAll(" ", "");
        str2 = str2.toLowerCase().replaceAll(" ", "");
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        String sorted1 = new String(chars1);
        String sorted2 = new String(chars2);
        if (sorted1.equals(sorted2)) {
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }

    public static void task9 (String str) {
        int number = 1;
        StringBuilder strNew = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i-1)){
                number ++;
            }else{
                strNew.append(str.charAt(i - 1)).append(number);
                number = 1;
            }
        }
        strNew.append(str.charAt(str.length() - 1)).append(number);
        if (strNew.length() >= str.length()) {
            System.out.println(str);
        }else {
            System.out.println(strNew);
        }
    }

    public static void task10 (String str1, String str2) {
        StringBuilder matching = new StringBuilder();
        for (int i = 0; i < str1.length() && i < str2.length(); i++){
            if (str1.charAt(i) == str2.charAt(i)){
                matching.append(str1.charAt(i));
            }
        }
        System.out.println(matching);
    }
}