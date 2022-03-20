package org.nioun.essentials.commande.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ReportUtilImpl implements ReportUtil {

	
	public void generatePieChart(String path, List<Object[]> data) {
		
		DefaultPieDataset dataSet = new DefaultPieDataset();
		
		for (Object[] objects:data) {
			dataSet.setValue(objects[0].toString(),new Double(objects[1].toString()));
		}

		JFreeChart chart = ChartFactory.createPieChart3D("Reporting Commande Par Produit  ", dataSet);
		
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/pieChart.jpeg"), chart, 600, 600);
		} 
		catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}

}


