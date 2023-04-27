package ba.bank.bank;

import ba.bank.SessionFactoryUtil;
import ba.bank.bank.transfer.ResponseModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * 1 - 1 relacija između
 * <li>AbstractBankAccount</li>
 * <li>BankAccount</li>
 */
public class AbstractBankAccount {

    private static SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

    public BankAccount getThis() {
        return (BankAccount) this;
    }

    public void save() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(getThis());
        session.getTransaction().commit();
    }

    public void update() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(getThis());
        session.getTransaction().commit();
    }

    public BankAccount get() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        BankAccount bankAccount = (BankAccount) session.get(BankAccount.class, getThis().getAccountNumber());
        session.getTransaction().commit();
        return bankAccount;
    }

    public void delete(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(getThis());
        session.getTransaction().commit();
    }

    public static BankAccount findByAccountNumber(String accountNumber){
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        BankAccount bankAccount = (BankAccount) session.get(BankAccount.class, accountNumber);
        session.getTransaction().commit();
        return bankAccount;
    }

    public static List<BankAccount> findAll() {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session.createQuery("from BankAccount");
        session.getTransaction().commit();
        return query.list();
    }

    public static ResponseModel transferMoney(BankAccount fromBankAccount, BankAccount toBankAccount, double transferAmount){
          if(transferAmount <= 0.0){
            return new ResponseModel(false, "Uneseni transferirani iznos ne može biti negativan broj");
        }
        if(fromBankAccount.getAmount()<transferAmount){
            return new ResponseModel(false, "Nema dovoljno sredstava na računu..");
        }
        if(fromBankAccount.equals(toBankAccount)){
            return new ResponseModel(false, "Ne možete sami sebi prebacivati novce..");

        }
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        fromBankAccount.setAmount(fromBankAccount.getAmount()-transferAmount);
        fromBankAccount.update();
        toBankAccount.setAmount(toBankAccount.getAmount()+transferAmount);
        toBankAccount.update();
        session.getTransaction().commit();
        return new ResponseModel(true, "Uspješna transakcija");
    }
}
