package pr14;

import java.util.regex.*;
import java.util.ArrayList;

public class task2 {
    public static void main(String[] args) {
        String text = "Here are some prices: 25.98 USD, 300 RUB, 100 EUR, 0.004 EU, and 44 ERR.";

        String regex = "\\b\\d{1,5}(\\.\\d{2})?\\s?(USD|RUB|EU)\\b";

        ArrayList<String> prices = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            prices.add(matcher.group());
        }

        System.out.println("Найденные цены:");
        for (String price : prices) {
            System.out.println(price);
        }
    }
}
