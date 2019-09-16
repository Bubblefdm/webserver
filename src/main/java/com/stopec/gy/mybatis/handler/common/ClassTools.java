package com.stopec.gy.mybatis.handler.common;

import org.springframework.util.ClassUtils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClassTools extends ClassUtils {

    public static boolean hasClassAnnotation(Class<?> clazz, Class<? extends Annotation> annotationClass) {
        return getClassAnnotation(clazz, annotationClass) != null;
    }

    public static <A extends Annotation> A getClassAnnotation(Class<?> clazz, Class<A> annotationClass) {
        return clazz.getAnnotation(annotationClass);
    }

    public static Set<Class<?>> getClasses(String pagekageName, boolean recursive, Class<? extends Annotation> annotationClass) {
        Set<Class<?>> classes = new LinkedHashSet();
        String packageName = pagekageName;
        String packageDirName = pagekageName.replace('.', '/');

        try {
            Enumeration dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);

            while (true) {
                while (dirs.hasMoreElements()) {
                    URL url = (URL) dirs.nextElement();
                    String protocol = url.getProtocol();
                    if ("file".equals(protocol)) {
                        String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                        findAndAddClassesInPackageByFile(packageName, filePath, recursive, classes, annotationClass);
                    } else if ("jar".equals(protocol)) {
                        try {
                            JarFile jar = ((JarURLConnection) url.openConnection()).getJarFile();
                            Enumeration entries = jar.entries();

                            while (true) {
                                JarEntry entry = null;
                                String name = "";
                                int idx;
                                do {
                                    do {
                                        if (!entries.hasMoreElements()) {
                                            continue;
                                        }

                                        entry = (JarEntry) entries.nextElement();
                                        name = entry.getName();
                                        if (name.charAt(0) == '/') {
                                            name = name.substring(1);
                                        }
                                    } while (!name.startsWith(packageDirName));

                                    idx = name.lastIndexOf(47);
                                    if (idx != -1) {
                                        packageName = name.substring(0, idx).replace('/', '.');
                                    }
                                } while (idx == -1 && !recursive);

                                if (name.endsWith(".class") && !entry.isDirectory()) {
                                    String className = name.substring(packageName.length() + 1, name.length() - 6);
                                    try {
                                        Class<?> forName = Class.forName(packageName + '.' + className);
                                        if (annotationClass != null) {
                                            if (forName.getAnnotation(annotationClass) != null) {
                                                classes.add(forName);
                                            }
                                        } else {
                                            classes.add(forName);
                                        }
                                    } catch (ClassNotFoundException var16) {
                                        var16.printStackTrace();
                                    }
                                }
                            }
                        } catch (IOException var17) {
                            throw new RuntimeException(var17);
                        }
                    }
                }

                return classes;
            }
        } catch (IOException var18) {
            var18.printStackTrace();
            return classes;
        }
    }

    public static void findAndAddClassesInPackageByFile(String packageName, String packagePath, final boolean recursive, Set<Class<?>> classes, Class<? extends Annotation> annotationClass) {
        File dir = new File(packagePath);
        if (dir.exists() && dir.isDirectory()) {
            File[] dirfiles = dir.listFiles(new FileFilter() {
                public boolean accept(File file) {
                    return recursive && file.isDirectory() || file.getName().endsWith(".class");
                }
            });
            File[] var7 = dirfiles;
            int var8 = dirfiles.length;
            for (int var9 = 0; var9 < var8; ++var9) {
                File file = var7[var9];
                if (file.isDirectory()) {
                    findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, classes, annotationClass);
                } else {
                    String className = file.getName().substring(0, file.getName().length() - 6);
                    try {
                        Class<?> forName = Class.forName(packageName + '.' + className);
                        if (annotationClass != null) {
                            if (forName.getAnnotation(annotationClass) != null) {
                                classes.add(forName);
                            }
                        } else {
                            classes.add(forName);
                        }
                    } catch (ClassNotFoundException var13) {
                        var13.printStackTrace();
                    }
                }
            }

        }
    }
}

