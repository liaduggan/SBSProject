

package grpc.sbs;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.ServiceInfo;

//import grpc.sbs.CounterServiceGrpc.CounterServiceBlockingStub;
import grpc.sbs.LightingServiceGrpc.LightingServiceBlockingStub;
import grpc.sbs.LightingServiceGrpc.LightingServiceStub;
//add other stubs

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class SBSLightsClient {

	private static final Logger logger = Logger.getLogger(SBSLightsClient.class.getName());


		private static LightingServiceStub asyncStub;
		private static LightingServiceBlockingStub blockingStub;
		
	    SBSLightsClient client = new SBSLightsClient();				  

	    public static void main(String[] args) throws Exception {
		
		
		//RETURN HERE TO ADD DISCOVERY
		/*ServiceInfo serviceInfo;
		String service_type = "_occ._tcp.local.";
		serviceInfo = SimpleServiceDiscovery.run(service_type);
		int port = serviceInfo.getPort();*/
				
		String host = "localhost";
		int port = 50052;
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();
		
		//Instantiate stubs
		blockingStub = LightingServiceGrpc.newBlockingStub(channel);
		
		asyncStub = LightingServiceGrpc.newStub(channel);
		
		lightSwitch();
		
	    }
		//LightingServiceBlockingStub  blockingStub = LightingServiceGrpc.newBlockingStub(channel);
		
		//LightingServiceStub  asyncStub = LightingServiceGrpc.newStub(channel);

	 
	    
	    public static void lightSwitch() {

	    	//lightSwitch request = lightSwitch.newBuilder().setMessage("Request Current Temperature readings").build();

	    	
			StreamObserver<CompletedActionsResponse> responseObserver = new StreamObserver<CompletedActionsResponse>() {

				@Override
				public void onNext(CompletedActionsResponse msg) {
					System.out.println("receiving light switch request " + msg.getMessage() );
				}

				@Override
				public void onError(Throwable t) {
					t.printStackTrace();
				}

				@Override
				public void onCompleted() {
					System.out.println("stream is completed ...");
				}

			};
	   
		    StreamObserver<FloorsRequest> requestObserver = asyncStub.lightSwitch(responseObserver);	    
		    //asyncStub.lightSwitch(request, responseObserver);
		    
		    int floorno = 2;
		    
		    		    
		    try {
		    	//write set floor no method for GUI
		    	requestObserver.onNext(FloorsRequest.newBuilder().setFloorNo(floorno).build());
		    	 
				Thread.sleep(500);
	
				requestObserver.onNext(FloorsRequest.newBuilder().setFloorNo(floorno).build());
				
				Thread.sleep(500);
		    	 
				// Mark the end of requests
				requestObserver.onCompleted();
	
							
				Thread.sleep(10000);
				
				
		    	 
		    	 //Greeting method
		    	 /*
		    	 
		    	 floorsRequest request = floorsRequest.newBuilder().setFloorNo(floorno).build();
		    	 
		    	 completedActionsResponse response = asyncStub.lightSwitch(request);
		    	 
		    	 logger.info("Greeting: " + response.getMessage());
		    	 //System.out.println("from blocking stub " + response.getMessage());
		    	 
		    } catch (StatusRuntimeException e) {
			    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
			    
			    return;		
			    */
		    } catch (RuntimeException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
		    
		  //  CompletedActionsResponse response = blockingStub.lightSwitch(floorno);
	    
	   }
	    
}


