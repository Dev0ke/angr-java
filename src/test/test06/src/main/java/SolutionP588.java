import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionP588 {
    static class FileSystem {
        private final File root;

        public FileSystem() {
            root = new File();
        }

        public List<String> ls(String path) {
            File f = root;
            List<String> files = new ArrayList<>();
            if (!path.equals("/")) {
                String[] dirs = path.split("/");
                for (int i = 1; i < dirs.length; i++) {
                    f = f.files.get(dirs[i]);
                }
                if (f.isFile) {
                    files.add(dirs[dirs.length - 1]);
                    return files;
                }
            }
            files = new ArrayList<>(f.files.keySet());
            Collections.sort(files);
            return files;
        }

        public void mkdir(String path) {
            File f = root;
            String[] dirs = path.split("/");
            for (int i = 1; i < dirs.length; i++) {
                if (!f.files.containsKey(dirs[i])) {
                    f.files.put(dirs[i], new File());
                }
                f = f.files.get(dirs[i]);
            }
        }

        public void addContentToFile(String filePath, String content) {
            File f = root;
            String[] dirs = filePath.split("/");
            for (int i = 1; i < dirs.length - 1; i++) {
                f = f.files.get(dirs[i]);
            }
            if (!f.files.containsKey(dirs[dirs.length - 1])) {
                f.files.put(dirs[dirs.length - 1], new File());
            }
            f = f.files.get(dirs[dirs.length - 1]);
            f.isFile = true;
            f.content = f.content + content;
        }

        public String readContentFromFile(String filePath) {
            File f = root;
            String[] dirs = filePath.split("/");
            for (int i = 1; i < dirs.length - 1; i++) {
                f = f.files.get(dirs[i]);
            }
            return f.files.get(dirs[dirs.length - 1]).content;
        }

        // 字典树 使用统一的文件夹文件列表
        private static class File {
            boolean isFile = false;
            Map<String, File> files = new HashMap<>();
            String content = "";
        }
    }
}
/*
$588. 设计内存文件系统
https://leetcode.cn/problems/design-in-memory-file-system/

设计一个内存文件系统，模拟以下功能：
实现文件系统类:
- FileSystem() 初始化系统对象
- List<String> ls(String path)
  - 如果 path 是一个文件路径，则返回一个仅包含该文件名称的列表。
  - 如果 path 是一个目录路径，则返回该目录中文件和 目录名 的列表。
答案应该 按字典顺序 排列。
- void mkdir(String path) 根据给定的路径创建一个新目录。给定的目录路径不存在。如果路径中的中间目录不存在，您也应该创建它们。
- void addContentToFile(String filePath, String content)
  - 如果 filePath 不存在，则创建包含给定内容 content的文件。
  - 如果 filePath 已经存在，将给定的内容 content附加到原始内容。
- String readContentFromFile(String filePath) 返回 filePath下的文件内容。
注意:
1 <= path.length, filePath.length <= 100
path 和 filePath 都是绝对路径，除非是根目录 ‘/’ 自身，其他路径都是以 ‘/’ 开头且 不 以 ‘/’ 结束。
你可以假定所有操作的参数都是有效的，即用户不会获取不存在文件的内容，或者获取不存在文件夹和文件的列表。
你可以假定所有文件夹名字和文件名字都只包含小写字母，且同一文件夹下不会有相同名字的文件夹或文件。
1 <= content.length <= 50
ls, mkdir, addContentToFile, and readContentFromFile 最多被调用 300 次

字典树 使用统一的文件夹文件列表
 */