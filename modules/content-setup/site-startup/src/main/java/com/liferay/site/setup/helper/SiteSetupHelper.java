package com.liferay.site.setup.helper;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.UserGroupLocalService;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = SiteSetupHelper.class)
public class SiteSetupHelper {  //classe que cria as páginas

    public Layout addPage(
            Long groupId, Boolean privatePage,
            String pageName, String title, String description, String type,
            Boolean hidden, String friendlyUrl, String columnLayout)
            throws Exception {

        return addPage(
                groupId, privatePage, pageName, title, description,
                type, hidden, friendlyUrl, columnLayout, null);
    }

    public Layout addPage(
            Long groupId, Boolean privatePage,
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

    }

    public Group addSite(
            String name, String description, String friendlyURL, int type)
            throws PortalException {

       long companyId = counterLocalService.increment(SiteSetupHelper.class.getName()); // pq o counter não tá funcionando?

        Group group = _groupLocalService.fetchFriendlyURLGroup(
                companyId, friendlyURL);

        if (group != null) {
            _log.info("Site already exists: " + name);

            return group;
        }

        long userId = getAdminUserId(companyId); //tentar fazer counter

        group = _groupLocalService.addGroup(
                userId, GroupConstants.DEFAULT_PARENT_GROUP_ID,
                Group.class.getName(), userId, GroupConstants.DEFAULT_LIVE_GROUP_ID,
                type, true, GroupConstants.DEFAULT_MEMBERSHIP_RESTRICTION, friendlyURL, true,
                false, true, serviceContext);

        _log.info("Site created: " + name);

        return group;
    }

     public void setCompanyPublicHomePage(String url) throws Exception {
        setHomeURL(url);
    }
}


    @Reference
    private GroupLocalService _groupLocalService;

    @Reference
    private LayoutLocalService _layoutLocalService; //essa é a classe que grava no banco

    @Reference
    private UserGroupLocalService _userGroupLocalService;


}
