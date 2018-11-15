package rs;

import java.sql.Timestamp;

public class PrijavaZaPosao {
 private int radnikID;
 private String ime;
 public int getRadnikID() {
	return radnikID;
}
public void setRadnikID(int radnikID) {
	this.radnikID = radnikID;
}
public String getIme() {
	return ime;
}
public void setIme(String ime) {
	this.ime = ime;
}
public String getPrezime() {
	return prezime;
}
public void setPrezime(String prezime) {
	this.prezime = prezime;
}
public int getZeljena_plata() {
	return zeljena_plata;
}
public void setZeljena_plata(int zeljena_plata) {
	this.zeljena_plata = zeljena_plata;
}
public int getGodine_iskustva() {
	return godine_iskustva;
}
public PrijavaZaPosao(String ime, String prezime, int godine_iskustva) {
	super();
	this.ime = ime;
	this.prezime = prezime;
	this.godine_iskustva = godine_iskustva;
	
}
public void setGodine_iskustva(int godine_iskustva) {
	this.godine_iskustva = godine_iskustva;
}
public Timestamp getDatum_prijave() {
	return datum_prijave;
}
public void setDatum_prijave(Timestamp datum_prijave) {
	this.datum_prijave = datum_prijave;
}
private String prezime;
 private int zeljena_plata;
 private int godine_iskustva;
 private Timestamp datum_prijave;
 

public PrijavaZaPosao() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "PrijavaZaPosao [radnikID=" + radnikID + ", ime=" + ime + ", prezime=" + prezime + ", zeljena_plata="
			+ zeljena_plata + ", godine_iskustva=" + godine_iskustva + ", datum_prijave=" + datum_prijave + "]";
}
public PrijavaZaPosao(String ime, String prezime, int zeljena_plata, int godine_iskustva) {
	super();
	this.ime = ime;
	this.prezime = prezime;
	this.zeljena_plata = zeljena_plata;
	this.godine_iskustva = godine_iskustva;
	
}
 

 
}
