package SOAP;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

@WebService(endpointInterface = "SOAP.AccountService")
public class AccountServiceImp implements AccountService
{

    Map<Integer,Account> usersAccounts = new HashMap<>();
    int offset = 0;
    @Override
    public int createAccount()
    {
        offset++;
        Account myAccount = new Account();
        usersAccounts.put(offset , myAccount);
        return offset;
    }

    @Override
    public boolean withdraw(double amount , int id)
    {
        Account myAccount = usersAccounts.get(id);
        if (myAccount.getBalance() >= amount)
        {
            myAccount.setBalance(myAccount.getBalance()-amount);
            return true;
        }
        return false;
    }

    @Override
    public boolean deposit(double amount , int id)
    {
        Account myAccount = usersAccounts.get(id);
        if (amount < 0) return false;
        myAccount.setBalance(myAccount.getBalance()+amount);
        return true;
    }

    @Override
    public double getBalance(int id)
    {
        Account myAccount = usersAccounts.get(id);
        return myAccount.getBalance();
    }
}
