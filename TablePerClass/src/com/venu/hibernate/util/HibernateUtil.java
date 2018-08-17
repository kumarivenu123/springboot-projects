package com.venu.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	public static SessionFactory factory;
	private HibernateUtil(){}
	public static SessionFactory getSessionFactory()
	{
		if(factory==null)
		{
			Configuration conf=new Configuration();
			conf.configure("com/venu/hibernate/config/hibernate.cfg.xml");
			ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
			factory=conf.buildSessionFactory(registry);
		}
		return factory;
	}
}
