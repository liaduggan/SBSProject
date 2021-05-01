package grpc.sbs;

import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Properties;
//import java.util.Random;
import java.util.Random;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import grpc.sbs.TempServiceGrpc.TempServiceImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class TempServer extends TempServiceImplBase {


	public static void main(String[] args) {
		TempServer tempserver = new TempServer();

		Properties prop = TempServer.getProperties();
		
		TempServer.registerService(prop);
		
		int port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;

		try {

			Server server = ServerBuilder.forPort(port)
					.addService(tempserver)
					.build()
					.start();

			System.out.println("Temperature Server started, listening on " + port);

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
		
		 try (InputStream input = new FileInputStream("src/main/resources/temperature.properties")) {

	            prop = new Properties();

	            // load a properties file
	            prop.load(input);

	            // get the property value and print it out
	            System.out.println("Occupancy Service properies ...");
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
	
	//method for the occupancy service
	/*
	public void occupancy(OccupancyRequest request, StreamObserver<OccupancyResponse> responseObserver) {
		

		System.out.println("receiving occupancy count request " + request.getName() + " , and msg");

		int rand = (int) (Math.random() * 100);
		
		String msg= "Hi there " + request.getName() + " the current occupancy count in the building is " + rand;
		
		OccupancyResponse response = OccupancyResponse.newBuilder().setMessage(msg).build();

		responseObserver.onNext(response);

		responseObserver.onCompleted();
	}*/
	
	// service impl for server-side streaming temp service
	public void tempReading(tempRequest request,
			StreamObserver<currentTemperature> responseObserver) {

			System.out.print("receiving temp request for" + request.getMessage());
			
			//Building has 4 floors. Server fetches current temp for each floor
			for(int i=0; i<4; i++) {
				
				//build functionality to read from an array of temps
				int realTemp = 19;
		
				currentTemperature reply = currentTemperature.newBuilder().setTemp(realTemp).build();
		
				responseObserver.onNext(reply);
		
				try {
					//wait for a second
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			responseObserver.onCompleted();
	
		}
	
	
	
	//service implementation for bidi tempset service


	public StreamObserver<tempSetRequest> tempSet(StreamObserver<tempSetResponse> responseObserver) {
		
		return new StreamObserver<tempSetRequest> () {
			
			StringBuffer tempBuff = new StringBuffer();
			public int newTemp;
			
			@Override
			public void onNext(tempSetRequest msg) {
				System.out.println("Receiving TempSet request to set temperature to: "+ msg.getTemp() + " degrees");
				
				//method to set temperature in system*
				newTemp = msg.getTemp();
				
				String confirmation =  "Request to Set Temperature to " + msg.getTemp() + " degrees completed." ;
				
				tempSetResponse response = tempSetResponse.newBuilder().setMessage(confirmation).build();
				
				responseObserver.onNext(response);
				
				tempBuff.append(msg.getTemp());
				tempBuff.append(", ");
				
			}

			@Override
			public void onError(Throwable t) {
				
				t.printStackTrace();
				
			}

			@Override
			public void onCompleted() {
				System.out.println("Receiving tempSet stream completed ");
				tempBuff.append("respectively.");
				String temps = tempBuff.toString();
				System.out.println("Tempreatures changed to " + temps);
				
				//completed too
				responseObserver.onCompleted();
			}
			
		};
	}
	
}


