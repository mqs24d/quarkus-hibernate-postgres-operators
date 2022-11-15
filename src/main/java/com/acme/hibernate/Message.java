package com.acme.hibernate;

import io.quarkiverse.hibernate.types.json.JsonBinaryType;
import io.quarkiverse.hibernate.types.json.JsonType;
import io.quarkiverse.hibernate.types.json.JsonTypes;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity(name="message")
  @TypeDef(name = JsonTypes.JSON, typeClass = JsonType.class)
  @TypeDef(name = JsonTypes.JSON_BIN, typeClass = JsonBinaryType.class)
public class Message extends PanacheEntityBase {

  @Id
  public String id;
  public String value;

  @Type(type = JsonTypes.JSON_BIN)
  @Column(columnDefinition = JsonTypes.JSON_BIN)
  public MyJsonValue data;
}
