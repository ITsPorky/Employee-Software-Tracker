// Form Class
import java.util.Iterator;
import java.util.Map;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Set;
import java.awt.*;

public class EmployeeForm extends JFrame {
    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    // Labels
    // Employee Labels/Fields
    private JLabel empIDLabel, fNameLabel, lNameLabel, emailLabel, phoneNumberLabel,
            stateLabel, cityLabel, postCodeLabel, streetAddressLabel;
    private JTextField empIDField, fNameField, lNameField, emailField, phoneNumberField,
            stateField, cityField, postCodeField, streetAddressField;
    private JTextField searchEmp;
    // Buttons
    private JButton nextButton, previousButton, closeButton, addEmpButton, addSoftwareButton,
            editEmpButton, editSoftwareButton;
    // Software Form object
    private SoftwareForm softwareForm;
    private JScrollPane scrPane;
    // Employee Map
    private Map<Integer, Employee> employees;
    private Set<Map.Entry<Integer, Employee>> entries;
    private Iterator<Map.Entry<Integer, Employee>> iterator;
    private Map.Entry<Integer, Employee> entry;


    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public EmployeeForm() {
        employees = new HashMap<Integer, Employee>();
        entries = employees.entrySet();
        iterator = entries.iterator();
        initForm();
    }

    // Argument Constructor
    public EmployeeForm(Map<Integer, Employee> employees) {
        this.employees = employees;
        entries = employees.entrySet();
        iterator = entries.iterator();
        entry = iterator.next();
        // Initialise Form
        initForm();
        // Fill fields with employee data
        showEmployee();
    }

    // -----------------------------------
    // Initialisation
    // -----------------------------------

    private void initForm() {

        // Main Panel Contents

        this.setLayout(null);
        this.setTitle("Employee Software Tracker | View Employees");
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
        phoneNumberField = new JTextField("ex. 04xxxxxxxx");
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

        // Scroll Pane for Employee Software
        scrPane = new JScrollPane(softwareForm);
        scrPane.setBounds(0, 200, 660, 215);
        scrPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scrPane);

        // Next/Previous Button
        nextButton = new JButton("Next");
        previousButton = new JButton("Previous");
        nextButton.setBounds(350, 425, 100, 25);
        previousButton.setBounds(200, 425, 100, 25);
        this.add(nextButton);
        this.add(previousButton);

        // Search Employee
        searchEmp = new JTextField("");
        searchEmp.setText(entry.getValue().grabEmpID().toString());
        searchEmp.setBounds(315, 425, 20, 25);
        this.add(searchEmp);

        // Add Employee Button
        addEmpButton = new JButton("Add Employee");
        addEmpButton.setBounds(150, 455, 150, 25);
        this.add(addEmpButton);

        // Add Software Button
        addSoftwareButton = new JButton("Add Software");
        addSoftwareButton.setBounds(350, 455, 150, 25);
        this.add(addSoftwareButton);

        // Edit Employee Button
        editEmpButton = new JButton("Edit Employee");
        editEmpButton.setBounds(150, 485, 150, 25);
        this.add(editEmpButton);

        // Edit Software Button
        editSoftwareButton = new JButton("Edit Software");
        editSoftwareButton.setBounds(350, 485, 150, 25);
        this.add(editSoftwareButton);

        // Close Button
        closeButton = new JButton("Close Window");
        closeButton.setBounds(250, 525, 150, 25);
        this.add(closeButton);

        // -----------------------------------
        // Listeners
        // -----------------------------------

        // Next Button Function
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (iterator.hasNext()) {
                    entry.getValue().next = iterator.next();
                    entry.getValue().next.getValue().previous = entry;
                }
                if (entry.getValue().next != null) {
                    entry = entry.getValue().next;
                    showEmployee();
                }
                // Update search box number
                searchEmp.setText(entry.getValue().grabEmpID().toString());
            }
        });

        // Search Field
        searchEmp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer userInput = Integer.parseInt(searchEmp.getText());
                if(entry.getValue().grabEmpID() < userInput) {
                    while (entry.getValue().grabEmpID() < userInput) {
                        if (iterator.hasNext()) {
                            entry.getValue().next = iterator.next();
                            entry.getValue().next.getValue().previous = entry;
                        }
                        if (entry.getValue().next != null) {
                            entry = entry.getValue().next;
                            showEmployee();
                        }
                    }
                }else if(entry.getValue().grabEmpID() > userInput) {
                    while (entry.getValue().grabEmpID() > userInput) {
                        if (entry.getValue().previous != null) {
                            entry = entry.getValue().previous;
                            showEmployee();
                        }
                    }
                }
                // Update search box number
                searchEmp.setText(entry.getValue().grabEmpID().toString());
            }
        });

        // Previous Button Function
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (entry.getValue().previous != null) {
                    entry = entry.getValue().previous;
                    showEmployee();
                }
                // Update search box number
                searchEmp.setText(entry.getValue().grabEmpID().toString());
            }
        });

        // Add Employee Button
        addEmpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewEmployee newEmp = new NewEmployee(employees);
                dispose();
            }
        });

        // Add Software Button
        addSoftwareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewSoftware newSoft = new NewSoftware(entry);
                dispose();
            }
        });

        // Edit Employee Button
        editEmpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditEmployee editEmp = new EditEmployee(employees, entry);
                dispose();
            }
        });

        // Edit Software Button
        editSoftwareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditSoftware editSoftware = new EditSoftware(employees, entry, softwareForm.grabIndex());
                dispose();
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileOutput output = new FileOutput(employees);
                dispose();
            }
        });

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }

    // -----------------------------------
    // Methods
    // -----------------------------------

    private void showEmployee() {
        // Fill employee data in fields
        empIDField.setText(entry.getValue().grabEmpID().toString());
        fNameField.setText(entry.getValue().grabFirstName());
        lNameField.setText(entry.getValue().grabLastName());
        emailField.setText(entry.getValue().grabEmail());
        phoneNumberField.setText(entry.getValue().grabPhoneNumber());
        stateField.setText(entry.getValue().address.grabState());
        cityField.setText(entry.getValue().address.grabCity());
        postCodeField.setText(entry.getValue().address.grabPostCode());
        streetAddressField.setText(entry.getValue().address.grabStreetAddress());


        displaySoftware();
        scrPane.repaint();
    }

    private void displaySoftware() {

        for(int i = 0; i < entry.getValue().programs.size(); i++) {
            softwareForm = new SoftwareForm(entry, i);
        }
        scrPane.getViewport().add(softwareForm);
    }

}