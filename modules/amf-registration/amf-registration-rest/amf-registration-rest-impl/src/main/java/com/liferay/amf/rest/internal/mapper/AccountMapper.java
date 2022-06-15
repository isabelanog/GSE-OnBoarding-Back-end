package com.liferay.amf.rest.internal.mapper;

import com.liferay.amf.model.Account;
import com.liferay.amf.rest.dto.v1_0.AccountDTO;

public class AccountMapper {

    public AccountDTO accountToDTO(Account accountModel) {

        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setFirstName(accountModel.getFirstName());
        accountDTO.setLastName(accountModel.getLastName());
        accountDTO.setAccountName(accountModel.getAccountName());
        accountDTO.setAddress1(accountModel.getAddress());
        accountDTO.setAddress2(accountModel.getAddress2());
        accountDTO.setGenre(accountModel.getGender());
        accountDTO.setBirthday(accountModel.getBirthday());
        accountDTO.setPassword(accountModel.getPassword());
        accountDTO.setSecurityQuestion(accountModel.getSecurityQuestion());
        accountDTO.setSecurityAnswer(accountModel.getSecurityAnswer());
        accountDTO.setHomePhone(accountModel.getHomePhone());
        accountDTO.setMobilePhone(accountModel.getMobilePhone());
        accountDTO.setCity(accountModel.getCity());
        accountDTO.setState(accountModel.getState());


        return accountDTO;
        }
}
