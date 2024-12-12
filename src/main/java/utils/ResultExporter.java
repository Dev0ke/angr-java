package utils;

import com.alibaba.fastjson2.JSON;
import java.io.*;
import java.util.List;
import java.util.Set;


public class ResultExporter {
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_TIMEOUT = 1;
    public static final int CODE_ERROR = 2;
    public static final int CODE_UNKNOWN = 3;

    private final File outputFile;
    private BufferedWriter bufferedWriter;

    public ResultExporter(String outputPath) {
        this.outputFile = initOutputFile(outputPath);
        this.bufferedWriter = initBufferedWriter(this.outputFile);
    }

    private File initOutputFile(String outputPath) {
        File file = new File(outputPath);
        File parentDir = file.getParentFile();

        if (parentDir != null && !parentDir.exists()) {
            if (!parentDir.mkdirs()) {
                Log.error("Failed to create directory: " + parentDir.getAbsolutePath());
                throw new RuntimeException("Directory creation failed");
            }
        }
        return file;
    }

    private BufferedWriter initBufferedWriter(File file) {
        try {
            return new BufferedWriter(new FileWriter(file, true));
        } catch (IOException e) {
            Log.error("Failed to initialize BufferedWriter for file: " + file.getAbsolutePath() + e);
            throw new RuntimeException("BufferedWriter initialization failed", e);
        }
    }

    public synchronized void writeString(String content) {
        try {
            bufferedWriter.write(content);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            Log.error("Failed to write string to file: " + this.outputFile.getAbsolutePath() + e);
        }
    }

    public synchronized void writeResult(int code, String className, String signature, Set<List<String>> result, long time,String msg) {
        try {
            String jsonOutput = JSON.toJSONString(new ResultOutput(code,className, signature, result, time,msg));
            bufferedWriter.write(jsonOutput);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            Log.error("Failed to write result to file: " + this.outputFile.getAbsolutePath() + e);
        }
    }

    public void close() {
        try {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        } catch (IOException e) {
            Log.error("Failed to close BufferedWriter for file: " + this.outputFile.getAbsolutePath() + e);
        }
    }

    public static class ResultOutput {
        private final int code;
        private final String className;
        private final String signature;
        private final Set<List<String>> result;
        private final long time;
        private final String msg;

        public ResultOutput(int code,String className, String signature, Set<List<String>> result, long time, String msg) {
            this.className = className;
            this.signature = signature;
            this.code = code;
            this.result = result;
            this.time = time;
            this.msg = msg;
        }

        public String getClassName() {
            return className;
        }

        public String getSignature() {
            return signature;
        }

        public int getCode() {
            return code;
        }

        public Set<List<String>> getResult() {
            return result;
        }

        public long getTime() {
            return time;
        }
        public String getMsg() {
            return msg;
        }
    }
}
