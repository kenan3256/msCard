package com.example.mscard.mscard.DTO;

import com.example.mscard.mscard.entity.CardEntity;
import lombok.Data;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class CardEntityDto implements Serializable {
    private final long id;
    @Size(min = 16)
    private final String card_No;
    private final long balance;
    @Size(min = 3)
    private final int cvv;
    private final Date expireData;
    private final int pin;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
}