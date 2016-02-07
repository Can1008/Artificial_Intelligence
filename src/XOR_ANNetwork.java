import java.util.Arrays;

import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.BackPropagation;
import org.neuroph.nnet.learning.ConvolutionalBackpropagation;
import org.neuroph.nnet.learning.MomentumBackpropagation;
import org.neuroph.nnet.learning.ResilientPropagation;
import org.neuroph.core.learning.LearningRule;

import org.neuroph.util.TransferFunctionType;

/*
 * Neural Network for XOR Rule
 * Sample from neuroph-2.92\neuroph-2.92\sources\neuroph-2.92\Samples\src\main\java\org\neuroph\samples\XorMultiLayerPerceptronSample
 * 
 */

public class XOR_ANNetwork {	
		
		private DataSet ts;
		private MultiLayerPerceptron mlp;
		
		public XOR_ANNetwork(String learningRule)
		{
			this.mlp = new MultiLayerPerceptron
					(TransferFunctionType.TANH, 2, 3, 1);
			
			setDataSet();
			this.setLearningRule(learningRule);
			mlp.learn(ts);
			mlp.save("XOR.nnet");
		}
		public void setLearningRule(String learningRule)
		{
			if(learningRule.equals("ResilientPropagation"))
			{
				mlp.setLearningRule(new ResilientPropagation());
			}
			else if (learningRule.equals("ConvolutionalBackpropagation"))
			{
				mlp.setLearningRule(new ConvolutionalBackpropagation());
			}
			else if(learningRule.equals("MomentumBackpropagation"))
			{
				mlp.setLearningRule(new MomentumBackpropagation());
			}
			else
			{
				mlp.setLearningRule(new BackPropagation());
			}
			
		}
		public void setDataSet()
		{
			ts = new DataSet(2,1);
			ts.addRow(new DataSetRow(new double[] {0, 0}, 
					new double[]{0}));
			ts.addRow(new DataSetRow(new double[] {0, 1},
					new double[] {1}));
			ts.addRow(new DataSetRow (new double[] {1, 0},
					new double[] {1}));
			ts.addRow(new DataSetRow(new double[]{1, 1},
					new double[]{0}));
			
		}
		
		public void print()
		{
			for(DataSetRow testSetRow : ts.getRows()) {
	            mlp.setInput(testSetRow.getInput());
	            mlp.calculate();
	            double[] networkOutput = mlp.getOutput();

	            System.out.print("Input: " + Arrays.toString( testSetRow.getInput() ) );
	            System.out.println(" Output: " + Arrays.toString( networkOutput) );
	        }
		}

}

