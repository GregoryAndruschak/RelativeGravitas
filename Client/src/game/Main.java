package game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Main extends StateBasedGame{

	public static final String gamename = "RG";
	public static final int game =1;
	public static final int menu =0;

	public Main(String gamename){
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Game(game));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException{
		 this.getState(game).init(gc, this);
		 this.enterState(0);
	}
	
	public static void main(String[] args) {
		AppGameContainer appgc;
		try{
			appgc = new AppGameContainer(new Main(gamename));
			appgc.setDisplayMode(1280, 720, false);
			appgc.setShowFPS(false);
			appgc.setVSync(true);
			appgc.start();
		}catch(SlickException e){
			e.printStackTrace();
		}
	}

}