package com.staysync.mapper;

import org.mapstruct.Mapper;

import com.staysync.dtos.PaymentDto;
import com.staysync.models.Payment;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentDto toDto(Payment payment);
    Payment toEntity(PaymentDto dto);
    
}
