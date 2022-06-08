package com.liferay.amf.rest.internal.resource.v1_0;

import com.liferay.amf.rest.dto.v1_0.Account;
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
	public Account createAccount(Account account) throws Exception {
		
		_accountLocalService.createAccount(
			account.getFirstName(),
			account.getLastName(),
			account.getEmailAddress(),
			account.getAccountName(),
			account.getGenre(),
			account.getBirthday(),
			account.getPassword(),
			account.getHomePhone(),
			account.getMobilePhone(),
			account.getAddress1(),
			account.getAddress2(),
			account.getCity(),
			account.getState(),
			account.getSecurityQuestion(),
			account.getSecurityAnswer()
		);

		return account;
	}
	
	@Reference
	private AccountLocalService _accountLocalService;

}