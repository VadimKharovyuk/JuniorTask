package com.example.juniortask.service;

import com.example.juniortask.request.PastaRequest;
import com.example.juniortask.responce.PastaBexResponce;
import com.example.juniortask.responce.PastaBexUrlResponce;

import java.util.List;

public interface PastaBoxService {
   PastaBexResponce getByhash(String hash) ;
   List<PastaBexResponce> getFirstPublickPastaBox ( );
    PastaBexUrlResponce create(PastaRequest request);


}
