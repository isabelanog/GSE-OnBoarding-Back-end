package com.liferay.content.setup.helper;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.object.model.ObjectField;
import com.liferay.object.model.ObjectFieldSetting;
import com.liferay.object.service.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Portal;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.*;

@Component(immediate = true, service = ObjectHelper.class)
public class ObjectHelper {

      public ObjectField addCustomObjectField(
                long userId, long listTypeDefinitionId, long objectDefinitionId,
                String businessType, String dbType, boolean indexed,
                boolean indexedAsKeyword, String indexedLanguageId,
                Map<Locale, String> labelMap, String name, boolean required,
                List<ObjectFieldSetting> objectFieldSettings)
                throws PortalException {
            
         labelMap = new HashMap<>();
         labelMap.put(LocaleUtil.getDefault(), name);

        return addCustomObjectField(userId, listTypeDefinitionId, objectDefinitionId,
            businessType, dbType, indexed,
            indexedAsKeyword, indexedLanguageId,
            labelMap, name, required, objectFieldSettings);

        }

    private static final Log _log = LogFactoryUtil.getLog(ObjectHelper.class);
    @Reference
    private GroupLocalService _groupLocalService;
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


/*  public ObjectEntry addObjectEntry(long userId, long groupId, long objectDefinitionId,
			Map<String, Serializable> values, ServiceContext serviceContext) throws Exception {

        userId = _userLocalService.getDefaultUserId(_portal.getDefaultCompanyId());
        objectDefinitionId = _counterLocalService.increment(ObjectHelper.class.getName());
        values = new HashMap<>();

             _log.info("Object created");

        //values.put(SerializableUtil.serialize());
           /*     objectFieldBuilder.listTypeDefinitionId(listTypeDefinitionId);
                objectFieldBuilder.businessType(businessType),
                objectFieldBuilder.dbType(dbType),
                objectFieldBuilder.indexed(indexed),
                objectFieldBuilder.objectFieldSettings(objectFieldSettings),
                objectFieldBuilder.name(name),
                objectFieldBuilder.required(required)),
        labelMap;*/

// return _objectEntryLocalService.addObjectEntry(userId,
//       groupId,objectDefinitionId, values,new ServiceContext());
// }