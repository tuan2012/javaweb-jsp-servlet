package com.cxtuan.Utils;

import com.cxtuan.Model.ExtendPaging;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

public class FormUtils {
    public static <T> T toModel(Class<T> tClass, HttpServletRequest req) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        T beanInstance = tClass.newInstance();
        BeanUtils.populate(beanInstance,req.getParameterMap());
        return beanInstance;
    }
}
