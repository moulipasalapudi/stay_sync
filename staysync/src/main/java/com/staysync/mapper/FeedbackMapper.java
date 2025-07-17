package com.staysync.mapper;

import org.mapstruct.*;
import com.staysync.dtos.FeedbackDto;
import com.staysync.models.Feedback;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {
    @Mapping(source = "tenant.id", target = "tenantId")
    @Mapping(source = "pgDetails.id", target = "pgId")
    FeedbackDto toDto(Feedback entity);

    @Mapping(target = "tenant", ignore = true)
    @Mapping(target = "pgDetails", ignore = true)
    Feedback toEntity(FeedbackDto dto);
}