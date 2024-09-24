package iago.hackathon.memi73.entity;

import iago.hackathon.memi73.controller.dto.MemeCompletoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Frase frase;

    @ManyToOne(cascade = CascadeType.ALL)
    private Imagem imagem;

    private Boolean compartilhado;

    public MemeCompletoDTO toDTO() {
        return new MemeCompletoDTO(this.id, frase.toDTO(), imagem.toDTO());
    }

    public void compartilhar() {
        this.compartilhado = true;
    }
}
