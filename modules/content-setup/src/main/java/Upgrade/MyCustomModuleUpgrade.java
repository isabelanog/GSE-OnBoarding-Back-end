package Upgrade;

import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class MyCustomModuleUpgrade implements UpgradeStepRegistrator{
    @Override
    public void register(Registry registry) { //informs the Upgrade Framework about each new schema and associated upgrade steps to adapt data
        //implement the module’s upgrade registrations



    }
}
