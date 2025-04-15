package assignment4;

class BankAccount {
    private String holderName;
    private int accountBalance;

    // Constructor
    public BankAccount(String holderName, int accountBalance) {
        this.holderName = holderName;
        this.accountBalance = accountBalance;
    }

    // Withdraw method (without synchronization - may cause overdraw)
    public void withdrawAmount(int amount, String user) {
        if (accountBalance >= amount) {
            System.out.println(user + " is withdrawing ₹" + amount);
            try { Thread.sleep(100); } catch (InterruptedException e) { }
            accountBalance -= amount;
            System.out.println(user + " successfully withdrew ₹" + amount + ". Remaining Balance: ₹" + accountBalance);
        } else {
            System.out.println(user + " attempted to withdraw ₹" + amount + " but insufficient funds. Balance: ₹" + accountBalance);
        }
    }

    // Withdraw method (with synchronization - thread-safe)
    public synchronized void secureWithdraw(int amount, String user) {
        if (accountBalance >= amount) {
            System.out.println(user + " is withdrawing ₹" + amount);
            try { Thread.sleep(100); } catch (InterruptedException e) { }
            accountBalance -= amount;
            System.out.println(user + " successfully withdrew ₹" + amount + ". Remaining Balance: ₹" + accountBalance);
        } else {
            System.out.println(user + " attempted to withdraw ₹" + amount + " but insufficient funds. Balance: ₹" + accountBalance);
        }
    }
}

// Thread class for unsafe withdrawal (No synchronization)
class NonSynchronizedWithdrawal extends Thread {
    private BankAccount account;
    private int withdrawalAmount;
    private String user;

    public NonSynchronizedWithdrawal(BankAccount account, int withdrawalAmount, String user) {
        this.account = account;
        this.withdrawalAmount = withdrawalAmount;
        this.user = user;
    }

    @Override
    public void run() {
        account.withdrawAmount(withdrawalAmount, user);
    }
}

// Thread class for safe withdrawal (With synchronization)
class SynchronizedWithdrawal extends Thread {
    private BankAccount account;
    private int withdrawalAmount;
    private String user;

    public SynchronizedWithdrawal(BankAccount account, int withdrawalAmount, String user) {
        this.account = account;
        this.withdrawalAmount = withdrawalAmount;
        this.user = user;
    }

    @Override
    public void run() {
        account.secureWithdraw(withdrawalAmount, user);
    }
}

// Banking Simulation
public class BankSimulation {
    public static void main(String[] args) {
        System.out.println("===== Demonstrating Unsynchronized Withdrawal (Overdraw Problem) =====");
        demonstrateUnsafeWithdrawal();

        System.out.println("\n===== Demonstrating Synchronized Withdrawal (Thread-Safe) =====");
        demonstrateSafeWithdrawal();
    }

    private static void demonstrateUnsafeWithdrawal() {
        BankAccount sharedAccount = new BankAccount("Shared Account", 1000);

        // Two users withdrawing at the same time (without synchronization)
        NonSynchronizedWithdrawal t1 = new NonSynchronizedWithdrawal(sharedAccount, 800, "User 1");
        NonSynchronizedWithdrawal t2 = new NonSynchronizedWithdrawal(sharedAccount, 700, "User 2");

        t1.start();
        t2.start();

        try { t1.join(); t2.join(); } catch (InterruptedException e) { }
    }

    private static void demonstrateSafeWithdrawal() {
        BankAccount sharedAccount = new BankAccount("Shared Account", 1000);

        // Two users withdrawing at the same time (with synchronization)
        SynchronizedWithdrawal t1 = new SynchronizedWithdrawal(sharedAccount, 800, "User 1");
        SynchronizedWithdrawal t2 = new SynchronizedWithdrawal(sharedAccount, 700, "User 2");

        t1.start();
        t2.start();

        try { t1.join(); t2.join(); } catch (InterruptedException e) { }
    }
}
