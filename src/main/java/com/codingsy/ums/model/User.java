package com.codingsy.ums.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"username", "email"}))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "is_active")
    private boolean isActive;

    @Embedded
    private Address address;

    //	protected because we are using builder pattern
    protected User() {
        // Required by JPA
    }

    private User(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.email = builder.email;
        this.password = builder.password;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phone = builder.phone;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.isActive = builder.isActive;
        this.address = builder.address;
    }

    public static Builder builder() {
        return new Builder();
    }
    
    public Builder toBuilder() {
        return User.builder()
            .id(this.id)
            .username(this.username)
            .email(this.email)
            .password(this.password)
            .firstName(this.firstName)
            .lastName(this.lastName)
            .phone(this.phone)
            .address(this.address)
            .createdAt(this.createdAt)
            .updatedAt(this.updatedAt)
            .isActive(this.isActive);
    }

    public static class Builder {
        private Long id;
        private String username;
        private String email;
        private String password;
        private String firstName;
        private String lastName;
        private String phone;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private boolean isActive;
        private Address address;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder isActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    // Getters (setters not required unless needed manually)
    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public boolean isActive() { return isActive; }
    public Address getAddress() { return address; }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", username='" + username + '\'' +
               ", email='" + email + '\'' +
               ", password='" + password + '\'' +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", phone='" + phone + '\'' +
               ", createdAt=" + createdAt +
               ", updatedAt=" + updatedAt +
               ", isActive=" + isActive +
               ", address=" + address +
               '}';
    }
}
