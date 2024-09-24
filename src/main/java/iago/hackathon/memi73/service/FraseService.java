package iago.hackathon.memi73.service;

import iago.hackathon.memi73.controller.dto.FraseDTO;
import iago.hackathon.memi73.entity.Frase;
import iago.hackathon.memi73.repository.FraseRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FraseService {

    private FraseRepository repository;


    public HttpStatus envioFrase(String frase){
        try {
            repository.save(new Frase(null,frase,null));
            return HttpStatus.OK;
        }catch (Exception e){
            return HttpStatus.NOT_ACCEPTABLE;
        }
    }

    public FraseDTO pegarFraseAleatoria() {
        List<Frase> todas = repository.findAll();
        int indexAleatorio = (int) (Math.random() * todas.size());
        return todas.get(indexAleatorio).toDTO();
    }

    public Frase pegerFraseId(Long id){
        return repository.findById(id).get();
    }
}
