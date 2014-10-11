package com.base.engine;

public class Main {
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String TITLE = "3D Engine";
	public static final double frameCap = 5000.0;
	
	private boolean isRunning;
	private Game game;
	
	public Main(){
		System.out.println(RenderUtil.getOpenGLVersion());
		
		isRunning = false;
		game = new Game();
		RenderUtil.initGraphics();
	}
	
	public void start(){
		if(isRunning)
			return;
		
		run();
	}
	
	public void stop(){
		if(!isRunning)
			return;
		
		isRunning = false;
	}
	
	private void run(){
		isRunning = true;
		
		int frames = 0;
		long frameCounter = 0;
		
		final double frameTime = 1.0 / frameCap;
		
		long lastTime = Time.getTime();
		double unprocessedTime = 0;
		
		while(isRunning){
			
			boolean render = false;
			
			long startTime = Time.getTime();
			long passedTime = startTime - lastTime;
			lastTime = startTime;
			
			unprocessedTime += passedTime / (double)Time.second;
			frameCounter += passedTime;
			
			while(unprocessedTime > frameTime){
				
				render = true;
				
				unprocessedTime -= frameTime;
				
				if(Window.isCloseRequested())
					stop();
				
				Time.setDelta(frameTime);
				Input.update();
				
				game.input();
				game.update();
				
				if(frameCounter >= Time.second){
					System.out.println(frames);
					frames = 0;
					frameCounter = 0;
				}
			}
			
			if(render){
				render();
				frames++;
			}else{
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		cleanUp();
	}
	
	private void render(){
		Window.render();
		RenderUtil.clearScreen();
		game.render();
	}
	
	private void cleanUp(){
		
		Window.dispose();
	}
	
	public static void main(String[] args){
		
		Window.createWindow(WIDTH, HEIGHT, TITLE);
		
		Main game = new Main();
		game.start();
	}
	
}
