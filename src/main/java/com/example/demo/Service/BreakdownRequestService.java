package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.BreakdownRequest;
import com.example.demo.Repository.BreakdownRequestRepository;

@Service
public class BreakdownRequestService {
    @Autowired
    private BreakdownRequestRepository breakdownRequestRepository;

    public BreakdownRequest createRequest(BreakdownRequest request) {
        request.setStatus("Pending");
        return breakdownRequestRepository.save(request);
    }

    public List<BreakdownRequest> getAllRequests() {
        return breakdownRequestRepository.findAll();
    }

    public void updateRequestStatus(Long id, String status) {
        BreakdownRequest request = breakdownRequestRepository.findById(id).orElse(null);
        if (request != null) {
            request.setStatus(status);
            breakdownRequestRepository.save(request);
        }
    }
}
