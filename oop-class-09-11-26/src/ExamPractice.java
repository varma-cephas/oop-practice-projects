import java.util.Scanner;


// ==========================================
// 1. BANK BRANCH CLASS
// ==========================================
class BankBranch {
    private int branchId;
    private String branchName;
    private String branchCode;
    private String branchLocation;
    private String branchManager;

    public BankBranch(int branchId, String branchName, String branchCode, String branchLocation, String branchManager) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.branchCode = branchCode;
        this.branchLocation = branchLocation;
        this.branchManager = branchManager;
    }

    public int getBranchId() { return branchId; }
    public void setBranchId(int branchId) { this.branchId = branchId; }

    public String getBranchName() { return branchName; }
    public void setBranchName(String branchName) { this.branchName = branchName; }

    public String getBranchCode() { return branchCode; }
    public void setBranchCode(String branchCode) { this.branchCode = branchCode; }

    public String getBranchLocation() { return branchLocation; }
    public void setBranchLocation(String branchLocation) { this.branchLocation = branchLocation; }

    public String getBranchManager() { return branchManager; }
    public void setBranchManager(String branchManager) { this.branchManager = branchManager; }

    @Override
    public String toString() {
        return "Branch [ID: " + branchId + ", Name: " + branchName + ", Code: " + branchCode +
                ", Location: " + branchLocation + ", Manager: " + branchManager + "]";
    }
}










// ==========================================
// 2. CUSTOMER CLASS (Chaining & Overloading)
// ==========================================
class Customer {
    private int customerId;
    private String customerName;
    private String customerEmail;
    private int customerAge;
    private double monthlyIncome;

    // Full Parameterized Constructor
    public Customer(int customerId, String customerName, String customerEmail, int customerAge, double monthlyIncome) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerAge = customerAge;
        this.monthlyIncome = monthlyIncome;
    }

    // Overloaded Constructor with Constructor Chaining via this(...)
    public Customer(int customerId, String customerName, int customerAge) {
        this(customerId, customerName, "Not provided", customerAge, 0.0);
    }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

    public int getCustomerAge() { return customerAge; }
    public void setCustomerAge(int customerAge) { this.customerAge = customerAge; }

    public double getMonthlyIncome() { return monthlyIncome; }
    public void setMonthlyIncome(double monthlyIncome) { this.monthlyIncome = monthlyIncome; }

    @Override
    public String toString() {
        return "Customer [ID: " + customerId + ", Name: " + customerName + ", Email: " + customerEmail +
                ", Age: " + customerAge + ", Monthly Income: " + monthlyIncome + "]";
    }
}

// ==========================================
// 3. LOAN OFFICER CLASS
// ==========================================
class LoanOfficer {
    private int officerId;
    private String officerName;
    private String officerEmail;
    private int yearsOfExperience;
    private BankBranch branch;

    public LoanOfficer(int officerId, String officerName, String officerEmail, int yearsOfExperience, BankBranch branch) {
        this.officerId = officerId;
        this.officerName = officerName;
        this.officerEmail = officerEmail;
        this.yearsOfExperience = yearsOfExperience;
        this.branch = branch;
    }

    public int getOfficerId() { return officerId; }
    public void setOfficerId(int officerId) { this.officerId = officerId; }

    public String getOfficerName() { return officerName; }
    public void setOfficerName(String officerName) { this.officerName = officerName; }

    public String getOfficerEmail() { return officerEmail; }
    public void setOfficerEmail(String officerEmail) { this.officerEmail = officerEmail; }

    public int getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(int yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }

    public BankBranch getBranch() { return branch; }
    public void setBranch(BankBranch branch) { this.branch = branch; }

    @Override
    public String toString() {
        return "LoanOfficer [ID: " + officerId + ", Name: " + officerName + ", Email: " + officerEmail +
                ", Experience: " + yearsOfExperience + " yrs, Branch: " + (branch != null ? branch.getBranchName() : "None") + "]";
    }
}

// ==========================================
// 4. LOAN PRODUCT CLASS (Overloaded Calculations)
// ==========================================
class LoanProduct {
    private int productId;
    private String productName;
    private double interestRate; // Annual percentage
    private double maximumLoanAmount;
    private int maximumRepaymentMonths;

    public LoanProduct(int productId, String productName, double interestRate, double maximumLoanAmount, int maximumRepaymentMonths) {
        this.productId = productId;
        this.productName = productName;
        this.interestRate = interestRate;
        this.maximumLoanAmount = maximumLoanAmount;
        this.maximumRepaymentMonths = maximumRepaymentMonths;
    }

    // Single-argument version using product's own interestRate and maximumRepaymentMonths
    public double calculateRepayable(double principal) {
        double interest = principal * (interestRate / 100.0) * (maximumRepaymentMonths / 12.0);
        return principal + interest;
    }

    // Overloaded version accepting custom annual rate and months
    public double calculateRepayable(double principal, double annualRate, int months) {
        double interest = principal * (annualRate / 100.0) * (months / 12.0);
        return principal + interest;
    }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }

    public double getMaximumLoanAmount() { return maximumLoanAmount; }
    public void setMaximumLoanAmount(double maximumLoanAmount) { this.maximumLoanAmount = maximumLoanAmount; }

    public int getMaximumRepaymentMonths() { return maximumRepaymentMonths; }
    public void setMaximumRepaymentMonths(int maximumRepaymentMonths) { this.maximumRepaymentMonths = maximumRepaymentMonths; }

    @Override
    public String toString() {
        return "LoanProduct [ID: " + productId + ", Name: " + productName + ", Rate: " + interestRate +
                "%, Max Amount: " + maximumLoanAmount + ", Max Months: " + maximumRepaymentMonths + "]";
    }
}

// ==========================================
// 5. GUARANTOR CLASS
// ==========================================
class Guarantor {
    private int guarantorId;
    private String guarantorName;
    private String guarantorEmail;
    private String guarantorPhone;
    private double monthlyIncome;

    public Guarantor(int guarantorId, String guarantorName, String guarantorEmail, String guarantorPhone, double monthlyIncome) {
        this.guarantorId = guarantorId;
        this.guarantorName = guarantorName;
        this.guarantorEmail = guarantorEmail;
        this.guarantorPhone = guarantorPhone;
        this.monthlyIncome = monthlyIncome;
    }

    public int getGuarantorId() { return guarantorId; }
    public void setGuarantorId(int guarantorId) { this.guarantorId = guarantorId; }

    public String getGuarantorName() { return guarantorName; }
    public void setGuarantorName(String guarantorName) { this.guarantorName = guarantorName; }

    public String getGuarantorEmail() { return guarantorEmail; }
    public void setGuarantorEmail(String guarantorEmail) { this.guarantorEmail = guarantorEmail; }

    public String getGuarantorPhone() { return guarantorPhone; }
    public void setGuarantorPhone(String guarantorPhone) { this.guarantorPhone = guarantorPhone; }

    public double getMonthlyIncome() { return monthlyIncome; }
    public void setMonthlyIncome(double monthlyIncome) { this.monthlyIncome = monthlyIncome; }

    @Override
    public String toString() {
        return "Guarantor [ID: " + guarantorId + ", Name: " + guarantorName + ", Email: " + guarantorEmail +
                ", Phone: " + guarantorPhone + ", Monthly Income: " + monthlyIncome + "]";
    }
}

// ==========================================
// 6. LOAN APPLICATION CLASS
// ==========================================
class LoanApplication {
    private int applicationId;
    private Customer customer;
    private LoanProduct loanProduct;
    private Guarantor guarantor;
    private double requestedAmount;

    public LoanApplication(int applicationId, Customer customer, LoanProduct loanProduct, Guarantor guarantor, double requestedAmount) {
        this.applicationId = applicationId;
        this.customer = customer;
        this.loanProduct = loanProduct;
        this.guarantor = guarantor;
        this.requestedAmount = requestedAmount;
    }

    public int getApplicationId() { return applicationId; }
    public void setApplicationId(int applicationId) { this.applicationId = applicationId; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public LoanProduct getLoanProduct() { return loanProduct; }
    public void setLoanProduct(LoanProduct loanProduct) { this.loanProduct = loanProduct; }

    public Guarantor getGuarantor() { return guarantor; }
    public void setGuarantor(Guarantor guarantor) { this.guarantor = guarantor; }

    public double getRequestedAmount() { return requestedAmount; }
    public void setRequestedAmount(double requestedAmount) { this.requestedAmount = requestedAmount; }

    @Override
    public String toString() {
        return "LoanApplication [ID: " + applicationId + ", Customer: " + customer.getCustomerName() +
                ", Product: " + loanProduct.getProductName() + ", Guarantor: " + guarantor.getGuarantorName() +
                ", Requested Amount: " + requestedAmount + "]";
    }
}

// ==========================================
// 7. LOAN REPAYMENT CLASS
// ==========================================
class LoanRepayment {
    private int repaymentId;
    private LoanApplication loanApplication;
    private double repaymentAmount;
    private String repaymentDate;
    private LoanOfficer processedBy;

    public LoanRepayment(int repaymentId, LoanApplication loanApplication, double repaymentAmount, String repaymentDate, LoanOfficer processedBy) {
        this.repaymentId = repaymentId;
        this.loanApplication = loanApplication;
        this.repaymentAmount = repaymentAmount;
        this.repaymentDate = repaymentDate;
        this.processedBy = processedBy;
    }

    public int getRepaymentId() { return repaymentId; }
    public void setRepaymentId(int repaymentId) { this.repaymentId = repaymentId; }

    public LoanApplication getLoanApplication() { return loanApplication; }
    public void setLoanApplication(LoanApplication loanApplication) { this.loanApplication = loanApplication; }

    public double getRepaymentAmount() { return repaymentAmount; }
    public void setRepaymentAmount(double repaymentAmount) { this.repaymentAmount = repaymentAmount; }

    public String getRepaymentDate() { return repaymentDate; }
    public void setRepaymentDate(String repaymentDate) { this.repaymentDate = repaymentDate; }

    public LoanOfficer getProcessedBy() { return processedBy; }
    public void setProcessedBy(LoanOfficer processedBy) { this.processedBy = processedBy; }

    @Override
    public String toString() {
        return "LoanRepayment [ID: " + repaymentId + ", App ID: " + loanApplication.getApplicationId() +
                ", Amount: " + repaymentAmount + ", Date: " + repaymentDate + ", Officer: " + processedBy.getOfficerName() + "]";
    }
}

// ==========================================
// 8. MAIN CLASS & SYSTEM MANAGEMENT
// ==========================================
public class ExamPractice {
    // Arrays with capacity of at least 5
    private static BankBranch[] branches = new BankBranch[10];
    private static int branchCount = 0;

    private static Customer[] customers = new Customer[10];
    private static int customerCount = 0;

    private static LoanOfficer[] officers = new LoanOfficer[10];
    private static int officerCount = 0;

    private static LoanProduct[] products = new LoanProduct[10];
    private static int productCount = 0;

    private static Guarantor[] guarantors = new Guarantor[10];
    private static int guarantorCount = 0;

    private static LoanApplication[] applications = new LoanApplication[10];
    private static String[] applicationStatuses = new String[10]; // Parallel status tracking array
    private static int applicationCount = 0;

    private static LoanRepayment[] repayments = new LoanRepayment[20];
    private static int repaymentCount = 0;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;
        while (choice != 0) {
            printMenu();
            try {
                System.out.print("Enter your choice (0-10): ");
                choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1: registerBranch(); break;
                    case 2: registerCustomer(); break;
                    case 3: registerLoanOfficer(); break;
                    case 4: registerLoanProduct(); break;
                    case 5: registerGuarantor(); break;
                    case 6: submitLoanApplication(); break;
                    case 7: reviewLoanApplication(); break;
                    case 8: approveOrRejectApplication(); break;
                    case 9: recordLoanRepayment(); break;
                    case 10: viewLoanSummaryAndRecords(); break;
                    case 0:
                        System.out.println("Exiting Loan Application Management System. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 0 and 10.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Non-numeric input detected. Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("==================================================");
        System.out.println("     LOAN APPLICATION MANAGEMENT SYSTEM MENU      ");
        System.out.println("==================================================");
        System.out.println("1. Register Bank Branch");
        System.out.println("2. Register Customer");
        System.out.println("3. Register Loan Officer");
        System.out.println("4. Register Loan Product");
        System.out.println("5. Register Guarantor");
        System.out.println("6. Submit Loan Application");
        System.out.println("7. Review Loan Application");
        System.out.println("8. Approve / Reject Loan Application");
        System.out.println("9. Record Loan Repayment");
        System.out.println("10. View Loan Summary / Records");
        System.out.println("0. Exit");
        System.out.println("==================================================");
    }

    // --- HELPER LOOKUP & VALIDATION METHODS ---
    private static boolean isBranchIdUnique(int id) {
        for (int i = 0; i < branchCount; i++) {
            if (branches[i].getBranchId() == id) return false;
        }
        return true;
    }

    private static boolean isBranchCodeUnique(String code) {
        for (int i = 0; i < branchCount; i++) {
            if (branches[i].getBranchCode().equalsIgnoreCase(code)) return false;
        }
        return true;
    }

    private static boolean isCustomerIdUnique(int id) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getCustomerId() == id) return false;
        }
        return true;
    }

    private static boolean isOfficerIdUnique(int id) {
        for (int i = 0; i < officerCount; i++) {
            if (officers[i].getOfficerId() == id) return false;
        }
        return true;
    }

    private static boolean isProductIdUnique(int id) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getProductId() == id) return false;
        }
        return true;
    }

    private static boolean isGuarantorIdUnique(int id) {
        for (int i = 0; i < guarantorCount; i++) {
            if (guarantorInfoUnique(guarantors[i], id)) {
                // checked below
            }
            if (guarantors[i].getGuarantorId() == id) return false;
        }
        return true;
    }

    private static boolean guarantorInfoUnique(Guarantor g, int id) {
        return g.getGuarantorId() == id;
    }

    private static boolean isApplicationIdUnique(int id) {
        for (int i = 0; i < applicationCount; i++) {
            if (applications[i].getApplicationId() == id) return false;
        }
        return true;
    }

    private static boolean isRepaymentIdUnique(int id) {
        for (int i = 0; i < repaymentCount; i++) {
            if (repayments[i].getRepaymentId() == id) return false;
        }
        return true;
    }

    private static boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    private static BankBranch findBranchById(int id) {
        for (int i = 0; i < branchCount; i++) {
            if (branches[i].getBranchId() == id) return branches[i];
        }
        return null;
    }

    private static Customer findCustomerById(int id) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getCustomerId() == id) return customers[i];
        }
        return null;
    }

    private static LoanOfficer findOfficerById(int id) {
        for (int i = 0; i < officerCount; i++) {
            if (officers[i].getOfficerId() == id) return officers[i];
        }
        return null;
    }

    private static LoanProduct findProductById(int id) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getProductId() == id) return products[i];
        }
        return null;
    }

    private static Guarantor findGuarantorById(int id) {
        for (int i = 0; i < guarantorCount; i++) {
            if (guarantors[i].getGuarantorId() == id) return guarantors[i];
        }
        return null;
    }

    private static LoanApplication findApplicationById(int id) {
        for (int i = 0; i < applicationCount; i++) {
            if (applications[i].getApplicationId() == id) return applications[i];
        }
        return null;
    }

    private static int findApplicationIndex(int id) {
        for (int i = 0; i < applicationCount; i++) {
            if (applications[i].getApplicationId() == id) return i;
        }
        return -1;
    }

    // --- OPTION 1: REGISTER BANK BRANCH ---
    private static void registerBranch() {
        if (branchCount >= branches.length) {
            System.out.println("Branch storage capacity reached.");
            return;
        }
        System.out.println("--- Register Bank Branch ---");
        try {
            System.out.print("Enter Branch ID (positive int): ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            if (id <= 0 || !isBranchIdUnique(id)) {
                System.out.println("Rejection: Branch ID must be positive and unique.");
                return;
            }

            System.out.print("Enter Branch Name (non-blank): ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Rejection: Branch name cannot be blank.");
                return;
            }

            System.out.print("Enter Branch Code (non-blank, unique): ");
            String code = scanner.nextLine().trim();
            if (code.isEmpty() || !isBranchCodeUnique(code)) {
                System.out.println("Rejection: Branch code must be non-blank and unique.");
                return;
            }

            System.out.print("Enter Branch Location (non-blank): ");
            String location = scanner.nextLine().trim();
            if (location.isEmpty()) {
                System.out.println("Rejection: Branch location cannot be blank.");
                return;
            }

            System.out.print("Enter Branch Manager (non-blank): ");
            String manager = scanner.nextLine().trim();
            if (manager.isEmpty()) {
                System.out.println("Rejection: Branch manager cannot be blank.");
                return;
            }

            branches[branchCount++] = new BankBranch(id, name, code, location, manager);
            System.out.println("Success: Bank Branch registered successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Rejection: Invalid numeric format entered.");
        }
    }

    // --- OPTION 2: REGISTER CUSTOMER ---
    private static void registerCustomer() {
        if (customerCount >= customers.length) {
            System.out.println("Customer storage capacity reached.");
            return;
        }
        System.out.println("--- Register Customer ---");
        try {
            System.out.print("Enter Customer ID (positive int): ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            if (id <= 0 || !isCustomerIdUnique(id)) {
                System.out.println("Rejection: Customer ID must be positive and unique.");
                return;
            }

            System.out.print("Enter Customer Name (non-blank): ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Rejection: Customer name cannot be blank.");
                return;
            }

            System.out.print("Enter Customer Email: ");
            String email = scanner.nextLine().trim();
            if (!isValidEmail(email)) {
                System.out.println("Rejection: Invalid basic email format (must contain '@' and '.').");
                return;
            }

            System.out.print("Enter Customer Age (18-100): ");
            int age = Integer.parseInt(scanner.nextLine().trim());
            if (age < 18 || age > 100) {
                System.out.println("Rejection: Customer age must be between 18 and 100.");
                return;
            }

            System.out.print("Enter Monthly Income (positive double): ");
            double income = Double.parseDouble(scanner.nextLine().trim());
            if (income <= 0) {
                System.out.println("Rejection: Monthly income must be positive.");
                return;
            }

            customers[customerCount++] = new Customer(id, name, email, age, income);
            System.out.println("Success: Customer registered successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Rejection: Invalid numeric format entered.");
        }
    }

    // --- OPTION 3: REGISTER LOAN OFFICER ---
    private static void registerLoanOfficer() {
        if (officerCount >= officers.length) {
            System.out.println("Loan Officer storage capacity reached.");
            return;
        }
        if (branchCount == 0) {
            System.out.println("Rejection: Please register at least one Bank Branch first.");
            return;
        }
        System.out.println("--- Register Loan Officer ---");
        try {
            System.out.print("Enter Officer ID (positive int): ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            if (id <= 0 || !isOfficerIdUnique(id)) {
                System.out.println("Rejection: Officer ID must be positive and unique.");
                return;
            }

            System.out.print("Enter Officer Name (non-blank): ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Rejection: Officer name cannot be blank.");
                return;
            }

            System.out.print("Enter Officer Email: ");
            String email = scanner.nextLine().trim();
            if (!isValidEmail(email)) {
                System.out.println("Rejection: Invalid basic email format.");
                return;
            }

            System.out.print("Enter Years of Experience (non-negative): ");
            int exp = Integer.parseInt(scanner.nextLine().trim());
            if (exp < 0) {
                System.out.println("Rejection: Years of experience cannot be negative.");
                return;
            }

            System.out.println("Available Branches:");
            for (int i = 0; i < branchCount; i++) {
                System.out.println(branches[i]);
            }
            System.out.print("Enter Branch ID for this officer: ");
            int bId = Integer.parseInt(scanner.nextLine().trim());
            BankBranch branch = findBranchById(bId);
            if (branch == null) {
                System.out.println("Rejection: Branch ID not found.");
                return;
            }

            officers[officerCount++] = new LoanOfficer(id, name, email, exp, branch);
            System.out.println("Success: Loan Officer registered successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Rejection: Invalid numeric format entered.");
        }
    }

    // --- OPTION 4: REGISTER LOAN PRODUCT ---
    private static void registerLoanProduct() {
        if (productCount >= products.length) {
            System.out.println("Loan Product storage capacity reached.");
            return;
        }
        System.out.println("--- Register Loan Product ---");
        try {
            System.out.print("Enter Product ID (positive int): ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            if (id <= 0 || !isProductIdUnique(id)) {
                System.out.println("Rejection: Product ID must be positive and unique.");
                return;
            }

            System.out.print("Enter Product Name (non-blank): ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Rejection: Product name cannot be blank.");
                return;
            }

            System.out.print("Enter Interest Rate % (0 < rate <= 30): ");
            double rate = Double.parseDouble(scanner.nextLine().trim());
            if (rate <= 0 || rate > 30) {
                System.out.println("Rejection: Interest rate must be between 0 and 30%.");
                return;
            }

            System.out.print("Enter Maximum Loan Amount (positive double): ");
            double maxAmount = Double.parseDouble(scanner.nextLine().trim());
            if (maxAmount <= 0) {
                System.out.println("Rejection: Maximum loan amount must be positive.");
                return;
            }

            System.out.print("Enter Maximum Repayment Months (1-120): ");
            int maxMonths = Integer.parseInt(scanner.nextLine().trim());
            if (maxMonths < 1 || maxMonths > 120) {
                System.out.println("Rejection: Repayment period must be between 1 and 120 months.");
                return;
            }

            products[productCount++] = new LoanProduct(id, name, rate, maxAmount, maxMonths);
            System.out.println("Success: Loan Product registered successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Rejection: Invalid numeric format entered.");
        }
    }

    // --- OPTION 5: REGISTER GUARANTOR ---
    private static void registerGuarantor() {
        if (guarantorCount >= guarantors.length) {
            System.out.println("Guarantor storage capacity reached.");
            return;
        }
        System.out.println("--- Register Guarantor ---");
        try {
            System.out.print("Enter Guarantor ID (positive int): ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            if (id <= 0 || !isGuarantorIdUnique(id)) {
                System.out.println("Rejection: Guarantor ID must be positive and unique.");
                return;
            }

            System.out.print("Enter Guarantor Name (non-blank): ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Rejection: Guarantor name cannot be blank.");
                return;
            }

            System.out.print("Enter Guarantor Email: ");
            String email = scanner.nextLine().trim();
            if (!isValidEmail(email)) {
                System.out.println("Rejection: Invalid basic email format.");
                return;
            }

            System.out.print("Enter Guarantor Phone (non-blank): ");
            String phone = scanner.nextLine().trim();
            if (phone.isEmpty()) {
                System.out.println("Rejection: Guarantor phone cannot be blank.");
                return;
            }

            System.out.print("Enter Monthly Income (positive double): ");
            double income = Double.parseDouble(scanner.nextLine().trim());
            if (income <= 0) {
                System.out.println("Rejection: Monthly income must be positive.");
                return;
            }

            guarantors[guarantorCount++] = new Guarantor(id, name, email, phone, income);
            System.out.println("Success: Guarantor registered successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Rejection: Invalid numeric format entered.");
        }
    }

    // --- OPTION 6: SUBMIT LOAN APPLICATION ---
    private static void submitLoanApplication() {
        if (applicationCount >= applications.length) {
            System.out.println("Application storage capacity reached.");
            return;
        }
        if (customerCount == 0 || productCount == 0 || guarantorCount == 0) {
            System.out.println("Rejection: Ensure at least one Customer, Loan Product, and Guarantor are registered.");
            return;
        }

        System.out.println("--- Submit Loan Application ---");
        try {
            System.out.print("Enter Application ID (positive int): ");
            int appId = Integer.parseInt(scanner.nextLine().trim());
            if (appId <= 0 || !isApplicationIdUnique(appId)) {
                System.out.println("Rejection: Application ID must be positive and unique.");
                return;
            }

            // Display customers
            System.out.println("Registered Customers:");
            for (int i = 0; i < customerCount; i++) {
                System.out.println(customers[i]);
            }
            System.out.print("Enter Customer ID: ");
            int cId = Integer.parseInt(scanner.nextLine().trim());
            Customer customer = findCustomerById(cId);
            if (customer == null) {
                System.out.println("Rejection: Customer not found.");
                return;
            }

            // Display products
            System.out.println("Registered Loan Products:");
            for (int i = 0; i < productCount; i++) {
                System.out.println(products[i]);
            }
            System.out.print("Enter Product ID: ");
            int pId = Integer.parseInt(scanner.nextLine().trim());
            LoanProduct product = findProductById(pId);
            if (product == null) {
                System.out.println("Rejection: Loan Product not found.");
                return;
            }

            // Duplicate Pending application check
            for (int i = 0; i < applicationCount; i++) {
                if (applications[i].getCustomer().getCustomerId() == cId &&
                        applications[i].getLoanProduct().getProductId() == pId &&
                        applicationStatuses[i].equalsIgnoreCase("Pending")) {
                    System.out.println("Rejection: Customer already has a pending application for this loan product.");
                    return;
                }
            }

            // Display guarantors
            System.out.println("Registered Guarantors:");
            for (int i = 0; i < guarantorCount; i++) {
                System.out.println(guarantors[i]);
            }
            System.out.print("Enter Guarantor ID: ");
            int gId = Integer.parseInt(scanner.nextLine().trim());
            Guarantor guarantor = findGuarantorById(gId);
            if (guarantor == null) {
                System.out.println("Rejection: Guarantor not found.");
                return;
            }

            // Check if customer acts as their own guarantor
            if (customer.getCustomerEmail().equalsIgnoreCase(guarantor.getGuarantorEmail()) ||
                    customer.getCustomerName().equalsIgnoreCase(guarantor.getGuarantorName())) {
                System.out.println("Rejection: Customer cannot act as their own guarantor.");
                return;
            }

            System.out.print("Enter Requested Amount (double): ");
            double requestedAmount = Double.parseDouble(scanner.nextLine().trim());

            // Demonstrate explicit casting by displaying loan amount as (int) while retaining original double value
            int castedAmount = (int) requestedAmount;
            System.out.println("[Cast Info] Requested Amount as int: " + castedAmount + " | Original double: " + requestedAmount);

            // Eligibility Validation Checks
            if (customer.getCustomerAge() < 21) {
                System.out.println("Rejection: Customer must be at least 21 years old for loan eligibility.");
                return;
            }
            if (customer.getMonthlyIncome() <= 0 || guarantor.getMonthlyIncome() <= 0) {
                System.out.println("Rejection: Customer and guarantor must both have positive monthly incomes.");
                return;
            }
            if (requestedAmount <= 0 || requestedAmount > product.getMaximumLoanAmount()) {
                System.out.println("Rejection: Requested amount must be positive and within product maximum (" + product.getMaximumLoanAmount() + ").");
                return;
            }
            if (requestedAmount > 12 * customer.getMonthlyIncome()) {
                System.out.println("Rejection: Requested amount cannot exceed 12x customer's monthly income.");
                return;
            }
            if (guarantor.getMonthlyIncome() < 0.30 * customer.getMonthlyIncome()) {
                System.out.println("Rejection: Guarantor monthly income must be at least 30% of customer's income.");
                return;
            }
            if (product.getInterestRate() <= 0 || product.getInterestRate() > 30) {
                System.out.println("Rejection: Product interest rate must be > 0 and <= 30%.");
                return;
            }
            if (product.getMaximumRepaymentMonths() < 1 || product.getMaximumRepaymentMonths() > 120) {
                System.out.println("Rejection: Product repayment period must be between 1 and 120 months.");
                return;
            }

            // Store application and set initial status to "Pending"
            applications[applicationCount] = new LoanApplication(appId, customer, product, guarantor, requestedAmount);
            applicationStatuses[applicationCount] = "Pending";
            applicationCount++;

            // Demonstrate both calculateRepayable methods in program execution
            double defaultRepayable = product.calculateRepayable(requestedAmount);
            double customRepayable = product.calculateRepayable(requestedAmount, product.getInterestRate(), product.getMaximumRepaymentMonths());
            System.out.println("[Calculation Demo] Default Repayable: " + defaultRepayable + " | Custom Repayable: " + customRepayable);

            System.out.println("Success: Loan application submitted successfully with status: Pending.");
        } catch (NumberFormatException e) {
            System.out.println("Rejection: Invalid numeric input format.");
        }
    }

    // --- OPTION 7: REVIEW LOAN APPLICATION ---
    private static void reviewLoanApplication() {
        if (applicationCount == 0) {
            System.out.println("No loan applications found.");
            return;
        }
        System.out.println("--- Review Loan Application ---");
        try {
            System.out.print("Enter Application ID to review: ");
            int appId = Integer.parseInt(scanner.nextLine().trim());
            int idx = findApplicationIndex(appId);
            if (idx == -1) {
                System.out.println("Rejection: Loan application not found.");
                return;
            }

            LoanApplication app = applications[idx];
            System.out.println("--- Application Details ---");
            System.out.println(app);
            System.out.println("Status: " + applicationStatuses[idx]);
            System.out.println("Customer Income: " + app.getCustomer().getMonthlyIncome() +
                    ", Guarantor Income: " + app.getGuarantor().getMonthlyIncome());
            System.out.println("Calculated Total Repayable: " + app.getLoanProduct().calculateRepayable(app.getRequestedAmount()));
            System.out.println("Review completed successfully without changing status.");
        } catch (NumberFormatException e) {
            System.out.println("Rejection: Invalid numeric format entered.");
        }
    }

    // --- OPTION 8: APPROVE / REJECT LOAN APPLICATION ---
    private static void approveOrRejectApplication() {
        if (applicationCount == 0) {
            System.out.println("No loan applications found.");
            return;
        }
        System.out.println("--- Approve / Reject Loan Application ---");
        try {
            System.out.print("Enter Application ID: ");
            int appId = Integer.parseInt(scanner.nextLine().trim());
            int idx = findApplicationIndex(appId);
            if (idx == -1) {
                System.out.println("Rejection: Application not found.");
                return;
            }

            if (!applicationStatuses[idx].equalsIgnoreCase("Pending")) {
                System.out.println("Rejection: Only Pending applications may change status.");
                return;
            }

            System.out.print("Do you want to Approve (A) or Reject (R)? ");
            String decision = scanner.nextLine().trim();

            if (decision.equalsIgnoreCase("A")) {
                // Re-verify eligibility before final approval
                LoanApplication app = applications[idx];
                boolean eligible = (app.getCustomer().getCustomerAge() >= 21 &&
                        app.getCustomer().getMonthlyIncome() > 0 &&
                        app.getGuarantor().getMonthlyIncome() > 0 &&
                        app.getRequestedAmount() > 0 &&
                        app.getRequestedAmount() <= app.getLoanProduct().getMaximumLoanAmount() &&
                        app.getRequestedAmount() <= 12 * app.getCustomer().getMonthlyIncome() &&
                        app.getGuarantor().getMonthlyIncome() >= 0.30 * app.getCustomer().getMonthlyIncome() &&
                        app.getLoanProduct().getInterestRate() > 0 &&
                        app.getLoanProduct().getInterestRate() <= 30);

                if (!eligible) {
                    System.out.println("Rejection: Only eligible applications may be approved.");
                    return;
                }

                applicationStatuses[idx] = "Approved";
                System.out.println("Success: Application ID " + appId + " has been Approved.");
            } else if (decision.equalsIgnoreCase("R")) {
                applicationStatuses[idx] = "Rejected";
                System.out.println("Success: Application ID " + appId + " has been Rejected.");
            } else {
                System.out.println("Rejection: Invalid choice. Enter 'A' or 'R'.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Rejection: Invalid numeric format entered.");
        }
    }

    // --- OPTION 9: RECORD LOAN REPAYMENT ---
    private static void recordLoanRepayment() {
        if (repaymentCount >= repayments.length) {
            System.out.println("Repayment storage capacity reached.");
            return;
        }
        if (applicationCount == 0 || officerCount == 0) {
            System.out.println("Rejection: Ensure applications and loan officers are registered.");
            return;
        }

        System.out.println("--- Record Loan Repayment ---");
        try {
            System.out.print("Enter Repayment ID (positive int): ");
            int repId = Integer.parseInt(scanner.nextLine().trim());
            if (repId <= 0 || !isRepaymentIdUnique(repId)) {
                System.out.println("Rejection: Repayment ID must be positive and unique.");
                return;
            }

            System.out.print("Enter Loan Application ID: ");
            int appId = Integer.parseInt(scanner.nextLine().trim());
            int appIdx = findApplicationIndex(appId);
            if (appIdx == -1) {
                System.out.println("Rejection: Loan application not found.");
                return;
            }

            if (!applicationStatuses[appIdx].equalsIgnoreCase("Approved")) {
                System.out.println("Rejection: Partial repayments can only be recorded for Approved applications.");
                return;
            }

            LoanApplication app = applications[appIdx];
            double totalRepayable = app.getLoanProduct().calculateRepayable(app.getRequestedAmount());

            // Calculate total repaid so far
            double totalRepaidSoFar = 0.0;
            for (int i = 0; i < repaymentCount; i++) {
                if (repayments[i].getLoanApplication().getApplicationId() == appId) {
                    totalRepaidSoFar += repayments[i].getRepaymentAmount();
                }
            }

            double outstandingBalance = totalRepayable - totalRepaidSoFar;
            if (outstandingBalance <= 0) {
                System.out.println("Rejection: Cannot record payments on fully paid loans.");
                return;
            }

            System.out.print("Enter Repayment Amount (positive double): ");
            double repAmount = Double.parseDouble(scanner.nextLine().trim());

            if (repAmount <= 0) {
                System.out.println("Rejection: Repayment amount must be positive.");
                return;
            }
            if (repAmount > outstandingBalance) {
                System.out.println("Rejection: Overpayment rejected. Outstanding balance is " + outstandingBalance);
                return;
            }

            System.out.print("Enter Repayment Date (e.g., YYYY-MM-DD): ");
            String date = scanner.nextLine().trim();
            if (date.isEmpty()) {
                System.out.println("Rejection: Repayment date cannot be blank.");
                return;
            }

            // Display officers
            System.out.println("Registered Loan Officers:");
            for (int i = 0; i < officerCount; i++) {
                System.out.println(officers[i]);
            }
            System.out.print("Enter Loan Officer ID processing this repayment: ");
            int offId = Integer.parseInt(scanner.nextLine().trim());
            LoanOfficer officer = findOfficerById(offId);
            if (officer == null) {
                System.out.println("Rejection: Loan officer not found.");
                return;
            }

            repayments[repaymentCount++] = new LoanRepayment(repId, app, repAmount, date, officer);
            System.out.println("Success: Repayment of " + repAmount + " recorded successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Rejection: Invalid numeric format entered.");
        }
    }

    // --- OPTION 10: VIEW LOAN SUMMARY / RECORDS ---
    private static void viewLoanSummaryAndRecords() {
        System.out.println("==================================================");
        System.out.println("             SYSTEM RECORDS & SUMMARY             ");
        System.out.println("==================================================");

        System.out.println("\n[Bank Branches (" + branchCount + ")]");
        for (int i = 0; i < branchCount; i++) System.out.println(branches[i]);

        System.out.println("\n[Customers (" + customerCount + ")]");
        for (int i = 0; i < customerCount; i++) System.out.println(customers[i]);

        System.out.println("\n[Loan Officers (" + officerCount + ")]");
        for (int i = 0; i < officerCount; i++) System.out.println(officers[i]);

        System.out.println("\n[Loan Products (" + productCount + ")]");
        for (int i = 0; i < productCount; i++) System.out.println(products[i]);

        System.out.println("\n[Guarantors (" + guarantorCount + ")]");
        for (int i = 0; i < guarantorCount; i++) System.out.println(guarantors[i]);

        System.out.println("\n[Loan Applications & Summary (" + applicationCount + ")]");
        if (applicationCount == 0) {
            System.out.println("No loan applications submitted yet.");
        } else {
            for (int i = 0; i < applicationCount; i++) {
                LoanApplication app = applications[i];
                double totalRepayable = app.getLoanProduct().calculateRepayable(app.getRequestedAmount());

                double totalRepaid = 0.0;
                for (int j = 0; j < repaymentCount; j++) {
                    if (repayments[j].getLoanApplication().getApplicationId() == app.getApplicationId()) {
                        totalRepaid += repayments[j].getRepaymentAmount();
                    }
                }
                double outstandingBalance = totalRepayable - totalRepaid;

                System.out.println("--------------------------------------------------");
                System.out.println("Application ID: " + app.getApplicationId());
                System.out.println("Customer: " + app.getCustomer().getCustomerName());
                System.out.println("Loan Product: " + app.getLoanProduct().getProductName());
                System.out.println("Application Status: " + applicationStatuses[i]);
                System.out.println("Requested Amount (double): " + app.getRequestedAmount() +
                        " | As int: " + (int) app.getRequestedAmount());
                System.out.println("Total Repayable: " + totalRepayable);
                System.out.println("Total Repaid: " + totalRepaid);
                System.out.println("Outstanding Balance: " + outstandingBalance);
            }
        }

        System.out.println("\n[Loan Repayments (" + repaymentCount + ")]");
        if (repaymentCount == 0) {
            System.out.println("No repayments recorded yet.");
        } else {
            for (int i = 0; i < repaymentCount; i++) {
                System.out.println(repayments[i]);
            }
        }
        System.out.println("==================================================");
    }
}