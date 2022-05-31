package com.liferay.amf.internal.resource.v1_0;

import com.liferay.amf.resource.v1_0.AccountResource;
import com.liferay.amf.dto.v1_0.Account;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.HashMap;
import java.util.Map;
/**
 * @author me
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/account.properties",
	scope = ServiceScope.PROTOTYPE, service = AccountResource.class
)
public class AccountResourceImpl extends BaseAccountResourceImpl   {

	Map<Integer, Account> account = new HashMap<>();

	public Account getAccount(Integer accountId) throws Exception {
		return getAccount(accountId);
	}

	public void deleteAccount(Integer accountId) throws Exception {
		deleteAccount(accountId);

	}

	public Account createAccount(Account account) throws Exception {

		return createAccount(account);
	}

	public Account updateAccount(Integer accountId, Account account) throws Exception {

		return updateAccount(accountId,account);
	}

}