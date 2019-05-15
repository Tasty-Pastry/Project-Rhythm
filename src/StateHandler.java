import java.awt.Graphics;

public class StateHandler {

	private GameState[] states;
	private int currentState;
	protected int character;

	private static final int NUMOFSTATES = 1;
	private static final int BATTLE = 0;

	public StateHandler() {

		states = new GameState[NUMOFSTATES];

		currentState = BATTLE;

		loadState(currentState);

	}

	public void loadState(int state) {

		if (currentState == BATTLE) {

			states[currentState] = new BattleState(this);

		}

	}

	private void unloadState(int state) {

		// Sets the state to null to unload and free space
		states[state] = null;

	}

	// Unloads the state and sets the new state
	public void setState(int state) {

		unloadState(currentState);
		currentState = state;
		loadState(currentState);

	}

	public void update() {

		// Calls the state update method
		if (states[currentState] != null) {

			states[currentState].update();

		}

	}

	public void draw(Graphics g) {

		// Calls the state draw method
		if (states[currentState] != null) {

			states[currentState].draw(g);

		}

	}

	public int getState() {

		return currentState;

	}

}