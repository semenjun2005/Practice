package pr4;

enum Seasons{
    WINTER("Зима",-25.27, "Месяцы: декабрь, январь, февраль"),
    SPRING("Осень", 15.11, "Месяцы: март, апрель, май"),
    SUMMER("Зима", -25.69, "Месяцы: июнь, июль, август"),
    AUTUMN("Весна", 12.54, "Месяцы: сентябрь, январь, февраль");

    private String name;
    private double avg_tmp;
    private String description;

    Seasons(String name, double avg_tmp, String description){
        this.name = name;
        this.avg_tmp = avg_tmp;
        this.description = description;
    }

    public double getAvg_tmp(){
        return avg_tmp;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    @Override
    public String toString(){
        return "name = " + name +
                ", avg_tmp" + avg_tmp +
                ", description" + description;

    }
}

public class task1 {
    public static void printSeasonMessage(Seasons string){
        switch (string){
            case WINTER:
                System.out.println("Я люблю зиму");
                break;
            case AUTUMN:
                System.out.println("Я люблю весну");
                break;
            case SPRING:
                System.out.println("Я люблю осень");
                break;
            case SUMMER:
                System.out.println("Я люблю лето");
                break;
        }
    }

    public static void getDescription(String name){
        switch (name){
            case "Лето":
                System.out.println("Теплое время года\n");
                break;
            default:
                System.out.println("Холодное время года\n");
                break;
        }

    }

    public static void main(String[] args) {
        System.out.println("Мое любимое время года это: " + Seasons.WINTER.getName() + "\n" + "В нем три месяца: декабрь, январь, февраль\n");

        getDescription(Seasons.SUMMER.getName());

        for(Seasons season: Seasons.values()){
            System.out.println(season);
        }

    }
}