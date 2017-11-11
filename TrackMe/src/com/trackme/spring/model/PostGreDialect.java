package com.trackme.spring.model;

import java.sql.Types;

public class PostGreDialect extends org.hibernate.dialect.PostgreSQL82Dialect{

    public PostGreDialect() {

        super();    

        System.out.println("Register Hibernate Type ... ");
        registerHibernateType(Types.ARRAY, "array");

        System.out.println("Register Column Type ... ");
        registerColumnType(Types.ARRAY, "text[]");
}
    }