package com.staysync.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staysync.dtos.FeedbackDto;
import com.staysync.mapper.FeedbackMapper;
import com.staysync.models.Feedback;
import com.staysync.models.PgDetails;
import com.staysync.models.Tenant;
import com.staysync.repository.FeedbackRepository;
import com.staysync.repository.PgDetailsRepository;
import com.staysync.repository.TenantRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private FeedbackMapper feedbackMapper;
    @Autowired
    private TenantRepository tenantRepository;
    @Autowired
    private PgDetailsRepository pgDetailsRepository;

    @Override
    public void submitFeedback(FeedbackDto dto) {
        Feedback feedback = feedbackMapper.toEntity(dto);
        Tenant tenant = tenantRepository.findById(dto.getTenantId()).orElse(null);
        PgDetails pg = pgDetailsRepository.findById(dto.getPgId()).orElse(null);
        feedback.setTenant(tenant);
        feedback.setPgDetails(pg);
        feedbackRepository.save(feedback);
    }

    @Override
    public List<FeedbackDto> getFeedbackByTenant(Long tenantId) {
        return feedbackRepository.findByTenantId(tenantId)
                .stream()
                .map(feedbackMapper::toDto)
                .collect(Collectors.toList());
    }
}