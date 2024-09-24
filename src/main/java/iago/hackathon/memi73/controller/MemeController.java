package iago.hackathon.memi73.controller;

import iago.hackathon.memi73.controller.dto.FraseDTO;
import iago.hackathon.memi73.controller.dto.MemeCompletoDTO;
import iago.hackathon.memi73.service.MemeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@RequestMapping("/meme")
@CrossOrigin("*")
public class MemeController {
    private MemeService service;

    @PostMapping
    public ResponseEntity<?> memeSimples(@RequestPart MultipartFile file, @RequestPart FraseDTO dto){
        return new ResponseEntity<>(service.postMemeSimples(file, dto), HttpStatus.OK);
    }

    @PostMapping("/compartilhar/{id}")
    public ResponseEntity<?> compartilharMeme(@PathVariable Long id){
        try {
            return new ResponseEntity<>(service.compartilharMeme(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/compartilhar")
    public ResponseEntity<?> compartilharECriarMeme(@RequestBody MemeCompletoDTO memeCompletoDTO){
        return new ResponseEntity<>(service.compatilharECriarMeme(memeCompletoDTO), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarMeme(@PathVariable Long id){
        try {
            return new ResponseEntity<>(service.buscarMeme(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/compartilhados")
    public ResponseEntity<?> pegarMemesCompartilhados(@PageableDefault() Pageable pageable){
        return new ResponseEntity<>(service.pegarMemesCompartilhados(pageable), HttpStatus.OK);
    }

}
