package com.staysync.mapper;

import org.mapstruct.Mapper;

import com.staysync.dtos.MealPreferenceDto;
import com.staysync.models.MealPreference;

@Mapper(componentModel = "spring")
public interface PreferenceMapper {
     MealPreferenceDto toDto(MealPreference mealPreference);  
     MealPreference toEntity(MealPreferenceDto dto);         

    
}
