package com.tj.mmanager.base.persistence.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import com.tj.mmanager.base.persistence.filter.GenericFilter;

public interface GenericDao<T, PK> {

	/**
	 * @author Thejuampi
	 * 
	 * @param id
	 *            id de la entidad que se quiere
	 * @return la entidad con el id asociado
	 */

	public T findById(PK id);

	/**
	 * @author Thejuampi
	 * 
	 * @return todas las entidades disponibles en la base de datos.
	 */
	public List<T> findAll();

	/**
	 * @author Thejuampi
	 * 
	 * @param baseFilter
	 *            contiene los paramatros de la busqueda para obtener una lista
	 *            de resultados acordea a los mismos
	 * @return la lista con los valores obtenidos de la base de datos segun los
	 *         parámetros establecidos en el filtro
	 */

	public List<T> filter(GenericFilter<PK> baseFilter);

	/**
	 * @author Thejuampi
	 * 
	 * @param entity
	 *            la entidad a ser guardada en la base de datos
	 * 
	 */
	public void save(T entity);

	/**
	 * 
	 * @return la sessionFactory.getCurrentSession() gestionada por Spring y
	 *         Hibernate
	 */

	public Session getSession();

	/**
	 * Método utilizado en el filtrado de entidades
	 * 
	 * @author Thejuampi
	 * 
	 * @param filter
	 *            filtro con los parametros utilizados para filtrar por base de
	 *            datos los resultados
	 * @return el criteria de Hibernate que va a ser utilizado luego para
	 *         obtener las entidades persistentes
	 */
	public DetachedCriteria createCriteriaByFilter(GenericFilter<PK> filter);

	/**
	 * Funcion helper que debe ser implementada por la clase final. Aca se
	 * implementan los filtros personalizados
	 * 
	 * Ejemplo de uso: <br/>
	 * 
	 * if(StringUtils.isNotBlank(filter.getNombre())){<br/>
	 *		criteria.add(Restrictions.ilike( Localidad.Atributos.NOMBRE, filter.getNombre() )); <br/>
	 *	}<br/>
	 *	
	 *	return criteria;<br/>
	 * 
	 * @author Thejuampi
	 * 
	 * @param filter
	 *            filtro con los parametros utilizados para filtrar por base de
	 *            datos los resultados
	 * @param criteria
	 *            el criteria de Hibernate que va a ser utilizado luego para
	 *            obtener las entidades persistentes
	 * @return el mismo criteria pasado se debe retornar para que funciones
	 */
	public DetachedCriteria criteriaFilterHelper(GenericFilter<PK> filter,
			DetachedCriteria criteria);

}
