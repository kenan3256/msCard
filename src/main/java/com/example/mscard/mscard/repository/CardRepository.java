package com.example.mscard.mscard.repository;

import com.example.mscard.mscard.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<CardEntity,Long> {
}
