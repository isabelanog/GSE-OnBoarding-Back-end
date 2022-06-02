package com.liferay.amf.internal.resource.v1_0;

import com.liferay.amf.dto.v1_0.Account;
import com.liferay.amf.resource.v1_0.AccountResource;
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
	public Account getAccount(String accountId) throws Exception {

		return (Account) _accountLocalService.getAccount(accountId);
	}


	public Account createAccount(Account account) throws Exception {

		return (Account) _accountLocalService.createAccount(account.getFirstName(), account.getLastName(),
				account.getEmailAddress(), account.getAccountName(), account.getGenre(), account.getBirthday(),
				account.getPassword(), account.getHomePhone(), account.getMobilePhone(), account.getAddress1(),
				account.getAddress2(), account.getCity(), account.getState(), account.getSecurityQuestion(),
				account.getSecurityAnswer());
	}

	@Override
	public void deleteAccount(String accountId) throws Exception {
		_accountLocalService.deleteAccount(accountId);
	}


	public Account updateAccount(String accountId, Account account) throws Exception {

		return (Account) _accountLocalService.updateAccount(accountId, account.getFirstName(), account.getLastName(),
				account.getEmailAddress(), account.getAccountName(), account.getGenre(), account.getBirthday(),
				account.getPassword(), account.getHomePhone(), account.getMobilePhone(), account.getAddress1(),
				account.getAddress2(), account.getCity(), account.getState(), account.getSecurityQuestion(),
				account.getSecurityAnswer());
		}
	@Reference
	private AccountLocalService _accountLocalService;
}