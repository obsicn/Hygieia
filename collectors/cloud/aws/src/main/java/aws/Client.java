package aws;

import com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import org.apache.log4j.Logger;
import com.google.gson.Gson;

@SuppressWarnings("PMD")
public class Client {
	
	private static AmazonEC2Client ec2Client;
	private static DescribeInstancesResult describeInstanceResult;
	private static final Logger log = Logger.getLogger(Client.class);
	
	
	public static void main1(String[] args) {
		
        ec2Client = new AmazonEC2Client(
        		new AWSCredentialsProviderChain(
        				new InstanceProfileCredentialsProvider(),
        				new ProfileCredentialsProvider("default")));
        ec2Client.setEndpoint("https://ec2.us-west-2.amazonaws.com");
        describeInstanceResult = ec2Client.describeInstances();
        
		Gson gson = new Gson();
		log.info("runInstances Result: "+gson.toJson(describeInstanceResult));
	}

}
