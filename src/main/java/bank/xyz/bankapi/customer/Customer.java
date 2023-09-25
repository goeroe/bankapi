package bank.xyz.bankapi.customer;

import bank.xyz.bankapi.utils.RandomPasswordGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.Period;

@Entity
public class Customer {
    @Id
    private String userName;
    private LocalDate birthDate;
    private String iban;
    private String country;

    public Customer() {
    }

    private String document_path;

    private String password;

    public Customer(String userName, LocalDate birthDate, String country) {
        super();
        this.userName = userName;
        this.birthDate = birthDate;
        this.country = country;
        this.password = new RandomPasswordGenerator().generatePassayPassword();
        this.iban = this.country+"00xyza000000000000";
    }

    public String getIban() {
        return iban;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getDocument_path() {
        return document_path;
    }

    public void setDocument_path(String document_path) {
        this.document_path = document_path;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdult() {
        int age = Period.between(this.getBirthDate(), LocalDate.now()).getYears();
        return age >= 18;

    }
}
