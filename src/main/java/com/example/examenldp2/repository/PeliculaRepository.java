package com.example.examenldp2.repository;
import com.example.examenldp2.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
public interface PeliculaRepository extends JpaRepository<Pelicula, UUID> {}