package com.liferay.common.extensions.preaction.login;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.WebKeys;
import constants.CommonExtensionConstantsPreAction;
import org.osgi.service.component.annotations.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component(
        immediate = true,
        property = {
            "key=" + PropsKeys.SERVLET_SERVICE_EVENTS_PRE
        },
        service = LifecycleAction.class
)
public class LoginPreActionCommonExtensions implements LifecycleAction {

    @Override
    public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {

        HttpServletRequest request = lifecycleEvent.getRequest();

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        if (!themeDisplay.isSignedIn()) {

                if(themeDisplay.getURLCurrent().contains(CommonExtensionConstantsPreAction.SAMPLE_PAGE_URL)) {

                    HttpServletResponse response = lifecycleEvent.getResponse();

                    try {
                        response.sendRedirect("/web/samplesite" + CommonExtensionConstantsPreAction.HIDDEN_PAGE_URL);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    _log.info("Guest user attempted to access the sample page");
            }
    }

}
    private static final Log _log = LogFactoryUtil.getLog(LoginPreActionCommonExtensions.class);

}
