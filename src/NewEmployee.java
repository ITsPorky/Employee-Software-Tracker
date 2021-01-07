import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class NewEmployee extends JFrame {
    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    // Labels
    // Employee Labels/Fields
    private JLabel empIDLabel, fNameLabel, lNameLabel, emailLabel, phoneNumberLabel,
            stateLabel, cityLabel, postCodeLabel, streetAddressLabel;
    private JTextField empIDField, fNameField, lNameField, emailField, phoneNumberField,
            stateField, cityField, postCodeField, streetAddressField;
    // Buttons
    private JButton closeButton, addEmpButton, addSoftwareButton;
    // Software Form object
    private SoftwareForm softwareForm;
    // Employee Map
    private Map<Integer, Employee> employees;
    private Map.Entry<Integer, Employee> entry;


    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public NewEmployee() {
        initNewEmployee();
    }

    // Argument Constructor
    public NewEmployee(Map<Integer, Employee> employees) {
        this.employees = employees;
        initNewEmployee();
    }

    // -----------------------------------
    // Initialisation
    // -----------------------------------

    private void initNewEmployee() {
        // Create new Employee
        Employee newEmp = new Employee();

        // Main Panel Contents
        this.setLayout(null);
        this.setTitle("Employee Software Tracker | New Employee");
        this.setSize(675, 600);

        // Center New Window
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        // Report Section Fields/Labels
        empIDLabel = new JLabel("Employee ID:");
        empIDField = new JTextField("ex. 1");
        empIDField.setFont(new Font("Arial", Font.PLAIN, 12));
        empIDLabel.setBounds(50, 5, 150, 25);
        empIDField.setBounds(50, 30, 150, 25);

        fNameLabel = new JLabel("First Name:");
        fNameField = new JTextField("ex. John");
        fNameField.setFont(new Font("Arial", Font.PLAIN, 12));
        fNameLabel.setBounds(250, 5, 150, 25);
        fNameField.setBounds(250, 30, 150, 25);

        lNameLabel = new JLabel("Last Name:");
        lNameField = new JTextField("ex. Doe");
        lNameField.setFont(new Font("Arial", Font.PLAIN, 12));
        lNameLabel.setBounds(450, 5, 150, 25);
        lNameField.setBounds(450, 30, 150, 25);

        emailLabel = new JLabel("Email:");
        emailField = new JTextField("ex. example@domain.com");
        emailField.setFont(new Font("Arial", Font.PLAIN, 12));
        emailLabel.setBounds(50, 60, 150, 25);
        emailField.setBounds(50, 90, 150, 25);

        phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberField = new JTextField("ex. 0400000000");
        phoneNumberField.setFont(new Font("Arial", Font.PLAIN, 12));
        phoneNumberLabel.setBounds(250, 60, 150, 25);
        phoneNumberField.setBounds(250, 90, 150, 25);

        stateLabel = new JLabel("State:");
        stateField = new JTextField("ex. QLD");
        stateField.setFont(new Font("Arial", Font.PLAIN, 12));
        stateLabel.setBounds(450, 60, 150, 25);
        stateField.setBounds(450, 90, 150, 25);

        cityLabel = new JLabel("City:");
        cityField = new JTextField("ex. Toowoomba");
        cityLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        cityLabel.setBounds(50, 120, 150, 25);
        cityField.setBounds(50, 150, 150, 25);

        postCodeLabel = new JLabel("Post Code:");
        postCodeField = new JTextField("ex. 4000");
        postCodeField.setFont(new Font("Arial", Font.PLAIN, 12));
        postCodeLabel.setBounds(250, 120, 150, 25);
        postCodeField.setBounds(250, 150, 150, 25);

        streetAddressLabel = new JLabel("Street Address:");
        streetAddressField = new JTextField("ex. 123 Example Street");
        streetAddressField.setFont(new Font("Arial", Font.PLAIN, 12));
        streetAddressLabel.setBounds(450, 120, 150, 25);
        streetAddressField.setBounds(450, 150, 150, 25);

        // Top Row
        this.add(empIDLabel);
        this.add(fNameLabel);
        this.add(lNameLabel);
        this.add(empIDField);
        this.add(fNameField);
        this.add(lNameField);
        // 2nd Row
        this.add(emailLabel);
        this.add(phoneNumberLabel);
        this.add(stateLabel);
        this.add(emailField);
        this.add(phoneNumberField);
        this.add(stateField);
        // 3rd Row
        this.add(cityLabel);
        this.add(postCodeLabel);
        this.add(streetAddressLabel);
        this.add(cityField);
        this.add(postCodeField);
        this.add(streetAddressField);

        // Add Employee Button
        addEmpButton = new JButton("Save & Close");
        addEmpButton.setBounds(250, 495, 150, 25);
        this.add(addEmpButton);

        // Close Button
        closeButton = new JButton("Close Window");
        closeButton.setBounds(250, 525, 150, 25);
        this.add(closeButton);

        // -----------------------------------
        // Listeners
        // -----------------------------------

        // Add Employee Button
        addEmpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addValues(newEmp);
                FileOutput output = new FileOutput(employees);
                dispose();
            }
        });

        // Close Button
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(newEmp.grabEmpID());
                FileOutput output = new FileOutput(employees);
                dispose();
            }
        });

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }

    // -----------------------------------
    // Methods
    // -----------------------------------

    private void addValues(Employee newEmp) {
        newEmp.empIDValid(empIDField.getText());
        newEmp.fnameValid(fNameField.getText());
        newEmp.lnameValid(lNameField.getText());
        newEmp.emailValid(emailField.getText());
        newEmp.phoneNumberValid(phoneNumberField.getText());
        newEmp.address.stateValid(stateField.getText());
        newEmp.address.cityValid(cityField.getText());
        newEmp.address.postCodeValid(postCodeField.getText());
        newEmp.address.streetAddressValid(streetAddressField.getText());

        employees.put(newEmp.grabEmpID(), newEmp);

    }

}
