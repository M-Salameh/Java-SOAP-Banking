package SOAP;

public class Account
{
    double balance;

    public Account()
    {
        balance = 0;
    }
    public Account(double balance)
    {
        if (balance >= 0) this.balance = balance;
        else this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance)
    {
        if(balance >=0) this.balance = balance;
        else this.balance = 0;
    }
}
