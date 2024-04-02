package SOAP;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client
{

    public static void main(String[] args) throws MalformedURLException
    {
        try
        {

            URL url = new URL("http://localhost:8080/ws/account?wsdl");

            QName qname = new QName("http://SOAP/", "AccountServiceImpService");
            Service service = Service.create(url, qname);
            AccountService accountService = service.getPort(AccountService.class);
            int myID = accountService.createAccount();
            processClient(accountService , myID);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void processClient(AccountService accountService , int myID) {
        while (true) {
            System.out.println("To Deposit Enter 1");
            System.out.println("To Withdraw Enter 2");
            System.out.println("To Make Balance Inquiry Enter 3");
            System.out.println("To Exit Enter 4");
            Scanner scanner = new Scanner(System.in);
            Scanner scanner2 = new Scanner(System.in);
            Integer choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Enter Amount To Deposit (Numbers - Floats)");
                Double amount = scanner2.nextDouble();
                boolean res = accountService.deposit(amount , myID);
                if (res) {
                    System.out.println("Ok , new Balance is " + accountService.getBalance(myID));
                } else {
                    System.out.println("Error !!! , You Can't Deposit negative balance");
                }
            } else if (choice == 2) {
                System.out.println("Enter Amount to Withdraw (Numbers - Floats");
                double amount = scanner2.nextDouble();
                boolean res = accountService.withdraw(amount , myID);
                if (res) {
                    System.out.println("Ok , new Balance is " + accountService.getBalance(myID));
                } else {
                    System.out.println("Error !! , Insufficient Balance or Negative Amount To WithDraw");
                }
           } else if (choice == 3) {
                System.out.println("Current Balance is : " + accountService.getBalance(myID));
            }
            else
            {
                System.exit(0);
            }
        }
    }

}
