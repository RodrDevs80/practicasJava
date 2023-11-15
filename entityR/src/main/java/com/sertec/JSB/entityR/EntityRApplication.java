package com.sertec.JSB.entityR;


import com.sertec.JSB.entityR.domain.Address;
import com.sertec.JSB.entityR.domain.Client;
import com.sertec.JSB.entityR.domain.Product;
import com.sertec.JSB.entityR.domain.User;
import com.sertec.JSB.entityR.repository.AddressRepository;
import com.sertec.JSB.entityR.repository.ClientRepository;
import com.sertec.JSB.entityR.repository.ProductRepository;
import com.sertec.JSB.entityR.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;


@SpringBootApplication
public class EntityRApplication {

	public static void main(String[] args) {SpringApplication.run(EntityRApplication.class, args);}
	@Bean
	CommandLineRunner commandLineRunner
			(UserRepository userRepository, ClientRepository clientRepository,
			 AddressRepository addressRepository, ProductRepository productRepository){

		return  args -> {
			User user1=userRepository.save(new User(null,"carlos","1234"));
			Client client1=clientRepository
					.save(new Client(null,"Carlos Rodriguez",user1,null,null));
			//address
			Address address1=addressRepository
					.save(new Address(null,"General Taboada","ABC27",client1));
			Address address2=addressRepository
					.save(new Address(null,"La leñera","MUN33",client1));
			Address address3=addressRepository
					.save(new Address(null,"Santa Rafaela","A0008",client1));
			Address address4=addressRepository
					.save(new Address(null,"Colonia Dora","YQ2345",client1));
            //product
			Product p1=productRepository.save(new Product(null,"silla diseño",1234.00));
			client1.setAddressList(Set.of(address1,address2,address3,address4));


		};

	}

}
