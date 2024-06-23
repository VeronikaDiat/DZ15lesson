package DZ15lesson.lesson_15.homework;

import DZ15lesson.lesson_15.homework.exceptions.WrongAccountException;
import DZ15lesson.lesson_15.homework.exceptions.WrongCurrencyException;
import DZ15lesson.lesson_15.homework.exceptions.WrongOperationException;

public class Main
{
    private static DZ15lesson.lesson_15.homework.BankApplication  BankApplication;


    public void Application (DZ15lesson.lesson_15.homework.BankApplication BankApplication){
        Main.BankApplication = BankApplication;
    }

    public static void processWrapper(String accountId, int amount, String currency) {
        try {
            BankApplication.process(accountId,amount,currency);
        }
        catch (WrongAccountException e){
            System.out.println("This account not exist");
        }
        catch (WrongCurrencyException e){
            System.out.println("The account has an account in another currency");
        }
        catch (WrongOperationException e){
            System.out.println("The account does not have enough funds");
        } catch (Exception e) {
            System.out.println("A processing error occurred, please try again");
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("Thank you for using our service");
        }
    }
    static public void main(String[] args) {

        if (BankApplication == null) {
            BankApplication = new BankApplication();
        }
        processWrapper("accountId000", 50, "USD");
        processWrapper("accountId003", 250, "HRV");
        processWrapper("accountId001", 50, "EUR");
        processWrapper("accountId001", 50, "USD");
        processWrapper("accountId001", 200, "USD");

    }
}
