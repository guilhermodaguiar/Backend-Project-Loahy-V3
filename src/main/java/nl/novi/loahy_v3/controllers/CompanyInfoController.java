package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.dtos.CompanyInfoDto;
import nl.novi.loahy_v3.services.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/about")
public class CompanyInfoController {

    @Autowired
    private CompanyInfoService companyInfoService;

    @GetMapping(value = "/{company}")
    public CompanyInfoDto getCompanyInfo(@PathVariable("company") String name) {
         CompanyInfoDto companyInfoDto = companyInfoService.getCompanyInfo(name);

         return companyInfoDto;
    }

    @PutMapping(value = "/{company}")
    public CompanyInfoDto updateCompanyInfo(@PathVariable("company")String name, @RequestBody CompanyInfoDto companyInfoDto) {
        companyInfoService.updateCompanyInfo(name, companyInfoDto);
        return companyInfoDto;
    }

}
