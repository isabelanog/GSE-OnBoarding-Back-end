package com.liferay.content.setup.helper;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.*;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Portal;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Component(immediate = true, service = ObjectHelper.class)
public class ObjectHelper {

    public ObjectEntry addObjectEntry(long userId, long groupId, long objectDefinitionId,
			Map<String, Serializable> values, ServiceContext serviceContext) throws Exception {

        userId = _userLocalService.getDefaultUserId(_portal.getDefaultCompanyId());
        objectDefinitionId = _counterLocalService.increment(ObjectHelper.class.getName());
        values = new HashMap<>();
        //values.put(SerializableUtil.serialize());
           /*     objectFieldBuilder.listTypeDefinitionId(listTypeDefinitionId);
                objectFieldBuilder.businessType(businessType),
                objectFieldBuilder.dbType(dbType),
                objectFieldBuilder.indexed(indexed),
                objectFieldBuilder.objectFieldSettings(objectFieldSettings),
                objectFieldBuilder.name(name),
                objectFieldBuilder.required(required)),
        labelMap;*/

         return _objectEntryLocalService.addObjectEntry(userId, groupId,objectDefinitionId,values,new ServiceContext());

        }


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
