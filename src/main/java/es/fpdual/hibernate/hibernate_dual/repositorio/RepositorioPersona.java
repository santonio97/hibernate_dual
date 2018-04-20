package es.fpdual.hibernate.hibernate_dual.repositorio;

import java.util.List;

import org.hibernate.Session;

import es.fpdual.hibernate.hibernate_dual.Cliente;
import es.fpdual.hibernate.hibernate_dual.EstadoCivil;
import es.fpdual.hibernate.hibernate_dual.Persona;
import es.fpdual.hibernate.hibernate_dual.util.HibernateUtil;

public class RepositorioPersona {

	public static Integer crearPersona(final Persona persona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();

			final Integer idPersona = (Integer) sesion.save(persona);

			sesion.getTransaction().commit();

			return idPersona;
		} catch (Exception e) {
			System.out.println("se ha producido un error insertando la persona" + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();

		} finally {
			sesion.close();
		}
	}

	public static void modificarPersona(Persona persona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();

			sesion.saveOrUpdate(persona);
			sesion.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("se ha producido un error creando la persona" + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);

		} finally {
			sesion.close();
		}
	}

	public static void eliminarPersona(Integer idPersona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();

			sesion.createQuery("delete Usuario Usu where usu_id = :idPersona").setParameter("idPersona", idPersona)
					.executeUpdate();

			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("se ha producido un error eliminando la persona" + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);

		} finally {
			sesion.close();
		}
	}

	public static List<Persona> consultar(String nombre, String apellidos, String dni, EstadoCivil estadoCivil,
			String login) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			final StringBuilder sb = new StringBuilder("from Usuario where 1=1");
			if (!nombre.isEmpty()) {
				sb.append(" and PER_NOM like :nombre");
			}
			if (!apellidos.isEmpty()) {
				sb.append(" and per_ape like :apellidos");
			}
			if (!dni.isEmpty()) {
				sb.append(" and per_dni like :dni");
			}
			if (estadoCivil != null) {
				sb.append(" and per_ecv = :estadoCivil");
			}
			if (login != null && !login.isEmpty()) {
				sb.append(" and usu_log = :login");
			}

			final org.hibernate.query.Query<Persona> consulta = sesion.createQuery(sb.toString());

			if (!nombre.isEmpty()) {
				consulta.setParameter("nombre", nombre);
			}

			if (!apellidos.isEmpty()) {
				consulta.setParameter("apellidos", apellidos);
			}

			if (!dni.isEmpty()) {
				consulta.setParameter("dni", dni);
			}

			if (estadoCivil != null) {
				consulta.setParameter("estadoCivil", estadoCivil.ordinal());
			}

			if (login != null && !login.isEmpty()) {
				consulta.setParameter("login", login);
			}

			return consulta.list();

		} catch (Exception e) {

			System.out.println("se ha producido un error consultando la persona: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);

		} finally {
			sesion.close();
		}
	}

	public static Persona consultarNombreCompleto(Integer idPersona) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();

			Persona persona = (Persona) sesion.createQuery("from Persona where usu_id = :idPersona")
					.setParameter("idPersona", idPersona).uniqueResult();

			persona.getTelefonos().stream();

			return persona;

		} catch (Exception e) {
			System.out
					.println("se ha producido un error consultando el nombre completo de la persona " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);

		} finally {
			sesion.close();
		}
	}
}