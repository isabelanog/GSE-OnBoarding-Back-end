package com.liferay.site.setup.upgrade;

import com.liferay.headless.admin.user.dto.v1_0.Site;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.site.setup.constants.SiteSetupConstants;
import com.liferay.site.setup.helper.SiteSetupHelper;
import org.osgi.service.component.annotations.Reference;

public class CreatePortalSite extends UpgradeProcess {

    public CreatePortalSite(SiteSetupHelper siteSetupHelper) {
        _siteSetupHelper = siteSetupHelper;
    }

    @Override
    protected void doUpgrade() throws Exception {
        Group site = _siteSetupHelper.addSite(   //HOME PAGE
                SiteSetupConstants.HOME_PAGE_NAME,
                SiteSetupConstants.HOME_PAGE_DESCRIPTION,
                SiteSetupConstants.HOME_PAGE_URL,
                GroupConstants.TYPE_SITE_OPEN);

        _siteSetupHelper.addPage(
                site.getGroupId(),
                false,
                SiteSetupConstants.PAGE_ONE_NAME,
                SiteSetupConstants.PAGE_ONE_TITLE,
                SiteSetupConstants.PAGE_ONE_DESCRIPTION,
                GroupConstants.TYPE_SITE_OPEN,
                false,
                SiteSetupConstants.PAGE_ONE_URL,
                SiteSetupConstants.LAYOUT_1_COLUMN
        );

        _siteSetupHelper.addPage(
                site.getGroupId(),
                false,
                SiteSetupConstants.PAGE_TWO_NAME,
                SiteSetupConstants.PAGE_TWO_TITLE,
                SiteSetupConstants.PAGE_TWO_DESCRIPTION,
                GroupConstants.TYPE_SITE_OPEN,
                false,
                SiteSetupConstants.PAGE_TWO_URL,
                SiteSetupConstants.LAYOUT_1_COLUMN
        );

        _siteSetupHelper.addPage(
                site.getGroupId(),
                false,
                SiteSetupConstants.PAGE_THREE_NAME,
                SiteSetupConstants.PAGE_THREE_TITLE,
                SiteSetupConstants.PAGE_THREE_DESCRIPTION,
                GroupConstants.TYPE_SITE_OPEN,
                false,
                SiteSetupConstants.PAGE_THREE_URL,
                SiteSetupConstants.LAYOUT_1_COLUMN
        );

        _siteSetupHelper.addPage(
                site.getGroupId(),
                false,
                SiteSetupConstants.HIDDEN_PAGE_NAME,
                SiteSetupConstants.HIDDEN_PAGE_TITLE,
                SiteSetupConstants.HIDDEN_PAGE_DESCRIPTION,
                GroupConstants.TYPE_SITE_OPEN,
                true,
                SiteSetupConstants.HIDDEN_PAGE_URL,
                SiteSetupConstants.LAYOUT_1_COLUMN
        );
    }
    @Reference
    SiteSetupHelper _siteSetupHelper;
}
