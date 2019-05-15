import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

	// Counter Vars
	private boolean isRunning;
	private Thread thread;
	private static int count;

	// Screen Vars
	private final int width = 1024;
	private final int height = 640;

	private StateHandler sh;

	public Game() {

		Window window = new Window("Project: Rhythm", this);

		sh = new StateHandler();

		start();

	}

	private void start() {

		// Starts thread
		isRunning = true;
		thread = new Thread(this);

		thread.start();

	}

	private void stop() {

		// Stops thread
		isRunning = false;

		// throws errors
		try {

			thread.join();

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}

	// Manages the game, allows for controllable FPS on all computers
	public void run() {

		// Requests focus
		this.requestFocus();

		// Timer Variables
		long lastTime = System.nanoTime(); // Gets the current time from the pc
		double ticks = 60.0;
		double ns = 1 * Math.pow(10, 9) / ticks;
		double delta = 0;
		long timer = System.nanoTime();
		int frames = 0;

		// timer for game
		while (isRunning) {

			// Updates timer
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			// updates timer
			while (delta >= 1) {

				update();
				delta--;

			}

			// drawing graphics
			draw();
			frames++;
			count++;

			// updating nanosecond timer
			if (System.nanoTime() - timer > 1000000) {

				timer += 1000000;
				frames = 0;

			}

		}
		// stopping timer
		stop();

	}

	private void draw() {

		// Creates a new BufferStrategy
		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {

			// This allows the game to preload 3 frames in order to prevent choppy framerate
			this.createBufferStrategy(3);

			return;

		}

		// initialing graphics
		Graphics g = bs.getDrawGraphics();

		// drawing everything

		sh.draw(g);
		bs.show();

	}

	private void update() {

		sh.update();

	}

	// geting size method
	@Override
	public Dimension getPreferredSize() {

		return new Dimension(width, height);

	}

	// creating a new instance of the game
	public static void main(String args[]) {

		// Creates new game
		new Game();

	}

}
