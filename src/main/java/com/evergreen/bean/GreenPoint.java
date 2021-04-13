package com.evergreen.bean;

public class GreenPoint {
	private int greenPointId;
	private float latitude;
	private float longitude;
	private String image_avant;
	private String image_apres;
	private int id_nettoyeur;
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private int id_emetteur;
	public int getGreenPointId() {
		return greenPointId;
	}
	public void setGreenPointId(int greenPointId) {
		this.greenPointId = greenPointId;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public String getImage_avant() {
		return image_avant;
	}
	public void setImage_avant(String image_avant) {
		this.image_avant = image_avant;
	}
	public String getImage_apres() {
		return image_apres;
	}
	public void setImage_apres(String image_apres) {
		this.image_apres = image_apres;
	}
	public int getId_nettoyeur() {
		return id_nettoyeur;
	}
	public void setId_nettoyeur(int id_nettoyeur) {
		this.id_nettoyeur = id_nettoyeur;
	}
	public int getId_emetteur() {
		return id_emetteur;
	}
	public void setId_emetteur(int id_emetteur) {
		this.id_emetteur = id_emetteur;
	}
	
	
	
}
