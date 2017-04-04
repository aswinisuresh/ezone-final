/*package com.niit.ezone.dao.impl;

import java.util.List;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import com.niit.ezone.dao.CartDAO;
import com.niit.ezone.model.MyCart;


@EnableTransactionManagement
@Repository("cartDAO")
public class CartDAOImpl implements CartDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	public CartDAOImpl(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<MyCart> list(String userID) {
		
		String hql = "from MyCart where userID=" + "'" + userID + "'  and status = " + "'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
	
		return query.list();

	}

	@Transactional
	public boolean save1(MyCart myCart) {
	

		myCart.setId(getMaxId());
		sessionFactory.getCurrentSession().save(myCart);
		
	}

	@Transactional
	public Long getTotalAmount(String userID) {
	
		String hql = "select sum(price) from MyCart where userID=" + "'" + userID + "' " + "  and status = " + "'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return (Long) query.uniqueResult();

	}

	private Long getMaxId() {
		log.debug("->->Starting of the method getMaxId");

		Long maxID = 100L;
		try {
			String hql = "select max(id) from MyCart";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			maxID = (Long) query.uniqueResult();
		} catch (Exception e) {
		
			maxID = 100L;
			e.printStackTrace();
		}
		
		return maxID + 1;

	}

	public MyCart get(String cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean save(MyCart myCart) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(MyCart myCart) {
		myCart.setStatus('X');
		return false;
	}

	public boolean update(MyCart myCart) {
	sessionFactory.getCurrentSession().update(myCart);
	return false;
	}

	
}
*/