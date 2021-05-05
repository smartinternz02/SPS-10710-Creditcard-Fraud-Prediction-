package org.ml;
import java.util.Arrays;
import weka.classifiers.Classifier;
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.functions.LinearRegression;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
public class regression {
	
	public static Instances getInstances (String filename){
				DataSource source;
				Instances dataset = null;
			
				try {
						source = new DataSource(filename);
						dataset = source.getDataSet();
						dataset.setClassIndex(dataset.numAttributes()-1);
			
			
				} catch (Exception e) {
						e.printStackTrace();
					}
		return dataset;
	}
	
	public static void main(String[] args) throws Exception{
		

		Instances train_data = getInstances("C:\\Users\\saish\\Desktop\\OracleProject\\train.arff");
		System.out.println(train_data.size());
		DataSource source=new DataSource("C:\\Users\\saish\\Desktop\\OracleProject\\train.arff");
		Instances dataset=source.getDataSet();
		dataset.setClassIndex(dataset.numAttributes()-1);
		LinearRegression lr=new LinearRegression();
		lr.buildClassifier(dataset);
		System.out.println(lr);
		
		Evaluation lreval=new Evaluation(dataset);
		lreval.evaluateModel(lr, dataset);
		System.out.println(lreval.toSummaryString());
		
		Classifier classifier = new weka.classifiers.functions.SimpleLinearRegression();

		System.out.print(" the expression for the input data as per alogorithm is ");
		System.out.println(classifier);
		System.out.println("-------------------");
		System.out.println(Evaluation.getAllEvaluationMetricNames());
	}

}
