package com.example.examenldp2.dto;
import lombok.Data;
import java.util.UUID;

@Data
public class ResponseDTO {
    private UUID id;
    private String titulo;
    private String mensaje;
}