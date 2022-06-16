package com.liferay.amf.rest.resource.v1_0.test;

import com.liferay.amf.rest.client.dto.v1_0.AccountDTO;
import com.liferay.amf.rest.client.http.HttpInvoker;
import com.liferay.amf.rest.client.pagination.Page;
import com.liferay.amf.rest.client.resource.v1_0.AccountResource;
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
	public void testDeleteAccount() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLDeleteAccount() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testCreateAccount() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGetAccount() throws Exception {
		Account postAccount = testGetAccount_addAccount();

		AccountDTO postAccountDTO = testGetAccount_addAccountDTO(
			postAccount.getId(), randomAccountDTO());

		AccountDTO getAccountDTO = accountResource.getAccount(
			postAccount.getId());

		assertEquals(postAccountDTO, getAccountDTO);
		assertValid(getAccountDTO);
	}

	protected AccountDTO testGetAccount_addAccountDTO(
			long accountId, AccountDTO accountDTO)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testUpdateAccount() throws Exception {
		Account postAccount = testPutAccount_addAccount();

		testUpdateAccount_addAccountDTO(
			postAccount.getId(), randomAccountDTO());

		AccountDTO randomAccountDTO = randomAccountDTO();

		AccountDTO putAccountDTO = accountResource.updateAccount(
			postAccount.getId(), randomAccountDTO);

		assertEquals(randomAccountDTO, putAccountDTO);
		assertValid(putAccountDTO);
	}

	protected AccountDTO testUpdateAccount_addAccountDTO(
			long accountId, AccountDTO accountDTO)
		throws Exception {

		return accountResource.updateAccount(accountId, accountDTO);
	}

	protected void assertContains(Object account, List<Object> accounts) {
		boolean contains = false;

		for (Object item : accounts) {
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

	protected void assertEquals(Object account1, Object account2) {
		Assert.assertTrue(
			account1 + " does not equal " + account2,
			equals(account1, account2));
	}

	protected void assertEquals(
		List<Object> accounts1, List<Object> accounts2) {

		Assert.assertEquals(accounts1.size(), accounts2.size());

		for (int i = 0; i < accounts1.size(); i++) {
			Object account1 = accounts1.get(i);
			Object account2 = accounts2.get(i);

			assertEquals(account1, account2);
		}
	}

	protected void assertEquals(
		AccountDTO accountDTO1, AccountDTO accountDTO2) {

		Assert.assertTrue(
			accountDTO1 + " does not equal " + accountDTO2,
			equals(accountDTO1, accountDTO2));
	}

	protected void assertEqualsIgnoringOrder(
		List<Object> accounts1, List<Object> accounts2) {

		Assert.assertEquals(accounts1.size(), accounts2.size());

		for (Object account1 : accounts1) {
			boolean contains = false;

			for (Object account2 : accounts2) {
				if (equals(account1, account2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				accounts2 + " does not contain " + account1, contains);
		}
	}

	protected void assertValid(Object account) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Object> page) {
		boolean valid = false;

		java.util.Collection<Object> accounts = page.getItems();

		int size = accounts.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(AccountDTO accountDTO) {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAccountDTOAssertFieldNames()) {

			if (Objects.equals("accountName", additionalAssertFieldName)) {
				if (accountDTO.getAccountName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("address1", additionalAssertFieldName)) {
				if (accountDTO.getAddress1() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("address2", additionalAssertFieldName)) {
				if (accountDTO.getAddress2() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("birthday", additionalAssertFieldName)) {
				if (accountDTO.getBirthday() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("city", additionalAssertFieldName)) {
				if (accountDTO.getCity() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("confirmPassword", additionalAssertFieldName)) {
				if (accountDTO.getConfirmPassword() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("emailAddress", additionalAssertFieldName)) {
				if (accountDTO.getEmailAddress() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("firstName", additionalAssertFieldName)) {
				if (accountDTO.getFirstName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("genre", additionalAssertFieldName)) {
				if (accountDTO.getGenre() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("homePhone", additionalAssertFieldName)) {
				if (accountDTO.getHomePhone() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("lastName", additionalAssertFieldName)) {
				if (accountDTO.getLastName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("mobilePhone", additionalAssertFieldName)) {
				if (accountDTO.getMobilePhone() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("password", additionalAssertFieldName)) {
				if (accountDTO.getPassword() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("securityAnswer", additionalAssertFieldName)) {
				if (accountDTO.getSecurityAnswer() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("securityQuestion", additionalAssertFieldName)) {
				if (accountDTO.getSecurityQuestion() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("state", additionalAssertFieldName)) {
				if (accountDTO.getState() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("termsOfUse", additionalAssertFieldName)) {
				if (accountDTO.getTermsOfUse() == null) {
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

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected String[] getAdditionalAccountDTOAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

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

	protected boolean equals(Object account1, Object account2) {
		if (account1 == account2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

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

	protected boolean equals(AccountDTO accountDTO1, AccountDTO accountDTO2) {
		if (accountDTO1 == accountDTO2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAccountDTOAssertFieldNames()) {

			if (Objects.equals("accountName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						accountDTO1.getAccountName(),
						accountDTO2.getAccountName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("address1", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						accountDTO1.getAddress1(), accountDTO2.getAddress1())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("address2", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						accountDTO1.getAddress2(), accountDTO2.getAddress2())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("birthday", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						accountDTO1.getBirthday(), accountDTO2.getBirthday())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("city", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						accountDTO1.getCity(), accountDTO2.getCity())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("confirmPassword", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						accountDTO1.getConfirmPassword(),
						accountDTO2.getConfirmPassword())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("emailAddress", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						accountDTO1.getEmailAddress(),
						accountDTO2.getEmailAddress())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("firstName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						accountDTO1.getFirstName(),
						accountDTO2.getFirstName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("genre", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						accountDTO1.getGenre(), accountDTO2.getGenre())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("homePhone", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						accountDTO1.getHomePhone(),
						accountDTO2.getHomePhone())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("lastName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						accountDTO1.getLastName(), accountDTO2.getLastName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("mobilePhone", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						accountDTO1.getMobilePhone(),
						accountDTO2.getMobilePhone())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("password", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						accountDTO1.getPassword(), accountDTO2.getPassword())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("securityAnswer", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						accountDTO1.getSecurityAnswer(),
						accountDTO2.getSecurityAnswer())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("securityQuestion", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						accountDTO1.getSecurityQuestion(),
						accountDTO2.getSecurityQuestion())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("state", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						accountDTO1.getState(), accountDTO2.getState())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("termsOfUse", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						accountDTO1.getTermsOfUse(),
						accountDTO2.getTermsOfUse())) {

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
		EntityField entityField, String operator, Object account) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

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

	protected AccountDTO randomAccountDTO() throws Exception {
		return new AccountDTO() {
			{
				accountName = RandomTestUtil.randomString();
				address1 = RandomTestUtil.randomString();
				address2 = RandomTestUtil.randomString();
				birthday = RandomTestUtil.randomString();
				city = RandomTestUtil.randomString();
				confirmPassword = RandomTestUtil.randomString();
				emailAddress = RandomTestUtil.randomString();
				firstName = RandomTestUtil.randomString();
				genre = RandomTestUtil.randomString();
				homePhone = RandomTestUtil.randomString();
				lastName = RandomTestUtil.randomString();
				mobilePhone = RandomTestUtil.randomString();
				password = RandomTestUtil.randomString();
				securityAnswer = RandomTestUtil.randomString();
				securityQuestion = RandomTestUtil.randomString();
				state = RandomTestUtil.randomString();
				termsOfUse = RandomTestUtil.randomString();
			}
		};
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
	private com.liferay.amf.rest.resource.v1_0.AccountResource _accountResource;

}