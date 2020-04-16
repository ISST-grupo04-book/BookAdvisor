package es.upm.dit.isst.bookadvisor.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Localizacion implements Serializable{

	@Id
	private int ID;
	
	private float Longitud;
	private float latitud;
	
}
