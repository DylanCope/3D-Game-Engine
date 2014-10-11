package com.base.engine;

public class Vector3f {
	
	private float x, y, z;
	
	public Vector3f(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public float len(){
		return (float)Math.sqrt(x*x + y*y + z*z);
	}
	
	public Vector3f getNormalised(){
		float i = x / len();
		float j = y / len();
		float k = z / len();
		
		return new Vector3f(i, j, k);
	}
	
	public Vector3f getCrossProduct(Vector3f b){
		float i = y * b.getZ() - z * b.getY();
		float j = z * b.getX() - x * b.getZ();
		float k = x * b.getY() - y * b.getX();
		
		return new Vector3f(i, j, k);
	}
	
	public float getDotProduct(Vector3f b){
		return x * b.getX() + y * b.getY() + z * b.getZ();
	}
	
	public Vector3f add(Vector3f b){
		return new Vector3f(x + b.getX(), y + b.getY(), z + b.getZ());
	}
	
	public Vector3f sub(Vector3f b){
		return new Vector3f(x - b.getX(), y - b.getY(), z - b.getZ());
	}
	
	public Vector3f mul(Vector3f b){
		return new Vector3f(x * b.getX(), y * b.getY(), z * b.getZ());
	}
	
	public Vector3f div(Vector3f b){
		return new Vector3f(x / b.getX(), y / b.getY(), z / b.getZ());
	}
	
	public Vector3f add(float k){
		return new Vector3f(x + k, y + k, z + k);
	}
	
	public Vector3f mul(float k){
		return new Vector3f(x * k, y * k, z * k);
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

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}
	
}
