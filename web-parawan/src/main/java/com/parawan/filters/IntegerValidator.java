package com.parawan.filters;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntegerValidator {

    public boolean isIntegerParameterValid (String parameterKey, HttpServletRequest servletRequest){
        String parameter = servletRequest.getParameter(parameterKey);
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        boolean isGet = httpRequest.getMethod().equalsIgnoreCase("get");

        if (parameter == null || parameter.isEmpty()){
            return !isGet;
        }

        Pattern integerPattern = Pattern.compile("\\d+");
        Matcher matcher = integerPattern.matcher(parameter);

        if(!matcher.matches()){
            return false;
        }

        return true;
    }

    public boolean isIntegerParameterInScope(String parameterKey, HttpServletRequest servletRequest){
        int parameter =Integer.parseInt(servletRequest.getParameter(parameterKey));
        if(parameter>8 && parameter <19){
            return true;
        }
        return false;
    }
}
