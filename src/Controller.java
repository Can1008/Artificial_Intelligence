
public class Controller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("******START AND RULE******"+"\n");
		AND_ANNetwork backprop = new AND_ANNetwork("BackPropagation");
		System.out.println("********BACKPROPAGATION**********");
		backprop.print();
		
		AND_ANNetwork resilientPropagation = new AND_ANNetwork("ResilientPropagation");
		System.out.println("\n"+"*********RESILIENT PROPAGATION**********");
		resilientPropagation.print();
		
		AND_ANNetwork convolutionalBackpropagation = new AND_ANNetwork("ConvolutionalBackpropagation");
		System.out.println("\n"+"********CONVOLUTIONAL BACKPROPAGATION*********");
		convolutionalBackpropagation.print();
		
		AND_ANNetwork momentumBackpropagation = new AND_ANNetwork("MomentumBackpropagation");
		System.out.println("\n" +"*************MOMENTUM BACKPROPAGATION*************");
		momentumBackpropagation.print();	
		System.out.println("\n" +"******END AND RULE*******");

	}

}
