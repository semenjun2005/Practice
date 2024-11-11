package pr10;

public class Student {
    private String firstName;
    private String lastName;
    private String major;
    private int year;
    private String group;


    public Student(String firstName, String lastName, String major, int year, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.year = year;
        this.group = group;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    // Переопределение метода toString для удобного вывода информации о студенте
    @Override
    public String toString() {
        return "Student {" +
                "Имя='" + firstName + '\'' +
                ", Фамилия='" + lastName + '\'' +
                ", Специальность='" + major + '\'' +
                ", Курс=" + year +
                ", Группа='" + group + '\'' +
                '}';
    }
}
