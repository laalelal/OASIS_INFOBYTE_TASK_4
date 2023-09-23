import java.util.*;
public class ATM_INTERFACE {
    private double balance;
    public ATM_INTERFACE(double initial_Balance) {
        balance = initial_Balance;
    }
    public double check_Balance() {
        return balance;  //task rule.point 3.SEPARATE METHOD TO CHECK THE BALANCE
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Your Amount is Deposited successful.");
            System.out.println("Your updated balance is "+balance);  // Task rule,point.3..Separate method for deposit amount
        } 
        else {
            System.out.println("Invalid amount.You must  deposit an amount greater than 0.");
        }
    }
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter an amount greater than 0.");
            System.out.println("You have an amount of " +check_Balance() +" Kindly withdraw an amount greater than 0 and less than or equal to  " +check_Balance());
            return;
        } // separate method for withdraw money.

        if (amount > balance) {
            System.out.println("Insufficient funds. Please enter a smaller amount.");
            return;
        }

        balance -= amount;
        System.out.println("Transaction successful.\n New balance is : " + balance);
    }
    public void turnOn() {
        System.out.println("ATM is WORKING.");
    }
    public void turnOff() {
        System.out.println("ATM is now turned off.");
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ATM_INTERFACE myATM = new ATM_INTERFACE(1000.0);
        myATM.turnOn();
        System.out.println("Current balance in your bank account is : " + myATM.check_Balance());
        System.out.println("Enter the amount you want to deposit in your Bank account : ");
        double depositAmount = sc.nextFloat();
        myATM.deposit(depositAmount);
        System.out.println("Enter the amount you want to Withdraw from your Bank account : ");
        double withdrawAmount = sc.nextFloat();
        myATM.withdraw(withdrawAmount);
        sc.close();
        myATM.turnOff();
    }
}

