package pr20;

import java.io.Serializable;

// Интерфейс Animal
abstract class Animal {
    public abstract void makeSound();
}

// Класс Dog, который теперь реализует Serializable
class Dog extends Animal implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

