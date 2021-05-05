package org.ml;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;
import tech.tablesaw.columns.numbers.DoubleColumnType;
import tech.tablesaw.columns.numbers.IntColumnType;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.HorizontalBarPlot;
import tech.tablesaw.plotly.components.Figure;
import tech.tablesaw.plotly.components.Layout;
import tech.tablesaw.plotly.traces.BoxTrace;
import tech.tablesaw.plotly.traces.HistogramTrace;
import static tech.tablesaw.aggregate.AggregateFunctions.sum;

public class ccard {
	public static void main(String args[]) {
		try {
			Table data=Table.read().csv("C:\\Users\\saish\\Desktop\\OracleProject\\creditcard.csv");
			System.out.println(data.structure());
			System.out.println("First 6 of DataSet values : "+data.first(6));
			System.out.println("Last 6 Dataset values : "+data.last(6));
			System.out.println("DATASET null : "+data.dropRowsWithMissingValues() );
			System.out.println(data.sampleN(200));//==> random 200 rows
			
			Layout layout1 = Layout.builder().title("Distribution Over draft").build();
			HistogramTrace trace1=HistogramTrace.builder(data.nCol("v1")).build();
			Plot.show(new Figure(layout1,trace1));
			
			Layout layout2 = Layout.builder().title("Distribution of  Credit usage").build();
			HistogramTrace trace2 = HistogramTrace.builder(data.nCol("v2")).build();
		    Plot.show(new Figure(layout2, trace2));
		    
		    Layout layout3 = Layout.builder().title("Distribution of Credit history").build();
		    HistogramTrace trace3 = HistogramTrace.builder(data.nCol("v3")).build();
		    Plot.show(new Figure(layout3, trace3));
			
		    Layout layout4 = Layout.builder().title("Credit usage by Purpose ").build();
		    BoxTrace trace4 =BoxTrace.builder(data.categoricalColumn("v4"), data.nCol("v2")).build();
		    Plot.show(new Figure(layout4, trace4));
//			@SuppressWarnings("unchecked")
//			java.util.List<Column<?>> ar=(java.util.List<Column<?>>) new List();
//			ar=data.columns("Class");
			
			IntColumn sc = (IntColumn) data.column("Class");
			System.out.println(sc);//==>{System.out.println(data.column("Class"));}
		
			
			Table result = data.dropDuplicateRows();
			System.out.println(result);
			System.out.println("---------------------------------------------------------------------------------------------------------------");
//			 DoubleColumn scale = (DoubleColumn) data.doubleColumn("v1");
//			    scale.set(scale.isEqualTo(1), DoubleColumnType.missingValueIndicator());
//			    Table data1 = data.summarize("v1", sum).by("v1");
//			    Plot.show(
//			            HorizontalBarPlot.create(
//			                "Class by classvalue", // plot title
//			                data1, // table
//			                "v1", // grouping column name
//			                "sum [v1]")); // numeric column name
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
