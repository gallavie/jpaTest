/**
 * Copyright 2012 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.appengine.demos;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EclipselinkJpaServlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws IOException {
    res.setContentType("text/plain");

    Map<String, String> properties = new HashMap();
    properties.put("javax.persistence.jdbc.driver",
            "com.mysql.jdbc.GoogleDriver");
        properties.put("javax.persistence.jdbc.url",
            System.getProperty("cloudsql.url"));

    EntityManagerFactory emf = Persistence.createEntityManagerFactory(
        "Demo", properties);

    // Insert a few rows.
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(new Post1("user", "Hello!"));
    em.persist(new Post1("user", "Hi!"));
    em.getTransaction().commit();
    em.close();

    // List all the rows.
    em = emf.createEntityManager();
    em.getTransaction().begin();
    List<Post1> result = em
        .createQuery("select *  from post1")
        .getResultList();
    for (Post1 g : result) {
      res.getWriter().println(
          g.getId() + " " +
          g.getContent());
    }
    em.getTransaction().commit();
    em.close();

  }
}
