package pr13;

class PhoneNumber {
    private String originalNumber;
    private String formattedNumber;


    public PhoneNumber(String number) {
        this.originalNumber = number.trim();
        this.formattedNumber = formatNumber();
    }


    private String formatNumber() {
        String countryCode;
        String mainNumber;


        if (originalNumber.startsWith("+")) {
            countryCode = originalNumber.substring(0, originalNumber.length() - 10);
            mainNumber = originalNumber.substring(originalNumber.length() - 10);
        }

        else if (originalNumber.startsWith("8") && originalNumber.length() == 11) {
            countryCode = "+7";
            mainNumber = originalNumber.substring(1);
        } else {
            throw new IllegalArgumentException("Неверный формат номера: " + originalNumber);
        }


        String formattedMainNumber = mainNumber.substring(0, 3) + "-" +
                mainNumber.substring(3, 6) + "-" +
                mainNumber.substring(6);

        return countryCode + "-" + formattedMainNumber;
    }


    public String getFormattedNumber() {
        return formattedNumber;
    }


    @Override
    public String toString() {
        return "Original Number: " + originalNumber + "\nFormatted Number: " + formattedNumber;
    }


    public static void main(String[] args) {
        String[] phoneNumbers = {
                "+79175655655",
                "+104289652211",
                "89175655655",
                "+123456789012",
                "81234567890"
        };

        for (String number : phoneNumbers) {
            PhoneNumber phoneNumber = new PhoneNumber(number);
            System.out.println(phoneNumber);
            System.out.println();

        }
    }
}

