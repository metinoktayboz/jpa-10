package com.moboz;

import com.moboz.dto.CountedEnrollmentForStudent;
import com.moboz.dto.EnrolledStudent;
import com.moboz.entitites.Student;
import com.moboz.persistence.CustomPersistenceUnitInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String puName = "pu-name";
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "none");     //none, create, update

        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), properties);

        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();

//            String jpql = """
//                    SELECT s, e FROM Student s INNER JOIN s.enrollments e
//                    """;

//            String jpql = """
//                    SELECT s, e FROM Student s JOIN s.enrollments e
//                    """;

//            String jpql = """
//                    SELECT s, e FROM Student s, Enrollment  e WHERE s.id = e.student.id
//                    """;

//            String jpql = """
//                    SELECT s, e FROM Student s, Enrollment  e WHERE s = e.student
//                    """;

//            String jpql = """
//                    SELECT s, e FROM Student s LEFT JOIN s.enrollments e
//                    """;

//            String jpql = """
//                    SELECT s, e FROM Student s RIGHT JOIN s.enrollments e
//                    """;

//            TypedQuery<Object[]> q = em.createQuery(jpql, Object[].class);
//
//            q.getResultList().forEach(o -> System.out.println(o[0] + " " + o[1]));

//            String jpql = """
//                    SELECT NEW com.moboz.dto.EnrolledStudent (s, e) FROM Student s JOIN s.enrollments e
//                    """;

//            TypedQuery<EnrolledStudent> q = em.createQuery(jpql, EnrolledStudent.class);
//
//            q.getResultList().forEach(o -> System.out.println(o.student() + " " + o.enrollment()));

//            String jpql = """
//                    SELECT s FROM Student s WHERE
//                        (SELECT COUNT(e) FROM Enrollment e WHERE  e.student.id = s.id) > 1
//                    """;

//            String jpql = """
//                    SELECT NEW com.moboz.dto.CountedEnrollmentForStudent (s, (SELECT count(e) FROM Enrollment e WHERE e.student = s))
//                    FROM Student s
//                    """;

//            String jpql = """
//                    SELECT NEW com.moboz.dto.CountedEnrollmentForStudent (s.name, count (s))
//                    FROM Student s
//                    GROUP BY s.name
//                    HAVING s.name LIKE '%e'
//                    ORDER BY s.name DESC
//                    """;
//
//            TypedQuery<CountedEnrollmentForStudent> q = em.createQuery(jpql, CountedEnrollmentForStudent.class);


            TypedQuery<Student> q = em.createNamedQuery("getAllEnrolledStudents", Student.class);
            q.getResultList().forEach(System.out::println);


            em.getTransaction().commit();   //end of the transaction
        }
    }
}