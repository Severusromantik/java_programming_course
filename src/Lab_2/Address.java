package Lab_2;

public class Address {
    // Характеристика нашого класу (поля)
    private String city;
    private String street;
    private String house;
    private String apartment;

    // Конструктор класу. (ініціалізація полів)
    public Address(String city, String street, String house, String apartment) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }

    // Getters and Setters. methods to access and update the value of a private variable
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }
    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartment() {
        return apartment;
    }
    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "м. " + city + ", вул. " + street + ", буд. " + house + ", кв. " + apartment;
    }
}
