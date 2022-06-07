package com.liferay.amf.web.actions;

import com.liferay.amf.service.AccountLocalService;
import com.liferay.amf.web.constants.AccountPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.Date;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AccountPortletKeys.ACCOUNT,
                "mvc.command.name=/add-account"
        },
        service = MVCActionCommand.class
)
public class RegisterAccountMVCActionCommand extends BaseMVCActionCommand {
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        Long accountId = ParamUtil.getLong(actionRequest, "accountId")
        String firstName = ParamUtil.getString(actionRequest, "firstName");
        String lastName = ParamUtil.getString(actionRequest, "lastName");
        String emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
        String accountName = ParamUtil.getString(actionRequest, "accountName");
        String gender = ParamUtil.getString(actionRequest, "gender");
        String birthday = ParamUtil.getString(actionRequest, "birthday");
        String password = ParamUtil.getString(actionRequest, "password");
        int homePhone = Integer.parseInt(ParamUtil.getString(actionRequest, "homePhone"));
        int  mobilePhone = Integer.parseInt(ParamUtil.getString(actionRequest, "mobilePhone"));
        String address = ParamUtil.getString(actionRequest, "address");
        String address2 = ParamUtil.getString(actionRequest, "address2");
        String city = ParamUtil.getString(actionRequest, "city");
        String statezip = ParamUtil.getString(actionRequest, "statezip");
        String securityQuestion = ParamUtil.getString(actionRequest, "securityQuestion");
        String securitysecurityAnswer = ParamUtil.getString(actionRequest, "securityAnswer");
        String acceptedTou = ParamUtil.getString(actionRequest, "acceptedTou");



        _accountLocalService.createAccount(accountId,firstName,lastName,emailAddress,accountName,gender,birthday,password,
                homePhone,mobilePhone,address,address2,city,statezip,securityQuestion,securitysecurityAnswer,
                acceptedTou);
        System.out.println(("Account created sucefully"));
    }
    @Reference
    private AccountLocalService _accountLocalService;
}
