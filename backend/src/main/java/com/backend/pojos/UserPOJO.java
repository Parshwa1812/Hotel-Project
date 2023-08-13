package com.backend.pojos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.backend.pojos.enums.UserRole;

@Entity
@Table(name = "users")
public class UserPOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "email")
    private String userEmail;

    @Column(name = "mob_no")
    private String mobileNumber;

    @ManyToMany
    @JoinTable(name = "users_address", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Set<AddressPOJO> addresses = new HashSet<AddressPOJO>();

    @Column(name = "reg_date")
    private LocalDate registeredDate;

    @Column(name = "password")
    private String password;

    @Column(name = "user_image")
    private byte[] userImage;

    @Column(name = "is_present")
    private Boolean isPresent;

    public UserPOJO() {
    }

    // public UserPOJO(String firstName, String lastName, UserRole role, String
    // userEmail) {
    // this.firstName = firstName;
    // this.lastName = lastName;
    // this.role = role;
    // this.userEmail = userEmail;
    // }

    public UserPOJO(String firstName, String lastName, UserRole role, String userEmail, String mobileNumber,
            Set<AddressPOJO> addresses, LocalDate registeredDate, String password, byte[] userImage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.userEmail = userEmail;
        this.mobileNumber = mobileNumber;
        this.addresses = addresses;
        this.registeredDate = registeredDate;
        this.password = password;
        this.userImage = userImage;
        this.isPresent = true;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRoles(UserRole role) {
        this.role = role;
    }

    public Boolean getIsPresent() {
        return isPresent;
    }

    public void setIsPresent(Boolean isPresent) {
        this.isPresent = isPresent;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Set<AddressPOJO> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressPOJO> addresses) {
        this.addresses = addresses;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getUserImage() {
        return userImage;
    }

    public void setUserImage(byte[] userImage) {
        this.userImage = userImage;
    }

    private String toStr() {
        return "UserPOJO [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role
                + ", userEmail=" + userEmail + ", mobileNumber=" + mobileNumber + ", addresses=" + addresses
                + ", registeredDate=" + registeredDate + "]";
    }

    @Override
    public String toString() {
        String message = "Invalid User";
        if (this.getIsPresent()) {
            message = toStr();
        }
        return message;
    }
}
