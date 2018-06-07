package br.com.sergio.wallet.dao;

import br.com.sergio.wallet.model.Users;
import br.com.sergio.wallet.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UsersDAO implements IGenericDAO<Users> {

    private Session session;

    @Override
    public void initDAOSession() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    public Users getById(Integer id) {
        Criteria criteria = this.session.createCriteria(Users.class);
        criteria.add(Restrictions.eq("userId",id));
        Users user = (Users) criteria.uniqueResult();
        return user;
    }

    @Override
    public void saveOrUpdate(Users user) {
        session.getTransaction().begin();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
    }

    @Override
    public List<Users> list(Criteria criteria) {
        return criteria.list();
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
