import java.util.List;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.Node;
import java.util.Collections;
import javafx.scene.shape.Circle;

public class Player {
  	private int mass;
  	private final String name;
  	private List<PlayerCell> cells = new ArrayList<>();
  	private Color color;
  
  	public Player(double x, double y, String name) {
      	this.name = name;
      	color = createColor();
      	createCell(x, y);
    }
  	
  	//methods
  	public void split() {
      	for (PlayerCell cell : cells) {
          	cell.split();
        }
    }
  	private void createCell(double x, double y) {
      	cells.add(new PlayerCell(x, y));
    }
    private void deleteCell(PlayerCell cell) {
    	cells.remove(cell);
    }

    public List<PlayerCell> getCells() {
    	return cells;
    }

  	private static Color createColor() {
		List<Integer> values = new ArrayList<>(); 
		values.add(255);
		values.add(7);
		values.add((int)Math.round(Math.random()*255));
		Collections.shuffle(values);

		Color color = Color.rgb(
			values.get(0),
			values.get(1),
			values.get(2));

		return color;
	}
  
  	//getters & setters
  	public int getMass() {
      	return mass;
    }
  	public String getName() {
      	return name;
    }

    public Color getColor() {
    	return color;
    }
  	
  	//inner class
	public class PlayerCell extends Cell implements CanEat {
		
	  	public PlayerCell(double x, double y, int mass) {
	      	this.x = x;
	      	this.y = y;
	      	setMass(mass);
	      	//create cell body
	      	node = new Circle(x, y, radian, getColor());
	    }

	  	public PlayerCell(double x, double y) {
	      	this(x, y, Settings.PLAYER_START_MASS);
	    }
	  	
	  	
	  	//methods
	  	public void split() {

	  	}
	  	public void eject() {

	  	}
	  	public void delete() {

	  	}
	  
	  	public void eat(Cell cell) {
	      	
	    }
	  
	  	public boolean canEat(Cell cell) {
	      	if (getMass() > Math.round(cell.getMass() * 1.1)) {
	          	double distance = Math.sqrt(Math.abs(getX()-cell.getX()) + Math.abs(getY()-cell.getY()));
	          	if (distance < cell.getRadian()) {
	              	return true;
	            }
	        }
	      	return false;
	    }
	  	
	  	//getters & setters
	  	public int getMass() {
	      	return mass;
	    }
	    public void setMass(int mass) {
	    	this.mass = mass;
	    	this.radian = Math.sqrt(100 * mass);
	    }
		public double getRadian() {
	      	return radian;
	    }
		public double getX() {
	      	return x;
	    }
		public double getY() {
	      	return y;
	    }
	  	public String getName() {
	    	return name;
	    }
	  	public Node getNode() {
	      	return node;
	    }
	}
}
