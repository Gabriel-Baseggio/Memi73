package iago.hackathon.memi73.repository;

import iago.hackathon.memi73.entity.Frase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraseRepository extends JpaRepository<Frase, Long> {
}
