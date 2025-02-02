import java.time.LocalDateTime;

public class AuditLog {
    private String cardId;
    private String action;
    private LocalDateTime timestamp;
    private String floor;
    private String room;
    private boolean status;

    public AuditLog(String cardId, String action, LocalDateTime timestamp, String floor, String room, boolean status) {
        this.cardId = cardId;
        this.action = action;
        this.timestamp = timestamp;
        this.floor = floor;
        this.room = room;
        this.status = status;
    }

    // Getter methods to access log details
}

