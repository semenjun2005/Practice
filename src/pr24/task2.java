package pr24;

interface Chair {
    void sit();
}

class VictorianChair implements Chair {
    @Override
    public void sit() {
        System.out.println("Вы сидите на викторианском стуле");
    }
}

class MultifunctionalChair implements Chair {
    @Override
    public void sit() {
        System.out.println("Вы сидите на многофункциональном стуле");
    }
}

class MagicChair implements Chair {
    @Override
    public void sit() {
        System.out.println("Вы сидите на магическом стуле.");
    }
}

interface ChairAbstractFactory {
    Chair createVictorianChair();
    Chair createMultifunctionalChair();
    Chair createMagicChair();
}

class ChairFactory implements ChairAbstractFactory {
    @Override
    public Chair createVictorianChair() {
        return new VictorianChair();
    }

    @Override
    public Chair createMultifunctionalChair() {
        return new MultifunctionalChair();
    }

    @Override
    public Chair createMagicChair() {
        return new MagicChair();
    }
}

class Client {
    public void sit(Chair chair) {
        chair.sit(); // Вызов метода sit() для любого типа стула
    }
}

public class task2 {
    public static void main(String[] args) {
        ChairAbstractFactory factory = new ChairFactory();

        Chair victorianChair = factory.createVictorianChair();
        Chair multifunctionalChair = factory.createMultifunctionalChair();
        Chair magicChair = factory.createMagicChair();

        Client client = new Client();

        client.sit(victorianChair);
        client.sit(multifunctionalChair);
        client.sit(magicChair);
    }
}
