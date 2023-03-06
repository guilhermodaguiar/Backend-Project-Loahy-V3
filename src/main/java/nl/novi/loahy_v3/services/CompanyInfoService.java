package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.controllers.CompanyInfoController;
import nl.novi.loahy_v3.dtos.CompanyInfoDto;
import nl.novi.loahy_v3.exceptions.RecordNotFoundException;
import nl.novi.loahy_v3.models.CompanyInfo;
import nl.novi.loahy_v3.repositories.CompanyInfoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyInfoService {

    private final CompanyInfoRepository companyInfoRepository;

    public CompanyInfoService(CompanyInfoRepository companyInfoRepository) {
        this.companyInfoRepository = companyInfoRepository;
    }

    public CompanyInfoDto getCompanyInfo(String name) {
        Optional<CompanyInfo> companyInfo = companyInfoRepository.findCompanyInfoByName(name);
        if(companyInfo.isPresent()) {
            return transferToDto(companyInfo.get());
        } else {
            throw new RecordNotFoundException("No company info found");
        }
    }

    public void updateCompanyInfo(String name, CompanyInfoDto companyInfoDto) {
        if(!companyInfoRepository.existsById(name)) {
            throw new RecordNotFoundException("No company information found");
        }
        CompanyInfo storeInformation = companyInfoRepository.findCompanyInfoByName(name).orElse(null);
        storeInformation.setInformation(companyInfoDto.getCompanyInfo());
        companyInfoRepository.save(storeInformation);
    }

    public CompanyInfoDto transferToDto(CompanyInfo companyInfo) {
        var dto = new CompanyInfoDto();

        dto.name = companyInfo.getName();
        dto.companyInfo = companyInfo.getInformation();

        return dto;
    }


}
