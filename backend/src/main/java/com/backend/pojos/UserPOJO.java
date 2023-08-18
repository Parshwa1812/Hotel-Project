package com.backend.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.backend.pojos.enums.UserRole;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_address", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "address_id"))
    // @JsonManagedReference
    private Set<AddressPOJO> addresses = new HashSet<AddressPOJO>();

    public Boolean addAddress(AddressPOJO addressPOJO) {
        addressPOJO.getUsers().add(this);
        return this.addresses.add(addressPOJO);
    }

    public Boolean removeAddress(AddressPOJO addressPOJO) {
        addressPOJO.getUsers().remove(this);
        return this.addresses.remove(addressPOJO);
    }

    @Column(name = "reg_date")
    private LocalDate registeredDate = LocalDate.now();

    @Column(name = "password")
    private String password;

    @Column(name = "user_image")
    private byte[] userImage;

    @Column(name = "is_present")
    private Boolean isPresent = true;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TableReservationPOJO> reservedTables = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderPOJO> orders = new HashSet<>();

    public void addTableReservation(TableReservationPOJO tableReservationPOJO) {
        reservedTables.add(tableReservationPOJO);
        tableReservationPOJO.setUser(this);
    }

    public void removeTableReservation(TableReservationPOJO tableReservationPOJO) {
        reservedTables.remove(tableReservationPOJO);
        tableReservationPOJO.setUser(null);
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
