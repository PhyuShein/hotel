package com.example.hotelmanagenetsystem.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity

public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookingNumber;
    private int numberOfAdults;
    private int numberOfChildren;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fromStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate toEnd;
    private boolean bookingCancelled;
    private double inAdvance;
    private double fullCharges;


    @ManyToOne
    private UserProfile userProfile;



    public Bookings() {
    }

    public Bookings(String bookingNumber, int numberOfAdults, int numberOfChildren, LocalDate fromStart, LocalDate toEnd, boolean bookingCancelled, double inAdvance, double fullCharges, UserProfile userProfile) {
        this.bookingNumber = bookingNumber;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;
        this.fromStart = fromStart;
        this.toEnd = toEnd;
        this.bookingCancelled = bookingCancelled;
        this.inAdvance = inAdvance;
        this.fullCharges = fullCharges;
        this.userProfile = userProfile;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public LocalDate getFrom() {
        return fromStart;
    }

    public void setFrom(LocalDate from) {
        this.fromStart = from;
    }

    public LocalDate getTo() {
        return toEnd;
    }

    public void setTo(LocalDate to) {
        this.toEnd = to;
    }

    public boolean isBookingCancelled() {
        return bookingCancelled;
    }

    public void setBookingCancelled(boolean bookingCancelled) {
        this.bookingCancelled = bookingCancelled;
    }

    public double getInAdvance() {
        return inAdvance;
    }

    public void setInAdvance(double inAdvance) {
        this.inAdvance = inAdvance;
    }

    public double getFullCharges() {
        return fullCharges;
    }

    public void setFullCharges(double fullCharges) {
        this.fullCharges = fullCharges;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }


}
