package com.liferay.site.setup.upgrade;

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
                site.getGroupId(), false,
                SiteSetupConstants.PAGE_ONE_NAME,
                SiteSetupConstants.PAGE_ONE_DESCRIPTION,
                SiteSetupConstants.PAGE_ONE_URL);
        )
    }
    @Reference
    SiteSetupHelper _siteSetupHelper;
}
