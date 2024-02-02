package com.example.juniortask.repository;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class PastaBoxEntity {
    private int id;
    private String data;
    private String hash;
    private LocalDateTime lifetime;
    private boolean isPublick;
}
