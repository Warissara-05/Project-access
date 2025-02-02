import java.util.ArrayList;
import java.util.List;

public class AccessControlSystem {
    private List<AccessCard> accessCards;

    public AccessControlSystem() {
        this.accessCards = new ArrayList<>();
    }

    public void addAccessCard(AccessCard card) {
        accessCards.add(card);
    }

    public boolean checkCardAccess(String cardId, String floor, String room) {
        for (AccessCard card : accessCards) {
            if (card.getCardId().equals(cardId)) {
                return card.checkAccess(floor, room);
            }
        }
        return false;
    }

    public void revokeCardAccess(String cardId) {
        for (AccessCard card : accessCards) {
            if (card.getCardId().equals(cardId)) {
                card.revokeAccess();
            }
        }
    }

    // Additional methods for logging and card management
}
