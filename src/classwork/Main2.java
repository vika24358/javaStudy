package classwork;

public class Main2 {

    public static void main(String[] args) {
        String s = "Hello"; // char[]
        char ch = 's';//65 000
        String test = "Education";

        System.out.println(isBigLetter("world"));
        System.out.println(isBigLetter("Hell"));
        System.out.println(strRevers(s));
        System.out.println(countVowels(test));
    }
    //    public static String strRevers(String s) {
//        s
//        return ;
//    }
    public static boolean isBigLetter(String s) {
        if (s.charAt(0)>=65 && s.charAt(0) <= 90) {
            return true;
        }
            return false;
    }

    public static char[] strRevers(String s) {
        char[] reverseString = new char[s.length()];
        for (int i = 0 ; i < s.length(); i++){
            reverseString[s.length() -1 -i] = s.charAt(i);
        }
        return reverseString;
    }

    public static int countVowels(String str) {
        int amount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.toLowerCase().charAt(i) == 'a' || str.toLowerCase().charAt(i) == 'e' || str.toLowerCase().charAt(i) == 'i' || str.toLowerCase().charAt(i) == 'o' || str.toLowerCase().charAt(i) == 'u') {
                amount++;
            }
        }
        return amount;
    }


    public static boolean task3 (String s) {
        String reverseStr = strRevers(s).toString();
        if (s.equals(reverseStr)) {
            return true;
        }
    return false;
    }
}