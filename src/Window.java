import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

// Imports
import javax.swing.JFrame;

public class Window {

	// Constructor
	public Window(String title, Game game) {

		// Creates new JFrame
		JFrame frame = new JFrame(title);

		// Adds Game to window
		frame.add(game);
		frame.setResizable(false);
		frame.pack();

		// Settings of Window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminated application on close
		frame.setLocationRelativeTo(null); // Opens the window in the middle of the screen
		frame.setVisible(true); // Allows the window to be seen

	}

}
