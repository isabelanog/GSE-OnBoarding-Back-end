package com.liferay.amf.rest.internal.resource.v1_0;

import com.liferay.amf.rest.dto.v1_0.AccountDTO;
import com.liferay.amf.rest.resource.v1_0.AccountResource;

import com.liferay.amf.service.AccountLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author me
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/account.properties",
	scope = ServiceScope.PROTOTYPE, service = AccountResource.class
)
public class AccountResourceImpl extends BaseAccountResourceImpl {

	@Override
	public AccountDTO createAccount(AccountDTO accountDTO) throws Exception {
		_accountLocalService.createAccount(
				accountDTO.getFirstName(),
				accountDTO.getLastName(),
				accountDTO.getEmailAddress(),
				accountDTO.getAccountName(),
				accountDTO.getAddress1(),
				accountDTO.getAddress2(),
				accountDTO.getGenre(),
				accountDTO.getBirthday(),
				accountDTO.getPassword(),
				accountDTO.getSecurityQuestion(),
				accountDTO.getSecurityAnswer(),
				accountDTO.getHomePhone(),
				accountDTO.getMobilePhone(),
				accountDTO.getCity(),
				accountDTO.getState());
	return accountDTO;

	}
	
	@Reference
	private AccountLocalService _accountLocalService;

}