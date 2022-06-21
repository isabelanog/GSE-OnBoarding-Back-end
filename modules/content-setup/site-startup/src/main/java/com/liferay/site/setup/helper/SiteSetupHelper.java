package com.liferay.site.setup.helper;

import com.liferay.layout.page.template.importer.LayoutPageTemplatesImporter;
import com.liferay.layout.page.template.model.LayoutPageTemplateEntry;
import com.liferay.layout.page.template.service.LayoutPageTemplateEntryLocalService;
import com.liferay.layout.util.LayoutCopyHelper;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.model.LayoutPrototype;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.model.UserGroup;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.LayoutPrototypeLocalService;
import com.liferay.portal.kernel.service.LayoutRevisionLocalService;
import com.liferay.portal.kernel.service.LayoutSetLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserGroupLocalService;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;

import java.io.InputStream;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;


import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = SiteSetupHelper.class)
public class SiteSetupHelper {  //classe que cria as páginas

    public Layout addPage(
            Long groupId, Boolean privatePage, Long parentLayoutId,
            String pageName, String title, String description, String type,
            Boolean hidden, String friendlyUrl, String columnLayout)
            throws Exception {

        return addPage(
                groupId, privatePage, parentLayoutId, pageName, title, description,
                type, hidden, friendlyUrl, columnLayout, null);
    }

    public Layout addPage(
            Long groupId, Boolean privatePage, Long parentLayoutId,
            String pageName, String title, String description, String type,
            Boolean hidden, String friendlyUrl, String columnLayout,
            String layoutPageTemplateEntryKey)
            throws Exception {

        Layout layout = _layoutLocalService.fetchLayoutByFriendlyURL(
                groupId, privatePage, friendlyUrl);

        if (Validator.isNotNull(layout)) {
            _log.info(
                    "Page with friendly url: " + friendlyUrl + " already exists");

            return layout;
        }

        long defaultCompanyId = _setupToolbox.getDefaultCompanyId();

        long adminUserId = _setupToolbox.getAdminUserId(defaultCompanyId);

        ServiceContext serviceContext = _setupToolbox.getDefaultServiceContext(
                defaultCompanyId, adminUserId);

        _setupPageTemplateSource(layoutPageTemplateEntryKey, serviceContext);

        layout = _layoutLocalService.addLayout(
                adminUserId, groupId, privatePage, parentLayoutId, pageName, title,
                description, type, hidden, friendlyUrl, serviceContext);

        LayoutTypePortlet layoutTypePortlet =
                (LayoutTypePortlet) layout.getLayoutType();

        layoutTypePortlet.setLayoutTemplateId(adminUserId, columnLayout);

        _layoutLocalService.updateLayout(layout);

        if (LayoutConstants.TYPE_CONTENT.equals(type)) {
            _publishLayout(layout);
        }

        return layout;
    }

    public Group addSite(
            String name, String description, String friendlyURL, int type)
            throws PortalException {

        long companyId = _setupToolbox.getDefaultCompanyId();

        Group group = _groupLocalService.fetchFriendlyURLGroup(
                companyId, friendlyURL);

        if (group != null) {
            _log.info("Site already exists: " + name);

            return group;
        }

        long userId = _setupToolbox.getAdminUserId(companyId);
        Map<Locale, String> nameMap = _setupToolbox.getLocalizedMap(
                LocaleUtil.getDefault(), name);
        Map<Locale, String> descriptionMap = _setupToolbox.getLocalizedMap(
                Locale.getDefault(), description);
        ServiceContext serviceContext = _setupToolbox.getDefaultServiceContext(
                companyId, userId);

        group = _groupLocalService.addGroup(
                userId, GroupConstants.DEFAULT_PARENT_GROUP_ID,
                Group.class.getName(), userId, GroupConstants.DEFAULT_LIVE_GROUP_ID,
                nameMap, descriptionMap, type, true,
                GroupConstants.DEFAULT_MEMBERSHIP_RESTRICTION, friendlyURL, true,
                false, true, serviceContext);

        _log.info("Site created: " + name);

        return group;
    }

     public void setCompanyPublicHomePage(String url) throws Exception {
        _setupToolbox.setHomeURL(url);
    }

}

    private static final Log _log = LogFactoryUtil.getLog(
            SiteSetupHelper.class);

    @Reference
    private GroupLocalService _groupLocalService;

    @Reference
    private LayoutCopyHelper _layoutCopyHelper;

    @Reference
    private LayoutLocalService _layoutLocalService;

    @Reference
    private LayoutPageTemplateEntryLocalService
            _layoutPageTemplateEntryLocalService;

    @Reference
    private LayoutPageTemplatesImporter _layoutPageTemplatesImporter;

    @Reference
    private LayoutPrototypeLocalService _layoutPrototypeLocalService;

    @Reference
    private LayoutRevisionLocalService _layoutRevisionLocalService;

    @Reference
    private LayoutSetLocalService _layoutSetLocalService;

    @Reference
    private SetupToolbox _setupToolbox;

    @Reference
    private UserGroupLocalService _userGroupLocalService;


}
