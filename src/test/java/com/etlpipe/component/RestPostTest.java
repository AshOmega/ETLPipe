package com.etlpipe.component;

import com.etlpipe.aop.Included;
import com.etlpipe.common.Constants;
import com.etlpipe.component.impl.rest.RestPost;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.util.Set;

@SpringBootTest
public class RestPostTest
{
    @Test
    public void testDependencies() throws Exception
    {
        Reflections reflections = new Reflections(Constants.BASE_PACKAGE);
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(Included.class);
        boolean isPresent = false;

        for (Class<?> controller : annotated) {
            Included included = controller.getAnnotation(Included.class);
            Class[] mapping = included.values();
            System.out.println(mapping[0].getCanonicalName());

            Field[] declaredFields = controller.getDeclaredFields();

            for(Field field : declaredFields){
                System.out.println(field.getType().getName());
                System.out.println(RestPost.class.getCanonicalName());
                if(field.getType().getName().equalsIgnoreCase(RestPost.class.getCanonicalName())){
                    isPresent = true;
                    break;
                }
            }
        }
        if(isPresent)
            System.out.println("Configs are ok");
        else
            throw new Exception("Unable to find the mandatory class RestPost");

    }
}
