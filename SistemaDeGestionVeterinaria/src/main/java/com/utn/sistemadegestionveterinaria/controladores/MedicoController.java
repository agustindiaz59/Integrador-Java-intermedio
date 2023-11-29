package com.utn.sistemadegestionveterinaria.controladores;

import com.utn.sistemadegestionveterinaria.dao.MedicoDAO;
import com.utn.sistemadegestionveterinaria.modelos.Medico;
import com.utn.sistemadegestionveterinaria.modelos.Perro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.HibernateError;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MedicoController implements MedicoDAO, Serializable {
    private EntityManagerFactory emf;
    private EntityManager em;

    public MedicoController(EntityManagerFactory emf) {
        this.emf = emf;
        em = emf.createEntityManager();
    }

    public MedicoController() {
        this.emf = Persistence.createEntityManagerFactory("BD");
        em = emf.createEntityManager();
    }


    @Override
    public void crear(Medico medico) {
        try {
            em.getTransaction().begin();
            em.persist(medico);
            em.getTransaction().commit();
        }catch (HibernateError e){
            System.out.println("Error en la creacion del medico " + e.getMessage());
        }
    }

    @Override
    public Medico traer(Medico medico) {
            try{
                em.getTransaction().begin();
                return em.find(medico.getClass(), medico.getId());
            }catch (Exception e){
                System.out.println("Error al traer el medico");
                return null;
            }
    }

    @Override
    public void actualizar(Medico medico) {
        try{
            em.getTransaction().begin();
            em.merge(medico);
        }catch (Exception e){
            System.out.println("Error actualizando el medico");
        }
    }

    @Override
    public void borrar(Medico medico) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.remove(medico);
        }catch (Exception e){
            System.out.println("Error eliminando el medico");
        }
    }

    @Override
    public List<Medico> traerTodo() {
        List<Medico> medicos = new ArrayList<>();
        try {
            em.getTransaction().begin();
            em.createQuery("from Medico").getResultList().stream().forEach(p -> medicos.add((Medico) p));
            em.getTransaction().commit();
        }catch (HibernateError e){
            System.out.println("Error trayendo la lista de medicos " + e.getMessage());
        }
        return medicos;
    }

    @Override
    public boolean existe(Medico medico) {
        try {
            boolean existe;
            em.getTransaction().begin();
            existe = em.find(medico.getClass(),medico.getId()) != null;
            em.getTransaction().commit();
            return existe;
        }catch (HibernateError e){
            System.out.println("Error comprobando el medico " + e.getMessage());
            return false;
        }
    }
}
