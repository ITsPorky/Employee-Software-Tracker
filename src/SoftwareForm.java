// Software Form
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.*;

public class SoftwareForm extends JPanel {
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
    private JButton editSoftwareButton;
    // Employee Map
    private Map<Integer, Employee> employees;
    private Map.Entry<Integer, Employee> entry;

    // Index Counter
    private int index;


    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public SoftwareForm() {
        initSoftwareForm();
        showSoftware(entry, index);
    }

    // Argument Constructor
    public SoftwareForm(Map.Entry<Integer, Employee> empSoft, int i) {
        this.entry = empSoft;
        this.index = i;
//        for(index = 0; index < entry.getValue().programs.size(); index++) {
            initSoftwareForm();
            showSoftware(entry, index);
//        }
    }


    // -----------------------------------
    // Initialisation
    // -----------------------------------

    private void initSoftwareForm() {

        // Main Contents
        this.setLayout(null);
        this.setBounds(0, 200, 600, 200);

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

        // Edit Software Button
        editSoftwareButton = new JButton("Edit Software");
        editSoftwareButton.setBounds(250, 185, 150, 25);
        this.add(editSoftwareButton);

        // -----------------------------------
        // Listeners
        // -----------------------------------

        // Edit Software Button
        editSoftwareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditSoftware editSoftware = new EditSoftware(employees, entry, index);
            }
        });

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

    // -----------------------------------
    // Setters and Getters
    // -----------------------------------

    private int getIndex() {
        return index;
    }
    public int grabIndex() {
        return getIndex();
    }
}