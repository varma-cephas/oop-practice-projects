import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Taxpayer[] taxpayers = new Taxpayer[10];
    private static int taxpayerIndexCount = 0;

    private static String[] taxAccountTypes = {"VAT", "PAYE", "Income Tax"};
    private static TaxAccount[] taxAccounts = new TaxAccount[10];
    private static int taxAccountIndexCount = 0;

    private static Declaration[] declarations = new Declaration[10];
    private static int decclarationIndexCount = 0;

    private static Payment[] payments = new Payment[10];
    private static int paymentIndexCount = 0;

    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        int choice = -1;
        while (choice != 0) {
            printMenu();
            try {
                System.out.print("Enter your choice (0-5): ");
                choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1:
                        registerTaxpayer();
                        break;
                    case 2:
                        registerTaxAccount();
                        break;
                    case 3:
                        submitDeclarationAndCalculateTax();
                        break;
                    case 4:
                        makePayment();
                        break;
                    case 5: viewTaxpayerTaxSummary(); break;
                    case 0:
                        System.out.println("Exiting Application. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 0 and 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Non-numeric input detected. Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static void registerTaxpayer() {
        System.out.println("Please enter tin number: ");
        String taxpayerTinNumber = scanner.nextLine().trim();
        if(taxpayerTinNumber.length() != 10) {
            System.out.println("Error: Taxpayer TIN number must have 10 characters.");
            return;
        }

        for (int i = 0; i < taxpayerIndexCount; i++) {
            if (Objects.equals(taxpayers[i].getTaxpayerTin(), taxpayerTinNumber)) {
                System.out.println("Tax payer TIN number must be unique");
                return;
            }
        }
        System.out.println("Please enter taxpayer name: ");
        String taxpayerName = scanner.nextLine().trim();
        if(taxpayerName.isEmpty()) {
            System.out.println("Error: Taxpayer Name must not be empty or blank.");
        }
        System.out.println("Please enter taxpayer age: ");
        int taxpayerAge = scanner.nextInt();
        try {

            if(taxpayerAge < 18) {
                System.out.println("Error: Taxpayer Age must be greater than 18");
                return;
            }
        } catch (Exception e) {
            System.out.println("Error: Taxpayer Age must be a valid number.");
        }
        taxpayers[taxpayerIndexCount++] = new Taxpayer(taxpayerTinNumber, taxpayerName, taxpayerAge);
    }

    private static void registerTaxAccount() {
        System.out.println("Please enter account number: ");
        String accountNumber = scanner.nextLine().trim();

        System.out.println("Please enter TIN number: ");
        String tinNUmber = scanner.nextLine().trim();
        boolean customerExists = false;
        for (int i = 0; i < taxpayerIndexCount; i++) {
            if (Objects.equals(taxpayers[i].getTaxpayerTin(), tinNUmber)) {
                customerExists = true;
                break;
            }
        }
        if(!customerExists) {
            System.out.println("Error: You must be an existing customer to register this account.");
            return;
        }
        System.out.println("Please enter tax type: ");
        String taxAccountType  = scanner.nextLine().trim();
        boolean taxAccountExists = false;
        for (int i = 0; i < 2; i++) {
            if (Objects.equals(taxAccountTypes[i], taxAccountType)) {
                taxAccountExists = true;
            }
        }
        if(!taxAccountExists) {
            System.out.println("Error: Not a valid tax account");
            return;
        }
        System.out.println("Please enter account status : ");
        String accountStatus = scanner.nextLine().trim();
        taxAccounts[taxAccountIndexCount++] = new TaxAccount(accountNumber, tinNUmber, taxAccountType, accountStatus);

    }

    private static void submitDeclarationAndCalculateTax() {
        System.out.println("Please enter delaration id: ");
        String delarationId = scanner.nextLine().trim();
        System.out.println("Please enter account number: ");
        String accountNumber = scanner.nextLine().trim();
        System.out.println("Please enter taxable amount: ");
        double taxableAmount = scanner.nextDouble();
        System.out.println("Please enter declared tax: ");
        double declaredAmount = Declaration.calculateTax(taxableAmount);
        declarations[decclarationIndexCount] = new Declaration(delarationId, accountNumber, taxableAmount, declaredAmount);
    }

    private static void makePayment() {
    //tod

        System.out.println("Please enter payment id: ");
        String paymentId = scanner.nextLine().trim();
        System.out.println("Please enter declaration id: ");
        String declarationId = scanner.nextLine().trim();
        System.out.println("Please enter amount Paid: ");
        double amountPaid = scanner.nextDouble();
        if(taxAccounts[0].getTaxType() == "VAT")
        {
            amountPaid = amountPaid * 0.18;
        }else if(taxAccounts[0].getTaxType() == "PAYE"){
            amountPaid = amountPaid * 0.15;
        }else{
            amountPaid = amountPaid * 0.30;
        }
        amountPaid = 50;
        System.out.println("Please enter payment method: ");
        String paymentMethod = scanner.nextLine().trim();

        payments[paymentIndexCount] = new Payment(paymentId, declarationId, amountPaid, paymentMethod);
    }


    private static void viewTaxpayerTaxSummary() {
        System.out.println("Tax payer name: " + taxpayers[0].getTaxpayerName() );
        System.out.println("Tax payer TIN number: " + taxpayers[0].getTaxpayerTin() );
        System.out.println("Tax payer Declaration: " + declarations[0].getDeclaredTax() );
        System.out.println("Tax amount: " + declarations[0].getTaxableAmount() );
        System.out.println("Payment: " + payments[0].getAmountPaid() );
    }


    private static void printMenu() {
        System.out.println("==================================================");
        System.out.println("     RRA Tax Management System Menu     ");
        System.out.println("==================================================");
        System.out.println("1. Register taxpayer");
        System.out.println("2. Register tax account");
        System.out.println("3. Submit declaration and calculate tax");
        System.out.println("4. Make payment");
        System.out.println("5. View taxpayer tax summary");
        System.out.println("0. Exit");
        System.out.println("==================================================");
    }
}