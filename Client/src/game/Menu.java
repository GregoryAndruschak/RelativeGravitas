package game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {

	Rectangle start;
	Rectangle exit;
	
	Image ph1;
	
	public Menu(int state) {
		
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		//LoginForm lf = new LoginForm();
		//lf.dispose();
//		String pass = lf.p1.getText();
//		String name = lf.tf1.getText();
		
	//	System.out.println(pass +" "+name);
		
		gc.getGraphics().setColor(Color.cyan);
		start = new Rectangle(200, 200, 100, 35);
		exit = new Rectangle(200, 400, 100, 35);
		
		//ph1 = new Image("res/white.png");
		
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		//ph1.draw(0,0,1280,720);
		
		g.setColor(Color.cyan);
		g.drawString("Start", 200, 200);
		g.drawString("Exit", 200, 400);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int d) throws SlickException {
		Input input = gc.getInput();
		Point p = new Point(input.getMouseX(), input.getMouseY());
		if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
			if (start.contains(p)) {
				sbg.enterState(1);
			}
			if (exit.contains(p)) {
				gc.exit();
			}
		}

	}

	@Override
	public int getID() {
		return 0;
	}

}
