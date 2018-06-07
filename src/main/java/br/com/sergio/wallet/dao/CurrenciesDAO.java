package br.com.sergio.wallet.dao;

import br.com.sergio.wallet.model.Currencies;
import br.com.sergio.wallet.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CurrenciesDAO implements IGenericDAO<Currencies> {

    private Session session;

    @Override
    public void initDAOSession() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public Currencies getById(Integer id) {
        Criteria criteria = this.session.createCriteria(Currencies.class);
        criteria.add(Restrictions.eq("CurrenciesId", id));
        Currencies currency = (Currencies) criteria.uniqueResult();
        return currency;
    }

    @Override
    public void saveOrUpdate(Currencies Currencies) {
        session.getTransaction().begin();
        session.saveOrUpdate(Currencies);
        session.getTransaction().commit();
    }

    @Override
    public List<Currencies> list(Criteria criteria) {
        return criteria.list();
    }

    public Currencies getByCurrencyCode(String currencyCode){
        Criteria criteria = session.createCriteria(Currencies.class);
        criteria.add(Restrictions.eq("currencyCode", currencyCode));
        List<Currencies> result = list(criteria);
        if(result != null) {
            return result.get(0);
        }else{
            return null;
        }
    }

    public Session getSession() {
        return session;
    }

    @Override
    public void closeSession() {
        getSession().close();
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
