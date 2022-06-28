package com.liferay.content.setup.helper;


import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = SampleSiteSetupHelper.class)
public class SampleSiteSetupHelper {

    public Layout addPage(Long groupId, Boolean privatePage, long parentLayoutId,
                          String pageName, String title, String description,
                          String type, Boolean hidden, String friendlyURL, int columnLayout)
        throws Exception {

        Layout layout = _layoutLocalService.fetchLayoutByFriendlyURL(groupId, privatePage,friendlyURL);

        if (Validator.isNotNull(layout)) {
            _log.info("Page with the friendly URL "+ friendlyURL + " already existis");
            return layout;
        }

        long defaultCompanyId = _portal.getDefaultCompanyId();
        long adminUserId = _userLocalService.getDefaultUserId(defaultCompanyId);

        layout = _layoutLocalService.addLayout(adminUserId, groupId, privatePage, parentLayoutId,
                pageName, title, description, type, hidden, friendlyURL, new ServiceContext());

        return layout;
    }

    public Group addSite(String name, String description, String friendlyURL, int type)
        throws PortalException {

        long companyId = _portal.getDefaultCompanyId();

        Group group = _groupLocalService.fetchFriendlyURLGroup(
                companyId, friendlyURL);

        if (group != null) {
            _log.info("Site already exists: " + name);

            return group;
        }

        long userId = _userLocalService.getDefaultUserId(companyId);

        group = _groupLocalService.addGroup(
                userId, GroupConstants.DEFAULT_PARENT_GROUP_ID,
                Group.class.getName(), userId, GroupConstants.DEFAULT_LIVE_GROUP_ID, null, null,
                type, true, GroupConstants.DEFAULT_MEMBERSHIP_RESTRICTION, friendlyURL, true,
                false, true, new ServiceContext());

        _log.info("Site created: " + name);

        return group;
    }

    private static final Log _log = LogFactoryUtil.getLog(SampleSiteSetupHelper.class);
    @Reference
    private LayoutLocalService _layoutLocalService;

    @Reference
    private GroupLocalService _groupLocalService;

    @Reference
    private UserGroupLocalService _userGroupLocalService;

    @Reference
    private UserLocalService _userLocalService;

    @Reference
    private Portal _portal;
}
