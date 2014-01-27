package prealpha;


import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Tile {
	
	private ArrayList tiletypes; // what terrain?
	private Image image; // terrain image
	private int x; //locationx
	private int y;// locationy
	private boolean visible; // tile visibility
	
	
public Tile (int x, int y, int tile) {
	
	int type = tile;
	tiletypes = new ArrayList();
	tiletypes.add("grass.png");
	
	ImageIcon ii = new ImageIcon(this.getClass().getResource("grass.png"));
	image = ii.getImage(); 
	
	visible = true;
	this.x = x;
	this.y = y;
	
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

}
