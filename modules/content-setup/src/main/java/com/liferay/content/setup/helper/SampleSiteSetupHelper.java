package com.liferay.content.setup.helper;


import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Component(immediate = true, service = SampleSiteSetupHelper.class)
public class SampleSiteSetupHelper {

    public Layout addPage(Long groupId, Boolean privatePage, Long parentLayoutId,
                          String pageName, String title, String description, String type,
                          Boolean hidden, String friendlyUrl, String columnLayout)
        throws Exception {

        return addPage(groupId, privatePage, parentLayoutId, pageName, title, description,
                type, hidden, friendlyUrl, columnLayout, null);
    }

    public Layout addPage(Long groupId, Boolean privatePage, Long parentLayoutId,
                          String pageName, String title, String description, String type,
                          Boolean hidden, String friendlyUrl, String columnLayout,
                          String layoutPageTemplateEntryKey) throws Exception {

        Layout layout = _layoutLocalService.fetchLayoutByFriendlyURL(groupId, privatePage,friendlyUrl);

        if (Validator.isNotNull(layout)) {
            _log.info("Page with the friendly URL "+ friendlyUrl + " already existis");
            return layout;
        }

        long defaultCompanyId = _portal.getDefaultCompanyId();
        long adminUserId = _userLocalService.getDefaultUserId(defaultCompanyId);

        layout = _layoutLocalService.addLayout(adminUserId, groupId, privatePage, parentLayoutId,
                pageName, title, description, type, hidden, friendlyUrl, new ServiceContext());

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

        Map<Locale,String> nameMap = new HashMap<>();
        Map<Locale,String> descriptionMap = new HashMap<>();

        nameMap.put(LocaleUtil.getDefault(), name);
        descriptionMap.put(LocaleUtil.getDefault(),description);

        group = _groupLocalService.addGroup(
                userId, GroupConstants.DEFAULT_PARENT_GROUP_ID,
                Group.class.getName(), userId, GroupConstants.DEFAULT_LIVE_GROUP_ID,
                nameMap, descriptionMap, type, true,
                GroupConstants.DEFAULT_MEMBERSHIP_RESTRICTION, friendlyURL, true,
                false, true, new ServiceContext());

        _log.info("Site created: " + name);

        return _groupLocalService.addGroup(group);
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
