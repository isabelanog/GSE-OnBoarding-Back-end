package com.liferay.content.setup;


import com.liferay.content.setup.command.processor.UpgradeCommandProcessor;
import com.liferay.content.setup.constants.SampleSiteSetupConstants;
import com.liferay.content.setup.upgrade.CreateSampleSiteUpgradeProcess;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upgrade.DummyUpgradeProcess;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = ContentSetupUpgradeStepRegistrator.class)
public class ContentSetupUpgradeStepRegistrator implements UpgradeStepRegistrator {

    @Override
    public void register(Registry registry) {

        registry.register("0.0.0","1.0.0", new DummyUpgradeProcess());

        registry.register("1.0.0","1.1.0", new CreateSampleSiteUpgradeProcess());

    }

    @Activate
    public void activate() throws PortalException {
        try {
            _upgradeCommandProcessor.upgradeBundle(SampleSiteSetupConstants.BUNDLE_SYMBOLIC_NAME);
        }
        catch (PortalException portalException) {
            _log.error("Error upgrading bundle: " + portalException.getMessage(), portalException);

            throw new PortalException(portalException);
        }
    }
    @Reference
    private UpgradeCommandProcessor _upgradeCommandProcessor;

    private static final Log _log = LogFactoryUtil.getLog(ContentSetupUpgradeStepRegistrator.class);
}
