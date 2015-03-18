import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Perfil;
import model.Usuario;


public class Main {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
		EntityManager em = factory.createEntityManager();
	
		for(int i=0; i < 100; i++){
			Usuario u = new Usuario();
			u.setIdade(i);
			u.setNome("Usuario" + i);
			u.setNumerico(new Long(i));
			
			Perfil p = new Perfil();
			p.setDescricao("Perfil" + i);
			p.setUsuario(u);
			
			u.getPerfis().add(p);
			
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
		}
		
		Query query = em.createQuery("from Usuario");
		List<Usuario> list = query.getResultList();
		for(Usuario u: list ){
			System.out.println("-----------------------------------------------------------------\n" +  u.getId() + " | " + u.getNome() + " | " + u.getIdade());
			if(!u.getPerfis().isEmpty()){
				System.out.println(u.getPerfis().get(0).getDescricao() + "\n -------------------------------------------------------------------------");
			}
		}
		
	}
	
}