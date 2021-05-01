

package grpc.sbs;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.ServiceInfo;

import grpc.sbs.CounterServiceGrpc.CounterServiceBlockingStub;
//add other stubs
import grpc.sbs.TempServiceGrpc.TempServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class SBSClient {

	private static final Logger logger = Logger.getLogger(SBSClient.class.getName());
	
	private static CounterServiceBlockingStub blockingStub;
		  
	public static void main(String[] args) throws Exception {
		
		
		//jmDNS DISCOVERY of services for http1 type i.e. Occupancy
		ServiceInfo serviceInfo;
		String service_type = "_http1._tcp.local.";
		serviceInfo = SimpleServiceDiscovery.run(service_type);
		int port = serviceInfo.getPort();
				
		String host = "localhost";
		// port = 50051;
		
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress(host, port)
				.usePlaintext()
				.build();
		
		//Instantiate stub
		blockingStub = CounterServiceGrpc.newBlockingStub(channel);
				
		
	    SBSClient client = new SBSClient();
	 
	    occupancy();
	    
	 

	
	
	}
	
	//occupancy client method
	
	public static void occupancy() {
		
		String name = "Requestor";
		OccupancyRequest request = OccupancyRequest.newBuilder().setName(name).build();
	   
		try {  	 
	    	 OccupancyResponse response = blockingStub.occupancy(request);
	    	 
	    	 logger.info("Response: " + response.getMessage());
	    	 System.out.println("From blocking stub: " + response.getMessage());
	    	 
	    }
	    
	    catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
		    
		    return;		
		    
	    } 
	}



	// finally
	//shutdown channel
	//channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);



}



