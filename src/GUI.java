// GUI Class
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI extends JFrame {

    // ----------------------------------
    // Variables/Fields
    // ----------------------------------
 
    private JFileChooser fileChooser;
    private String filePath;

    private Map<Integer, Employee> employees;

    // Buttons
    private JButton openFileButton, exitButton, employeeButton, addEmpButton, empReport;

    // Menu Fields
    private JMenu fileMenu;
    private JMenuItem open;

    private JMenu report;
    private JMenuItem sortByEmp, sortByExpiry, allSoftware, chooseEmp, chooseSoftware;

    private JMenu view;
    private JMenuItem viewEmployees;

    // Panels
    private JPanel center;

    // ----------------------------------
    // Constructors
    // ----------------------------------

    // Default Constructor
    public GUI() {
        employees = new HashMap<Integer, Employee>();
        chooseFile();
        // Pass values to input
        FileInput input = new FileInput(filePath, employees);
        // Initialise GUI Window
        initWindow();
    }


    // -----------------------------------
    // Initialisation
    // -----------------------------------

    // Initialise Window
    private void initWindow() {
        // Initialise the GUI
        // Methods
        this.setLayout(new BorderLayout());
        this.setTitle("Employee Software Tracker");
        this.setSize(900, 600);

        // Menu
        // Menu 1
        JMenuBar menuBar = new JMenuBar();
        this.add(menuBar);
        fileMenu = new JMenu("File");
        open = new JMenuItem("Open File");
        fileMenu.add(open);
        menuBar.add(fileMenu);

        // Menu 2
        report = new JMenu("Reports");
        sortByEmp = new JMenuItem("Sort By Employee");
        sortByExpiry = new JMenuItem("Sort By Expiry Date");
        allSoftware = new JMenuItem("All Software");
        chooseEmp = new JMenuItem("Select An Employee");
        chooseSoftware = new JMenuItem("Select A Software");
        report.add(sortByEmp);
        report.add(sortByExpiry);
        report.add(allSoftware);
        report.add(chooseEmp);
        report.add(chooseSoftware);
        menuBar.add(report);

        // Menu 3
        view = new JMenu("View");
        viewEmployees = new JMenuItem("View Employees");
        view.add(viewEmployees);
        menuBar.add(view);

        // Center Menu Buttons
        center = new JPanel(new GridLayout(2, 2));

        // Open Button
        openFileButton = new JButton(filePath);
        center.add(openFileButton);

        // View Employees
        employeeButton = new JButton("View Employees");
        center.add(employeeButton);

        // Add New Employee Button
        addEmpButton = new JButton("Add New Employee");
        center.add(addEmpButton);

        // Report Employee Button
        empReport = new JButton("All Employees Report");
        center.add(empReport);

        // Save and Exit Button
        exitButton = new JButton("Save & Exit");

        // Left Panel Contents
        this.add(exitButton, BorderLayout.SOUTH);

        // Add Buttons
        this.add(center, BorderLayout.CENTER);

        // -----------------------------------
        // Listeners
        // -----------------------------------

        // Menu Items
        // Open File Menu
        openFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseFile();
            }
        });

        employeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add Form
                EmployeeForm form = new EmployeeForm(employees);
            }
        });

        // Add Employee Button
        addEmpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewEmployee newEmp = new NewEmployee(employees);
            }
        });

        // All Employee Report Button
        empReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SortByEmp sortByEmp = new SortByEmp(employees);
            }
        });


        // Menu Bar Listeners
        // Open File
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseFile();
            }
        });

        // Reports
        // By Employee
        sortByEmp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SortByEmp sortByEmp = new SortByEmp(employees);
            }
        });

        // By Expiry Date
        sortByExpiry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SortByExpiry sortByEmp = new SortByExpiry(employees);
            }
        });

        // View Employess 
        viewEmployees.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add Form
                EmployeeForm form = new EmployeeForm(employees);
            }
        });

        // Save and Exit the Program
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAndExit();
            }
        });

        // Pop up on closing
        

        this.setJMenuBar(menuBar);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
       
    }


    // -----------------------------------
    // Methods
    // -----------------------------------

    // Read Data from file into Memory
    private void chooseFile() {
        fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle("Choose Directory");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnValue = fileChooser.showSaveDialog(null);
        if(returnValue == JFileChooser.APPROVE_OPTION) {
            filePath = fileChooser.getSelectedFile().toString();
        }

    }

    // Save data into text file and exit program
    private void saveAndExit() {
        FileOutput output = new FileOutput(filePath, employees);
        closeWindow();
    }

    // Close the Current Window
    private void closeWindow() {
        this.dispose();
    }

}