package br.com.fiap.fintech.backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "T_FTC_USER")
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_USER"
    )
    @SequenceGenerator(
            name = "SEQ_USER",
            sequenceName = "SEQ_USER",
            allocationSize = 1
    )
    @Column(name = "ID_USER")
    private Integer id;

    @Column(name = "NM_USER")
    private String name;

    @Column(name = "DT_BIRTH")
    private LocalDate birthDate;

    @Column(name = "DS_GENRE")
    private String genre;

    @Column(name = "DT_CREATED_AT")
    private LocalDate createdAt;

    @Column(name = "TX_URL_IMG_PROFILE")
    private String img_url;

    @Column(name = "TX_EMAIL")
    private String email;

    @Column(name = "TX_PASSWORD")
    private String password;

    public User() {
    }

    public User (String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public User(String name, LocalDate birthDate, String genre, LocalDate createdAt, String img_url, String email, String password) {
        this.name = name;
        this.birthDate = birthDate;
        this.genre = genre;
        this.createdAt = createdAt;
        this.img_url = img_url;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public User setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public User setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public User setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getImg_url() {
        return img_url;
    }

    public User setImg_url(String img_url) {
        this.img_url = img_url;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}
