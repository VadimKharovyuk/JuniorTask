package com.example.juniortask.repository;

import java.util.List;

public interface PastaBoxRepositoty {
    PastaBoxEntity getByHash(String hash) ;
    List<PastaBoxEntity> getListPubluickAndLive();

    List<PastaBoxEntity> getListPubluickAndLive(int amount);

    void add(PastaBoxEntity pastaBoxEntity) ;
}
