public class UserAccount {

    String Name;
    int AccountNumber;
    int amount;
    public UserAccount(String Name)
    {

        this.Name = Name;
    }
    public UserAccount(String Name, int AccountNumber)
    {
        this.Name = Name;
        this.AccountNumber = AccountNumber;
    }
    public UserAccount(String Name, int AccountNumber, int amount)
    {
        this(Name, AccountNumber);
        this.amount = amount;
    }
    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getSecurityNumber() {
        return AccountNumber;
    }

    public void setSecurityNumber(int securityNumber) {
        AccountNumber = securityNumber;
    }
    public boolean reduceAccount(int amount)
    {
        if(amount < this.amount)
        {
            this.amount -= amount;
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean increaseAccount(int amount)
    {
        this.amount += amount;
        return true;
    }
    public void transferAccount(UserAccount ToAccount, int Amount)
    {
        this.amount -= Amount;
        ToAccount.amount  += Amount;
    }
}
