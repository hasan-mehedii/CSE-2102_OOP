// i) Consider the parent class named Account. design its two child classes named
// CurrentAccount and SavingsAccount. Child classes should be at least one additional
// meaningful variable declared within them, one parameterized constructor and a toString
// method. The CurrentAccount maintains daily transactions, and provides a chequebook 
// facility, but does not provide any interest. The SavingsAccount does not provide any
// chequebook but provides yearly interest.

// ii) Design a driver class named Inheritance Test and a main method inside it.
// Declare at least one object of each of the two child classes using the
// parameterized constructor. Display values of all the variables of these
// objects using the toString method. You have to ensure the maximum utilization
// of the variables/methods of the parent class.

class Account{
    int accountNumber;
    String name;
    double balance;

    Account(int n, String s, double b){
        accountNumber = n;
        name = s;
        balance = b;
    }

    public String toString(){
        return accountNumber + " " + name + " " + balance;
    }
}

class CurrentAccount extends Account{
    int dailyTransactions;

    CurrentAccount(int n, String s, double b, int transactions){
        super(n, s, b);
        this.dailyTransactions = transactions;
    }

    public String toString(){
        return super.toString() + " Daily Transactions: " + dailyTransactions + " Chequebook Facility: Yes";
    }
}

class SavingsAccount extends Account{
    double yearlyInterest;

    SavingsAccount(int n, String s, double b, double interest){
        super(n, s, b);
        this.yearlyInterest = interest;
    }

    public String toString(){
        return super.toString() + " Yearly Interest: " + yearlyInterest + "% Chequebook Facility: No";
    }
}

public class Q1_b{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        CurrentAccount ca = new CurrentAccount(1001, "John Doe", 5000.0, 10);
        SavingsAccount sa = new SavingsAccount(1002, "Jane Doe", 7000.0, 4.5);

        System.out.println(ca.toString());
        System.out.println(sa.toString());
        scanner.close();
    }
}
