package com.example.juniortask.request;

import lombok.Data;

@Data

public class PastaRequest {
    private String data;
    private Long timeSeconds ;
    private  PublicStatus publicStatus ;
}
