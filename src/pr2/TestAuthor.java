package pr2;


class Author{
    //Инициализация переменных
    private String name;
    private String email;
    private char gender;
    // Создание конструктора
    public Author(String name, String email, char gender){
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String newEmail){
        this.email=newEmail;
    }

    public char getGender(){
        return gender;
    }

    @Override
    public String toString(){
        return "Author:" +
                "\n" +
                "name=" + name + '\n' +
                "email=" + email + '\n' +
                "gender=" + gender;
    }
}

public class TestAuthor{
    public static void main(String[] args){
        String name = "Alex";

        String email = "pushkin.a.s@edu.mirea.ru";

        char gender = 'm';

        Author Pushkin = new Author(name, email, gender);

        System.out.println("Информация об авторе");
        System.out.println(Pushkin);
        System.out.print("\n");

        String new_email = "pushkin.a.s@mirea.ru";
        Pushkin.setEmail(new_email);

        System.out.println("Обновленная информация об авторе");
        System.out.println(Pushkin);

    }

}