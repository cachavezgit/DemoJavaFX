package com.wilsondevelopment.demojavafx.models;

import javafx.beans.property.*;

import java.time.LocalDate;

// Model class para mostrar informacion en la aplicación
public class Persona {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty street;
    private final IntegerProperty postalCode;
    private final StringProperty city;
    private final ObjectProperty<LocalDate> birthdate;

    public Persona(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.street = new SimpleStringProperty("Elm Street");
        this.postalCode = new SimpleIntegerProperty(1234);
        this.city = new SimpleStringProperty("Mexicali");
        this.birthdate = new SimpleObjectProperty<LocalDate>
                (LocalDate.of(2000,7,12));
    }

    public Persona(String firstName, String lastName, String street, int postalCode, String city, LocalDate birthdate) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.street =  new SimpleStringProperty(street);
        this.postalCode =  new SimpleIntegerProperty(postalCode);
        this.city = new SimpleStringProperty(city);
        this.birthdate = new SimpleObjectProperty<LocalDate>(birthdate);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName){
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName){
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getStreet() {
        return street.get();
    }

    public void setStreet(String street){
        this.street.set(street);
    }

    public StringProperty streetProperty() {
        return streetProperty();
    }

    public int getPostalCode() {
        return postalCode.get();
    }

    public void setPostalCode(int postalCode){
        this.postalCode.set(postalCode);
    }

    public IntegerProperty postalCodeProperty() {
        return postalCode;
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city){
        this.city.set(city);
    }

    public StringProperty cityProperty() {
        return cityProperty();
    }

    public LocalDate getBirthdate() {
        return birthdate.get();
    }

    public void setBirthDate(LocalDate birthDate){
        this.birthdate.set(birthDate);
    }

    public ObjectProperty<LocalDate> birthdayPropery() {
        return birthdate;
    }

}
