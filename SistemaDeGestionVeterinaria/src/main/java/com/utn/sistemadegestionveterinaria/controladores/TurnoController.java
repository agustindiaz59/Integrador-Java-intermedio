package com.utn.sistemadegestionveterinaria.controladores;

import com.utn.sistemadegestionveterinaria.dao.TurnoDAO;
import com.utn.sistemadegestionveterinaria.modelos.Turno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.hibernate.HibernateError;

import java.util.ArrayList;
import java.util.List;

public class TurnoController implements TurnoDAO {
    private EntityManagerFactory emf;
    private EntityManager em;

    public TurnoController(EntityManagerFactory emf) {
        this.emf = emf;
        this.em = getEntityManager();
    }

    public TurnoController() {
        emf = Persistence.createEntityManagerFactory("BD");
        this.em = getEntityManager();
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void crear(Turno turno) {
        try {
            em.getTransaction().begin();
            em.persist(turno);
            em.getTransaction().commit();
        }catch (HibernateError e){
            System.out.println("Error guardando el turno " + e.getMessage());
        }
    }

    @Override
    public Turno traer(Turno turno) {
        Turno t = null;
        try {
            em.getTransaction().begin();
            t = em.find(turno.getClass(),turno);
            em.getTransaction().commit();
        }catch (HibernateError e){
            System.out.println("Error trayendo el turno " + e.getMessage());
        }
        return t;
    }

    @Override
    public void actualizar(Turno turno) {
        try {
            em.getTransaction().begin();
            em.merge(turno);
            em.getTransaction().commit();
        }catch (HibernateError e){
            System.out.println("Error actualizando el turno " + e.getMessage());
        }
    }

    @Override
    public List<Turno> traerTodo() {
        List<Turno> turnos = new ArrayList<>();
        try {
            em.getTransaction().begin();
            em.createQuery("from Turno").getResultList().stream().forEach(t -> turnos.add((Turno) t));
            em.getTransaction().commit();
        }catch (HibernateError e){
            System.out.println("Error trayendo los turnos " + e.getMessage());
        }
        return turnos;
    }

    @Override
    public void borrar(Turno turno) {
        try {
            em.getTransaction().begin();
            em.remove(turno);
            em.getTransaction().commit();
        }catch (HibernateError e){
            System.out.println("Error borrando el turno " + e.getMessage());
        }
    }

    @Override
    public boolean existe(Turno turno) {
        try {
            boolean existe;
            em.getTransaction().begin();
            existe = em.find(turno.getClass(),turno.getId()) != null;
            em.getTransaction().commit();
            return existe;
        }catch (HibernateError e){
            System.out.println("Error comprobando el turno " + e.getMessage());
            return false;
        }
    }
}
