package es.fpdual.hibernate.hibernate_dual.repositorio;

import org.hibernate.Session;

import es.fpdual.hibernate.hibernate_dual.Vehiculo;
import es.fpdual.hibernate.hibernate_dual.util.HibernateUtil;

public class RepositorioVehiculo {

	public static Integer crearVehiculo(final Vehiculo vehiculo) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();

			final Integer idVehiculo = (Integer) sesion.save(vehiculo);

			sesion.getTransaction().commit();

			return idVehiculo;
		} catch (Exception e) {
			System.out.println("se ha producido un error insertando un vehiculo" + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException();

		} finally {
			sesion.close();
		}
	}

	public static void eliminarVehiculo(Integer idVehiculo) {
		final Session sesion = HibernateUtil.getMiFactoria().getCurrentSession();

		try {

			sesion.beginTransaction();

			sesion.createQuery("delete Vehiculo where VEH_ID = :idVehiculo").setParameter("idVehiculo", idVehiculo)
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
}