/**
 * 
 */
package info.jabara.sandbox.service.impl;

import info.jabara.sandbox.entity.EEmployee;
import info.jabara.sandbox.service.HogeService;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

/**
 * @author jabaraster
 */
public class HogeServiceImpl implements HogeService {

    @PersistenceUnit(unitName = "WithWebSocket_WithDataSource")
    EntityManagerFactory emf;

    /**
     * @see info.jabara.sandbox.service.HogeService#getAll()
     */
    @Override
    public List<EEmployee> getAll() {
        final EntityManager em = this.emf.createEntityManager();
        final CriteriaBuilder builder = em.getCriteriaBuilder();
        final CriteriaQuery<EEmployee> query = builder.createQuery(EEmployee.class);
        query.from(EEmployee.class);
        return em.createQuery(query).getResultList();
    }

    /**
     * @return -
     */
    @Override
    public String getNow() {
        return DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
    }

    /**
     * 
     */
    @Transactional
    @Override
    public void insert() {
        final EntityManager em = this.emf.createEntityManager();
        final EEmployee emp = new EEmployee("Jabara"); //$NON-NLS-1$
        em.persist(emp);
        em.flush();
        jabara.Debug.write(emp.getId());
    }

}
