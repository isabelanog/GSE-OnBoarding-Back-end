create table AMF_Account (
	uuid_ VARCHAR(75) null,
	accountId VARCHAR(75) not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	accountName VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	gender VARCHAR(75) null,
	birthday DATE null,
	password_ VARCHAR(75) null,
	homePhone INTEGER,
	mobilePhone INTEGER,
	address VARCHAR(75) null,
	address2 VARCHAR(75) null,
	city VARCHAR(75) null,
	state_ VARCHAR(75) null,
	zip INTEGER,
	securityQuestion VARCHAR(75) null,
	securityAnswer VARCHAR(75) null,
	acceptedTou VARCHAR(75) null
);