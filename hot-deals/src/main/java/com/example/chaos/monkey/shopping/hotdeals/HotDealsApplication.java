package com.example.chaos.monkey.shopping.hotdeals;

import io.dekorate.kubernetes.annotation.KubernetesApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@KubernetesApplication( group = "spencergibb" )
@SpringBootApplication
@EnableDiscoveryClient
public class HotDealsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotDealsApplication.class, args);
	}
}
