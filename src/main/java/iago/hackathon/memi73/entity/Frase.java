package iago.hackathon.memi73.entity;

import iago.hackathon.memi73.controller.dto.FraseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Frase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String frase;

    @OneToMany(mappedBy = "frase")
    private List<Meme> meme;

    public FraseDTO toDTO() {
        return new FraseDTO(this.id, this.frase);
    }
}
