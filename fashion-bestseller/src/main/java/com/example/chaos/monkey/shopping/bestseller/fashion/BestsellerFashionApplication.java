package com.example.chaos.monkey.shopping.bestseller.fashion;

import io.dekorate.kubernetes.annotation.KubernetesApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@KubernetesApplication( group = "spencergibb" )
@SpringBootApplication
@EnableDiscoveryClient
public class BestsellerFashionApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestsellerFashionApplication.class, args);
	}
}
