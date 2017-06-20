package com.sda.todo;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;




/**
 * Created by bartosz on 12.06.2017.
 */
public class TodoUtil {

    public static boolean isWriteRequest(HttpServletRequest req){

        Map<String, String[]> parameterMap = req.getParameterMap();
        //sprawdza czy mamy dane w naszym requescie czy mamy klucz
        return exists("name", parameterMap) &&
                exists("description", parameterMap) &&
                exists("priority", parameterMap) &&
                exists("date", parameterMap);

    }

    private static boolean exists(String param, Map<String, String[]>map){
        return map.containsKey(param) && StringUtils.isNotEmpty(map.get(param)[0]);
    }


}
