package SOAP;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface AccountService
{
    @WebMethod
    public int createAccount();
    @WebMethod
    public boolean withdraw(double amount , int id);

    @WebMethod
    public boolean deposit(double amount ,int id);

    @WebMethod
    public double getBalance(int id);
}
