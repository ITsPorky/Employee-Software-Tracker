// Employee Class
import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;

public class Employee {

    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    private Integer empID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    // Address object 
    Address address;
    // Employees installed Softwares
    ArrayList<Software> programs;
    // List next/previous
    Map.Entry<Integer, Employee> next;
    Map.Entry<Integer, Employee> previous;
    // Validation Scanner
    Scanner sc = new Scanner(System.in);

    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public Employee() {
        empID = 0;
        firstName = "";
        lastName = "";
        email = "";
        phoneNumber = "";
        address = new Address();
        programs = new ArrayList<Software>();
    }

    // Agument constructor
    public Employee(Integer empID,
                    String firstName, 
                    String lastName,
                    String email,
                    String phoneNumber,
                    String state, 
                    String city,
                    String postCode,
                    String streetAddress) {
        setEmpID(empID);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        address = new Address(state, city, postCode, streetAddress);
        programs = new ArrayList<Software>();
    }

    // -----------------------------------
    // Methods
    // -----------------------------------

    // Setters and Getters

    // Employee ID
    private void setEmpID(Integer empID) {
        this.empID = empID;
    }
    private Integer getEmpID() {
        return empID;
    }
    public void inputEmpID(Integer empID) {
        setEmpID(empID);
    }
    public Integer grabEmpID() {
        return getEmpID();
    }

    // First Name
    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    private String getFirstName() {
        return firstName;
    }
    public void inputFirstName(String firstName) {
        setFirstName(firstName);
    }
    public String grabFirstName() {
        return getFirstName();
    }

    // Last Name
    private void setLastName(String lastName) {
        this.lastName = lastName;
    }
    private String getLastName() {
        return lastName;
    }
    public void inputLastName(String lastName) {
        setLastName(lastName);
    }
    public String grabLastName() {
        return getLastName();
    }

    // Email
    private void setEmail(String email) {
        this.email = email;
    }
    private String getEmail() {
        return email;
    }
    public void inputEmail(String email) {
        setEmail(email);
    }
    public String grabEmail() {
        return getEmail();
    }

    // Phone Number
    private void setPhoneNumber(String phoneNumber) {
        this.phoneNumber= phoneNumber;
    }
    private String getPhoneNumber() {
        return phoneNumber;
    }
    public void inputPhoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
    }
    public String grabPhoneNumber() {
        return getPhoneNumber();
    }
    

    // Validation Methods

    // Employee ID Valid
    public void empIDValid(String input) {
        boolean flag;
        do {
            String IDPattern = "[0-9]{1,25}";
            flag = input.matches(IDPattern);
            if (!flag) {
                System.out.println("Invalid Employee ID");
                JPopupMenu error = new JPopupMenu("Error: Invalid Input");

                break;
            }
        } while (!flag);
        System.out.println("Valid Employee ID");
        System.out.println("The Employee ID " + input + " has been set\n");

        setEmpID(Integer.parseInt(input));
    }

    // First Name Validation
    public void fnameValid(String input) {
        boolean flag;
                do {
            String namePattern = "[a-zA-Z\\s]{3,25}";
            flag = input.matches(namePattern);
            if (!flag) System.out.println("Invalid first name");
        } while (!flag);
        System.out.println("Valid first name");
        System.out.println("The first name " + input + " has been set\n");
        
        setFirstName(input);
    }

    // Last Name Validation
    public void lnameValid(String input) {
        boolean flag;
        do {
            String namePattern = "[a-zA-Z\\s]{3,25}";
            flag = input.matches(namePattern);
            if (!flag) System.out.println("Invalid last name");
        } while (!flag);
        System.out.println("Valid last name");
        System.out.println("The last name " + input + " has been set\n");
        
        setLastName(input);
    }

    // Email Validation
    public void emailValid(String input) {
        boolean flag;
        do {
            String emailPattern = "[a-zA-Z0-9.\\s]{3,15}@[a-zA-Z0-9\\s]{3,15}[.\\s][a-zA-Z\\s]{2,5}";
            flag = input.matches(emailPattern);
            if (!flag) System.out.println("Invalid email");
        } while (!flag);
        System.out.println("Valid email");
        System.out.println("The email " + input + " has been set\n");

        setEmail(input);
    }

    // Phone Number Validation
    public void phoneNumberValid(String input) {
        boolean flag;
        do {
            String phonePattern = "[0-9\\s]{10}";
            flag = input.matches(phonePattern);
            if(!flag) System.out.println("Invalid phone number");
        } while (!flag);
        System.out.println("Valid phone number");
        System.out.println("The phone number " + input + " has been set\n");
        
        setPhoneNumber(input);
    }

    // Output Of Employee Objects 
    @Override
    public String toString() {
        return getEmpID() + "\n" +
         getFirstName() + "\n" + 
         getLastName() + "\n" +
         getEmail() + "\n" +
         getPhoneNumber() + "\n" + 
         address.toString() + "\n" +
         programs;
    }
    
}