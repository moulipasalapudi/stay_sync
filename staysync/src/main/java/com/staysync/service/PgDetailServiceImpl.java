package com.staysync.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staysync.dtos.PgDetailsDto;
import com.staysync.mapper.PgDetailsMapper;
import com.staysync.models.PgDetails;
import com.staysync.repository.PgDetailsRepository;

@Service
public class PgDetailServiceImpl implements PgDetailService {
    @Autowired
    private PgDetailsRepository pgDetailsRepository;

    @Autowired
    private PgDetailsMapper pgDetailsMapper;

    // Implement the methods defined in PgDetailService interface
    @Override
    public void savePgDetails(PgDetailsDto pgDetailDto) {
        PgDetails pgDetails = pgDetailsMapper.toEntity(pgDetailDto);
        pgDetailsRepository.save(pgDetails);

    }

    @Override
    public PgDetailsDto getPgDetailsById(Long id) {
        PgDetails pgDetails = pgDetailsRepository.findById(id).orElse(null);
        if (pgDetails != null) {
            return pgDetailsMapper.toDto(pgDetails);
        }
        return null; 

    }

    @Override
    public List<PgDetailsDto> getAllPgDetails() {
        List<PgDetails> pgDetailsList = pgDetailsRepository.findAll();
        return pgDetailsMapper.toDtoList(pgDetailsList);
    }

    @Override
    public void updatePgDetails(Long id, PgDetailsDto pgDetailDto) {
        PgDetails existingPgDetails = pgDetailsRepository.findById(id).orElse(null);
        if (existingPgDetails != null) {
            existingPgDetails.setName(pgDetailDto.getName());
            existingPgDetails.setLocation(pgDetailDto.getLocation());
            existingPgDetails.setAmenities(pgDetailDto.getAmenities());
            pgDetailsRepository.save(existingPgDetails);
        }
    }

    @Override
    public void deletePgDetails(Long id) {
        if(pgDetailsRepository.existsById(id)) {
            pgDetailsRepository.deleteById(id);
        }

      
    }

    // @Override
    // public List<PgDetailsDto> searchPgDetails(String query) {


    // }

    @Override
    public List<PgDetailsDto> filterPgDetails(String location, String amenities, Integer rent) {
        // Implement filtering logic based on location, amenities, and rent
        List<PgDetails> filteredPgDetails = pgDetailsRepository.findByLocationAndAmenitiesAndRent(location, amenities,rent);
        return pgDetailsMapper.toDtoList(filteredPgDetails);
    }

    
    
}
