package com.example.mscard.mscard.mapper;
import com.example.mscard.mscard.DTO.CardEntityDto;
import com.example.mscard.mscard.entity.CardEntity;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {

    public CardEntityDto toDto(CardEntity cardEntity) {
        CardEntityDto cardDto = new CardEntityDto();
        cardDto.setId(cardEntity.getId());
        cardDto.setCard_No(cardEntity.getCard_No());
        cardDto.setBalance(cardEntity.getBalance());
        cardDto.setCvv(cardEntity.getCvv());
        cardDto.setExpireData(cardEntity.getExpireData());
        cardDto.setPin(cardEntity.getPin());
        return cardDto;
    }

    public CardEntity toEntity(CardEntityDto cardDto) {
        CardEntity cardEntity = new CardEntity();
        cardEntity.setId(cardDto.getId());
        cardEntity.setCard_No(cardDto.getCard_No());
        cardEntity.setBalance(cardDto.getBalance());
        cardEntity.setCvv(cardDto.getCvv());
        cardEntity.setExpireData(cardDto.getExpireData());
        cardEntity.setPin(cardDto.getPin());
        return cardEntity;
    }
}
