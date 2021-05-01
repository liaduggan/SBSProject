
//import package gRPC Smart Building System
package grpc.sbs;

//display input dialogs
import javax.swing.JOptionPane;

//grpc imports
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

//grpc package stubs
import grpc.sbs.CounterServiceGrpc.CounterServiceBlockingStub;
import grpc.sbs.LightingServiceGrpc.LightingServiceBlockingStub;
import grpc.sbs.LightingServiceGrpc.LightingServiceStub;
import grpc.sbs.TempServiceGrpc.TempServiceBlockingStub;
import grpc.sbs.TempServiceGrpc.TempServiceStub;

//stubs and streaming
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

//jmDNS
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

//java events and exceptions
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class MainGUIApplication {

	/*
	private static CounterServiceBlockingStub blockingStub;
	private static LightingServiceStub asyncStub;
	private static LightingServiceBlockingStub blockingStub;
	private static TempServiceBlockingStub blockingStub;
	private static TempServiceStub asyncStub;
	*/
	String user;
	String service_type;
	int serviceNumberType;
	int floor;
	int tempSet;
	
	

	public static void main(String[] args) {
		
		String user = JOptionPane.showInputDialog(null,"Enter your username");
		//TODO Design verification for users
		
		JOptionPane.showMessageDialog(null,"Please note: \n Occupancy Service Code is : 1\n Lighting Service Code is : 2\n Temperature Service Code is : 3\n");
		
		int serviceNumberType = Integer.parseInt(JOptionPane.showInputDialog(null,"Select a service would you \nlike to use? 1, 2 or 3?"));
		
		
		// ToDo Design if/than logic based on the input of the user
		// if 1 service_type, port are set to http1 / 50051
		// start occupancy server
		// run SBSClient
		
		
		//if 2 service_type, port are set to http2 / 50052
		// start lighting server
		// run SBSLightsClient
		// ask user to input which floors to switch the lights
		// ideally request includes on/off boolean input - not included in design because of conflict with streaming
		// floors are streamed - receive response
		
		// if 3 service_type, port are set to http3 / 50053
		// start temp server
		// run SBSTempClient
		// ask user input which service (check temp or set temp)
		// nested if
		// check temp streams temp responses from server
		// set temp prompts input from user per floor
		// streams bidi responses as floors temps are set
		
		

	
	}


}
