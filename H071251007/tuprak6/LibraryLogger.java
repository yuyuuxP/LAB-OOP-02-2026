package tuprak6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class LibraryLogger {
    private static class LogEntry {
        String borrowedAt;
        String returnedAt;
        String title;
        String member;

        LogEntry(String title, String member) {
            this.borrowedAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            this.title = title;
            this.member = member;
            this.returnedAt = "";
        }
    }

    private List<LogEntry> logs = new ArrayList<>();

    public void logBorrow(String title, String member) {
        logs.add(new LogEntry(title, member));
    }

    public void logReturn(String title, String member) {
        for (LogEntry log : logs) {
            if (log.title.equals(title) && log.member.equals(member) && log.returnedAt.isEmpty()) {
                log.returnedAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                break;
            }
        }
    }

    public String getLogsTable() {
        if (logs.isEmpty()) return "Tidak ada aktivitas";
        StringBuilder sb = new StringBuilder();
        sb.append("+---------------------+----------------------+----------------+---------------------+\n");
        sb.append("| Dipinjam pada       | Judul                | Member         | Dikembalikan pada   |\n");
        sb.append("+---------------------+----------------------+----------------+---------------------+\n");
        for (LogEntry log : logs) {
            sb.append(String.format("| %-19s | %-20s | %-14s | %-19s |\n",
                    log.borrowedAt,
                    log.title,
                    log.member,
                    log.returnedAt.isEmpty() ? "-" : log.returnedAt));
        }
        sb.append("+---------------------+----------------------+----------------+---------------------+\n");
        return sb.toString();
    }

    public void clearLogs() {
        logs.clear();
    }
}
