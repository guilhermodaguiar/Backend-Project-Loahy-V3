package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.dtos.CompanyInfoDto;
import nl.novi.loahy_v3.services.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/about-company")
public class CompanyInfoController {

    @Autowired
    private CompanyInfoService companyInfoService;

    @GetMapping(value = "/loahy")
    public CompanyInfoDto getCompanyInfo(String name) {
         CompanyInfoDto companyInfoDto = companyInfoService.getCompanyInfo(name);

         return companyInfoDto;
    }

    @PutMapping(value = "/update")
    public CompanyInfoDto updateCompanyInfo(String name, @RequestBody CompanyInfoDto companyInfoDto) {
        companyInfoService.updateCompanyInfo(name, companyInfoDto);
        return companyInfoDto;
    }
}
