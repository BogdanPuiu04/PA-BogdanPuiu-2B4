import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Solution {

    public static void readFileRecursive(File folder, String path) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String aux = null;
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                readFileRecursive(file, path + "\\" + file.getName());
            } else if (file.getName().endsWith(".java")) {
                aux = path + "\\" + file.getName();
                aux = aux.substring(0, aux.length() - 5);
                System.out.println("Path ul este: " + aux);
                File f1 = new File(aux);
                String clas = f1.getName();
                Class c = Class.forName(clas);
                System.out.println("class name: " + c.getName());
                System.out.println("atribut: " + ClassInfos.getAttributes(c) + " " + c.getName());
                Method[] methods = c.getMethods();
                for (Method m : methods) {
                    System.out.println("method: " + m.getName() + " " + ClassInfos.methodAttributes(m));
                }
                ClassInfos.isTestClass(c);
            }
        }
    }

}
