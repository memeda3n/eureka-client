package client.demo;

import javax.annotation.Resource;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

	@Resource
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("hello")
	public String index(){
		ServiceInstance instance=discoveryClient.getLocalServiceInstance();
		System.out.println(instance.getHost() + " ==hello==" +instance.getServiceId());
		return "hello";
	}
}
