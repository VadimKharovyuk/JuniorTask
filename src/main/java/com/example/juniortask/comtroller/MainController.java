package com.example.juniortask.comtroller;

import com.example.juniortask.request.PastaRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
public class MainController {




    @GetMapping("/{hash}")
    public String  getByhash(@PathVariable String hash){

        return hash;
    }
    @GetMapping("/")
    public List<String>   getList(){

        return Collections.EMPTY_LIST;
}
@PostMapping("/")
    public String add(@RequestBody PastaRequest request){
        return request.getData();

}


}
