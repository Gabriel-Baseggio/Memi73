package iago.hackathon.memi73.service;

import iago.hackathon.memi73.controller.dto.ImagemDTO;
import iago.hackathon.memi73.controller.dto.FraseDTO;
import iago.hackathon.memi73.controller.dto.MemeCompletoDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GeradorService {

    private MemeService memeService;
    private  ImagemService imagemService;
    private  FraseService fraseService;

    public ImagemDTO pegarImagemAleatoria() {
        return imagemService.pegarImagemAleatoria();
    }

    public FraseDTO pegarFraseAleatoria() {
        return fraseService.pegarFraseAleatoria();
    }

    public MemeCompletoDTO pegarMemeAleatorio() {
        return memeService.pegarMemeAleatorio();
    }

    public MemeCompletoDTO gerarMeme() {
        return new MemeCompletoDTO(null, fraseService.pegarFraseAleatoria(), imagemService.pegarImagemAleatoria());
    }
}
