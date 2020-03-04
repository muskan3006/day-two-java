package com.knoldus;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class AppDriver extends Const {
    public static void main(String[] args) {
        AllFunctions a = new AllFunctions();
        LocalDate birthDay = LocalDate.of(1998, 12, 30);
        System.out.println(a.getBirthDateDayOfWeek(birthDay));
        List<Student> listOfStudents = Arrays.asList(
                new Student(1, "Pushkar", 20, new Address("Delhi", "Sarita Vihar")),
                new Student(2, "Alice", 26, new Address("Dehradun")),
                new Student(5, "Joy", 30, new Address("Faridabad", "Noida")),
                new Student(7, "Shivam", 21, new Address("Mumbai", "Sarita Vihar")),
                new Student(8, "Malice", 22, new Address("Kolkata", "Noida")),
                new Student(9, "Merry", 18, new Address("Chennai")));
        System.out.println(a.getStudentsWithoutSecondaryAddress(listOfStudents));
        String name = "Muskan";
        System.out.println(a.getStudentsWithoutSecondaryAddressAndNameInitial(listOfStudents, name));
        System.out.println(a.getLeapYearsAfterRepublicDay());
        System.out.println(a.getSecondsManLived(birthDay, LocalDate.of(1998, 12, 31)));
        System.out.println(a.getTimeFromTimeZone(timeZone));
        System.out.println(a.wordCountInFile("/home/knoldus/workspace/day-two-java/src/main/resources/Demo.txt"));
    }


}
