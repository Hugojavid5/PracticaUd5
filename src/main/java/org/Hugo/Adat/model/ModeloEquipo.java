package org.Hugo.Adat.model;

import java.util.Objects;

public class ModeloEquipo {
	private String nombre;

	private String iniciales;

	public ModeloEquipo() {}

	public ModeloEquipo(String nombre, String iniciales) {
		this.nombre = nombre;
		this.iniciales = iniciales;
	}


	@Override
	public int hashCode() {
		return Objects.hash(iniciales, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModeloEquipo other = (ModeloEquipo) obj;
		return Objects.equals(iniciales, other.iniciales) && Objects.equals(nombre, other.nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIniciales() {
		return iniciales;
	}

	public void setIniciales(String iniciales) {
		this.iniciales = iniciales;
	}
	
}
