package com.utn.sistemadegestionveterinaria.controladores;

import com.utn.sistemadegestionveterinaria.dao.GatoDAO;
import com.utn.sistemadegestionveterinaria.modelos.Gato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.hibernate.HibernateError;

import java.util.ArrayList;
import java.util.List;

public class GatoController implements GatoDAO {
    private EntityManagerFactory emf;
    private EntityManager em;
    public GatoController(){
        emf = Persistence.createEntityManagerFactory("BD");
        em = getEntityManager();
    }
    public GatoController(EntityManagerFactory emf){
        this.emf = emf;
        em = getEntityManager();
    }
    private EntityManager getEntityManager(){
        return this.emf.createEntityManager();
    }
    @Override
    public void crear(Gato gato) {
        try {
            em.getTransaction().begin();
            em.persist(gato);
            em.getTransaction().commit();
        }catch (HibernateError e){
            System.out.println("Error guardando el gato " + e.getMessage());
        }
    }

    @Override
    public Gato traer(Gato gato) {
        try {
            Gato g;
            em.getTransaction().begin();
            g = em.find(gato.getClass(),gato.getId());
            em.getTransaction().commit();
            return g;
        }catch (HibernateError e){
            System.out.println("Error trayendo el gato " + e.getMessage());
            return null;
        }
    }

    @Override
    public void actualizar(Gato gato) {
        try {
            em.getTransaction().begin();
            em.merge(gato);
            em.getTransaction().commit();
        }catch (HibernateError e){
            System.out.println("Error actualizando el gato " + e.getMessage());
        }
    }

    @Override
    public void borrar(Gato gato) {
        try {
            em.getTransaction().begin();
            em.remove(gato);
            em.getTransaction().commit();
            System.out.println("Gato borrado con exito");
        }catch (HibernateError e){
            System.out.println("Error eliminando el gato " + e.getMessage());
        }
    }

    @Override
    public List<Gato> traerTodo() {
        List<Gato> gatos = new ArrayList<>();
        try {
            em.getTransaction().begin();
            em.createQuery("from Gato").getResultList().stream().forEach(g -> gatos.add((Gato) g));
            em.getTransaction().commit(); //Uso de stream
        }catch (HibernateError e){
            System.out.println("Error trayendo el gato " + e.getMessage());
        }
        return gatos;
    }

    @Override
    public boolean existe(Gato gato) {
        try {
            boolean existe;
            em.getTransaction().begin();
            existe = em.find(gato.getClass(),gato.getId()) != null;
            em.getTransaction().commit();
            return existe;
        }catch (HibernateError e){
            System.out.println("Error comprobando el gato " + e.getMessage());
            return false;
        }
    }
}
