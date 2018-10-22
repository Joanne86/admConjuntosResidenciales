package co.edu.uan.reciboPropFacade;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import co.edu.uan.DBAdapter.DBFactory;
import co.edu.uan.DBAdapter.IDBAdapter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReporteSubsystem {
	private IDBAdapter dbAdapter;

	public ReporteSubsystem() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}
	public void iniciar(int codigoFact) {
        try {
        	Connection conn = dbAdapter.getConnection();

            JasperReport reporte = null;

            //String path = "src\\reportes\\FacturaReporte.jasper";
            
            Map parametro = new HashMap();
            parametro.put("codigo", codigoFact);
            
            //reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            
            
            reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/reports/Recibo.jasper"));
            
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, conn);
            JasperViewer view = new JasperViewer(jprint, false);
            //view.setDefaultCloseOperation();
            view.setVisible(true);
        
        } catch (JRException ex) {
            
        }

    }
	
}
