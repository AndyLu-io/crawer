package Demo;

import java.io.*;

public class ClassLoaderDemo extends ClassLoader {
    private String name;

    public ClassLoaderDemo(ClassLoader parent, String name) {
        super(parent);
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public Class<?> findClass(String name) {

        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(new File("Users.luxiaobo.githubProject.simpleCrawer.target.classes.Demo.ClassLoaderTest.class"));
            int c = 0;
            while (-1 != (c = is.read())) {
                baos.write(c);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this.defineClass(name, data, 0, data.length);
    }
    public static void main(String[] args) {
        ClassLoaderDemo loader = new ClassLoaderDemo(
                ClassLoaderDemo.class.getClassLoader(), "ClassLoaderDemo");
        Class clazz;
        try {
            clazz = loader.loadClass("");
            Object object = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
