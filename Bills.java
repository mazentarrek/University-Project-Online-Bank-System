public class Bills {
    User client;
    String BillType;
    int amount;

    public Bills(User client, String BillType, int amount) {
        this.client = new User(client.Name, client.Password);
        this.BillType = BillType;
        this.amount = amount;
    }

    public User getClient() {
        return client;
    }

    public String getBillType() {
        return BillType;
    }

    public int getAmount() {
        return amount;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public void setBillType(String billType) {
        BillType = billType;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
