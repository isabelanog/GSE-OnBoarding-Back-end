package com.liferay.amf.client.serdes.v1_0;

import com.liferay.amf.client.dto.v1_0.Account;
import com.liferay.amf.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author me
 * @generated
 */
@Generated("")
public class AccountSerDes {

	public static Account toDTO(String json) {
		AccountJSONParser accountJSONParser = new AccountJSONParser();

		return accountJSONParser.parseToDTO(json);
	}

	public static Account[] toDTOs(String json) {
		AccountJSONParser accountJSONParser = new AccountJSONParser();

		return accountJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Account account) {
		if (account == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (account.getAccountName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"accountName\": ");

			sb.append("\"");

			sb.append(_escape(account.getAccountName()));

			sb.append("\"");
		}

		if (account.getAddress1() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"address1\": ");

			sb.append("\"");

			sb.append(_escape(account.getAddress1()));

			sb.append("\"");
		}

		if (account.getAddress2() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"address2\": ");

			sb.append("\"");

			sb.append(_escape(account.getAddress2()));

			sb.append("\"");
		}

		if (account.getBirthday() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"birthday\": ");

			sb.append("\"");

			sb.append(_escape(account.getBirthday()));

			sb.append("\"");
		}

		if (account.getCity() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"city\": ");

			sb.append("\"");

			sb.append(_escape(account.getCity()));

			sb.append("\"");
		}

		if (account.getConfirmPassword() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"confirmPassword\": ");

			sb.append("\"");

			sb.append(_escape(account.getConfirmPassword()));

			sb.append("\"");
		}

		if (account.getEmailAddress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"emailAddress\": ");

			sb.append("\"");

			sb.append(_escape(account.getEmailAddress()));

			sb.append("\"");
		}

		if (account.getFirstName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"firstName\": ");

			sb.append("\"");

			sb.append(_escape(account.getFirstName()));

			sb.append("\"");
		}

		if (account.getGenre() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"genre\": ");

			sb.append("\"");

			sb.append(_escape(account.getGenre()));

			sb.append("\"");
		}

		if (account.getHomePhone() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"homePhone\": ");

			sb.append("\"");

			sb.append(_escape(account.getHomePhone()));

			sb.append("\"");
		}

		if (account.getLastName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"lastName\": ");

			sb.append("\"");

			sb.append(_escape(account.getLastName()));

			sb.append("\"");
		}

		if (account.getMobilePhone() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mobilePhone\": ");

			sb.append("\"");

			sb.append(_escape(account.getMobilePhone()));

			sb.append("\"");
		}

		if (account.getPassword() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"password\": ");

			sb.append("\"");

			sb.append(_escape(account.getPassword()));

			sb.append("\"");
		}

		if (account.getSecurityAnswer() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"securityAnswer\": ");

			sb.append("\"");

			sb.append(_escape(account.getSecurityAnswer()));

			sb.append("\"");
		}

		if (account.getSecurityQuestion() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"securityQuestion\": ");

			sb.append("\"");

			sb.append(_escape(account.getSecurityQuestion()));

			sb.append("\"");
		}

		if (account.getState() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"state\": ");

			sb.append("\"");

			sb.append(_escape(account.getState()));

			sb.append("\"");
		}

		if (account.getTermsOfUse() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"termsOfUse\": ");

			sb.append("\"");

			sb.append(_escape(account.getTermsOfUse()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		AccountJSONParser accountJSONParser = new AccountJSONParser();

		return accountJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Account account) {
		if (account == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (account.getAccountName() == null) {
			map.put("accountName", null);
		}
		else {
			map.put("accountName", String.valueOf(account.getAccountName()));
		}

		if (account.getAddress1() == null) {
			map.put("address1", null);
		}
		else {
			map.put("address1", String.valueOf(account.getAddress1()));
		}

		if (account.getAddress2() == null) {
			map.put("address2", null);
		}
		else {
			map.put("address2", String.valueOf(account.getAddress2()));
		}

		if (account.getBirthday() == null) {
			map.put("birthday", null);
		}
		else {
			map.put("birthday", String.valueOf(account.getBirthday()));
		}

		if (account.getCity() == null) {
			map.put("city", null);
		}
		else {
			map.put("city", String.valueOf(account.getCity()));
		}

		if (account.getConfirmPassword() == null) {
			map.put("confirmPassword", null);
		}
		else {
			map.put(
				"confirmPassword",
				String.valueOf(account.getConfirmPassword()));
		}

		if (account.getEmailAddress() == null) {
			map.put("emailAddress", null);
		}
		else {
			map.put("emailAddress", String.valueOf(account.getEmailAddress()));
		}

		if (account.getFirstName() == null) {
			map.put("firstName", null);
		}
		else {
			map.put("firstName", String.valueOf(account.getFirstName()));
		}

		if (account.getGenre() == null) {
			map.put("genre", null);
		}
		else {
			map.put("genre", String.valueOf(account.getGenre()));
		}

		if (account.getHomePhone() == null) {
			map.put("homePhone", null);
		}
		else {
			map.put("homePhone", String.valueOf(account.getHomePhone()));
		}

		if (account.getLastName() == null) {
			map.put("lastName", null);
		}
		else {
			map.put("lastName", String.valueOf(account.getLastName()));
		}

		if (account.getMobilePhone() == null) {
			map.put("mobilePhone", null);
		}
		else {
			map.put("mobilePhone", String.valueOf(account.getMobilePhone()));
		}

		if (account.getPassword() == null) {
			map.put("password", null);
		}
		else {
			map.put("password", String.valueOf(account.getPassword()));
		}

		if (account.getSecurityAnswer() == null) {
			map.put("securityAnswer", null);
		}
		else {
			map.put(
				"securityAnswer", String.valueOf(account.getSecurityAnswer()));
		}

		if (account.getSecurityQuestion() == null) {
			map.put("securityQuestion", null);
		}
		else {
			map.put(
				"securityQuestion",
				String.valueOf(account.getSecurityQuestion()));
		}

		if (account.getState() == null) {
			map.put("state", null);
		}
		else {
			map.put("state", String.valueOf(account.getState()));
		}

		if (account.getTermsOfUse() == null) {
			map.put("termsOfUse", null);
		}
		else {
			map.put("termsOfUse", String.valueOf(account.getTermsOfUse()));
		}

		return map;
	}

	public static class AccountJSONParser extends BaseJSONParser<Account> {

		@Override
		protected Account createDTO() {
			return new Account();
		}

		@Override
		protected Account[] createDTOArray(int size) {
			return new Account[size];
		}

		@Override
		protected void setField(
			Account account, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "accountName")) {
				if (jsonParserFieldValue != null) {
					account.setAccountName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "address1")) {
				if (jsonParserFieldValue != null) {
					account.setAddress1((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "address2")) {
				if (jsonParserFieldValue != null) {
					account.setAddress2((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "birthday")) {
				if (jsonParserFieldValue != null) {
					account.setBirthday((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "city")) {
				if (jsonParserFieldValue != null) {
					account.setCity((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "confirmPassword")) {
				if (jsonParserFieldValue != null) {
					account.setConfirmPassword((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "emailAddress")) {
				if (jsonParserFieldValue != null) {
					account.setEmailAddress((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "firstName")) {
				if (jsonParserFieldValue != null) {
					account.setFirstName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "genre")) {
				if (jsonParserFieldValue != null) {
					account.setGenre((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "homePhone")) {
				if (jsonParserFieldValue != null) {
					account.setHomePhone((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "lastName")) {
				if (jsonParserFieldValue != null) {
					account.setLastName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "mobilePhone")) {
				if (jsonParserFieldValue != null) {
					account.setMobilePhone((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "password")) {
				if (jsonParserFieldValue != null) {
					account.setPassword((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "securityAnswer")) {
				if (jsonParserFieldValue != null) {
					account.setSecurityAnswer((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "securityQuestion")) {
				if (jsonParserFieldValue != null) {
					account.setSecurityQuestion((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "state")) {
				if (jsonParserFieldValue != null) {
					account.setState((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "termsOfUse")) {
				if (jsonParserFieldValue != null) {
					account.setTermsOfUse((String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}