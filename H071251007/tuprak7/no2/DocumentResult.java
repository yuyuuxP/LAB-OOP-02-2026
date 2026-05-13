package tuprak7.no2;

public class DocumentResult {
    private final String fileName;
    private final int wordCount;
    private final String threadName;
    private final long duration;

    public DocumentResult(String fileName, int wordCount, String threadName, long duration) {
        this.fileName = fileName;
        this.wordCount = wordCount;
        this.threadName = threadName;
        this.duration = duration;
    }

    // Getter untuk keperluan laporan akhir
    public String getFileName() { return fileName; }
    public int getWordCount() { return wordCount; }
    public String getThreadName() { return threadName; }
    public long getDuration() { return duration; }
}