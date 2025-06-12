package com.staysync.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.staysync.models.PgDetails;

public interface PgDetailsRepository extends JpaRepository<PgDetails, Long> {

    List<PgDetails> findByLocationAndAmenitiesAndPriceRange(String location, String amenities, String priceRange);

}
