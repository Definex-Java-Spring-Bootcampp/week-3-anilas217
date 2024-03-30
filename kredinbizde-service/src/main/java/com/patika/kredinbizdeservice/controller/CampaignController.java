package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.service.ICampaignService;
import com.patika.kredinbizdeservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/campaigns")
public class CampaignController {

    @Autowired
    private ICampaignService campaignService;

    @Autowired
    public CampaignController(ICampaignService campaignService){
        this.campaignService = campaignService;
    }

    @PostMapping
    public List<Campaign> takeAll(@RequestBody List<Campaign> campaigns){
        return campaignService.listAllCampaigns(campaigns);
    }


}
