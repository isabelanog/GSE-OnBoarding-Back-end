package com.liferay.amf.internal.resource.v1_0;

import com.liferay.amf.dto.v1_0.Account;
import com.liferay.amf.resource.v1_0.AccountResource;
import com.liferay.amf.service.AccountLocalService;
import com.liferay.portal.vulcan.pagination.Page;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.Collections;
import java.util.Date;

/**
 * @author me
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/account.properties",
	scope = ServiceScope.PROTOTYPE, service = AccountResource.class
)
public class AccountResourceImpl extends BaseAccountResourceImpl {

	@Override
	public Account getAccount(String accountId, Account account) throws Exception {

		return _accountLocalService.getAccount(accountId, account.getFirstName(), account.getLastName(), account.getEmailAdress(),
				account.getUserName(), account.getGenre(), account.getBirthday(), account.getBirthday(), account.getPassword(), account.getHomePhone(),
				account.getMobilePhone(), account.getAdress1(),account.getAdress2(), account.getCity(), account.getState(), account.getSecurityQuestion(),
				account.getSecurityAnswer(), account.getacceptedTou);
	}

	@Override
	public Account createAccount(Account account) throws Exception {

		return _accountLocalService.createAccount(account.getFirstName(), account.getLastName(), account.getEmailAdress(),
				account.getUserName(), account.getGenre(), account.getBirthday(), account.getBirthday(), account.getPassword(), account.getHomePhone(),
				account.getMobilePhone(), account.getAdress1(),account.getAdress2(), account.getCity(), account.getState(), account.getSecurityQuestion(),
				account.getSecurityAnswer(), account.getacceptedTou);
	}
	@Override
	public void deleteAccount(String accountId) throws Exception {
		_accountLocalService.deleteAccount(accountId);
	}
	@Override
	public Account updateAccount(String accountId, Account account) throws Exception {

		return _accountLocalService.updateAccount(accountId, account.getFirstName(), account.getLastName(), account.getEmailAdress(),
				account.getUserName(), account.getGenre(), account.getBirthday(), account.getBirthday(), account.getPassword(), account.getHomePhone(),
				account.getMobilePhone(), account.getAdress1(),account.getAdress2(), account.getCity(), account.getState(), account.getSecurityQuestion(),
				account.getSecurityAnswer(), account.getacceptedTou);
		}
	@Reference
	private AccountLocalService _accountLocalService;
}