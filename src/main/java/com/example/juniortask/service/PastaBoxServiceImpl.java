package com.example.juniortask.service;

import com.example.juniortask.repository.PastaBoxEntity;
import com.example.juniortask.repository.PastaBoxRepositoty;
import com.example.juniortask.request.PastaRequest;
import com.example.juniortask.request.PublicStatus;
import com.example.juniortask.responce.PastaBexResponce;
import com.example.juniortask.responce.PastaBexUrlResponce;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
//@ConfigurationProperties(prefix ="app")

public class PastaBoxServiceImpl  implements PastaBoxService{
    private String host = "http://abc.ua" ;
    private int publicListSize = 10 ;

    private final PastaBoxRepositoty repositoty ;
    private AtomicInteger idGenerator = new AtomicInteger(0);



    @Override
    public PastaBexResponce getByhash(String hash) {
        PastaBoxEntity pastaBoxEntity = repositoty.getByHash(hash);

        return new PastaBexResponce(pastaBoxEntity.getData(),pastaBoxEntity.isPublick());
    }

    @Override
    public List<PastaBexResponce> getFirstPublickPastaBox() {
        List<PastaBoxEntity> list = repositoty.getListPubluickAndLive(publicListSize);
        return list.stream().map(pastaBoxEntity ->
                new PastaBexResponce(pastaBoxEntity.getData(), pastaBoxEntity.isPublick())
        ).collect(Collectors.toList());


    }

    @Override
    public PastaBexUrlResponce create(PastaRequest request) {
        int hash  = generateId();
        PastaBoxEntity pastaBoxEntity = new PastaBoxEntity();
        pastaBoxEntity.setData(request.getData());
        pastaBoxEntity.setId(hash);
        pastaBoxEntity.setHash(Integer.toHexString(hash));
        pastaBoxEntity.setPublick(request.getPublicStatus()== PublicStatus.PUBLIC);
        pastaBoxEntity.setLifetime(LocalDateTime.now().plusSeconds(request.getTimeSeconds()));
                    repositoty.add(pastaBoxEntity);
                    return new PastaBexUrlResponce(host +"/" +pastaBoxEntity.getHash()) ;

    }

    private int generateId() {
        return idGenerator.getAndIncrement();
    }
}
