package com.staysync.service;

import java.util.List;
import com.staysync.dtos.FeedbackDto;

public interface FeedbackService {
    void submitFeedback(FeedbackDto feedbackDto);
    List<FeedbackDto> getFeedbackByTenant(Long tenantId);
}