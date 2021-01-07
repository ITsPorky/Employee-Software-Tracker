import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SortByExpiry extends JFrame{
    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    private JLabel empIDLabel, fNameLabel, lNameLabel, emailLabel, phoneNumberLabel,
            stateLabel, cityLabel, postCodeLabel, streetAddressLabel, spacing;
    private JButton closeButton;

    private SoftwareForm softwareForm;

    private Map<Integer, Employee> employees;
    private Set<Map.Entry<Integer, Employee>> entries;
    private Iterator<Map.Entry<Integer, Employee>> iterator;
    private Map.Entry<Integer, Employee> entry;


    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public SortByExpiry() {
        this.employees = employees;
        entries = employees.entrySet();
        iterator = entries.iterator();
        initReport();
    }

    // Argument Constructor
    public SortByExpiry(Map<Integer, Employee> employees) {
        this.employees = employees;
        entries = employees.entrySet();
        iterator = entries.iterator();
        entry = iterator.next();

        initReport();
    }


    // -----------------------------------
    // Initialisation
    // -----------------------------------

    private void initReport() {
        // Main Contents
        this.setLayout(null);
        this.setTitle("Employee Software Tracker | Report: Sorted By Expiry date");
        this.setSize(675, 600);

        // Center New Window
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        // Placement Variables
        int[] x = {50, 250, 450};
        int y = 0;

        // Display First Employee
        y += 5;

        // Labels/Fields
        empIDLabel = new JLabel("");
        empIDLabel.setBounds(x[0], y, 150, 25);

        y += 30;

        fNameLabel = new JLabel("");
        fNameLabel.setBounds(x[0], y, 150, 25);

        lNameLabel = new JLabel("");
        lNameLabel.setBounds(x[1], y, 150, 25);

        y += 30;

        emailLabel = new JLabel("");
        emailLabel.setBounds(x[0], y, 150, 25);

        phoneNumberLabel = new JLabel("");
        phoneNumberLabel.setBounds(x[1], y, 150, 25);

        stateLabel = new JLabel("");
        stateLabel.setBounds(x[2], y, 150, 25);

        y += 30;

        cityLabel = new JLabel("");
        cityLabel.setBounds(x[0], y, 150, 25);

        postCodeLabel = new JLabel("");
        postCodeLabel.setBounds(x[1], y, 150, 25);

        streetAddressLabel = new JLabel("");
        streetAddressLabel.setBounds(x[2], y, 150, 25);

        y += 40;

        spacing = new JLabel("");
        spacing.setBounds(x[1], y, 150, 25);

        // Top Row
        this.add(empIDLabel);
        this.add(fNameLabel);
        this.add(lNameLabel);
        // 2nd Row
        this.add(emailLabel);
        this.add(phoneNumberLabel);
        this.add(stateLabel);
        // 3rd Row
        this.add(cityLabel);
        this.add(postCodeLabel);
        this.add(streetAddressLabel);
        // Add space
        this.add(spacing);

        // Software Form
//        softwareForm = new SoftwareForm(entry);
//        this.add(softwareForm);

        showData();

        // Display The Rest of Employees
        while(iterator.hasNext()) {
            entry = iterator.next();
            // Placement Variables
            y += 5;

            // Labels/Fields
            empIDLabel = new JLabel("");
            empIDLabel.setBounds(x[0], y, 150, 25);

            y += 30;

            fNameLabel = new JLabel("");
            fNameLabel.setBounds(x[0], y, 150, 25);

            lNameLabel = new JLabel("");
            lNameLabel.setBounds(x[1], y, 150, 25);

            y += 30;

            emailLabel = new JLabel("");
            emailLabel.setBounds(x[0], y, 150, 25);

            phoneNumberLabel = new JLabel("");
            phoneNumberLabel.setBounds(x[1], y, 150, 25);

            stateLabel = new JLabel("");
            stateLabel.setBounds(x[2], y, 150, 25);

            y += 30;

            cityLabel = new JLabel("");
            cityLabel.setBounds(x[0], y, 150, 25);

            postCodeLabel = new JLabel("");
            postCodeLabel.setBounds(x[1], y, 150, 25);

            streetAddressLabel = new JLabel("");
            streetAddressLabel.setBounds(x[2], y, 150, 25);

            y += 40;

            spacing = new JLabel("");
            spacing.setBounds(x[1], y, 150, 25);

            // Top Row
            this.add(empIDLabel);
            this.add(fNameLabel);
            this.add(lNameLabel);
            // 2nd Row
            this.add(emailLabel);
            this.add(phoneNumberLabel);
            this.add(stateLabel);
            // 3rd Row
            this.add(cityLabel);
            this.add(postCodeLabel);
            this.add(streetAddressLabel);
            // Add space
            this.add(spacing);

            // Software Form
//            softwareForm = new SoftwareForm(entry);
//            this.add(softwareForm);

            showData();

        }

        // Close Button
        closeButton = new JButton("Close Window");
        closeButton.setBounds(250, 525, 150, 25);
        this.add(closeButton);


        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }

    private void showData() {
        // Fill employee data in fields
        empIDLabel.setText(entry.getValue().grabEmpID().toString());
        fNameLabel.setText(entry.getValue().grabFirstName());
        lNameLabel.setText(entry.getValue().grabLastName());
        emailLabel.setText(entry.getValue().grabEmail());
        phoneNumberLabel.setText(entry.getValue().grabPhoneNumber());
        stateLabel.setText(entry.getValue().address.grabState());
        cityLabel.setText(entry.getValue().address.grabCity());
        postCodeLabel.setText(entry.getValue().address.grabPostCode());
        streetAddressLabel.setText(entry.getValue().address.grabStreetAddress());
    }

}
