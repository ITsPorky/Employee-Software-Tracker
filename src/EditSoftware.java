import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class EditSoftware extends JFrame {
    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    // Software Labels/Fields
    private JLabel companyNameLabel, softwareNameLabel, compStateLabel, compCityLabel, compPostcodeLabel, compStreetAddressLabel,
            versionNumberLabel, expiryDateLabel, licenseTypeLabel;
    private JTextField companyNameField, softwareNameField, compStateField, compCityField, compPostcodeField,
            compStreetAddressField, versionNumberField, expiryDateField;
    private JComboBox licenseTypeField;
    private String[] types = {"Personal", "Company", "Student"};
    // Buttons
    private JButton closeButton, saveButton;
    // Employee Map
    private Map<Integer, Employee> employees;
    private Map.Entry<Integer, Employee> entry;
    // Software Index
    private Integer index;


    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public EditSoftware() {
        initEditSoftware();
        showSoftware(entry, index);
    }

    // Argument Constructor
    public EditSoftware(Map<Integer, Employee> employee, Map.Entry<Integer, Employee> entrySoft, Integer softIndex) {
        this.employees = employee;
        this.entry = entrySoft;
        this.index = softIndex;
        initEditSoftware();
        showSoftware(entry, index);
    }


    // -----------------------------------
    // Initialisation
    // -----------------------------------

    private void initEditSoftware() {
        // Main Contents
        this.setLayout(null);
        this.setTitle("Employee Software Tracker | Edit Software");
        this.setSize(675, 600);

        // Center New Window
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        // Labels/Fields for software
        companyNameLabel = new JLabel("Company Name:");
        companyNameField = new JTextField("ex. Adobe");
        companyNameField.setFont(new Font("Arial", Font.PLAIN, 12));
        companyNameLabel.setBounds(50, 5, 150, 25);
        companyNameField.setBounds(50, 30, 150, 25);

        softwareNameLabel = new JLabel("Software Name:");
        softwareNameField = new JTextField("ex. Photoshop");
        softwareNameField.setFont(new Font("Arial", Font.PLAIN, 12));
        softwareNameLabel.setBounds(250, 5, 150, 25);
        softwareNameField.setBounds(250, 30, 150, 25);

        compStateLabel = new JLabel("State:");
        compStateField = new JTextField("ex. QLD");
        compStateField.setFont(new Font("Arial", Font.PLAIN, 12));
        compStateLabel.setBounds(450, 5, 150, 25);
        compStateField.setBounds(450, 30, 150, 25);

        compCityLabel = new JLabel("City:");
        compCityField = new JTextField("ex. Brisbane");
        compCityField.setFont(new Font("Arial", Font.PLAIN, 12));
        compCityLabel.setBounds(50, 60, 150, 25);
        compCityField.setBounds(50, 90, 150, 25);

        compPostcodeLabel = new JLabel("Post Code:");
        compPostcodeField = new JTextField("ex. 4000");
        compPostcodeField.setFont(new Font("Arial", Font.PLAIN, 12));
        compPostcodeLabel.setBounds(250, 60, 150, 25);
        compPostcodeField.setBounds(250, 90, 150, 25);

        compStreetAddressLabel = new JLabel("Street Address:");
        compStreetAddressField = new JTextField("4 John Close");
        compStreetAddressField.setFont(new Font("Arial", Font.PLAIN, 12));
        compStreetAddressLabel.setBounds(450, 60, 150, 25);
        compStreetAddressField.setBounds(450, 90, 150, 25);

        versionNumberLabel = new JLabel("Version Number:");
        versionNumberField = new JTextField(" ex. 1.12.7");
        versionNumberField.setFont(new Font("Arial", Font.PLAIN, 12));
        versionNumberLabel.setBounds(50, 120, 150, 25);
        versionNumberField.setBounds(50, 150, 150, 25);

        expiryDateLabel = new JLabel("Expiry Date:");
        expiryDateField = new JTextField("ex. 5/11/2023");
        expiryDateField.setFont(new Font("Arial", Font.PLAIN, 12));
        expiryDateLabel.setBounds(250, 120, 150, 25);
        expiryDateField.setBounds(250, 150, 150, 25);

        licenseTypeLabel = new JLabel("License Type:");
        licenseTypeField = new JComboBox(types);
        licenseTypeField.setFont(new Font("Arial", Font.PLAIN, 12));
        licenseTypeLabel.setBounds(450, 120, 150, 25);
        licenseTypeField.setBounds(450, 150, 150, 25);

        // Top Row
        this.add(companyNameLabel);
        this.add(softwareNameLabel);
        this.add(compStateLabel);
        this.add(companyNameField);
        this.add(softwareNameField);
        this.add(compStateField);
        // 2nd Row
        this.add(compCityLabel);
        this.add(compPostcodeLabel);
        this.add(compStreetAddressLabel);
        this.add(compCityField);
        this.add(compPostcodeField);
        this.add(compStreetAddressField);
        // 3rd Row
        this.add(versionNumberLabel);
        this.add(expiryDateLabel);
        this.add(licenseTypeLabel);
        this.add(versionNumberField);
        this.add(expiryDateField);
        this.add(licenseTypeField);

        // Save Button
        saveButton = new JButton("Save Data");
        saveButton.setBounds(250, 495, 150, 25);
        this.add(saveButton);

        // Close Button
        closeButton = new JButton("Close Window");
        closeButton.setBounds(250, 525, 150, 25);
        this.add(closeButton);

        // -----------------------------------
        // Listeners
        // -----------------------------------
        // Save Edited Employee
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSoftware(entry, index);
                FileOutput output = new FileOutput(employees);
                dispose();
            }
        });

        // Close Button
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

    private void showSoftware(Map.Entry<Integer, Employee> entry, int index) {
        // File employee software data
        companyNameField.setText(entry.getValue().programs.get(index).grabCompanyName());
        softwareNameField.setText(entry.getValue().programs.get(index).grabSoftwareName());
        compStateField.setText(entry.getValue().programs.get(index).companyAddress.grabState());
        compCityField.setText(entry.getValue().programs.get(index).companyAddress.grabCity());
        compPostcodeField.setText(entry.getValue().programs.get(index).companyAddress.grabPostCode());
        compStreetAddressField.setText(entry.getValue().programs.get(index).companyAddress.grabStreetAddress());
        versionNumberField.setText(entry.getValue().programs.get(index).grabVersionNumber());
        expiryDateField.setText(entry.getValue().programs.get(index).grabExpiryDate());
        licenseTypeField.setSelectedItem(entry.getValue().programs.get(index).grabLicenseType());
    }

    private void addSoftware(Map.Entry<Integer, Employee> entry, int index) {
        // Update Software Data
        entry.getValue().programs.get(index).companyNameValid(companyNameField.getText());
        entry.getValue().programs.get(index).softwareNameValid(softwareNameField.getText());
        entry.getValue().programs.get(index).companyAddress.stateValid(compStateField.getText());
        entry.getValue().programs.get(index).companyAddress.cityValid(compCityField.getText());
        entry.getValue().programs.get(index).companyAddress.postCodeValid(compPostcodeField.getText());
        entry.getValue().programs.get(index).companyAddress.streetAddressValid(compStreetAddressField.getText());
        entry.getValue().programs.get(index).versionNumberValid(versionNumberField.getText());
        entry.getValue().programs.get(index).expiryDateValid(expiryDateField.getText());
        entry.getValue().programs.get(index).licenseTypeValid(licenseTypeField.getSelectedItem().toString());
    }

}
