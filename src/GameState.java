import java.awt.Graphics;

public abstract class GameState {

	protected StateHandler sh;

	public abstract void update();

	public abstract void draw(Graphics g);

}
