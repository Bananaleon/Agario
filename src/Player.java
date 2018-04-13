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
	public class PlayerCell extends HungryCell {
		
	  	public PlayerCell(double x, double y, int mass) {
	      	setX(x);
	      	setY(y);
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
	  	@override
	  	public void eat(Cell cell) {
			mass += cell.getMass();
	    }
	  	
	  	//getters & setters
	  	public String getName() {
	    	return name;
	    }
	}
}
