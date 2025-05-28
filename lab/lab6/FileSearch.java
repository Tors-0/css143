import org.jetbrains.annotations.Nullable;

import java.beans.Transient;
import java.io.File;

public class FileSearch {
    /*
    1.
    check starting dir exists
    check starting dir is not empty
    2.
    get target filename
    check if start dir contains file
    3.
    for each directory in current dir
        check if selected dir contains file
        if: return path to file
        if not: repeat step 3 for each dir in selected dir
            if this returns null: continue
            if != null: return this
    4.
    print full (rel to starting) path+name of file
    */

    public static void main(String[] args) {
        System.out.println(searchFiles(new File("./"), "misc.xml"));
    }

    /**
     * recursive depth-first search for files in a given dir
     * @param path
     * @param target filename to search for
     * @return null if file matching target not found in path
     */
    public static String searchFiles(File path, String target) {
        if (path == null) return "Valid path required";
        if (!path.isDirectory()) return "Invalid working dir";
        String out = null;
        for (File o : path.listFiles()) {
            if (o.isDirectory()) {
                out = searchFiles(o, target);
                if (out != null) return out;
            } else {
                if (target.equals(o.getName())) {
                    return o.getAbsolutePath();
                }
            }
        }
        return null;
    }

}
