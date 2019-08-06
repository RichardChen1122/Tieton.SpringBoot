package com.siemens.kpiscriptengine.support;

import java.sql.Types;

import org.hibernate.dialect.PostgreSQL94Dialect;

public class JsonPostgresDialect extends PostgreSQL94Dialect {

    public JsonPostgresDialect() {
        this.registerColumnType(Types.JAVA_OBJECT, "json");
    }
}