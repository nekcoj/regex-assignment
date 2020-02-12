package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {

    String pn1 = "08-12 34 56";
    String pn2 = "040-123 45";
    String pn3 = "0704-12 34 56";
    String pn4 = "0707321654";
    String pn5 = "0707 555 666";
    String eMail1 = "nekcoj@gmail.com";
    String eMail2 = "d@a.c";
    String bdate1 = "1990-08-21 1234";
    String bdate2 = "9008211234";
    String bdate3 = "900821-1234";
    String bdate4 = "1918-09-22 2345";
    String bdate5 = "180922+2345";
    String eMail3 = "nekcoj@gmail.co.uk";
    String pword1 = "Ih/2dNM1.GYP9\"EE";
    String pword2 = "4>E\"rFwu[f\"5Qb'c";
    String pword3 = "wU*n,f)f.HW0od5V";
    String pword4 = ">S/ml:R^KlQT*Z'%";
    String pword5 = ",-OFFAnBRx.S}\\HT";
    Scanner scan = new Scanner(System.in);
    Stream<String> text1 = Files.lines(Paths.get("text1"));
    Stream<String> text2 = Files.lines(Paths.get("text2"));


    public Program() throws IOException {
        checkPhoneNumbers();
        checkEmail();
        checkBirthdate();
        checkPassword();
        checkText();

    }
    public void checkPhoneNumbers() {
        System.out.printf("Phonenumber %s is %s\n", pn1, validatePhoneNumber(pn1));
        System.out.printf("Phonenumber %s is %s\n", pn2, validatePhoneNumber(pn2));
        System.out.printf("Phonenumber %s is %s\n", pn3, validatePhoneNumber(pn3));
        System.out.printf("Phonenumber %s is %s\n", pn4, validatePhoneNumber(pn4));
        System.out.printf("Phonenumber %s is %s\n", pn5, validatePhoneNumber(pn5));
    }
    public void checkEmail(){
        System.out.printf("E-mail %s is %s\n", eMail1, validateEMail(eMail1));
        System.out.printf("E-mail %s is %s\n", eMail2, validateEMail(eMail2));
        System.out.printf("E-mail %s is %s\n", eMail3, validateEMail(eMail3));
    }

    public void checkBirthdate(){
        System.out.printf("Bday %s is %s\n", bdate1, validateBirthdate(bdate1));
        System.out.printf("Bday %s is %s\n", bdate2, validateBirthdate(bdate2));
        System.out.printf("Bday %s is %s\n", bdate3, validateBirthdate(bdate3));
        System.out.printf("Bday %s is %s\n", bdate4, validateBirthdate(bdate4));
        System.out.printf("Bday %s is %s\n", bdate5, validateBirthdate(bdate5));
    }

    public void checkPassword(){
        System.out.printf("Password %s is %s\n", pword1, validatePassword(pword1));
        System.out.printf("Password %s is %s\n", pword2, validatePassword(pword2));
        System.out.printf("Password %s is %s\n", pword3, validatePassword(pword3));
        System.out.printf("Password %s is %s\n", pword4, validatePassword(pword4));
        System.out.printf("Password %s is %s\n", pword5, validatePassword(pword5));
//        System.out.println(validatePassword(scan.nextLine()));
    }

    public void checkText(){
        text1.map(s-> s.replaceAll("\\d+", ""))
                .filter(s-> !s.isBlank())
                .collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("<---------------------------->");

        text2.map(s-> s.replaceAll("\\s+", " ")
                .trim())
                .collect(Collectors.toList()).forEach(System.out::println);
    }

    public boolean validatePhoneNumber(String phoneNumber){
        return phoneNumber.matches("[\\d]+-?[\\d]+ ?[\\d]+ ?[\\d]+ ?[\\d]+");
    }

    public boolean validateEMail(String eMail){
        return eMail.matches("\\w{2,}@\\w{2,}.{2,}");
    }

    public boolean validateBirthdate(String birthdate){
        return birthdate.matches("[\\d]+([-+])?[\\d]+([- ])?[\\d]+ ?[\\d]+");
    }

    public boolean validatePassword(String password){
        return password.matches(".{8,}")
                && password.matches(".*[0-9]+.*")
                && password.matches(".*[A-ZÅ-Ö]+.*")
                && password.matches(".*[a-zå-ö]+.*")
                && !password.matches(".*\\\\.*")
                && password.matches(".*\\w.*");
    }
}
