package prealpha;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player {

	/**
	 * This is the fields section. Fields required to work:
	 * geometry
	 * image
	 * visibility bool
	 */
	private String avatar = "avatar.png";
	private int x;
	private int y;
	private int dx;
	private int dy;
	private boolean visible;
	private Image image;
	
	public Player() {
		ImageIcon ii = new ImageIcon(this.getClass().getResource(avatar));
		image = ii.getImage();
		visible = true;
		x = 60;
		y = 60;
		
	}
	
	// this is the movement method pt 1
	// it updates player location
	public void move () {
		x += dx;
		y += dy;
		
		if (x < 1) {
			x = 1;
		}
		
		if (x > 400) {
			x = 400;
		}
		
		if (y < 1) {
			y = 1;
		}
		
		if (y > 300 ) {
			y = 300;
		}
	}
	
	
	/** 
	 * Accessor section.
	 * 
	 */
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Image getImage() {
		return image;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	//Visibility toggle
	//Takes bool and sets it to this.visible
	public void setVisible (boolean visible) {
		this.visible = visible;
	}
	
	public void keyPressed (KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_W) dy = -1;
		
		if (key == KeyEvent.VK_S) dy = 1;
		
		if (key == KeyEvent.VK_A) dx = -1;
		
		if (key == KeyEvent.VK_D) dx = 1;
		
	}
	
	public void keyReleased (KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_W) dy = 0;
		
		if (key == KeyEvent.VK_S) dy = 0;
		
		if (key == KeyEvent.VK_A) dx = 0;
		
		if (key == KeyEvent.VK_D) dx = 0;
	}
}
