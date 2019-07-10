package com.example.chaos.monkey.shopping.hotdeals;

import io.dekorate.kubernetes.annotation.ImagePullPolicy;
import io.dekorate.kubernetes.annotation.KubernetesApplication;
import io.dekorate.kubernetes.annotation.ServiceType;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@KubernetesApplication(
		serviceType = ServiceType.NodePort,
		imagePullPolicy = ImagePullPolicy.Always,
		group = "spencergibb" )
@SpringBootApplication
@EnableDiscoveryClient
public class HotDealsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotDealsApplication.class, args);
	}
}
