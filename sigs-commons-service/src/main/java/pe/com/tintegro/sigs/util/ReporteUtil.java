package pe.com.tintegro.sigs.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import pe.com.tintegro.sigs.constants.ExtensionArchivo;

@SuppressWarnings( value = { "rawtypes", "unused", "unchecked" })
public class ReporteUtil 
{
	public static String generarReporte(Resource plantilla, Map parameters, List<?> objectList, String fileName, int tipoFile) throws Exception
	{
		InputStream inputStream = plantilla.getInputStream();
		File plantillaTemp = File.createTempFile("test", ".jrxml");
		try
		{
			FileUtils.copyInputStreamToFile(inputStream, plantillaTemp);
		}
		finally
		{
			IOUtils.closeQuietly(inputStream);
		}

		JasperDesign jasDesign = JRXmlLoader.load(plantillaTemp.getPath());
		JasperReport reporte = JasperCompileManager.compileReport(jasDesign);
		JasperPrint jasperPrint;
	
		if (objectList.size() > 0)
		{
			jasperPrint = JasperFillManager.fillReport(reporte, parameters, new JRBeanCollectionDataSource(objectList));
		}
		else
		{
			jasperPrint = JasperFillManager.fillReport(reporte, parameters, new JREmptyDataSource());
		}

		String pathAbsoluteFile = String.format("%s", fileName);
		File filex = new File(pathAbsoluteFile);

		if (tipoFile == ExtensionArchivo.EXCEL)
		{
			JRExporter exporter = new JRXlsExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new File(fileName + ".xls"));
			exporter.exportReport();
			filex = new File(pathAbsoluteFile + ".xls");

		}

		if (tipoFile == ExtensionArchivo.PDF)
		{
			JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new File(fileName + ".pdf"));
			exporter.exportReport();
			filex = new File(pathAbsoluteFile + ".pdf");
		}

		if (tipoFile == ExtensionArchivo.RTF)
		{

			JRExporter exporter = new JRRtfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);

			exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new File(fileName + ".rtf"));

			exporter.exportReport();

			filex = new File(pathAbsoluteFile + ".rtf");

		}

		byte[] fileByteArray = new byte[(int) filex.length()];

		FileInputStream fis = new FileInputStream(filex);
		fis.read(fileByteArray); // read file into bytes[]
		fis.close();

		String fileString = new String(Base64.encodeBase64(fileByteArray));
		return fileString;
	}
}
