import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class NewSoftware extends JFrame{
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
    private JButton addSoftwareButton, saveSoftwareButton, closeButton;
    // Employee Map
    private Map<Integer, Employee> employees;
    private Map.Entry<Integer, Employee> entry;


    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public NewSoftware() {
        initNewSoftware();
    }

    // Argument Constructor
    public NewSoftware(Map.Entry<Integer, Employee> empSoft) {
        this.entry = empSoft;
        initNewSoftware();
    }


    // -----------------------------------
    // Initialisation
    // -----------------------------------

    private void initNewSoftware() {
        // Main Contents
        this.setLayout(null);
        this.setTitle("Employee Software Tracker | New Software");
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

        this.add(versionNumberLabel);
        this.add(expiryDateLabel);
        this.add(licenseTypeLabel);
        this.add(versionNumberField);
        this.add(expiryDateField);
        this.add(licenseTypeField);

        // Save Software Button
        saveSoftwareButton = new JButton("Save & Close");
        saveSoftwareButton.setBounds(250, 495, 150, 25);
        this.add(saveSoftwareButton);

        // Close Button
        closeButton = new JButton("Close");
        closeButton.setBounds(250, 525, 150, 25);
        this.add(closeButton);

        // -----------------------------------
        // Listeners
        // -----------------------------------

        // Save Software info
        saveSoftwareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
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

    private void saveData() {
        Software newSoft = new Software();
        addSoftware(newSoft);
    }

    private void addSoftware(Software newSoft) {
        newSoft.companyNameValid(companyNameField.getText());
        newSoft.softwareNameValid(softwareNameField.getText());
        newSoft.companyAddress.stateValid(compStateField.getText());
        newSoft.companyAddress.cityValid(compCityField.getText());
        newSoft.companyAddress.postCodeValid(compPostcodeField.getText());
        newSoft.companyAddress.streetAddressValid(compStreetAddressField.getText());
        newSoft.versionNumberValid(versionNumberField.getText());
        newSoft.expiryDateValid(expiryDateField.getText());
        newSoft.licenseTypeValid(licenseTypeField.getSelectedItem().toString());

        entry.getValue().programs.add(newSoft);
    }
}
