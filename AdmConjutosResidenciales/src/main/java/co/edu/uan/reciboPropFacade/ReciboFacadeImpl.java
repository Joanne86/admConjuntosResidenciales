package co.edu.uan.reciboPropFacade;

public class ReciboFacadeImpl implements IReporteFacade{

	@Override
	public void generarReporte(int parametro) {
		ReporteSubsystem reporteSubsystem = new ReporteSubsystem();
		reporteSubsystem.iniciar(parametro);
	}

}
