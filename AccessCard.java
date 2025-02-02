import java.time.LocalDateTime;

public class AccessCard {
    private String cardId;
    private String userId;
    private String allowedFloors;
    private String allowedRooms;
    private LocalDateTime expirationDate;
    private boolean active;

    public AccessCard(String cardId, String userId, String allowedFloors, String allowedRooms, LocalDateTime expirationDate) {
        this.cardId = cardId;
        this.userId = userId;
        this.allowedFloors = allowedFloors;
        this.allowedRooms = allowedRooms;
        this.expirationDate = expirationDate;
        this.active = true;
    }

    // Getter for cardId
    public String getCardId() {
        return cardId;
    }

    public String getUserId() {
        return userId;
    }


    public boolean checkAccess(String floor, String room) {
        return allowedFloors.contains(floor) && allowedRooms.contains(room) && active && expirationDate.isAfter(LocalDateTime.now());
    }

    public void revokeAccess() {
        this.active = false;
    }

    // Getters and Setters for other fields if necessary
}
