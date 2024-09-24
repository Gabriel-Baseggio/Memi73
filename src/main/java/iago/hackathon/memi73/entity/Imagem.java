package iago.hackathon.memi73.entity;

import iago.hackathon.memi73.controller.dto.ImagemDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Base64;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(columnDefinition = "BLOB", nullable = false)
    private byte[] imagem;

    private String tipo;

    @OneToMany(mappedBy = "imagem")
    private List<Meme> meme;

    public String getUrl() {
        return "data:" + this.tipo + ";base64," + Base64.getEncoder().encodeToString(this.imagem);
    }

    public ImagemDTO toDTO() {
        return new ImagemDTO(this.id, this.getUrl());
    }
}
