package pr11;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Student {
    private String firstName;
    private String lastName;
    private String major;
    private int year;
    private String group;
    private LocalDate birthDate;

    public Student(String firstName, String lastName, String major, int year, String group, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.year = year;
        this.group = group;
        this.birthDate = birthDate;
    }


    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    public String getFormattedBirthDate(FormatStyle formatStyle) {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(formatStyle).withLocale(Locale.getDefault());
        return birthDate.format(formatter);
    }

    @Override
    public String toString() {
        return "Student {" +
                "Имя='" + firstName + '\'' +
                ", Фамилия='" + lastName + '\'' +
                ", Специальность='" + major + '\'' +
                ", Курс=" + year +
                ", Группа='" + group + '\'' +
                ", Дата рождения='" + getFormattedBirthDate(FormatStyle.MEDIUM) + '\'' + // Используем формат по умолчанию
                '}';
    }
}
