package com.liferay.content.setup.upgrade;

import com.liferay.content.setup.constants.SampleSiteSetupConstants;
import com.liferay.content.setup.helper.SampleSiteSetupHelper;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

public class CreateSampleSiteUpgradeProcess extends UpgradeProcess {
    public CreateSampleSiteUpgradeProcess(SampleSiteSetupHelper sampleSiteSetupHelper){
        _sampleSiteSetupHelper = sampleSiteSetupHelper;
    }
    @Override
    protected void doUpgrade() throws Exception {

        Group sampleSite = _sampleSiteSetupHelper.addSite(
                SampleSiteSetupConstants.SAMPLE_SITE_NAME,
                SampleSiteSetupConstants.SAMPLE_SITE_DESCRIPTION,
                SampleSiteSetupConstants.SAMPLE_SITE_URL,
                GroupConstants.TYPE_SITE_OPEN
        );

        _sampleSiteSetupHelper.addPage(
                sampleSite.getGroupId(), false,
                LayoutConstants.DEFAULT_PARENT_LAYOUT_ID,
                SampleSiteSetupConstants.SAMPLE_PAGE_NAME,
                SampleSiteSetupConstants.SAMPLE_PAGE_TITLE,
                SampleSiteSetupConstants.SAMPLE_PAGE_DESCRIPTION,
                LayoutConstants.TYPE_CONTENT,
                false,
                SampleSiteSetupConstants.SAMPLE_PAGE_URL,
                SampleSiteSetupConstants.LAYOUT_1_COLUMN
        );


       _sampleSiteSetupHelper.addPage(
               sampleSite.getGroupId(), false,
               LayoutConstants.DEFAULT_PARENT_LAYOUT_ID,
               SampleSiteSetupConstants.HIDDEN_PAGE_NAME,
               SampleSiteSetupConstants.HIDDEN_PAGE_TITLE,
               SampleSiteSetupConstants.HIDDEN_PAGE_DESCRIPTION,
               LayoutConstants.TYPE_CONTENT,
               true,
               SampleSiteSetupConstants.HIDDEN_PAGE_URL,
               SampleSiteSetupConstants.LAYOUT_1_COLUMN
       );

    }

    private SampleSiteSetupHelper _sampleSiteSetupHelper;

}
