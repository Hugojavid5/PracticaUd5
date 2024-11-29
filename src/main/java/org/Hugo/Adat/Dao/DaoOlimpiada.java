package org.Hugo.Adat.Dao;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import org.Hugo.Adat.model.ModeloOlimpiada;

import java.util.List;


public class DaoOlimpiada {

	public static void insertar(ModeloOlimpiada o, ObjectContainer db) {
	db.store(o);	
	}

	public static List<ModeloOlimpiada> conseguirPorTemporada(String temporada,ObjectContainer db){
		List<ModeloOlimpiada> olimpiadas=db.query(new Predicate<ModeloOlimpiada>() {

			@Override
			public boolean match(ModeloOlimpiada o) {
				return o.getTemporada().equals(temporada);
			}
		});
		return olimpiadas;
	}

	public static ModeloOlimpiada conseguirPorNombre(String nombre, ObjectContainer db) {
		ModeloOlimpiada dep=new ModeloOlimpiada();
		dep.setNombre(nombre);
		ObjectSet<ModeloOlimpiada> set=db.queryByExample(dep);
		return set.hasNext() ? set.next() : null;
	}
	
}
