// Software Class
import java.util.Scanner;

public class Software {

    // ----------------------------------
    // Variables/Fields
    // ----------------------------------

    private String companyName;
    private String softwareName;
    Address companyAddress;
    private String versionNumber;
    // private String hotfix;
    // private String licenseNumber;
    private String expiryDate;
    // private String licenseVersion;
    private String licenseType;
    // Validation Scanner
    Scanner sc = new Scanner(System.in);

    // ----------------------------------
    // Constructors
    // ----------------------------------
    
    // Default Constructor
    public Software() {
        companyName = "N/A";
        softwareName = "N/A";
        companyAddress = new Address();
        versionNumber = "N/A";
        expiryDate = "N/A";
        licenseType = "N/A";
    } 

    // Argument Constructor
    public Software(String companyName,
                    String softwareName,
                    String state, 
                    String city,
                    String postCode,
                    String streetAddress,
                    String versionNumber,
                    String expiryDate,
                    String licenseType) {
        setCompanyName(companyName);
        setSoftwareName(softwareName);
        companyAddress = new Address(state, city, postCode, streetAddress);
        setVersionNumber(versionNumber);
        setExpiryDate(expiryDate); 
        setLicenseType(licenseType);
    }

    // -----------------------------------
    // Methods
    // -----------------------------------

    // Setters and Getters
    // Company Name
    private void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    private String getCompanyName() {
        return companyName;
    }
    public void inputCompanyName(String companyName) {
        setCompanyName(companyName);
    }
    public String grabCompanyName() {
        return getCompanyName();
    }

    // Software Name
    private void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }
    private String getSoftwareName() {
        return softwareName;
    }
    public void inputSoftwareName(String softwareName) {
        setSoftwareName(softwareName);
    }
    public String grabSoftwareName() {
        return getSoftwareName();
    }

    // Version Number
    private void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }
    private String getVersionNumber() {
        return versionNumber;
    }
    public void inputVersionNumber(String versionNumber) {
        setVersionNumber(versionNumber);
    }
    public String grabVersionNumber() {
        return getVersionNumber();
    }

    // Expiry Date
    private void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    private String getExpiryDate() {
        return expiryDate;
    }
    public void inputExpiryDate(String expiryDate) {
        setExpiryDate(expiryDate);
    }
    public String grabExpiryDate() {
        return getExpiryDate();
    }

    // License Type
    private void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }
    private String getLicenseType() {
        return licenseType;
    }
    public void inputLicenseType(String licenseType) {
        setLicenseType(licenseType);
    }
    public String grabLicenseType() {
        return getLicenseType();
    }

    // Validation Methods

    // Company Name 
    public void companyNameValid(String input) {
        boolean flag;
        do {
            String namePattern = "[a-zA-Z0-9\\s]{3,25}";
            flag = input.matches(namePattern);
            if (!flag) System.out.println("Invalid company name");
        } while (!flag);
        System.out.println("Valid company name");
        System.out.println("The company name " + input + " has been set\n");
        
        setCompanyName(input);
//        return getCompanyName();
    }

    // Software Name
    public void softwareNameValid(String input) {
        boolean flag;
        do {
            String namePattern = "[a-zA-Z0-9\\s]{3,25}";
            flag = input.matches(namePattern);
            if (!flag) System.out.println("Invalid software name");
        } while (!flag);
        System.out.println("Valid software name");
        System.out.println("The software name " + input + " has been set\n");
        
        setSoftwareName(input);
    }

    // Version Number
    public void versionNumberValid(String input) {
        boolean flag;
        do {
            String versionPattern = "[0-9\\s]{1,2}[.\\s][0-9\\s]{1,2}[.\\s][0-9\\s]{1,2}";
            flag = input.matches(versionPattern);
            if (!flag) System.out.println("Invalid software version number");
        } while (!flag);
        System.out.println("Valid software version number");
        System.out.println("The version number " + input + " has been set\n");
        
        setVersionNumber(input);
    }

    // Expiry Date
    public void expiryDateValid(String input) {
        boolean flag;
        do {
            String expiryDatePattern = "[0-9]{1,2}(/|-)[0-9]{1,2}(/|-)[0-9]{4}";
            flag = input.matches(expiryDatePattern);
            if (!flag) System.out.println("Invalid Date");
        } while (!flag);
        System.out.println("Valid Date");
        System.out.println("The Date " + input + " has been set\n");
        
        setExpiryDate(input);
    }

    // License Type
    public void licenseTypeValid(String input) {
        boolean flag;
        do {
            String licenseTypePattern = "[a-zA-Z]{1,25}";
            flag = input.matches(licenseTypePattern);
            if (!flag) System.out.println("Invalid license type");
        } while (!flag);
        System.out.println("Valid license type");
        System.out.println("The license type " + input + " has been set\n");
        
        setLicenseType(input);
    }

    // Simple Output for Software Object (For Simpler Details)
    public String simplePrint() {
        return "Company Name = " + getCompanyName() + "\n" +
         "Software Name = " + getSoftwareName() + "\n" +
         "Expiry Date = " + expiryDate + "\n";
    }

    @Override
    public String toString() {
        return "\n" +
        getCompanyName() + "\n" +
        getSoftwareName() + "\n" +
        companyAddress + "\n" +
        getVersionNumber() + "\n" +
        getExpiryDate() + "\n" +
        getLicenseType() + "\n";
    }

}