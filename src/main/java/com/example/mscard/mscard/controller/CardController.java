package com.example.mscard.mscard.controller;


import com.example.mscard.mscard.entity.CardEntity;
import com.example.mscard.mscard.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("getallcards")
    public List<CardEntity> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/{id}")
    public CardEntity getCardById(@PathVariable Long id) {
        return cardService.getCardById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CardEntity createCard(@Valid @RequestBody CardEntity card) {
        return cardService.createCard(card);
    }

    @DeleteMapping("/{id}")
    public void deleteCardById(@PathVariable Long id) {
        cardService.deleteCardById(id);
    }

    @PutMapping("/{id}")
    public CardEntity updateCard(@Valid @RequestBody CardEntity card, @PathVariable Long id) {
        return cardService.updateCard(card, id);
    }
}
