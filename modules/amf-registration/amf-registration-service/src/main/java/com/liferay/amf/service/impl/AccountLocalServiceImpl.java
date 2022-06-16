/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.amf.service.impl;

import com.liferay.amf.model.Account;
import com.liferay.amf.service.base.AccountLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import org.osgi.service.component.annotations.Component;


/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.amf.model.Account",
	service = AopService.class
)
public class AccountLocalServiceImpl extends AccountLocalServiceBaseImpl {

	@Override
	public Account getAccount(String accountId) throws PortalException {
		//Get account by ID
		Account account = getAccount(accountId);

		account.getAccountId();
		account.getFirstName();
		account.getLastName();
		account.getAccountName();
		account.getEmailAddress();
		account.getAccountName();
		account.getGender();
		account.getBirthday();
		account.getPassword();
		account.getHomePhone();
		account.getMobilePhone();
		account.getAddress();
		account.getAddress2();
		account.getCity();
		account.getState();
		account.getSecurityQuestion();
		account.getSecurityAnswer();

		return account;
	}

	@Override
	public Account createAccount(String firstname, String lastname, String emailAddress,
								 String accountName, String gender, String birthday, String  password, String  homePhone,
								 String mobilePhone, String address, String address2, String city, String statezip,
								 String securityQuestion, String securityAnswer) {
		// Create account
		long accountId = counterLocalService.increment(Account.class.getName());
		Account account = createAccount(String.valueOf(accountId));

		// populate fields
		account.setAccountId(String.valueOf(accountId));
		account.setFirstName(firstname);
		account.setLastName(lastname);
		account.setEmailAddress(emailAddress);
		account.setAccountName(accountName);
		account.setGender(gender);
		account.setBirthday(birthday);
		account.setPassword(password);
		account.setHomePhone(homePhone);
		account.setMobilePhone(mobilePhone);
		account.setAddress(address);
		account.setAddress2(address2);
		account.setCity(city);
		account.setState(statezip);
		account.setSecurityQuestion(securityQuestion);
		account.setSecurityAnswer(securityAnswer);

		return accountPersistence.update(account);
	}
	@Override
	public Account deleteAccount(long accountId) throws PortalException {

		Account account = deleteAccount(accountId);

		return accountPersistence.remove(account);
	}

	@Override
	public Account updateAccount(String accountId, String firstname, String lastname, String emailAddress,
								 String accountName, String gender, String birthday, String  password, String  homePhone,
								 String mobilePhone, String address, String address2, String city, String statezip,
								 String securityQuestion, String securityAnswer) throws PortalException {

		// Get the Account by Id

		Account account = getAccount(accountId);

		// Set updated fields and modification date

		account.setAccountId(accountId);
		account.setFirstName(firstname);
		account.setLastName(lastname);
		account.setEmailAddress(emailAddress);
		account.setAccountName(accountName);
		account.setGender(gender);
		account.setBirthday(birthday);
		account.setPassword(password);
		account.setHomePhone(homePhone);
		account.setMobilePhone(mobilePhone);
		account.setAddress(address);
		account.setAddress2(address2);
		account.setCity(city);
		account.setState(statezip);
		account.setSecurityQuestion(securityQuestion);
		account.setSecurityAnswer(securityAnswer);

		return accountPersistence.update(account);
	}

}