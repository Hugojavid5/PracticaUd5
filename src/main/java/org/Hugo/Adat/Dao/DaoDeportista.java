package org.Hugo.Adat.Dao;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import org.Hugo.Adat.model.ModeloDeportista;

import java.util.List;

public class DaoDeportista {

	public static void insertar(ModeloDeportista dep,ObjectContainer db) {
		db.store(dep);
	}

	public static ModeloDeportista conseguirPorNombre(String nombre, ObjectContainer db) {
		ModeloDeportista dep=new ModeloDeportista();
		dep.setNombre(nombre);
		ObjectSet<ModeloDeportista> set=db.queryByExample(dep);
		return set.hasNext() ? set.next() : null;
	}
	

	public static List<ModeloDeportista> conseguirPorFragmentoNombre(String fragmentoNombre, ObjectContainer db) {
	    List<ModeloDeportista> resultados = db.query(new Predicate<ModeloDeportista>() {
	        @Override
	        public boolean match(ModeloDeportista dep) {
	            return dep.getNombre() != null && dep.getNombre().contains(fragmentoNombre);
	        }
	    });
	    return resultados.isEmpty() ? null : resultados;
	}
}
