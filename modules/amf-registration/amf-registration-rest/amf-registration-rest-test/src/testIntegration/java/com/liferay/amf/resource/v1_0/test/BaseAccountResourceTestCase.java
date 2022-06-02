package com.liferay.amf.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.amf.client.dto.v1_0.Account;
import com.liferay.amf.client.http.HttpInvoker;
import com.liferay.amf.client.pagination.Page;
import com.liferay.amf.client.resource.v1_0.AccountResource;
import com.liferay.amf.client.serdes.v1_0.AccountSerDes;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtilsBean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author me
 * @generated
 */
@Generated("")
public abstract class BaseAccountResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_accountResource.setContextCompany(testCompany);

		AccountResource.Builder builder = AccountResource.builder();

		accountResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Account account1 = randomAccount();

		String json = objectMapper.writeValueAsString(account1);

		Account account2 = AccountSerDes.toDTO(json);

		Assert.assertTrue(equals(account1, account2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Account account = randomAccount();

		String json1 = objectMapper.writeValueAsString(account);
		String json2 = AccountSerDes.toJSON(account);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Account account = randomAccount();

		account.setAccountName(regex);
		account.setAddress1(regex);
		account.setAddress2(regex);
		account.setBirthday(regex);
		account.setCity(regex);
		account.setConfirmPassword(regex);
		account.setEmailAddress(regex);
		account.setFirstName(regex);
		account.setGenre(regex);
		account.setHomePhone(regex);
		account.setLastName(regex);
		account.setMobilePhone(regex);
		account.setPassword(regex);
		account.setSecurityAnswer(regex);
		account.setSecurityQuestion(regex);
		account.setState(regex);
		account.setTermsOfUse(regex);

		String json = AccountSerDes.toJSON(account);

		Assert.assertFalse(json.contains(regex));

		account = AccountSerDes.toDTO(json);

		Assert.assertEquals(regex, account.getAccountName());
		Assert.assertEquals(regex, account.getAddress1());
		Assert.assertEquals(regex, account.getAddress2());
		Assert.assertEquals(regex, account.getBirthday());
		Assert.assertEquals(regex, account.getCity());
		Assert.assertEquals(regex, account.getConfirmPassword());
		Assert.assertEquals(regex, account.getEmailAddress());
		Assert.assertEquals(regex, account.getFirstName());
		Assert.assertEquals(regex, account.getGenre());
		Assert.assertEquals(regex, account.getHomePhone());
		Assert.assertEquals(regex, account.getLastName());
		Assert.assertEquals(regex, account.getMobilePhone());
		Assert.assertEquals(regex, account.getPassword());
		Assert.assertEquals(regex, account.getSecurityAnswer());
		Assert.assertEquals(regex, account.getSecurityQuestion());
		Assert.assertEquals(regex, account.getState());
		Assert.assertEquals(regex, account.getTermsOfUse());
	}

	@Test
	public void testGetAllAccount() throws Exception {
		Page<Account> page = accountResource.getAllAccount(null, null);

		long totalCount = page.getTotalCount();

		Account account1 = testGetAllAccount_addAccount(randomAccount());

		Account account2 = testGetAllAccount_addAccount(randomAccount());

		page = accountResource.getAllAccount(null, null);

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(account1, (List<Account>)page.getItems());
		assertContains(account2, (List<Account>)page.getItems());
		assertValid(page);
	}

	protected Account testGetAllAccount_addAccount(Account account)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testCreateAccount() throws Exception {
		Account randomAccount = randomAccount();

		Account postAccount = testCreateAccount_addAccount(randomAccount);

		assertEquals(randomAccount, postAccount);
		assertValid(postAccount);
	}

	protected Account testCreateAccount_addAccount(Account account)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteAccount() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLDeleteAccount() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetAccount() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLGetAccount() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGraphQLGetAccountNotFound() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testUpdateAccount() throws Exception {
		Assert.assertTrue(false);
	}

	protected void assertContains(Account account, List<Account> accounts) {
		boolean contains = false;

		for (Account item : accounts) {
			if (equals(account, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(accounts + " does not contain " + account, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Account account1, Account account2) {
		Assert.assertTrue(
			account1 + " does not equal " + account2,
			equals(account1, account2));
	}

	protected void assertEquals(
		List<Account> accounts1, List<Account> accounts2) {

		Assert.assertEquals(accounts1.size(), accounts2.size());

		for (int i = 0; i < accounts1.size(); i++) {
			Account account1 = accounts1.get(i);
			Account account2 = accounts2.get(i);

			assertEquals(account1, account2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Account> accounts1, List<Account> accounts2) {

		Assert.assertEquals(accounts1.size(), accounts2.size());

		for (Account account1 : accounts1) {
			boolean contains = false;

			for (Account account2 : accounts2) {
				if (equals(account1, account2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				accounts2 + " does not contain " + account1, contains);
		}
	}

	protected void assertValid(Account account) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("accountName", additionalAssertFieldName)) {
				if (account.getAccountName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("address1", additionalAssertFieldName)) {
				if (account.getAddress1() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("address2", additionalAssertFieldName)) {
				if (account.getAddress2() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("birthday", additionalAssertFieldName)) {
				if (account.getBirthday() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("city", additionalAssertFieldName)) {
				if (account.getCity() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("confirmPassword", additionalAssertFieldName)) {
				if (account.getConfirmPassword() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("emailAddress", additionalAssertFieldName)) {
				if (account.getEmailAddress() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("firstName", additionalAssertFieldName)) {
				if (account.getFirstName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("genre", additionalAssertFieldName)) {
				if (account.getGenre() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("homePhone", additionalAssertFieldName)) {
				if (account.getHomePhone() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("lastName", additionalAssertFieldName)) {
				if (account.getLastName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("mobilePhone", additionalAssertFieldName)) {
				if (account.getMobilePhone() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("password", additionalAssertFieldName)) {
				if (account.getPassword() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("securityAnswer", additionalAssertFieldName)) {
				if (account.getSecurityAnswer() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("securityQuestion", additionalAssertFieldName)) {
				if (account.getSecurityQuestion() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("state", additionalAssertFieldName)) {
				if (account.getState() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("termsOfUse", additionalAssertFieldName)) {
				if (account.getTermsOfUse() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Account> page) {
		boolean valid = false;

		java.util.Collection<Account> accounts = page.getItems();

		int size = accounts.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(com.liferay.amf.dto.v1_0.Account.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(Account account1, Account account2) {
		if (account1 == account2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("accountName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getAccountName(), account2.getAccountName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("address1", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getAddress1(), account2.getAddress1())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("address2", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getAddress2(), account2.getAddress2())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("birthday", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getBirthday(), account2.getBirthday())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("city", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getCity(), account2.getCity())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("confirmPassword", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getConfirmPassword(),
						account2.getConfirmPassword())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("emailAddress", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getEmailAddress(),
						account2.getEmailAddress())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("firstName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getFirstName(), account2.getFirstName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("genre", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getGenre(), account2.getGenre())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("homePhone", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getHomePhone(), account2.getHomePhone())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("lastName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getLastName(), account2.getLastName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("mobilePhone", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getMobilePhone(), account2.getMobilePhone())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("password", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getPassword(), account2.getPassword())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("securityAnswer", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getSecurityAnswer(),
						account2.getSecurityAnswer())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("securityQuestion", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getSecurityQuestion(),
						account2.getSecurityQuestion())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("state", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getState(), account2.getState())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("termsOfUse", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						account1.getTermsOfUse(), account2.getTermsOfUse())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		Stream<java.lang.reflect.Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			java.lang.reflect.Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_accountResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_accountResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, Account account) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("accountName")) {
			sb.append("'");
			sb.append(String.valueOf(account.getAccountName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("address1")) {
			sb.append("'");
			sb.append(String.valueOf(account.getAddress1()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("address2")) {
			sb.append("'");
			sb.append(String.valueOf(account.getAddress2()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("birthday")) {
			sb.append("'");
			sb.append(String.valueOf(account.getBirthday()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("city")) {
			sb.append("'");
			sb.append(String.valueOf(account.getCity()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("confirmPassword")) {
			sb.append("'");
			sb.append(String.valueOf(account.getConfirmPassword()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("emailAddress")) {
			sb.append("'");
			sb.append(String.valueOf(account.getEmailAddress()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("firstName")) {
			sb.append("'");
			sb.append(String.valueOf(account.getFirstName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("genre")) {
			sb.append("'");
			sb.append(String.valueOf(account.getGenre()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("homePhone")) {
			sb.append("'");
			sb.append(String.valueOf(account.getHomePhone()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("lastName")) {
			sb.append("'");
			sb.append(String.valueOf(account.getLastName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("mobilePhone")) {
			sb.append("'");
			sb.append(String.valueOf(account.getMobilePhone()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("password")) {
			sb.append("'");
			sb.append(String.valueOf(account.getPassword()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("securityAnswer")) {
			sb.append("'");
			sb.append(String.valueOf(account.getSecurityAnswer()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("securityQuestion")) {
			sb.append("'");
			sb.append(String.valueOf(account.getSecurityQuestion()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("state")) {
			sb.append("'");
			sb.append(String.valueOf(account.getState()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("termsOfUse")) {
			sb.append("'");
			sb.append(String.valueOf(account.getTermsOfUse()));
			sb.append("'");

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected Account randomAccount() throws Exception {
		return new Account() {
			{
				accountName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				address1 = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				address2 = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				birthday = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				city = StringUtil.toLowerCase(RandomTestUtil.randomString());
				confirmPassword = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				emailAddress =
					StringUtil.toLowerCase(RandomTestUtil.randomString()) +
						"@liferay.com";
				firstName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				genre = StringUtil.toLowerCase(RandomTestUtil.randomString());
				homePhone = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				lastName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				mobilePhone = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				password = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				securityAnswer = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				securityQuestion = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				state = StringUtil.toLowerCase(RandomTestUtil.randomString());
				termsOfUse = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
			}
		};
	}

	protected Account randomIrrelevantAccount() throws Exception {
		Account randomIrrelevantAccount = randomAccount();

		return randomIrrelevantAccount;
	}

	protected Account randomPatchAccount() throws Exception {
		return randomAccount();
	}

	protected AccountResource accountResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BaseAccountResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private com.liferay.amf.resource.v1_0.AccountResource _accountResource;

}