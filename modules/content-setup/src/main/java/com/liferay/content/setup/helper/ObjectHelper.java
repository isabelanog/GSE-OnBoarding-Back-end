package com.liferay.content.setup.helper;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.model.ObjectField;
import com.liferay.object.model.ObjectFieldModel;
import com.liferay.object.model.ObjectFieldSetting;
import com.liferay.object.service.*;
import com.liferay.object.util.ObjectFieldBuilder;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Portal;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component(immediate = true, service = ObjectHelper.class)
public class ObjectHelper {

    public ObjectField addCustomObjectField(long userId, long listTypeDefinitionId, long objectDefinitionId,
                                            String businessType, String dbType, boolean indexed,
                                            boolean indexedAsKeyword, String indexedLanguageId,
                                            Map<Locale, String> labelMap, String name, boolean required,
                                            List<ObjectFieldSetting> objectFieldSettings) throws Exception {

        userId = _userLocalService.getDefaultUserId(_portal.getDefaultCompanyId());

        ObjectFieldBuilder objectFieldBuilder = new ObjectFieldBuilder();

        return addCustomObjectField(userId,
                objectFieldBuilder.listTypeDefinitionId(listTypeDefinitionId);
                objectFieldBuilder.businessType(businessType),
                objectFieldBuilder.dbType(dbType),
                objectFieldBuilder.indexed(indexed),
                objectFieldBuilder.objectFieldSettings(objectFieldSettings),
                objectFieldBuilder.name(name),
                objectFieldBuilder.required(required));

        }
        }

    @Reference
    private ObjectActionLocalService _objectActionLocalService;

    @Reference
    private  ObjectRelationshipLocalService _objectRelationshipLocalService;
    @Reference
    private ObjectDefinitionLocalService _objectDefinitionLocalService;

    @Reference
    private ObjectLayoutLocalService _objectLayoutLocalService;

    @Reference
    private ObjectEntryLocalService _objectEntryLocalService;

    @Reference
    private ObjectFieldLocalService _objectFieldLocalService;

    @Reference
    private Portal _portal;

    @Reference
    private UserLocalService _userLocalService;

    @Reference
    private CounterLocalService _counterLocalService;
}
