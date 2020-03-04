package com.knoldus;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static com.knoldus.Const.monthOfBirth;
import static com.knoldus.Const.yearOfBirth;
import static com.knoldus.Const.dayOfBirth;
import static com.knoldus.Const.timeZone;
import static com.knoldus.Const.yearOfDeath;
import static com.knoldus.Const.monthOfDeath;
import static com.knoldus.Const.dayOfDeath;
import static com.knoldus.Const.name;
import static com.knoldus.Const.nameOfFile;


public class AppDriver {
    public static void main(String[] args) {
        AllFunctions functionUser = new AllFunctions();
        List<Student> listOfStudents = Arrays.asList(
                new Student(1, "Pushkar", 20, new Address("Delhi", "Sarita Vihar")),
                new Student(2, "Alice", 26, new Address("Dehradun")),
                new Student(5, "Joy", 30, new Address("Faridabad", "Noida")),
                new Student(7, "Shivam", 21, new Address("Mumbai", "Sarita Vihar")),
                new Student(8, "Malice", 22, new Address("Kolkata", "Noida")),
                new Student(9, "Merry", 18, new Address("Chennai")));
        System.out.println("Assignment-1 Part-1" + functionUser.getStudentsWithoutSecondaryAddress(listOfStudents));
        System.out.println("Assignment-1 Part-2"
                + functionUser.getStudentsWithoutSecondaryAddressAndNameInitial(listOfStudents, name));

        LocalDate birthDay = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        System.out.println("Assignment-2" + functionUser.getBirthDateDayOfWeek(birthDay));

        System.out.println("Assignment-3" + functionUser.getTimeFromTimeZone(timeZone));

        System.out.println("Assignment -4"
                + functionUser.getSecondsManLived(birthDay, LocalDate.of(yearOfDeath, monthOfDeath, dayOfDeath)));

        System.out.println("Assignment-5" + functionUser.getLeapYearsAfterRepublicDay());

        System.out.println("Assignment-6" + functionUser.wordCountInFile(nameOfFile));
    }


}
