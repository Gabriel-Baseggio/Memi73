package iago.hackathon.memi73.repository;

import iago.hackathon.memi73.entity.Meme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemeRepository extends JpaRepository<Meme, Long> {

    Page<Meme> findAllByCompartilhadoTrue(Pageable pageable);

}
