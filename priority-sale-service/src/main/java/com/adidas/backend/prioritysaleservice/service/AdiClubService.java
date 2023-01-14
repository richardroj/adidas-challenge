package com.adidas.backend.prioritysaleservice.service;

import com.adidas.backend.prioritysaleservice.model.AdiClubMemberInfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "adiclub-service", url = "adiclub-service:8082")
public interface AdiClubService {

    @RequestMapping(method = RequestMethod.GET, value = "/adiclub-service/adiclub")
    AdiClubMemberInfoDto getAdiClubInfoByEmail(@RequestParam (value="emailAddress") final String emailAddress);

}
