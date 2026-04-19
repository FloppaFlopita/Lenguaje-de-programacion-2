package com.example.examenldp2.repository;
import com.example.examenldp2.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
public interface DirectorRepository extends JpaRepository<Director, UUID> {}