package com.example.mscard.mscard.mapper;
import com.example.mscard.mscard.DTO.CardEntityDto;
import com.example.mscard.mscard.entity.CardEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class CardMapper {

    private final ModelMapper modelMapper = new ModelMapper();


    public CardEntityDto toDto(CardEntity cardEntity) {
        CardEntityDto cardDto = modelMapper.map(cardEntity, CardEntityDto.class);
        return cardDto;
    }

    public CardEntity toEntity(CardEntityDto cardDto) {
        CardEntity cardEntity = modelMapper.map(cardDto, CardEntity.class);
        return cardEntity;
    }
    public List<CardEntityDto> toDtoList(List<CardEntity> cardEntities) {
        return cardEntities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }


}