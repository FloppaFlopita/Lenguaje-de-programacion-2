package com.example.examenldp2.repository;
import com.example.examenldp2.entity.PeliculaGenero;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
public interface PeliculaGeneroRepository extends JpaRepository<PeliculaGenero, UUID> {}