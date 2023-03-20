package com.example.mscard.mscard.entity;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link CardEntity} entity
 */
@Data
@Builder
public class CardEntityDto implements Serializable {
    private final long id;
    @Size(min = 16)
    private final String card_No;
    private final long balance;
    private final Date expireData;
}