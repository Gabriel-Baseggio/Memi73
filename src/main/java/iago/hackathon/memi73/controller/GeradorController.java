package iago.hackathon.memi73.controller;

import iago.hackathon.memi73.service.GeradorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gerador")
@AllArgsConstructor
@CrossOrigin("*")
public class GeradorController {

    private GeradorService service;

    @GetMapping("/imagem")
    public ResponseEntity<?> pegarImagemAleatoria() {
        return new ResponseEntity<>(service.pegarImagemAleatoria(), HttpStatus.OK);
    }

    @GetMapping("/frase")
    public ResponseEntity<?> pegarFraseAleatoria() {
        return new ResponseEntity<>(service.pegarFraseAleatoria(), HttpStatus.OK);
    }

    @GetMapping("/meme")
    public ResponseEntity<?> pegarMemeAleatorio() {
        return new ResponseEntity<>(service.pegarMemeAleatorio(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> gerarMeme() {
        return new ResponseEntity<>(service.gerarMeme(), HttpStatus.OK);
    }

}
