package iago.hackathon.memi73.service;

import iago.hackathon.memi73.controller.dto.MemeCompletoDTO;
import iago.hackathon.memi73.controller.dto.FraseDTO;
import iago.hackathon.memi73.entity.Frase;
import iago.hackathon.memi73.entity.Imagem;
import iago.hackathon.memi73.entity.Meme;
import iago.hackathon.memi73.repository.MemeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MemeService {
    private MemeRepository repository;
    private ImagemService imagemService;
    private FraseService fraseService;

    public MemeCompletoDTO postMemeSimples(MultipartFile file, FraseDTO dto){
        Imagem imagem = new Imagem();
        Frase frase = new Frase();
        Meme meme = new Meme();
        try{
            imagem.setImagem(file.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
        imagem.setTipo(file.getContentType());
        frase.setFrase(dto.frase());
        meme.setFrase(frase);
        meme.setImagem(imagem);
        salvarMeme(meme);
        return meme.toDTO();

    }

    private void salvarMeme(Meme meme) {
        repository.save(meme);
    }

    public MemeCompletoDTO buscarMeme(Long id) throws Exception {
        return buscarMemePorID(id).toDTO();
    }

    private Meme buscarMemePorID(Long id) throws Exception {
        Optional<Meme> meme = repository.findById(id);

        if (meme.isEmpty()) {
            throw new Exception("Meme não encontrado");
        }

        return meme.get();
    }

    public MemeCompletoDTO pegarMemeAleatorio() {
        List<Meme> todos = repository.findAll();
        int indexAleatorio = (int) (Math.random() * todos.size());
        return todos.get(indexAleatorio).toDTO();
    }

    public List<MemeCompletoDTO> pegarMemesCompartilhados() {
        List<Meme> memes = repository.findAllByCompartilhadoTrue();
        return memes.stream().map(Meme::toDTO).toList();
    }

    public MemeCompletoDTO compartilharMeme(Long id) throws Exception {
        Meme meme = buscarMemePorID(id);
        meme.compartilhar();
        salvarMeme(meme);
        return meme.toDTO();
    }

    public MemeCompletoDTO compatilharECriarMeme(MemeCompletoDTO memeCompletoDTO){
        Imagem imagem = imagemService.pegarImagemId(memeCompletoDTO.imagem().id());
        Frase frase = fraseService.pegerFraseId(memeCompletoDTO.frase().id());
        Meme meme = new Meme(null, frase, imagem, false);
        return repository.save(meme).toDTO();
    }
}
