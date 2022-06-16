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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Account service. Represents a row in the &quot;AMF_Account&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.amf.model.impl.AccountModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.amf.model.impl.AccountImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Account
 * @generated
 */
@ProviderType
public interface AccountModel
	extends BaseModel<Account>, GroupedModel, ShardedModel, StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a account model instance should use the {@link Account} interface instead.
	 */

	/**
	 * Returns the primary key of this account.
	 *
	 * @return the primary key of this account
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this account.
	 *
	 * @param primaryKey the primary key of this account
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the uuid of this account.
	 *
	 * @return the uuid of this account
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this account.
	 *
	 * @param uuid the uuid of this account
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the account ID of this account.
	 *
	 * @return the account ID of this account
	 */
	@AutoEscape
	public String getAccountId();

	/**
	 * Sets the account ID of this account.
	 *
	 * @param accountId the account ID of this account
	 */
	public void setAccountId(String accountId);

	/**
	 * Returns the group ID of this account.
	 *
	 * @return the group ID of this account
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this account.
	 *
	 * @param groupId the group ID of this account
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this account.
	 *
	 * @return the company ID of this account
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this account.
	 *
	 * @param companyId the company ID of this account
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this account.
	 *
	 * @return the user ID of this account
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this account.
	 *
	 * @param userId the user ID of this account
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this account.
	 *
	 * @return the user uuid of this account
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this account.
	 *
	 * @param userUuid the user uuid of this account
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this account.
	 *
	 * @return the user name of this account
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this account.
	 *
	 * @param userName the user name of this account
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this account.
	 *
	 * @return the create date of this account
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this account.
	 *
	 * @param createDate the create date of this account
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this account.
	 *
	 * @return the modified date of this account
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this account.
	 *
	 * @param modifiedDate the modified date of this account
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the first name of this account.
	 *
	 * @return the first name of this account
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this account.
	 *
	 * @param firstName the first name of this account
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the last name of this account.
	 *
	 * @return the last name of this account
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this account.
	 *
	 * @param lastName the last name of this account
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the account name of this account.
	 *
	 * @return the account name of this account
	 */
	@AutoEscape
	public String getAccountName();

	/**
	 * Sets the account name of this account.
	 *
	 * @param accountName the account name of this account
	 */
	public void setAccountName(String accountName);

	/**
	 * Returns the email address of this account.
	 *
	 * @return the email address of this account
	 */
	@AutoEscape
	public String getEmailAddress();

	/**
	 * Sets the email address of this account.
	 *
	 * @param emailAddress the email address of this account
	 */
	public void setEmailAddress(String emailAddress);

	/**
	 * Returns the gender of this account.
	 *
	 * @return the gender of this account
	 */
	@AutoEscape
	public String getGender();

	/**
	 * Sets the gender of this account.
	 *
	 * @param gender the gender of this account
	 */
	public void setGender(String gender);

	/**
	 * Returns the birthday of this account.
	 *
	 * @return the birthday of this account
	 */
	@AutoEscape
	public String getBirthday();

	/**
	 * Sets the birthday of this account.
	 *
	 * @param birthday the birthday of this account
	 */
	public void setBirthday(String birthday);

	/**
	 * Returns the password of this account.
	 *
	 * @return the password of this account
	 */
	@AutoEscape
	public String getPassword();

	/**
	 * Sets the password of this account.
	 *
	 * @param password the password of this account
	 */
	public void setPassword(String password);

	/**
	 * Returns the home phone of this account.
	 *
	 * @return the home phone of this account
	 */
	@AutoEscape
	public String getHomePhone();

	/**
	 * Sets the home phone of this account.
	 *
	 * @param homePhone the home phone of this account
	 */
	public void setHomePhone(String homePhone);

	/**
	 * Returns the mobile phone of this account.
	 *
	 * @return the mobile phone of this account
	 */
	@AutoEscape
	public String getMobilePhone();

	/**
	 * Sets the mobile phone of this account.
	 *
	 * @param mobilePhone the mobile phone of this account
	 */
	public void setMobilePhone(String mobilePhone);

	/**
	 * Returns the address of this account.
	 *
	 * @return the address of this account
	 */
	@AutoEscape
	public String getAddress();

	/**
	 * Sets the address of this account.
	 *
	 * @param address the address of this account
	 */
	public void setAddress(String address);

	/**
	 * Returns the address2 of this account.
	 *
	 * @return the address2 of this account
	 */
	@AutoEscape
	public String getAddress2();

	/**
	 * Sets the address2 of this account.
	 *
	 * @param address2 the address2 of this account
	 */
	public void setAddress2(String address2);

	/**
	 * Returns the city of this account.
	 *
	 * @return the city of this account
	 */
	@AutoEscape
	public String getCity();

	/**
	 * Sets the city of this account.
	 *
	 * @param city the city of this account
	 */
	public void setCity(String city);

	/**
	 * Returns the state of this account.
	 *
	 * @return the state of this account
	 */
	@AutoEscape
	public String getState();

	/**
	 * Sets the state of this account.
	 *
	 * @param state the state of this account
	 */
	public void setState(String state);

	/**
	 * Returns the zip of this account.
	 *
	 * @return the zip of this account
	 */
	@AutoEscape
	public String getZip();

	/**
	 * Sets the zip of this account.
	 *
	 * @param zip the zip of this account
	 */
	public void setZip(String zip);

	/**
	 * Returns the security question of this account.
	 *
	 * @return the security question of this account
	 */
	@AutoEscape
	public String getSecurityQuestion();

	/**
	 * Sets the security question of this account.
	 *
	 * @param securityQuestion the security question of this account
	 */
	public void setSecurityQuestion(String securityQuestion);

	/**
	 * Returns the security answer of this account.
	 *
	 * @return the security answer of this account
	 */
	@AutoEscape
	public String getSecurityAnswer();

	/**
	 * Sets the security answer of this account.
	 *
	 * @param securityAnswer the security answer of this account
	 */
	public void setSecurityAnswer(String securityAnswer);

	/**
	 * Returns the accepted tou of this account.
	 *
	 * @return the accepted tou of this account
	 */
	@AutoEscape
	public String getAcceptedTou();

	/**
	 * Sets the accepted tou of this account.
	 *
	 * @param acceptedTou the accepted tou of this account
	 */
	public void setAcceptedTou(String acceptedTou);

	@Override
	public Account cloneWithOriginalValues();

}