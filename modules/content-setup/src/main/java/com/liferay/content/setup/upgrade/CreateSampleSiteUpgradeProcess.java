package com.liferay.content.setup.upgrade;

import com.liferay.content.setup.constants.SampleSiteSetupConstants;
import com.liferay.content.setup.helper.SampleSiteSetupHelper;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import org.osgi.service.component.annotations.Reference;

public class CreateSampleSiteUpgradeProcess extends UpgradeProcess {

    @Override
    protected void doUpgrade() throws Exception {

        Group sampleSite = _sampleSiteSetupHelper.addSite(
                SampleSiteSetupConstants.SAMPLE_PAGE_NAME,
                SampleSiteSetupConstants.SAMPLE_PAGE_DESCRIPTION,
                SampleSiteSetupConstants.SAMPLE_PAGE_URL,
                GroupConstants.TYPE_SITE_OPEN);

        _sampleSiteSetupHelper.addPage(
                sampleSite.getGroupId(),
                false,
                LayoutConstants.DEFAULT_PARENT_LAYOUT_ID,
                SampleSiteSetupConstants.HIDDEN_PAGE_NAME,
                SampleSiteSetupConstants.HIDDEN_PAGE_TITLE,
                SampleSiteSetupConstants.HIDDEN_PAGE_DESCRIPTION,
                LayoutConstants.TYPE_CONTENT,
                true,
                SampleSiteSetupConstants.HIDDEN_PAGE_URL,
                SampleSiteSetupConstants.LAYOUT_1_COLUMN);
    }
    @Reference
    private SampleSiteSetupHelper _sampleSiteSetupHelper;

}
