package com.example.mscard.mscard.controller;


import com.example.mscard.mscard.DTO.CardEntityDto;
import com.example.mscard.mscard.entity.CardEntity;
import com.example.mscard.mscard.mapper.CardMapper;
import com.example.mscard.mscard.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService cardService;
    private final CardMapper cardMapper;

    public CardController(CardService cardService, CardMapper cardMapper) {
        this.cardService = cardService;
        this.cardMapper = cardMapper;
    }

    @GetMapping("/")
    public List<CardEntityDto> getAllCards() {
        List<CardEntity> cards = cardService.getAllCards();
        return cardMapper.toDtoList(cards);
    }

    @GetMapping("/{id}")
    public CardEntityDto getCardById(@PathVariable("id") Long id) {
        CardEntity card = cardService.getCardById(id);
        return cardMapper.toDto(card);
    }

    @PostMapping("/")
    public CardEntityDto createCard(@RequestBody CardEntityDto cardDto) {
        CardEntity card = cardMapper.toEntity(cardDto);
        card = cardService.createCard(card);
        return cardMapper.toDto(card);
    }

    @PutMapping("/{id}")
    public CardEntityDto updateCard(@RequestBody CardEntityDto cardDto, @PathVariable("id") Long id) {
        CardEntity card = cardMapper.toEntity(cardDto);
        card = cardService.updateCard(card, id);
        return cardMapper.toDto(card);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCardById(@PathVariable("id") Long id) {
        cardService.deleteCardById(id);
        return ResponseEntity.noContent().build();
    }
}
