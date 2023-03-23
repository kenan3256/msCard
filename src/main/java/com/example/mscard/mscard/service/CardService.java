package com.example.mscard.mscard.service;

import com.example.mscard.mscard.entity.CardEntity;
import com.example.mscard.mscard.repository.CardRepository;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<CardEntity> getAllCards() {
        return cardRepository.findAll();
    }

    public CardEntity getCardById(Long id) {
        return cardRepository.findById(id).orElseThrow(() -> new RuntimeException("Card not found with id " + id));
    }

    public CardEntity createCard(CardEntity card) {
        return cardRepository.save(card);
    }

    public void deleteCardById(Long id) {
        if (!cardRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Card with id " + id + " not found.");
        }
        cardRepository.deleteById(id);
    }


    public CardEntity updateCard(CardEntity card, Long id) {
        CardEntity existingCard = cardRepository.findById(id).orElseThrow(() -> new RuntimeException("Card not found with id " + id));

        existingCard.setCard_No(card.getCard_No());
        existingCard.setBalance(card.getBalance());
        existingCard.setCvv(card.getCvv());
        existingCard.setExpireData(card.getExpireData());
        existingCard.setPin(card.getPin());

        return cardRepository.save(existingCard);
    }
}
