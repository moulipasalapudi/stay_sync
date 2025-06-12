package com.staysync.service;

import java.util.List;

import com.staysync.dtos.PgDetailsDto;

public interface PgDetailService {

    void savePgDetails(PgDetailsDto pgDetailDto);

    PgDetailsDto getPgDetailsById(Long id);

    List<PgDetailsDto> getAllPgDetails();

    void updatePgDetails(Long id, PgDetailsDto pgDetailDto);

    void deletePgDetails(Long id);

    // List<PgDetailsDto> searchPgDetails(String query);

    List<PgDetailsDto> filterPgDetails(String location, String amenities, String priceRange);
    
}
