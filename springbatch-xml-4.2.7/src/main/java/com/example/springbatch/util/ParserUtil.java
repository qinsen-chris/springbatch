package com.example.springbatch.util;

import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.util.CollectionUtils;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.lang.reflect.Method;

public class ParserUtil {

    public static <T> T parseExpression(String expression, Method method, Object[] args, Class<T> classType) {
        if (StringUtils.isBlank(expression)) {
            return null;
        } else if (!expression.trim().startsWith("#") && !expression.trim().startsWith("$")) {
            return null;
        } else {
            LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();
            String[] paramNames = discoverer.getParameterNames(method);
            if(CollectionUtils.arrayToList(paramNames).isEmpty()){
                return null;
            }
//            if (ArrayUtils.isEmpty(paramNames)) {
//                return null;
//            }
            else {
                StandardEvaluationContext context = new StandardEvaluationContext();

                for (int i = 0; i < paramNames.length; ++i) {
                    context.setVariable(paramNames[i], args[i]);
                }
                return (new SpelExpressionParser()).parseExpression(expression).getValue(context, classType);
            }
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Demo demo = new Demo();
        Method setAge = Demo.class.getMethod("setAge",int.class);

        parseExpression("#age",setAge,new Object[]{11},Integer.class);
    }

}
