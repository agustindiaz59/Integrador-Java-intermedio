package com.utn.sistemadegestionveterinaria.controladores;

import com.utn.sistemadegestionveterinaria.dao.PerroDAO;
import com.utn.sistemadegestionveterinaria.modelos.Gato;
import com.utn.sistemadegestionveterinaria.modelos.Perro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.hibernate.HibernateError;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PerroController implements PerroDAO, Serializable {
    private EntityManagerFactory emf;
    private EntityManager em;

    public PerroController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public PerroController() {
        this.emf = Persistence.createEntityManagerFactory("BD");
        this.em = getEntityManager();
    }
    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    @Override
    public void crear(Perro perro) {
        try {
            em.getTransaction().begin();
            em.persist(perro);
            em.getTransaction().commit();
        }catch (HibernateError e){
            System.out.println("Error en la creacion del perro " + e.getMessage());
        }
    }

    @Override
    public Perro traer(Perro perro) {
        try{
            em.getTransaction().begin();
            return em.find(perro.getClass(), perro.getId());
        }catch (Exception e){
            System.out.println("Error al traer el perro");
            return null;
        }
    }

    @Override
    public void actualizar(Perro perro) {
        try{
            em.getTransaction().begin();
            em.merge(perro);
        }catch (Exception e){
            System.out.println("Error actualizando el perro");
        }
    }

    @Override
    public List<Perro> traerTodo() {
        List<Perro> perros = new ArrayList<>();
        try {
            em.getTransaction().begin();
            em.createQuery("from Perro").getResultList().stream().forEach(p -> perros.add((Perro) p));
            em.getTransaction().commit();
        }catch (HibernateError e){
            System.out.println("Error trayendo la lista de perros " + e.getMessage());
        }
        return perros;
    }

    @Override
    public boolean existe(Perro perro) {
        try {
            boolean existe;
            em.getTransaction().begin();
            existe = em.find(perro.getClass(),perro.getId()) != null;
            em.getTransaction().commit();
            return existe;
        }catch (HibernateError e){
            System.out.println("Error comprobando el perro " + e.getMessage());
            return false;
        }
    }

    @Override
    public void borrar(Perro perro) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.remove(perro);
        }catch (Exception e){
            System.out.println("Error eliminando la mascota");
        }
    }
}
