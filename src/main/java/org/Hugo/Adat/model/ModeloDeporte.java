package org.Hugo.Adat.model;

import java.util.Objects;

public class ModeloDeporte {

	private String nombre;
	public ModeloDeporte() {}

	public ModeloDeporte(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModeloDeporte other = (ModeloDeporte) obj;
		return nombre == other.nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
