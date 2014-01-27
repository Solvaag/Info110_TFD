package prealpha;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener {

	/**
	 * Class fields. Empty right now.
	 * 
	 */
	private Timer timer; // for game loop
	private Player player;
	private boolean ingame;
	private ArrayList tiles;
	private Tile tile;
	//private int B_WIDTH;
	//private int B_HEIGHT;
	
	public Board ()	{
		
		addKeyListener ( new TAdapter());
		setFocusable(true); // what??
		setBackground(Color.GREEN);
		setDoubleBuffered(true);
		ingame = true;
		
		player = new Player(); // Glemte å initialize denne, skapte sykt med problemer
		
		initTiles();
		
		setSize (400, 300);
		
		timer = new Timer(5, this);
		timer.start();
	}
	
	/**
	 * @title Tile Generator
	 * this method makes the tiles
	 */
	
	public void initTiles() {
		tiles = new ArrayList();
		
		for (int i = 0; i < 12; i++) {
			tiles.add(new Tile((i * 20), 1, 0));
		}
		
	}
	
	/**
	 * @param graphics
	 * 
	 * This method takes graphics objects and draws them using the Graphics class.
	 * Currently it will only render the player object and the version state.
	 */
	
	public void paint (Graphics g) {
		super.paint(g);
		
		Graphics g2d = (Graphics2D) g;
		
		for (int b = 0; b <= 3; b++) {
		for (int i = 0; i < tiles.size(); i++) {
			Tile a = (Tile)tiles.get(i);
			if (a.isVisible()) 
				g2d.drawImage(a.getImage(), a.getX(), a.getY(), this);
		} }
		
		if (player.isVisible()) g2d.drawImage(player.getImage(), player.getX(), player.getY(), this);
		
		
		
		g2d.setColor(Color.white);
		g2d.drawString("Xivia PreAlpha", 5, 15);
		
		
		
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		player.move();
		repaint();
	}
	
	private class TAdapter extends KeyAdapter {
		
		public void keyReleased (KeyEvent e) {
			player.keyReleased (e);
			
		}
		
		public void keyPressed (KeyEvent e) {
			player.keyPressed (e);
		}
	}
}
