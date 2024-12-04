package pr13;

public class task1 {
    public static void main(String[] args) {
        String str = "I like Java!!!";

        char lastChar = str.charAt(str.length() - 1);
        System.out.println("Последний символ строки: " + lastChar);

        boolean endsWithExclamation = str.endsWith("!!!");
        System.out.println("Заканчивается на '!!!': " + endsWithExclamation);

        boolean startsWithILike = str.startsWith("I like");
        System.out.println("Начинается с 'I like': " + startsWithILike);

        boolean containsJava = str.contains("Java");
        System.out.println("Содержит 'Java': " + containsJava);

        int indexOfJava = str.indexOf("Java");
        System.out.println("Позиция 'Java': " + indexOfJava);

        String replacedStr = str.replace('a', 'o');
        System.out.println("Замена 'а' на 'о': " + replacedStr);

        String upperCaseStr = str.toUpperCase();
        System.out.println("В верхнем регистре: " + upperCaseStr);

        String lowerCaseStr = str.toLowerCase();
        System.out.println("В нижнем регистре: " + lowerCaseStr);

        String substringJava = str.substring(indexOfJava, indexOfJava + 4);
        System.out.println("Вырезанная строка 'Java': " + substringJava);
    }
}
