package com.driver.model;

import javax.persistence.*;

@Entity
public class Payment {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;

        private Boolean paymentCompleted;

        @Enumerated
        private PaymentMode paymentMode;

        @OneToOne
        @JoinColumn
        private Reservation reservation;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getPaymentCompleted() {

        return paymentCompleted;
    }

    public void setPaymentCompleted(Boolean paymentCompleted) {

        this.paymentCompleted = paymentCompleted;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Payment(int id, Boolean paymentCompleted) {
        this.id = id;
        this.paymentCompleted = paymentCompleted;
    }
    public Payment(){

    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Payment(int id, Boolean paymentCompleted, Reservation reservation) {
        this.id = id;
        this.paymentCompleted = paymentCompleted;
        this.reservation = reservation;
    }

    public Payment(int id, Boolean paymentCompleted, PaymentMode paymentMode, Reservation reservation) {
        this.id = id;
        this.paymentCompleted = paymentCompleted;
        this.paymentMode = paymentMode;
        this.reservation = reservation;
    }


}
