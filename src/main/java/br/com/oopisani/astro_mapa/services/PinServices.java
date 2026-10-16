package br.com.oopisani.astro_mapa.services;

import br.com.oopisani.astro_mapa.controllers.PinController;
import br.com.oopisani.astro_mapa.data.dto.PinDTO;
import br.com.oopisani.astro_mapa.exception.RequiredObjectIsNullException;
import br.com.oopisani.astro_mapa.exception.ResourceNotFoundException;
import br.com.oopisani.astro_mapa.model.Pin;
import br.com.oopisani.astro_mapa.repository.PinRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

import static br.com.oopisani.astro_mapa.mapper.ObjectMapper.parseListObjects;
import static br.com.oopisani.astro_mapa.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PinServices {

    private Logger logger = LoggerFactory.getLogger(PinServices.class.getName());

    @Autowired
    PinRepository repository;

    private static ResourceNotFoundException get() {
        return new ResourceNotFoundException("No records found for this ID");
    }

    public List<PinDTO> findAll() {
        logger.info("Finding all Pins!");
        var pins = parseListObjects(repository.findAll(), PinDTO.class);
//        books.forEach(this::addHateoasLinks);
        pins.forEach(this::addHateoasLinks);
        return pins;
    }

    public PinDTO findById(Long id) {
        logger.info("Finding one Pin!");
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var dto = parseObject(entity, PinDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public PinDTO create(PinDTO pin) {
        if(pin == null) throw new RequiredObjectIsNullException();

        logger.info("Creating one Pin!");

        var entity = parseObject(pin, Pin.class);
        var dto = parseObject(repository.save(entity), PinDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public PinDTO update(PinDTO pin) {
        if(pin == null) throw new RequiredObjectIsNullException();

        logger.info("Updating one Pin!");
        var entity = repository.findById(pin.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setCreatedAt(pin.getCreatedAt());
        entity.setEasyAccess(pin.getEasyAccess());
        entity.setSafe(pin.getSafe());
        entity.setLatitude(pin.getLatitude());
        entity.setLocationType(pin.getLocationType());
        entity.setLongitude(pin.getLongitude());
        entity.setName(pin.getName());
        entity.setSignificantMoment(pin.getSignificantMoment());
        entity.setStarVisibility(pin.getStarVisibility());
        entity.setUapSighting(pin.getUapSighting());
        entity.setUapSightingDateTime(pin.getUapSightingDateTime());
        var dto = parseObject(repository.save(entity), PinDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public void delete(Long id) {
        logger.info("Deleting one Pin!");

        Pin entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        repository.delete(entity);
    }

    private void addHateoasLinks(PinDTO dto) {
        dto.add(linkTo(methodOn(PinController.class).findById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(PinController.class).findAll()).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(PinController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(PinController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(PinController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
    }


}
