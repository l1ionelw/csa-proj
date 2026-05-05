/**
 * Tracks the comfort and spirit meters for the school during gameplay.
 * Responsibilities:
 * - Store and update comfort and spirit meter values.
 * - Apply effects based on player actions.
 * @author Sejal Chandavale
 */
public class GameState {
    private int comfortMeter;
    private int spiritMeter;

    /**
     * Constructor - initializes both meters to full.
     * @author Sejal Chandavale
     */
    public GameState() {
        comfortMeter = 100;
        spiritMeter = 100;
    }

    /**
     * Returns the current comfort level.
     * @author Sejal Chandavale
     * @return comfortMeter value
     */
    public int getComfort() {
        return comfortMeter;
    }

    /**
     * Returns the current spirit level.
     * @author Sejal Chandavale
     * @return spiritMeter value
     */
    public int getSpirit() {
        return spiritMeter;
    }

    /**
     * Applies effects of a player action to the meters.
     * @author Sejal Chandavale
     * @param actionType the type of action taken
     * @param actionsThisDay number of actions taken today
     */
    public void applyActionEffects(String actionType, int actionsThisDay) {
        // TODO: implement in Week 2
        if (actionType.equals("LED")) {
            comfortMeter -= 5;
        } 
        else if (actionType.equals("HVAC")) {
            comfortMeter -= 10;
        } 
        else if (actionType.equals("DEVICE_SHUTDOWN")) {
            comfortMeter -= 3;
        } 
        else if (actionType.equals("AWARENESS")) {
            comfortMeter += 5;
            spiritMeter  += 8;
        }

        // spirit reaction rules
        if (comfortMeter >= 60) {
            spiritMeter += 10;
        }
        if (comfortMeter < 40) {
            spiritMeter -= 15;
        }
        if (actionsThisDay >= 3) {
            spiritMeter -= 5;
        }

        // keep between 0 and 100
        if (comfortMeter > 100){
            comfortMeter = 100;
        }
        if (comfortMeter < 0){
            comfortMeter = 0;
        }
        if (spiritMeter > 100){
            spiritMeter  = 100;
        }
        if (spiritMeter < 0){
            spiritMeter  = 0;
        }
    }

    /**
     * Resets both meters to 100 for a new run.
     * @author Sejal Chandavale
     */
    public void reset() {
        comfortMeter = 100;
        spiritMeter = 100;
    }
}
