package com.knoldus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.time.ZoneOffset.UTC;

public class AllFunctions extends Const {
    /**
     * getStudentsWithoutSecondaryAddress method gives the solution for the first part of Assignment-1.
     * In this a list of students is analysed and a list is returned of the users who don't have a secondary address.
     *
     * @param listOfStudents a list containing objects of Student class
     * @return a list of Student that doesn't has a secondary address
     */
    List<Student> getStudentsWithoutSecondaryAddress(List<Student> listOfStudents) {
        return listOfStudents
                .stream()
                .filter(student -> !student.address.secondaryAddress.isPresent())
                .collect(Collectors.toList());
    }

    /**
     * getStudentsWithoutSecondaryAddressAndNameInitial method gives the solution of 2nd part of Assignment 1.
     * It takes 2 inputs i.e a list of Students and your name and returns the list of those users that doesn't have a
     * secondary address and also the name starts with the initial of your name.
     *
     * @param listOfStudents a list containing objects of Student class
     * @param name           a String that has your name
     * @return a list of Student that doesn't has a secondary address and also the name of the student starts with
     *     initial letter of name.
     */
    List<Student> getStudentsWithoutSecondaryAddressAndNameInitial(List<Student> listOfStudents, String name) {
        return listOfStudents
                .stream()
                .filter(student -> !student.address.secondaryAddress.isPresent()
                        && (student.name.toLowerCase().charAt(0) == name.toLowerCase().charAt(0)))
                .collect(Collectors.toList());
    }

    /**
     * getBirthDateDayOfWeek method is a solution to Assignment-2.
     * It lists all the day of week of your birthday till date.
     *
     * @param birthDate a LocalDate as input i.e. your birthDate
     * @return a list of type String that has the day of week of birthday till date
     */
    List<String> getBirthDateDayOfWeek(LocalDate birthDate) {
        int currentYear = LocalDate.now().getYear();
        int birthYear = birthDate.getYear();
        int birthMonth = birthDate.getMonthValue();
        int birthDay = birthDate.getDayOfMonth();
        if (birthMonth < 10) {
            if (birthDay < 10) {
                return IntStream
                        .range(birthYear, currentYear)
                        .mapToObj(year -> LocalDate.parse(year + "-0" + birthMonth + "-0" + birthDay).getDayOfWeek()
                                .toString())
                        .collect(Collectors.toList());

            } else {
                return IntStream
                        .range(birthYear, currentYear)
                        .mapToObj(year -> LocalDate.parse(year + "-0" + birthMonth + "-" + birthDay)
                                .getDayOfWeek()
                                .toString())
                        .collect(Collectors.toList());

            }
        } else {
            if (birthDay < 10) {
                return IntStream
                        .range(birthYear, currentYear)
                        .mapToObj(year -> LocalDate.parse(year + "-" + birthMonth + "-0" + birthDay)
                                .getDayOfWeek()
                                .toString())
                        .collect(Collectors.toList());

            } else {
                return IntStream
                        .range(birthYear, currentYear)
                        .mapToObj(year -> LocalDate.parse(year + "-" + birthMonth + "-" + birthDay)
                                .getDayOfWeek()
                                .toString())
                        .collect(Collectors.toList());

            }
        }
    }

    /**
     * getTimeFromTimeZone method is the solution to Assignment-3.
     * It is used to give time of given timeZone.
     *
     * @param timeZone zoneId of which yo want to find the time
     * @return time at the timeZone
     */
    String getTimeFromTimeZone(String timeZone) {
        ZonedDateTime timeOfTimeZone = ZonedDateTime.now(ZoneId.of(timeZone));
        return String.valueOf(timeOfTimeZone.withZoneSameInstant(UTC));
    }

    /**
     * getSecondsManLived method is a solution to Assignment-4.
     * It takes birth date and death date as input and calculates the days between them and afterwards calculates the
     * seconds the person lived.
     *
     * @param birthDate a LocalDate type birth date
     * @param deathDate a LocalDate type death date
     * @return the seconds a man lived
     */
    long getSecondsManLived(LocalDate birthDate, LocalDate deathDate) {
        long noOfDays = ChronoUnit.DAYS.between(birthDate, deathDate);
        return noOfDays * 24 * 60 * 60;
    }

    /**
     * getLeapYearsAfterRepublicDay method is a solution to Assignment-5.
     * It finds all the leap years from the first republic day of India till date.
     *
     * @return a list of all the leap years from first Republic day till date
     */
    List<Integer> getLeapYearsAfterRepublicDay() {
        int currentYear = LocalDate.now().getYear();
        return IntStream
                .rangeClosed(yearOfRepublicDay, currentYear)
                .filter(year -> LocalDate.parse(year + firstDay).isLeapYear())
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * wordCountInFile method is a solution to Assignment-6.
     * It reads a file and counts the occurrences of words.
     *
     * @param fileName takes the name of the file
     * @return a map having word as key and it's occurrences count as value
     */
    public Map<String, Integer> wordCountInFile(String fileName) {

        String contentOfFile = null;
        try {
            contentOfFile = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException ioexception) {
            ioexception.printStackTrace();
        }

        List<String> listOfString = Stream.of(contentOfFile).filter(Objects::nonNull)
                .map(word -> word.split("\\s+"))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());

        return listOfString.stream()
                .collect(Collectors.toMap(String::toLowerCase, word -> 1, Integer::sum));

    }
}
