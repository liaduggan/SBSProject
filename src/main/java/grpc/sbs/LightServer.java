package grpc.sbs;

//import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
//import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Properties;
//import java.util.Random;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.sbs.LightingServiceGrpc.LightingServiceImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class LightServer extends LightingServiceImplBase {


	public static void main(String[] args) {
		LightServer lightserver = new LightServer();

		Properties prop = LightServer.getProperties();
		
		LightServer.registerService(prop);
		
		int port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;

		try {

			Server server = ServerBuilder.forPort(port)
					.addService(lightserver)
					.build()
					.start();

			System.out.println("Lighting Server started, listening on " + port);

			server.awaitTermination();


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	
	private static Properties getProperties() {
		
		Properties prop = null;		
		
		 try (InputStream input = new FileInputStream("src/main/resources/lighting.properties")) {

	            prop = new Properties();

	            // load a properties file
	            prop.load(input);

	            // get the property value and print it out
	            System.out.println("Lighting Service properies ...");
	            System.out.println("\t service_type: " + prop.getProperty("service_type"));
	            System.out.println("\t service_name: " +prop.getProperty("service_name"));
	            System.out.println("\t service_description: " +prop.getProperty("service_description"));
		        System.out.println("\t service_port: " +prop.getProperty("service_port"));

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	
		 return prop;
	}
	
	
	private static void registerService(Properties prop) {
		
		 try {
	            // Create a JmDNS instance
	            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
	            
	            String service_type = prop.getProperty("service_type") ;//"_http._tcp.local.";
	            String service_name = prop.getProperty("service_name")  ;// "example"
	            int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;

	            
	            String service_description_properties = prop.getProperty("service_description")  ;//"path=index.html";
	            
	            // Register a service
	            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
	            jmdns.registerService(serviceInfo);
	            
	            System.out.printf("registering service with type %s and name %s \n", service_type, service_name);
	            
	            // Wait a bit
	            Thread.sleep(1000);

	            // Unregister all services
	            //jmdns.unregisterAllServices();

	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	}
	
	//method for the lighting service
	//public void lightSwitch(FloorsRequest request, StreamObserver<CompletedActionsResponse> responseObserver) {
	
	public StreamObserver<FloorsRequest> lightSwitch(
			StreamObserver<CompletedActionsResponse> responseObserver) {


		return new StreamObserver<FloorsRequest>() {

		//	ArrayList<float> list = new ArrayList();
			
			 StringBuffer floorsBuff=new StringBuffer();

			@Override
			public void onNext(FloorsRequest request) {

				System.out.println("receiving lightSwitch method request for floor: "+ request.getFloorNo()  );

				//Add floor light switch to array for confirmation message
				floorsBuff.append(request.getFloorNo());
				floorsBuff.append(", ");
				
				//list.add(request.getFloorNo());		           

			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stubal

			}

			@Override
			public void onCompleted() {
				System.out.printf("receiving CompletedActionsResponse; method complete \n" );

				floorsBuff.append(".");
				String floors = floorsBuff.toString();
				
				String msg= "Confirmed the lights have been switched" + "on/off" + "for the following floors: " + floors;

				CompletedActionsResponse reply = CompletedActionsResponse.newBuilder().setMessage(msg).build();

				responseObserver.onNext(reply);

				responseObserver.onCompleted();

			}

		};

	}
	

}


