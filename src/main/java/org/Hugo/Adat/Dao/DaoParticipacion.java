package org.Hugo.Adat.Dao;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import org.Hugo.Adat.model.ModeloDeportista;
import org.Hugo.Adat.model.ModeloEvento;
import org.Hugo.Adat.model.ModeloParticipacion;


import java.util.List;

public class DaoParticipacion {

	public static void insertar(ModeloParticipacion p, ObjectContainer db) {
		db.store(p);
	}

	public static ModeloParticipacion conseguirPorDeportistaEvento(ModeloDeportista dep, ModeloEvento e, ObjectContainer db) {
		ModeloParticipacion par=new ModeloParticipacion();
		par.setDeportista(dep);
		par.setEvento(e);
		ObjectSet<ModeloParticipacion> set=db.queryByExample(par);
		return set.hasNext() ? set.next() : null;
	}

	public static List<ModeloParticipacion> conseguirPorEvento(ModeloEvento e, ObjectContainer db){
		List<ModeloParticipacion> participaciones=db.query(new Predicate<ModeloParticipacion>() {

			@Override
			public boolean match(ModeloParticipacion par) {
				return par.getEvento().equals(e);
			}
		});
		return participaciones;
	}

	public static List<ModeloParticipacion> conseguirPorDeportista(ModeloDeportista d,ObjectContainer db){
		List<ModeloParticipacion> participaciones=db.query(new Predicate<ModeloParticipacion>() {

			@Override
			public boolean match(ModeloParticipacion par) {
				return par.getDeportista().equals(d);
			}
		});
		return participaciones;
	}

	public static void actualizarMedallas(String medalla,ModeloDeportista dep,ModeloEvento e, ObjectContainer db) {
		ModeloParticipacion p=conseguirPorDeportistaEvento(dep, e, db);
		p.setMedalla(medalla);
		db.store(p);
	}

	public static void eliminar(ModeloDeportista dep,ModeloEvento e, ObjectContainer db) {
		ModeloParticipacion p=conseguirPorDeportistaEvento(dep, e, db);
		db.delete(p);
	}
	
}
