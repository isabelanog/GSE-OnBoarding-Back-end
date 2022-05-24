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

package com.liferay.amf.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Account}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Account
 * @generated
 */
public class AccountWrapper
	extends BaseModelWrapper<Account>
	implements Account, ModelWrapper<Account> {

	public AccountWrapper(Account account) {
		super(account);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("accountId", getAccountId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("first_name", getFirst_name());
		attributes.put("last_name", getLast_name());
		attributes.put("user_name", getUser_name());
		attributes.put("email_address", getEmail_address());
		attributes.put("gender", getGender());
		attributes.put("birthday", getBirthday());
		attributes.put("password", getPassword());
		attributes.put("home_phone", getHome_phone());
		attributes.put("mobile_phone", getMobile_phone());
		attributes.put("address", getAddress());
		attributes.put("address2", getAddress2());
		attributes.put("city", getCity());
		attributes.put("state", getState());
		attributes.put("zip", getZip());
		attributes.put("security_question", getSecurity_question());
		attributes.put("security_answer", getSecurity_answer());
		attributes.put("accepted_tou", getAccepted_tou());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long accountId = (Long)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String first_name = (String)attributes.get("first_name");

		if (first_name != null) {
			setFirst_name(first_name);
		}

		String last_name = (String)attributes.get("last_name");

		if (last_name != null) {
			setLast_name(last_name);
		}

		String user_name = (String)attributes.get("user_name");

		if (user_name != null) {
			setUser_name(user_name);
		}

		String email_address = (String)attributes.get("email_address");

		if (email_address != null) {
			setEmail_address(email_address);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Date birthday = (Date)attributes.get("birthday");

		if (birthday != null) {
			setBirthday(birthday);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		Integer home_phone = (Integer)attributes.get("home_phone");

		if (home_phone != null) {
			setHome_phone(home_phone);
		}

		Integer mobile_phone = (Integer)attributes.get("mobile_phone");

		if (mobile_phone != null) {
			setMobile_phone(mobile_phone);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String address2 = (String)attributes.get("address2");

		if (address2 != null) {
			setAddress2(address2);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		Integer zip = (Integer)attributes.get("zip");

		if (zip != null) {
			setZip(zip);
		}

		String security_question = (String)attributes.get("security_question");

		if (security_question != null) {
			setSecurity_question(security_question);
		}

		String security_answer = (String)attributes.get("security_answer");

		if (security_answer != null) {
			setSecurity_answer(security_answer);
		}

		String accepted_tou = (String)attributes.get("accepted_tou");

		if (accepted_tou != null) {
			setAccepted_tou(accepted_tou);
		}
	}

	@Override
	public Account cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the accepted_tou of this account.
	 *
	 * @return the accepted_tou of this account
	 */
	@Override
	public String getAccepted_tou() {
		return model.getAccepted_tou();
	}

	/**
	 * Returns the account ID of this account.
	 *
	 * @return the account ID of this account
	 */
	@Override
	public long getAccountId() {
		return model.getAccountId();
	}

	/**
	 * Returns the address of this account.
	 *
	 * @return the address of this account
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the address2 of this account.
	 *
	 * @return the address2 of this account
	 */
	@Override
	public String getAddress2() {
		return model.getAddress2();
	}

	/**
	 * Returns the birthday of this account.
	 *
	 * @return the birthday of this account
	 */
	@Override
	public Date getBirthday() {
		return model.getBirthday();
	}

	/**
	 * Returns the city of this account.
	 *
	 * @return the city of this account
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the company ID of this account.
	 *
	 * @return the company ID of this account
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this account.
	 *
	 * @return the create date of this account
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the email_address of this account.
	 *
	 * @return the email_address of this account
	 */
	@Override
	public String getEmail_address() {
		return model.getEmail_address();
	}

	/**
	 * Returns the first_name of this account.
	 *
	 * @return the first_name of this account
	 */
	@Override
	public String getFirst_name() {
		return model.getFirst_name();
	}

	/**
	 * Returns the gender of this account.
	 *
	 * @return the gender of this account
	 */
	@Override
	public String getGender() {
		return model.getGender();
	}

	/**
	 * Returns the group ID of this account.
	 *
	 * @return the group ID of this account
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the home_phone of this account.
	 *
	 * @return the home_phone of this account
	 */
	@Override
	public int getHome_phone() {
		return model.getHome_phone();
	}

	/**
	 * Returns the last_name of this account.
	 *
	 * @return the last_name of this account
	 */
	@Override
	public String getLast_name() {
		return model.getLast_name();
	}

	/**
	 * Returns the mobile_phone of this account.
	 *
	 * @return the mobile_phone of this account
	 */
	@Override
	public int getMobile_phone() {
		return model.getMobile_phone();
	}

	/**
	 * Returns the modified date of this account.
	 *
	 * @return the modified date of this account
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the password of this account.
	 *
	 * @return the password of this account
	 */
	@Override
	public String getPassword() {
		return model.getPassword();
	}

	/**
	 * Returns the primary key of this account.
	 *
	 * @return the primary key of this account
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the security_answer of this account.
	 *
	 * @return the security_answer of this account
	 */
	@Override
	public String getSecurity_answer() {
		return model.getSecurity_answer();
	}

	/**
	 * Returns the security_question of this account.
	 *
	 * @return the security_question of this account
	 */
	@Override
	public String getSecurity_question() {
		return model.getSecurity_question();
	}

	/**
	 * Returns the state of this account.
	 *
	 * @return the state of this account
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the user_name of this account.
	 *
	 * @return the user_name of this account
	 */
	@Override
	public String getUser_name() {
		return model.getUser_name();
	}

	/**
	 * Returns the user ID of this account.
	 *
	 * @return the user ID of this account
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this account.
	 *
	 * @return the user name of this account
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this account.
	 *
	 * @return the user uuid of this account
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this account.
	 *
	 * @return the uuid of this account
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the zip of this account.
	 *
	 * @return the zip of this account
	 */
	@Override
	public int getZip() {
		return model.getZip();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the accepted_tou of this account.
	 *
	 * @param accepted_tou the accepted_tou of this account
	 */
	@Override
	public void setAccepted_tou(String accepted_tou) {
		model.setAccepted_tou(accepted_tou);
	}

	/**
	 * Sets the account ID of this account.
	 *
	 * @param accountId the account ID of this account
	 */
	@Override
	public void setAccountId(long accountId) {
		model.setAccountId(accountId);
	}

	/**
	 * Sets the address of this account.
	 *
	 * @param address the address of this account
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the address2 of this account.
	 *
	 * @param address2 the address2 of this account
	 */
	@Override
	public void setAddress2(String address2) {
		model.setAddress2(address2);
	}

	/**
	 * Sets the birthday of this account.
	 *
	 * @param birthday the birthday of this account
	 */
	@Override
	public void setBirthday(Date birthday) {
		model.setBirthday(birthday);
	}

	/**
	 * Sets the city of this account.
	 *
	 * @param city the city of this account
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the company ID of this account.
	 *
	 * @param companyId the company ID of this account
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this account.
	 *
	 * @param createDate the create date of this account
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the email_address of this account.
	 *
	 * @param email_address the email_address of this account
	 */
	@Override
	public void setEmail_address(String email_address) {
		model.setEmail_address(email_address);
	}

	/**
	 * Sets the first_name of this account.
	 *
	 * @param first_name the first_name of this account
	 */
	@Override
	public void setFirst_name(String first_name) {
		model.setFirst_name(first_name);
	}

	/**
	 * Sets the gender of this account.
	 *
	 * @param gender the gender of this account
	 */
	@Override
	public void setGender(String gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the group ID of this account.
	 *
	 * @param groupId the group ID of this account
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the home_phone of this account.
	 *
	 * @param home_phone the home_phone of this account
	 */
	@Override
	public void setHome_phone(int home_phone) {
		model.setHome_phone(home_phone);
	}

	/**
	 * Sets the last_name of this account.
	 *
	 * @param last_name the last_name of this account
	 */
	@Override
	public void setLast_name(String last_name) {
		model.setLast_name(last_name);
	}

	/**
	 * Sets the mobile_phone of this account.
	 *
	 * @param mobile_phone the mobile_phone of this account
	 */
	@Override
	public void setMobile_phone(int mobile_phone) {
		model.setMobile_phone(mobile_phone);
	}

	/**
	 * Sets the modified date of this account.
	 *
	 * @param modifiedDate the modified date of this account
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the password of this account.
	 *
	 * @param password the password of this account
	 */
	@Override
	public void setPassword(String password) {
		model.setPassword(password);
	}

	/**
	 * Sets the primary key of this account.
	 *
	 * @param primaryKey the primary key of this account
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the security_answer of this account.
	 *
	 * @param security_answer the security_answer of this account
	 */
	@Override
	public void setSecurity_answer(String security_answer) {
		model.setSecurity_answer(security_answer);
	}

	/**
	 * Sets the security_question of this account.
	 *
	 * @param security_question the security_question of this account
	 */
	@Override
	public void setSecurity_question(String security_question) {
		model.setSecurity_question(security_question);
	}

	/**
	 * Sets the state of this account.
	 *
	 * @param state the state of this account
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the user_name of this account.
	 *
	 * @param user_name the user_name of this account
	 */
	@Override
	public void setUser_name(String user_name) {
		model.setUser_name(user_name);
	}

	/**
	 * Sets the user ID of this account.
	 *
	 * @param userId the user ID of this account
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this account.
	 *
	 * @param userName the user name of this account
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this account.
	 *
	 * @param userUuid the user uuid of this account
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this account.
	 *
	 * @param uuid the uuid of this account
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the zip of this account.
	 *
	 * @param zip the zip of this account
	 */
	@Override
	public void setZip(int zip) {
		model.setZip(zip);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected AccountWrapper wrap(Account account) {
		return new AccountWrapper(account);
	}

}