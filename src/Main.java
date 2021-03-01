
import java.util.ArrayList;



public class ApplicationRunner {
    public static void main(String[] args) {

        BankAccount ba= new BankAccount("123456789", 10000);
        Circle c= new Circle();
        c.setRadius(15);
        Rectangle r = new Rectangle();
        r.setSideA(15);
        r.setSideB(15);
        ArrayList<Printable> arr = new ArrayList<>();
        arr.add(ba);
        arr.add(c);
        arr.add(r);

        iterator(arr);
    }

    static void  iterator(ArrayList<Printable> arr)
    {
        for (int i=0;i<arr.size();i=i+1)
        {
            arr.get(i).printToConsole(i);
        }
    }
}
  import java.io.File;
  import java.io.FileWriter;
  import java.io.PrintWriter;


public class BankAccount implements Printable {

    String accountNumber;
    double balance;

    public BankAccount(String accNum,double bl)
    {
        accountNumber=accNum;
        balance=bl;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public double getBalance()
    {
        return balance;
    }
    public void  deposit(double amount)
    {
        balance= balance+amount;
    }
    public void  withdraw(double amount)
    {
        if(balance-amount>=0)
        {
            balance= balance-amount;
        }
    }

    @Override
    public void printToConsole(Object x) {

        System.out.println("Account Number = "+accountNumber);
        System.out.println("Balance ="+balance);
    }

    @Override
    public void printToFile(Object x) {
        try {
            File file = new File("BankAccount.txt");
            FileWriter fw = new FileWriter(file,true);
            PrintWriter pw = new PrintWriter(fw);

            String s="Account Number = "+accountNumber+ "\nBalance = "+balance ;

            pw.println(s);

            pw.close();
            fw.close();




        } catch (Exception ex) {
            ex.printStackTrace();
        }




    }

}

public interface Printable {

    void printToConsole(Object x);
    void printToFile(Object x);
}
