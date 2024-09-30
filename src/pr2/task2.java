package pr2;

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int calculateHumanAge() {
        return age * 7;
    }

    @Override
    public String toString() {
        return "Dog: Name: " + name + ", Age: " + age;
    }
}

class DogShelter {
    private Dog[] dogs; //инициализация массива собак
    private int count; //лимит собак

    //Конструктор приемника
    public DogShelter(int size) {
        dogs = new Dog[size]; //определение количества собак в приемнике
        count = 0;
    }

    //Функция добавления собак в приемник
    public void addDog(Dog dog) {
        if (count < dogs.length) {
            dogs[count] = dog;
            count++;
        } else {
            System.out.println("Места в приемнике закончились");
        }
    }

    //Функция вывода собак на экран
    public void displayDogs() {
        for (int i = 0; i < count; i++) {
            System.out.println(dogs[i]);
        }
    }
}

public class task2 {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Пушинка", 12);
        Dog dog2 = new Dog("Бантик", 7);

        DogShelter shelter = new DogShelter(2);
        shelter.addDog(dog1);
        shelter.addDog(dog2);

        shelter.displayDogs();
    }
}
