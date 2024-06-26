package br.com.doctrina.spring.config;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "rsa")
public record RsaKeyConfigProperties(RSAPublicKey publicKey, RSAPrivateKey privateKey ) {

}
