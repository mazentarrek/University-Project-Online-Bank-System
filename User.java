public class User {
    String Name;
    String Password;
    String PhoneNumber;
    String EmailAddress;
    int points = 0;
    UserAccount a1;
    UserAccount a2;

    public User(String Name, String Password) {
        this.Name = Name;
        this.Password = Password;
    }

    public User(String Name, String Password, String a1Name, int secure1,int start1, String a2Name, int secure2,int start2) {
        this(Name, Password);
        a1 = new UserAccount(a1Name, secure1,start1);
        a2 = new UserAccount(a2Name, secure2,start2);
    }

    public User(String Name, String Password, String PhoneNumber, String address, String a1Name, int start1, int secure1, String a2Name, int secure2, int start2) {
        this(Name, Password, a1Name, secure1,start1, a2Name, secure2,start2);
        this.PhoneNumber = PhoneNumber;
        this.EmailAddress = address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return EmailAddress;
    }

    public void setAddress(String address) {
        EmailAddress = address;
    }


    public boolean getRewards(String Name, int price) {
        Offer r = new Offer(Name, price);
        if(r.RedeemOffer(this.points))
        {
            this.points -= price;
            return true;
        }
        return false;

    }
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    public int addPoint(int amount)
    {
        return(this.points += amount);
    }

    public int SeeMyAccountAmount(UserAccount a) {
        return a.getAmount();
    }

    public boolean addMoneyToMyAccount(UserAccount a, int amount) {
        return a.increaseAccount(amount);
    }

    public Boolean buyCertificates(User client, String Name, int amount) {
        if (amount > 0 && (amount < this.a1.amount || amount < this.a2.amount)) {
            Certificates c = new Certificates(client, Name, amount);
            return true;
        }
        return false;
    }

    public boolean withdraw1(int amount) {
        return (this.a1.reduceAccount(amount));
    }

    public boolean withdraw2(int amount) {
        return (this.a2.reduceAccount(amount));
    }

    public Boolean PayBills(User client, String Name, int amount) {
        if (amount > 0 && (amount < this.a1.amount || amount < this.a2.amount)) {
            Bills b = new Bills(client, Name, amount);
            return true;
        }
        return false;
    }


//    public Boolean buyCurrency(String Name, int amount, int price, char logo) {
//        Currency c1 = new Currency(Name, logo, price);
//        return (c1.BuyCurrency(Name, amount, this.a1.getAmount()));
//
//    }
}
