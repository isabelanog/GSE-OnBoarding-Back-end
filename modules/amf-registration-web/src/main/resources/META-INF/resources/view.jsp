<%@ include file="/init.jsp" %>


<main class="col-lg-6 mx-auto">
  <aui:form name="amf-registration" onsubmit="handleOnSubmit(event)">
    <aui:fieldset-group markupView="lexicon">
      <aui:fieldset label="basic-info">
        <aui:row>
          <aui:col width="50">
            <aui:input
              required="true"
              label="first-name"
              name="firstName"
              type="text"
            >
              <aui:validator name="maxLength">50</aui:validator>
            </aui:input>
          </aui:col>
          <aui:col width="50">
            <aui:input
              required="true"
              label="last-name"
              name="lastName"
              type="text"
            >
              <aui:validator name="maxLength">50</aui:validator>
            </aui:input>
          </aui:col>
        </aui:row>
        <aui:row>
          <aui:col width="30">
            <aui:input
              required="true"
              label="email-address"
              name="emailAddress"
              type="email"
            >
              <aui:validator name="emailAddress" />
              <aui:validator name="maxLength">50</aui:validator>
            </aui:input>
          </aui:col>
          <aui:col width="30">
            <aui:input
              required="true"
              label="username"
              name="userName"
              type="text"
            >
              <aui:validator name="alphanum" />
              <aui:validator name="rangeLength">[4,16]</aui:validator>
            </aui:input>
          </aui:col>
          <aui:col width="30">
            <aui:select label="gender" name="genre" required="true">
              <aui:option value="" disabled="true" hidden="true" selected="true"
                ><liferay-ui:message key="gender-placeholder" /></aui:option
              >
              <aui:option label="male" value="Male" />
              <aui:option label="female" value="Female" />
            </aui:select>
          </aui:col>
        </aui:row>
        <aui:row>
          <aui:col width="30">
            <aui:input
              cssClass="input-group-inset-after"
              required="true"
              label="birthday"
              name="birthday"
              type="date"
            >
              <aui:validator name="date" />
              <aui:validator
                errorMessage="Must be at least 13 years old to register."
                name="custom"
              >
                function underAgeValidate(birthday){ var optimizedBirthday =
                birthday.replace(/-/g, "/"); var myBirthday = new
                Date(optimizedBirthday); var currentDate = new
                Date().toJSON().slice(0,10)+' 01:00:00'; var myAge =
                ~~((Date.now(currentDate) - myBirthday) / (31557600000));
                if(myAge < 13) { return false; }else{ return true; } }
              </aui:validator>
            </aui:input>
          </aui:col>
          <aui:col width="30">
            <aui:input
              label="password"
              name="password"
              required="true"
              type="password"
            >
              <aui:validator
                errorMessage="Must contain the minimum of 6 characters, one uppercase, one number and one special character"
                name="custom"
              >
                function checkPassword(password) { var regex =
                /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{6,}$/
                return regex.test(password)}
              </aui:validator>
            </aui:input>
          </aui:col>
          <aui:col width="30">
            <aui:input
              required="true"
              label="confirm-password"
              name="confirmPassword"
              type="password"
            >
              <aui:validator name="equalTo"
                >'#<portlet:namespace />password'</aui:validator
              >
            </aui:input>
          </aui:col>
        </aui:row>
      </aui:fieldset>
    </aui:fieldset-group>

    <aui:fieldset-group markupView="lexicon">
      <aui:fieldset label="phone-info">
        <aui:row>
          <aui:col width="50">
            <aui:input label="home-phone" name="homePhone" type="text">
              <aui:validator name="number" />
              <aui:validator name="maxLength">10</aui:validator>
              <aui:validator name="minLength">10</aui:validator>
            </aui:input>
          </aui:col>
          <aui:col width="50">
            <aui:input label="mobile-phone" name="mobilePhone" type="text">
              <aui:validator name="number" />
              <aui:validator name="maxLength">10</aui:validator>
              <aui:validator name="minLength">10</aui:validator>
            </aui:input>
          </aui:col>
        </aui:row>
      </aui:fieldset>
    </aui:fieldset-group>

    <aui:fieldset-group markupView="lexicon">
      <aui:fieldset label="billing-address">
        <aui:row>
          <aui:col width="50">
            <aui:input
              label="address1"
              name="address1"
              required="true"
              type="text"
            >
              <aui:validator name="maxLength">255</aui:validator>
            </aui:input>
          </aui:col>
          <aui:col width="50">
            <aui:input label="address2" name="address2" type="text">
              <aui:validator name="maxLength">255</aui:validator>
            </aui:input>
          </aui:col>
        </aui:row>
        <aui:row>
          <aui:col width="30">
            <aui:input label="city" name="city" required="true" type="text">
              <aui:validator name="alphanum" />
              <aui:validator name="maxLength">255</aui:validator>
            </aui:input>
          </aui:col>
          <aui:col width="30">
            <aui:input label="state" name="state" required="true" type="text">
              <aui:validator name="alphanum" />
              <aui:validator name="maxLength">255</aui:validator>
            </aui:input>
          </aui:col>
          <aui:col width="30">
            <aui:input
              label="zip-code"
              name="zipCode"
              required="true"
              type="text"
            >
              <aui:validator name="number" />
              <aui:validator name="minLength">5</aui:validator>
              <aui:validator name="maxLength">5</aui:validator>
            </aui:input>
          </aui:col>
        </aui:row>
      </aui:fieldset>
    </aui:fieldset-group>

    <aui:fieldset-group markupView="lexicon">
      <aui:fieldset label="misc">
        <aui:row>
          <aui:col width="50">
            <aui:select
              label="security-question-label"
              name="securityQuestion"
              required="true"
            >
              <aui:option value="" disabled="true" hidden="true" selected="true"
                ><liferay-ui:message key="security-question-placeholder" /></aui:option
              >
              <aui:option
                label="security-question1"
                value="What is your mother's maiden name?"
              />
              <aui:option
                label="security-question2"
                value="What is the make of your first car?"
              />
              <aui:option
                label="security-question3"
                value="What is your high school mascot?"
              />
              <aui:option
                label="security-question4"
                value="Who is your favorite actor?"
              />
            </aui:select>
          </aui:col>
          <aui:col width="50">
            <aui:input label="answer" name="answer" required="true" type="text">
              <aui:validator name="maxLength">255</aui:validator>
            </aui:input>
          </aui:col>
        </aui:row>
        <aui:row>
          <aui:input
            label="terms-of-use-label"
            name="termsOfUse"
            required="true"
            type="checkbox"
          />
        </aui:row>
      </aui:fieldset>
    </aui:fieldset-group>
    <aui:button-row cssClass="mt-3">
      <aui:button name="submitButton" type="submit" value="Submit" />
    </aui:button-row>
  </aui:form>
</main>

<aui:script>

function formatDate(date) {
  return (
    date.getFullYear() +
    '-' +
    (date.getMonth() + 1) +
    '-' +
    date.getDate() +
    ' ' +
    date.toLocaleTimeString('pt-br')
  );
}
function handleOnSubmit(event) {
  event.preventDefault();

  const formData = new FormData(event.target);
  const formProps = Object.fromEntries(formData);

  const data = Object.entries(formProps).reduce(function (acc, formData) {
    const [key, value] = formData;
    const keyFormatted = key.split('_').pop();
    return { ...acc, [keyFormatted]: value === 'on' ? true : value };
  }, {});

  let formattedData = {
    ...data,
    birthday: formatDate(new Date(data.birthday)),
    createDate: formatDate(new Date()),
    modifiedDate: formatDate(new Date()),
  };

  delete formattedData.formDate;

  fetch('http://localhost:8080/o/accounts/add?p_auth=' + Liferay.authToken, {
    body: JSON.stringify(formattedData),
    headers: { 'Content-Type': 'application/json' },
    method: 'POST',
  });
}
</aui:script>