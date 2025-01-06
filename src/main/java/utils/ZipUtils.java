package utils;
import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public class ZipUtils {

    /**
     * 解压 zip 文件到指定目录
     * @param zipFilePath   zip 文件路径
     * @param destDirPath   解压的目标目录
     * @throws IOException  解压过程中的异常
     */
    public static void unzip(String zipFilePath, String destDirPath) throws IOException {
        File destDir = new File(destDirPath);
        if (!destDir.exists()) {
            destDir.mkdirs();
        }

        try (ZipFile zipFile = new ZipFile(zipFilePath)) {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                File outFile = new File(destDir, entry.getName());

                // 如果是目录则创建
                if (entry.isDirectory()) {
                    outFile.mkdirs();
                } else {
                    // 如果父目录不存在，创建父目录
                    File parent = outFile.getParentFile();
                    if (!parent.exists()) {
                        parent.mkdirs();
                    }

                    // 写入文件内容
                    try (InputStream in = zipFile.getInputStream(entry);
                         FileOutputStream fos = new FileOutputStream(outFile)) {
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = in.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
