package es.fpdual.hibernate.hibernate_dual.repositorio;

import java.util.List;

import org.hibernate.Session;

import es.fpdual.hibernate.hibernate_dual.Cliente;
import es.fpdual.hibernate.hibernate_dual.EstadoCivil;
import es.fpdual.hibernate.hibernate_dual.Persona;
import es.fpdual.hibernate.hibernate_dual.util.HibernateUtil;

public class RepositorioCliente {

	public static Integer crearCliente(final Cliente cliente) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();

			final Integer idCliente = (Integer) sesion.save(cliente);

			sesion.getTransaction().commit();

			return idCliente;
		} catch (Exception e) {
			System.out.println("se ha producido un error insertando el cliente" + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();

		} finally {
			sesion.close();
		}
	}

	public static void modificarCliente(Cliente cliente) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();

			sesion.saveOrUpdate(cliente);

			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("se ha producido un error creando un cliente" + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);

		} finally {
			sesion.close();
		}
	}

	public static void eliminarCliente(Integer idCliente) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();

			sesion.createQuery("delete Usuario where usu_id = :idCliente").setParameter("idCliente", idCliente)
					.executeUpdate();

			sesion.getTransaction().commit();

		} catch (Exception e) {
			System.out.println("se ha producido un error eliminando el cliente" + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);

		} finally {
			sesion.close();
		}
	}

	public static List<Cliente> consultarCliente(String nombre, String apellidos, String dni, EstadoCivil estadoCivil, String login) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {
			sesion.beginTransaction();

			final StringBuilder sb = new StringBuilder("from Cliente where 1=1");
			if (!nombre.isEmpty()) {
				sb.append(" and CLI_NOM like :nombre");
			}
			if (!apellidos.isEmpty()) {
				sb.append(" and CLI_ape like :apellidos");
			}
			if (!dni.isEmpty()) {
				sb.append(" and CLI_dni like :dni");
			}
			if (estadoCivil != null) {
				sb.append(" and CLI_ecv = :estadoCivil");
			}
			if (login != null && !login.isEmpty()) {
				sb.append(" and CLI_ecv = :estadoCivil");
			}

			final org.hibernate.query.Query<Cliente> consulta = sesion.createQuery(sb.toString());

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

			System.out.println("se ha producido un error consultando el cliente: " + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);

		} finally {
			sesion.close();
		}
	}

	public static Cliente consultarNombreCompleto(Integer idCliente) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();

			return (Cliente) sesion.createQuery("from Usuario where usu_id = :idCliente")
					.setParameter("idCliente", idCliente).uniqueResult();

		} catch (Exception e) {
			System.out.println("se ha producido un error consultando el nombre completo del cliente" + e.getMessage());
			sesion.getTransaction().rollback();
			throw new RuntimeException(e);

		} finally {
			sesion.close();
		}

	}

}