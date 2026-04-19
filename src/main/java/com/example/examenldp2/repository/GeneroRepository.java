package com.example.examenldp2.repository;
import com.example.examenldp2.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
public interface GeneroRepository extends JpaRepository<Genero, UUID> {}