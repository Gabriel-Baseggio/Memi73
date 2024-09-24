package iago.hackathon.memi73.controller;

import iago.hackathon.memi73.service.FraseService;
import iago.hackathon.memi73.service.ImagemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/envio")
@AllArgsConstructor
@CrossOrigin("*")
public class EnvioController {

    private ImagemService imagemService;
    private FraseService fraseService;

    @PostMapping("/imagem")
    public ResponseEntity<?> envioImagem(@RequestPart MultipartFile image){
        return new ResponseEntity<>(imagemService.envioImagem(image));
    }

    @PostMapping("/frase")
    public ResponseEntity<?> envioFrase(@RequestBody String frase){
        return new ResponseEntity<>(fraseService.envioFrase(frase));
    }

}
