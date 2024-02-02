package com.example.juniortask.comtroller;

import com.example.juniortask.request.PastaRequest;
import com.example.juniortask.responce.PastaBexResponce;
import com.example.juniortask.responce.PastaBexUrlResponce;
import com.example.juniortask.service.PastaBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final PastaBoxService service ;

    @GetMapping("/{hash}")
    public PastaBexResponce getByhash(@PathVariable String hash){

        return service.getByhash(hash);
    }
    @GetMapping("/")
    public List<PastaBexResponce>getList(){

        return service.getFirstPublickPastaBox();
}
@PostMapping("/")
    public PastaBexUrlResponce add(@RequestBody PastaRequest request){
        return service.create(request);

}


}
