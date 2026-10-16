package br.com.oopisani.astro_mapa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // Evita que a aplicação quebre na inicialização caso a propriedade de CORS
    // não esteja definida no application.yml (fallback de segurança)
    @Value("${cors.originPatterns:default}")
    // ${cors.originPatterns:default}: procura a propriedade cors.originPatterns; se ela não existir, usa o texto literal default.
    private String corsOriginPatterns= "";

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        // VIA HEADER PARAM http://localhost:8080/api/person/v1/2

        // não usar parâmetro da URL para decidir o formato (?mediaType=json, por exemplo)
        configurer.favorParameter(false)
//                .parameterName("mediaType")
                // considerar o header Accept. Ele considera o que o cliente pediu no Accept antes de aplicar o nosso defaultContentType.
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                // se nenhuma preferência for informada, usar JSON
                .defaultContentType(MediaType.APPLICATION_JSON)
                // registra json como application/json
                .mediaType("json", MediaType.APPLICATION_JSON)
                // registra xml como application/xml
                .mediaType("xml", MediaType.APPLICATION_XML);

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // "Splita" o originPatterns do application.yaml em um array de strings
        var allowedOrigins = corsOriginPatterns.split(",");
        registry.addMapping("/**")
                .allowedOrigins(allowedOrigins)

                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")

                .allowCredentials(true);
    }
}

