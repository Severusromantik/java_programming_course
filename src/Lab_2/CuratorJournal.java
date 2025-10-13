package Lab_2;

public class CuratorJournal {
    private String lastName;
    private String firstName;
    private String birthDate;
    private String phoneNumber;

    private Address address;

    public CuratorJournal(String lastName, String firstName, String birthDate, String phoneNumber, Address address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;

        this.address = address;
    }

    // Getters and Setters. methods to access and update the value of a private variable
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "--- Запис у журналі ---\n" +
                "Студент: " + lastName + " " + firstName + "\n" +
                "Дата народження: " + birthDate + "\n" +
                "Телефон: " + phoneNumber + "\n" +
                "Адреса: " + address.toString();
    }

}
