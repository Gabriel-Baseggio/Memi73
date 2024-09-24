package iago.hackathon.memi73.service;

import iago.hackathon.memi73.controller.dto.ImagemDTO;
import iago.hackathon.memi73.entity.Imagem;
import iago.hackathon.memi73.repository.ImagemRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@AllArgsConstructor
public class ImagemService {

    private ImagemRepository repository;

    public HttpStatus envioImagem(MultipartFile imagemEnvio){
        try{
            Imagem imagem = new Imagem(null, imagemEnvio.getBytes(), imagemEnvio.getContentType(), null);
            repository.save(imagem);
            return HttpStatus.OK;
        }catch (Exception e){
            return HttpStatus.NOT_ACCEPTABLE;
        }
    }

    public ImagemDTO pegarImagemAleatoria() {
        List<Imagem> todas = repository.findAll();
        int indexAleatorio = (int) (Math.random() * todas.size());
        return todas.get(indexAleatorio).toDTO();
    }

    public Imagem pegarImagemId(Long id){
        return repository.findById(id).get();
    }

}
