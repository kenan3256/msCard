package com.example.mscard.mscard.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "card")
public class CardEntity {
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(min = 16)
    @Column(name = "card_No",length = 16,nullable = false,updatable = false,unique = true)
    private String card_No;
    @Column(name = "balance")
    private long balance;
    @Size(min = 3)
    @Column(name = "cvv",nullable = false,updatable = false)
    private int cvv;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "expire_data",nullable = false,updatable = false)
    private Date expireData;//?????????
    @Column(name = "pin", nullable = false)
    private int pin;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}