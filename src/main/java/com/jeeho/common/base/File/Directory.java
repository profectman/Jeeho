package com.jeeho.common.base.File;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * file 对象属性 file.list() file.listFiles() file.isDirectory() file.isFile() file.lastModified() file.exits() file.mkdirs() file.renameTo()
 */
public final class Directory {

    public static File[] local(File dir ,final String regex){
        return dir.listFiles(new FilenameFilter() {
            private Pattern p = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return p.matcher(name).matches();
            }
        });
    }

    public static File[] local(String path,final String regex){
        return local(new File(path),regex);
    }

    public static class TreeInfo implements Iterable<File>{

        public List<File> files  = new ArrayList<File>();
        public List<File> dirs = new ArrayList<File>();

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other){
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public String toString() {
            return super.toString();
        }

        public static TreeInfo walk(String start,String regex){
            return recurseDirs(new File(start),regex);
        }

        public static TreeInfo walk(File start,String regex){
            return recurseDirs(start,regex);
        }

        public static TreeInfo walk(File start){
            return recurseDirs(start,".*");
        }

        public static TreeInfo walk(String start){
            return recurseDirs(new File(start),".*");
        }

        static TreeInfo recurseDirs(File startDir,String regex){
            TreeInfo result = new TreeInfo();
            for(File item : startDir.listFiles()){
                if(item.isDirectory()){
                    result.dirs.add(item);
                    result.addAll(recurseDirs(item,regex));
                }else{
                    if(item.getName().matches(regex))
                        result.files.add(item);
                }
            }
            return result;
        }
    }
}
