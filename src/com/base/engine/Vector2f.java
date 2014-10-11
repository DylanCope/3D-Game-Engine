package com.base.engine;

public class Vector2f {
	
	private float x, y;
	
	public Vector2f(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public float len(){
		return (float) Math.sqrt(x*x + y*y);
	}
	
	public float getDotProduct(Vector2f b){
		return x*b.getX() + y*b.getY();
	}
	
	public Vector2f getNormalised(){
		float i = x / len();
		float j = y / len();
		
		return new Vector2f(i, j);
	}
	
	public Vector2f rotate(float deg){
		double rad = Math.toRadians(deg);
		double cos = Math.cos(rad);
		double sin = Math.sin(rad);
		
		return new Vector2f((float)(x * cos - y * sin),(float)(x * sin + y * cos));
	}
	
	public Vector2f add(Vector2f a){ 
		return new Vector2f(x + a.getX(), y + a.getY());
	}
	
	public Vector2f sub(Vector2f a){ 
		return new Vector2f(x - a.getX(), y - a.getY());
	}
	
	public Vector2f mul(Vector2f a){ 
		return new Vector2f(x * a.getX(), y * a.getY());
	}
	
	public Vector2f div(Vector2f a){ 
		return new Vector2f(x / a.getX(), y / a.getY());
	}
	
	public Vector2f add(float a){
		return new Vector2f(x + a, y + a);
	}
	
	public Vector2f mul(float a){
		return new Vector2f(x * a, y * a);
	}
	
	public String toString(){
		return "("+ x +", "+ y + ")";
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

}
