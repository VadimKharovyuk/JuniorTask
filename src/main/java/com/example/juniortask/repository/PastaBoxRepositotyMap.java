package com.example.juniortask.repository;

import com.example.juniortask.exaption.NotFindEntityExaption;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PastaBoxRepositotyMap implements PastaBoxRepositoty{


    private  final Map<String ,PastaBoxEntity> vault =  new HashMap<>();
    @Override
    public PastaBoxEntity getByHash(String hash) {
        PastaBoxEntity pastaBoxEntity = vault.get(hash);
        if (pastaBoxEntity == null){
            throw new NotFindEntityExaption("PasteBox not find with hash = "+hash);
        }
        return vault.get(hash);
    }

    @Override
    public List<PastaBoxEntity> getListPubluickAndLive() {
        return null;
    }

    @Override
    public List<PastaBoxEntity> getListPubluickAndLive(int amount) {
        LocalDateTime now = LocalDateTime.now();

        return vault.values().stream()
                .filter(PastaBoxEntity::isPublick)
                .filter(pastaBoxEntity -> pastaBoxEntity.getLifetime().isAfter(now))
                .sorted(Comparator.comparing(PastaBoxEntity::getId).reversed())
                .limit(amount)
                .collect(Collectors.toList());
    }

    @Override
    public void add(PastaBoxEntity pastaBoxEntity) {
        vault.put(pastaBoxEntity.getHash(), pastaBoxEntity);

    }
}
