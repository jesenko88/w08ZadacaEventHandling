package MoveCircle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * @Jesenko 
 * This class is a version of the 'MoveCircle' class.
 * In this version, the main class(this class) implements the KeyListener Interface
 * This class draws a circle which can be moved with the key: up,down,left, right. 
 */
public class MoveCircleImplemented extends JPanel implements KeyListener {

	private static final int C_SIZE = 40; // final size of the circle
	private int x, y; // x,y coordinates define the position of the circle
	private Color color;; // color of the circle

	// Constructor
	public MoveCircleImplemented() {

		x = 150; // the initial position of the circle
		y = 150;
		color = Color.BLUE.darker();

		setBackground(Color.GRAY.brighter());

		addKeyListener(this);

	}

	/*
	 * Main method
	 */
	public static void main(String[] args) {
		JFrame window = new JFrame("Move circle");
		MoveCircleImplemented content = new MoveCircleImplemented();
		window.setContentPane(content);
		window.setSize(500, 500);
		window.setLocation(200, 100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		content.requestFocusInWindow(); // focus is requested every time the
										// window is active
	}

	/*
	 * This method draws the circle and writes out a message if the focus is
	 * gained or not.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (hasFocus()) {
			g.setColor(Color.GREEN);
			g.drawString("Move the circle!", 40, 40);
		} else {
			g.setColor(Color.RED);
			g.drawString("No focus !    >>Relaunch the application<<", 40, 40);
		}

		g.setColor(color);
		g.fillOval(x, y, C_SIZE, C_SIZE); // draws the circle
	}

	/*
	 * This method belongs to the implemented KeyListener interface. It handles
	 * the keyPressed events. If the key: up/down/left or right is pressed, the
	 * x or y coordinates are changed and the circle is repainted. That way is
	 * the movement effect accomplished
	 */
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			x -= 10;
			if (x < 0)
				x = 0; // this stops the circle to be moved outside the visible
						// area
			repaint();

		} else if (key == KeyEvent.VK_RIGHT) {
			x += 10;
			if (x > getWidth() - C_SIZE)
				x = getWidth() - C_SIZE;

			repaint();

		} else if (key == KeyEvent.VK_UP) {
			y -= 10;
			if (y < 0)
				y = 0;

			repaint();

		} else if (key == KeyEvent.VK_DOWN) {
			y += 10;
			if (y > getHeight() - C_SIZE)
				y = getHeight() - C_SIZE;

			repaint();

		}

	}

	/*
	 * Unused methods from the KeyListener interface
	 */
	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	// -----------------------------------------

} // end of class MoveCircle