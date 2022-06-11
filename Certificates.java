public class Certificates {
    User owner;
    String Name;
    int amount;
    public Certificates(User buyer,String Name, int amount)
    {
        this.owner = new User(buyer.Name, buyer.Password);
        this.Name = Name;
        this.amount = amount;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    public User getOwner() {return owner;}
    public void setOwner(User owner)
    {
        this.owner = owner;
    }
}
