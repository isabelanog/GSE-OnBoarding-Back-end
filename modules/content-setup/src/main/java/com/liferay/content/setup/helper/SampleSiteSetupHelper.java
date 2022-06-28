package com.liferay.content.setup.helper;


import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
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

        long groupId = _counterLocalService.increment(Group.class.getName());

        group = _groupLocalService.createGroup(groupId);

        group.setCreatorUserId(userId);
        group.setParentGroupId(0);
        group.setName(name);
        group.setDescription(description);
        group.setType(type);
        group.setManualMembership(true);
        group.setMembershipRestriction(0);
        group.setFriendlyURL(friendlyURL);
        group.setInheritContent(false);
        group.setActive(true);

        _groupLocalService.updateGroup(group);

        _log.info("Site created: " + name);

        return group;
    }

    private static final Log _log = LogFactoryUtil.getLog(SampleSiteSetupHelper.class);
    @Reference
    private LayoutLocalService _layoutLocalService;

    @Reference
    private CounterLocalService _counterLocalService;
    @Reference
    private GroupLocalService _groupLocalService;

    @Reference
    private UserGroupLocalService _userGroupLocalService;

    @Reference
    private UserLocalService _userLocalService;

    @Reference
    private Portal _portal;
}
