package unit04.simple_classes_and_objects.task08;

public class Customer {
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private String address;
    private String creditCardNumber;
    private String bankAccountNumber;


    public Customer(int id, String name, String surname, String patronymic, String address, String creditCardNumber, String bankAccountNumber) {
        setId(id);
        setName(name);
        setSurname(surname);
        setPatronymic(patronymic);
        setAddress(address);
        setCreditCardNumber(creditCardNumber);
        setBankAccountNumber(bankAccountNumber);
    }

    @Override
    public String toString() {
        return "Customer:" + '\n' +
                "id: " + id + '\n' +
                "Surname: " + surname + '\n' +
                "Name: " + name + '\n' +
                "Patronymic: " + patronymic + '\n' +
                "Address:" + address + '\n' +
                "Credit card number: " + creditCardNumber + '\n' +
                "Bank account number: " + bankAccountNumber + '\n';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getAddress() {
        return address;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }
}
