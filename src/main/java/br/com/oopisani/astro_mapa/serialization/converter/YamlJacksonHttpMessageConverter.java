package br.com.oopisani.astro_mapa.serialization.converter;

import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractJacksonHttpMessageConverter;
import tools.jackson.dataformat.yaml.YAMLMapper;


public final class YamlJacksonHttpMessageConverter
        extends AbstractJacksonHttpMessageConverter<YAMLMapper> {

    public YamlJacksonHttpMessageConverter() {
        super(
                new YAMLMapper(),
                MediaType.parseMediaType("application/yaml")
        );
    }
}
