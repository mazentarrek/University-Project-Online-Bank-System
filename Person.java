public class Person {
    private String TransactionColumn;
    private String TransactionDescriptionC;

    public Person(String transactionColumn, String transactionDescriptionC) {
        this.TransactionColumn = transactionColumn;
        this.TransactionDescriptionC = transactionDescriptionC;
    }
    public String getTransactionColumn() {
        return TransactionColumn;
    }

    public String getTransactionDescriptionC() {
        return TransactionDescriptionC;
    }

}