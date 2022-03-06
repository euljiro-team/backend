package com.core.euljiro.dto;

import com.core.euljiro.common.EnumMaster;
import com.core.euljiro.domain.Account;
import lombok.Builder;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
public class CenterAccountFormDTO {

    @Autowired
    ModelMapper modelMapper;

    private Integer accountId;
    private String username;
    private String password;
    private String email;
    private String koreanName;
    private String englishName;
    private String phone;
    private List<EnumMaster.RoleType> accountRoles;
    private EnumMaster.Status status;

    private Integer centerId;
    private String centerName;
    private String centerAddress;
    private String operatingHour;
    private String telNo;

    public AccountDTO toAccountDTO(CenterAccountFormDTO centerAccountFormDTO) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountId(centerAccountFormDTO.getAccountId());
        accountDTO.setUsername(centerAccountFormDTO.getUsername());
        accountDTO.setPassword(centerAccountFormDTO.getPassword());
        accountDTO.setEmail(centerAccountFormDTO.getEmail());
        accountDTO.setKoreanName(centerAccountFormDTO.getKoreanName());
        accountDTO.setEnglishName(centerAccountFormDTO.getEnglishName());
        accountDTO.setPhone(centerAccountFormDTO.getPhone());
        accountDTO.setStatus(centerAccountFormDTO.getStatus());
        accountDTO.setAccountRoles(centerAccountFormDTO.getAccountRoles());
        return accountDTO;
    }

    public CenterDTO toCenterDTO(CenterAccountFormDTO centerAccountFormDTO) {
        CenterDTO centerDTO = new CenterDTO();
        centerDTO.setCenterId(centerAccountFormDTO.getCenterId());
        centerDTO.setName(centerAccountFormDTO.getCenterName());
        centerDTO.setAddress(centerAccountFormDTO.getCenterAddress());
        centerDTO.setOperatingHour(centerAccountFormDTO.getOperatingHour());
        centerDTO.setTelNo(centerAccountFormDTO.getTelNo());
        return centerDTO;
    }

    public static CenterAccountFormDTO toCenterAccountFormDTO(AccountDTO accountDTO, CenterDTO centerDTO) {
        CenterAccountFormDTO centerAccountFormDTO = new CenterAccountFormDTO();
        centerAccountFormDTO.setAccountId(accountDTO.getAccountId());
        centerAccountFormDTO.setAccountId(accountDTO.getAccountId());
        centerAccountFormDTO.setUsername(accountDTO.getUsername());
        centerAccountFormDTO.setPassword(accountDTO.getPassword());
        centerAccountFormDTO.setEmail(accountDTO.getEmail());
        centerAccountFormDTO.setKoreanName(accountDTO.getKoreanName());
        centerAccountFormDTO.setEnglishName(accountDTO.getEnglishName());
        centerAccountFormDTO.setPhone(accountDTO.getPhone());
        centerAccountFormDTO.setStatus(accountDTO.getStatus());
        centerAccountFormDTO.setCenterId(centerAccountFormDTO.getCenterId());
        centerAccountFormDTO.setCenterName(centerDTO.getName());
        centerAccountFormDTO.setCenterAddress(centerDTO.getAddress());
        centerAccountFormDTO.setOperatingHour(centerDTO.getOperatingHour());
        centerAccountFormDTO.setTelNo(centerDTO.getTelNo());

        return centerAccountFormDTO;
    }
}
