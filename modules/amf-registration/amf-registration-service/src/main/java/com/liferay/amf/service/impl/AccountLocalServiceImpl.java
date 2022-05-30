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

import java.util.Date;


/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.amf.model.Account",
	service = AopService.class
)
public class AccountLocalServiceImpl extends AccountLocalServiceBaseImpl {

	@Override
	public Account createAccount(long accountId, String firstname, String lastname, String emailAddress,
								 String username, String gender, Date birthday, String  password, int  homePhone,
								 int mobilePhone, String address, String address2, String city, String statezip,
								 String securityQuestion, String securityAnswer, String acceptedTou) {
		// Create account
		Account account = createAccount(accountId);

		// populate fields
		account.setAccountId(accountId);
		account.setFirst_name(firstname);
		account.setLast_name(lastname);
		account.setEmail_address(emailAddress);
		account.setUser_name(username);
		account.setGender(gender);
		account.setBirthday(birthday);
		account.setPassword(password);
		account.setHome_phone(homePhone);
		account.setMobile_phone(mobilePhone);
		account.setAddress(address);
		account.setAddress2(address2);
		account.setCity(city);
		account.setState(statezip);
		account.setSecurity_question(securityQuestion);
		account.setSecurity_answer(securityAnswer);
		account.setAccepted_tou(acceptedTou);

		return accountPersistence.update(account);
	}
	@Override
	public Account deleteAccount(long accountId) throws PortalException {

		Account account = deleteAccount(accountId);

		return accountPersistence.remove(account);
	}

	@Override
	public Account updateAccount(long accountId, String firstname, String lastname, String emailAddress,
								 String username, String gender, Date birthday, String  password, int  homePhone,
								 int mobilePhone, String address, String address2, String city, String statezip,
								 String securityQuestion, String securityAnswer, String acceptedTou) throws PortalException {

		// Get the Account by Id

		Account account = getAccount(accountId);

		// Set updated fields and modification date

		account.setFirst_name(firstname);
		account.setLast_name(lastname);
		account.setUser_name(username);
		account.setEmail_address(emailAddress);
		account.setGender(gender);
		account.setBirthday(birthday);
		account.setPassword(password);
		account.setHome_phone(homePhone);
		account.setMobile_phone(mobilePhone);
		account.setAddress(address);
		account.setAddress2(address2);
		account.setCity(city);
		account.setState(statezip);
		account.setSecurity_question(securityQuestion);
		account.setSecurity_answer(securityAnswer);
		account.setAccepted_tou(acceptedTou);

		return accountPersistence.update(account);
	}

}