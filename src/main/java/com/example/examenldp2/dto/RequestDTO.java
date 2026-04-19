package com.example.examenldp2.dto;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
public class RequestDTO {
    private String titulo;
    private Integer anyoEstreno;
    private Integer duracionMinutos;
    private UUID directorId;
    private List<UUID> generoIds;
}