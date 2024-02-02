package com.example.juniortask.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PastaRequest {
    private  final String data;
    private final Long timeSeconds ;
    private   final PublicStatus publicStatus ;
}
