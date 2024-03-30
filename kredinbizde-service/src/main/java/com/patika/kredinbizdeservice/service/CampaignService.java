package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Campaign;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class CampaignService implements ICampaignService {
    @Override
    public List<Campaign> listAllCampaigns(List<Campaign> campaigns) {
        campaigns.sort(Comparator.comparing(Campaign::getDueDate).reversed());
        return campaigns;
    }
}
