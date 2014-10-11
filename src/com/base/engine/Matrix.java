package com.base.engine;

public class Matrix {
	
	private float[][] values;
	private int width, height;
	
	public Matrix(int width, int height){
		values = new float[width][height];
		this.width = width;
		this.height = height;
	}
	
	public Matrix(float[][] values, int width, int height){
		this.values = values;
	}
	
	public float get(int i, int j){
		return values[i][j];
	}
	
	public void set(int i, int j, float value){
		values[i][j] = value;
	}
	
	public Matrix getIndentity(){
		
		if(width == height){
			
			float[][] values = new float[width][width];
			
			for(int i = 0; i < width; i++){
				for(int j = 0; j < width; j++){
					if(i == j){
						values[i][j] = 1;
					}else{
						values[i][j] = 0;
					}
				}
			}
			return new Matrix(values, width, width);
		}else{
			return null;
		}
	}
	
	public Matrix add(Matrix b){
		if(width == b.getWidth() && height == b.getHeight()){
			
			float[][] values = new float[width][height];
			
			for(int i = 0; i < width; i++){
				for(int j = 0; j < height; j++){
					values[i][j] = get(i, j) + b.get(i, j);
				}
			}
			
			return new Matrix(values, width, height);
		}else{
			return null;
		}
	}


	public Matrix mul(Matrix b){
		
		if(width == b.getHeight()){

			float[][] values = new float[b.getWidth()][height];
			
			for (int w = 0; w < b.getWidth(); w++){
				for(int h = 0; h < height; h++){
					
					float newVal = 0;
					
					for(int i = 0; i < width; i++){
						for(int j = 0; j < b.getHeight(); j++){
							newVal += i * j;
						}
					}
					
					values[w][h] = newVal;
				}
			}
			return new Matrix(values, b.getWidth(), height);
		}else{
			return null;
		}
	}
	
	public Matrix add(float k){
			
		float[][] values = new float[width][height];
		
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				values[i][j] = get(i, j) + k;
			}
		}
		return new Matrix(values, width, height);
	}
	
	public Matrix mul(float k){
		
		float[][] values = new float[width][height];
		
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				values[i][j] = get(i, j) * k;
			}
		}
		return new Matrix(values, width, height);
	}
	
	public float[][] getValues(){
		return values;
	}
	
	public void setValues(float[][] values){
		this.values = values;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	
}
