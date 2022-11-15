package com.acme.hibernate;

import io.quarkus.hibernate.orm.runtime.dialect.QuarkusPostgreSQL10Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StringType;

public class CustomPostgresSQL10Dialect extends QuarkusPostgreSQL10Dialect {

  public CustomPostgresSQL10Dialect() {
    super();
    registerFunction("js_get_string", new SQLFunctionTemplate(StringType.INSTANCE, "(?1 ->> ?2)"));
  }
}
