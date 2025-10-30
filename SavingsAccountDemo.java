
// SavingsAccountDemo for class/instance/static/Math/Wrapper demo

public class SavingsAccountDemo {
    private static class SavingsAccount {
        private double balance;
        private static double interestRate;
        private static int numberOfAccounts = 0;

        public SavingsAccount(double initialBalance) {
            this.balance = initialBalance;
            numberOfAccounts++;
        }

        public static void setInterestRate(double r) {
            if (r < 0) {
                interestRate = 0.0;
            } else {
                interestRate = r;
            }
        }

        public void deposit(double m) {
            if (m >= 0) {
                balance += m;
            }
        }

        public void addAnnualInterest() {
            balance *= (1 + interestRate);
        }

        public double getBalance() {
            return balance;
        }

        public static void showBalance(SavingsAccount acc) {
            System.out.println(acc.getBalance());
        }

        public static int getNumberOfAccounts() {
            return numberOfAccounts;
        }

        public static double roundUpToInt(double x) {
            return Math.ceil(x);
        }
    }

    public static void main(String[] args) {
    SavingsAccount.setInterestRate(0.01);

    SavingsAccount accA = new SavingsAccount(1000.0);
    SavingsAccount accB = new SavingsAccount(500.0);

    System.out.println("Number of accounts: " + SavingsAccount.getNumberOfAccounts());
    System.out.println();

    System.out.print("Account A: balance = ");
    System.out.print(accA.getBalance());
    accA.addAnnualInterest();
    System.out.print(" \u2192 after interest = ");
    System.out.println(accA.getBalance());

    System.out.print("Account B: balance = ");
    System.out.print(accB.getBalance());
    accB.addAnnualInterest();
    System.out.print(" \u2192 after interest = ");
    System.out.println(accB.getBalance());
    System.out.println();

    double toRound = 3.3;
    double ceiled = SavingsAccount.roundUpToInt(toRound);
    System.out.println("ceil(" + toRound + ") = " + ceiled);

    Integer intVal = Integer.valueOf("123");
    System.out.println("Integer.valueOf(\"123\") + 1 = " + (intVal + 1));

    double doubleVal = Double.parseDouble("3.14") * 2;
    System.out.println("Double.parseDouble(\"3.14\") * 2 = " + doubleVal);
    }
}
