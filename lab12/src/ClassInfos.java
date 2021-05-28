
import org.testng.annotations.Test;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassInfos {

    public static String getAttributes(Class o) {
        int aux = o.getModifiers();
        String type = null;
        if (Modifier.isPublic(aux))
            type = "public";
        if (Modifier.isPrivate(aux))
            type = "private";
        if (Modifier.isProtected(aux))
            type = "protected";
        if (Modifier.isPrivate(aux) && Modifier.isStatic(aux))
            type = "private static";
        return type;

    }

    public static String methodAttributes(Method method) {
        int aux = method.getModifiers();
        String type = null;
        if (Modifier.isPublic(aux))
            type = "public";
        if (Modifier.isPrivate(aux))
            type = "private";
        if (Modifier.isProtected(aux))
            type = "protected";
        if (Modifier.isPrivate(aux) && Modifier.isStatic(aux))
            type = "private static";
        if (Modifier.isPublic(aux) && Modifier.isStatic(aux))
            type = "public static";
        return type;
    }

    public static void isTestClass(Class o) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        int tests = 0;
        int testFailed = 0;
        int passed = 0;
        Object obj = o.getConstructor().newInstance();
        Method[] methods = o.getMethods();
        for (Method m : methods) {
            // System.out.println("Metoda este : " + m.getName());
            for (Annotation annotation : m.getAnnotations()) {
                System.out.println(annotation.toString());
                if (annotation instanceof Test) {
                    try {
                        tests++;
                        System.out.println("Metoda este : " + m.getName());
                        m.invoke(obj,null);
                        passed++;
                    } catch (Exception e) {
                        testFailed++;
                        System.out.println(e.getCause());
                    }
                }
            }
        }
        System.out.println("tests:" + tests);
        System.out.println("passed: " + passed);
        System.out.println("failed: " + testFailed);

    }

}
