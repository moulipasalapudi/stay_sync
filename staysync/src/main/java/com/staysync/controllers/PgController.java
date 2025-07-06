package com.staysync.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.staysync.dtos.PgDetailsDto;
import com.staysync.service.PgDetailService;

@RestController
@RequestMapping("/api/pg")
public class PgController {
    @Autowired
    private PgDetailService pgDetailService;

    @PostMapping
    public void createPgDetail(@RequestBody PgDetailsDto pgDetailsDto) {
        pgDetailService.savePgDetails(pgDetailsDto);
    }
    @GetMapping
    public List<PgDetailsDto> getAllPgDetails() {
        return pgDetailService.getAllPgDetails();
    }
    @GetMapping("/{id}")
    public PgDetailsDto getPgDetailById(@PathVariable Long id) {
        return pgDetailService.getPgDetailsById(id);
    }
}
