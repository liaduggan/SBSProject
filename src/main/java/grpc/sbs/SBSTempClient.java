

package grpc.sbs;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.ServiceInfo;

//import grpc.sbs.TempServiceGrpc.tempSetRequest;
//import grpc.sbs.TempServiceGrpc.tempSetResponse;
import grpc.sbs.TempServiceGrpc.TempServiceBlockingStub;
import grpc.sbs.TempServiceGrpc.TempServiceStub;
//add other stubs

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class SBSTempClient {

	private static final Logger logger = Logger.getLogger(SBSTempClient.class.getName());
	
	//declare stubs
	private static TempServiceBlockingStub blockingStub;
	private static TempServiceStub asyncStub;
		  
	public static void main(String[] args) throws Exception {
		
		
		//RETURN HERE TO ADD DISCOVERY
		/*ServiceInfo serviceInfo;
		String service_type = "_http3._tcp.local.";
		serviceInfo = SimpleServiceDiscovery.run(service_type);
		int port = serviceInfo.getPort();
		*/		
		String host = "localhost";
		int port = 50053;
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();
		
		
		//Instantiate stubs
		blockingStub = TempServiceGrpc.newBlockingStub(channel);
		
		asyncStub = TempServiceGrpc.newStub(channel);
				
		
	    SBSTempClient client = new SBSTempClient();
	 
	    tempSet();
	    tempReadingBlocking();
	    tempReadingAsyn();
	}
	    
		public static void tempSet() {

			StreamObserver<tempSetResponse> responseObserver = new StreamObserver<tempSetResponse>() {

				int count =0 ;
				
				@Override
				public void onNext(tempSetResponse msg) {
					System.out.println("receiving response: " + msg.getMessage() + " as response" );
					count += 1;
					//Add floor light switch to array for confirmation message		
				}

				@Override
				public void onError(Throwable t) {
					t.printStackTrace();
				}

				@Override
				public void onCompleted() {
					System.out.println("stream is completed received "+ count + " tempreature change requests");
				}

			};



			StreamObserver<tempSetRequest> requestObserver = asyncStub.tempSet(responseObserver);

			try {

				requestObserver.onNext(tempSetRequest.newBuilder().setTemp(17).build());
				requestObserver.onNext(tempSetRequest.newBuilder().setTemp(21).build());

				// Mark the end of requests
				requestObserver.onCompleted();

				// Sleep for a bit before sending the next one.
				Thread.sleep(new Random().nextInt(1000) + 500);


			} catch (RuntimeException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}



			//After all of the method which could run we add another sleep to the main method
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	 // request current temperature reading 
		public static void tempReadingBlocking() {
			tempRequest request = tempRequest.newBuilder().setMessage("Request Current Temperature readings").build();

			try {
				Iterator<currentTemperature> responces = blockingStub.tempReading(request);

				while(responces.hasNext()) {
					currentTemperature temp = responces.next();
					System.out.println(temp.getTemp());				
				}

			} catch (StatusRuntimeException e) {
				e.printStackTrace();
			}

		}


		public static void tempReadingAsyn() {

			tempRequest request = tempRequest.newBuilder().setMessage("Request Current Temperature readings").build();


			StreamObserver<currentTemperature> responseObserver = new StreamObserver<currentTemperature>() {

				int count =0 ;

				@Override
				public void onNext(currentTemperature value) {
					System.out.println("receiving current temperature " + value.getTemp());
					count += 1;
				}

				@Override
				public void onError(Throwable t) {
					t.printStackTrace();

				}

				@Override
				public void onCompleted() {
					System.out.println("stream of temperatures has completed ... received "+ count+ " temperature readings");
				}

			};

			asyncStub.tempReading(request, responseObserver);

			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	    	//add another catch and finish by closing channels
	
}
