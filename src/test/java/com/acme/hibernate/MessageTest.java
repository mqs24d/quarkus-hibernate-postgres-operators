package com.acme.hibernate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
@TestTransaction
class MessageTest {

  @Test
  public void test() {
    var t = new Message();
    t.id = "1";
    t.value = "Test";
    t.data = new MyJsonValue(5,"abc");
    t.persistAndFlush();

    var count = Message.<Message>find("from message m where js_get_string(m.data, 'a') = 'abc' ").count();
    assertEquals(count, 1);
  }
}