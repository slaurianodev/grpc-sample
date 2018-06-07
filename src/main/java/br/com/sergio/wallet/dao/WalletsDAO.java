package br.com.sergio.wallet.dao;

import br.com.sergio.wallet.model.Users;
import br.com.sergio.wallet.model.Wallets;
import br.com.sergio.wallet.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Map;

public class WalletsDAO implements IGenericDAO<Wallets> {

    private Session session;

    @Override
    public void initDAOSession() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public Wallets getById(Integer id) {
        Criteria criteria = this.session.createCriteria(Wallets.class);
        criteria.add(Restrictions.eq("walletId", id));
        Wallets wallet = (Wallets) criteria.uniqueResult();
        return wallet;
    }

    @Override
    public void saveOrUpdate(Wallets wallet) {
        session.getTransaction().begin();
        session.saveOrUpdate(wallet);
        session.getTransaction().commit();
    }

    @Override
    public List<Wallets> list(Criteria criteria) {
        return criteria.list();
    }

    @Override
    public void closeSession() {
        getSession().close();
    }


    public Wallets getByUserAndCurrency(Map<String, Object> params) {
        Criteria criteria = session.createCriteria(Wallets.class);
        criteria.add(Restrictions.eq("user.userId", params.get("userId"))).add(Restrictions.eq("currency.currencyId", params.get("currencyId")));
        List<Wallets> result = list(criteria);

        if(result.size() > 0) {
            return result.get(0);
        }else{
            return null;
        }
    }

    public List<Wallets> listByUser(Users user){
        Criteria criteria = session.createCriteria(Wallets.class);
        criteria.add(Restrictions.eq("user.userId",user.getUserId()));
        return list(criteria);
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
