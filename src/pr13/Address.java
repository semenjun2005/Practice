package pr13;

import java.util.StringTokenizer;

public class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String building;
    private String apartment;

    public void parseAddressWithSplit(String address) {
        String[] parts = address.split(",");
        if (parts.length != 7) {
            throw new IllegalArgumentException("Неверный формат адреса.");
        }

        country = parts[0].trim();
        region = parts[1].trim();
        city = parts[2].trim();
        street = parts[3].trim();
        house = parts[4].trim();
        building = parts[5].trim();
        apartment = parts[6].trim();
    }

    public void parseAddressWithTokenizer(String address) {
        StringTokenizer tokenizer = new StringTokenizer(address, ",.;-");
        if (tokenizer.countTokens() != 7) {
            throw new IllegalArgumentException("Неверный формат адреса.");
        }
        country = tokenizer.nextToken().trim();
        region = tokenizer.nextToken().trim();
        city = tokenizer.nextToken().trim();
        street = tokenizer.nextToken().trim();
        house = tokenizer.nextToken().trim();
        building = tokenizer.nextToken().trim();
        apartment = tokenizer.nextToken().trim();
    }

    @Override
    public String toString() {
        return "Address {" +
                "Страна='" + country + '\'' +
                ", Регион='" + region + '\'' +
                ", Город='" + city + '\'' +
                ", Улица='" + street + '\'' +
                ", Дом='" + house + '\'' +
                ", Корпус='" + building + '\'' +
                ", Квартира='" + apartment + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Address address1 = new Address();
        Address address2 = new Address();
        Address address3 = new Address();
        Address address4 = new Address();

        String addr1 = "Россия, Московская область, Москва, Тверская улица, 15, 1, 45";
        String addr2 = "Россия.Московская область.Москва.Тверская улица.15.1.45";
        String addr3 = "Россия;Московская область;Москва;Тверская улица;15;1;45";
        String addr4 = "Россия-Московская область-Москва-Тверская улица-15-1-45";

        System.out.println("Разбор через split():");
        address1.parseAddressWithSplit(addr1);
        System.out.println(address1);

        System.out.println("\nРазбор через StringTokenizer:");
        address2.parseAddressWithTokenizer(addr2);
        System.out.println(address2);

        address3.parseAddressWithTokenizer(addr3);
        System.out.println(address3);

        address4.parseAddressWithTokenizer(addr4);
        System.out.println(address4);
    }
}



