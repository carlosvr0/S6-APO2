package model;

import java.io.Serializable;

public class VallaPublicitaria implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	private String inUse;
	private String marcaPromociona;
	
	public VallaPublicitaria(int width, int height, String inUse, String marcaPromociona) {
		this.height = height;
		this.width = width;
		this.inUse = inUse;
		this.marcaPromociona = marcaPromociona;
	}
	
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getMarcaPromociona() {
		return marcaPromociona;
	}
	public void setMarcaPromociona(String marcaPromociona) {
		this.marcaPromociona = marcaPromociona;
	}
	public String getInUse() {
		return inUse;
	}
	public void setInUse(String inUse) {
		this.inUse = inUse;
	}
	
	
	
	
}
