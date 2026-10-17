package br.com.oopisani.astro_mapa.data.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class PinDTO extends RepresentationModel<PinDTO> implements Serializable {
    private Long id;
    private Double latitude;
    private Double longitude;
    private String name;
    private String locationType;
    private Boolean isSafe;
    private Boolean easyAccess;
    private String starVisibility;
    private Boolean uapSighting;
    private LocalDateTime uapSightingDateTime;
    private String significantMoment;
    private LocalDateTime createdAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getEasyAccess() {
        return easyAccess;
    }

    public void setEasyAccess(Boolean easyAccess) {
        this.easyAccess = easyAccess;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getSafe() {
        return isSafe;
    }

    public void setSafe(Boolean safe) {
        isSafe = safe;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignificantMoment() {
        return significantMoment;
    }

    public void setSignificantMoment(String significantMoment) {
        this.significantMoment = significantMoment;
    }

    public String getStarVisibility() {
        return starVisibility;
    }

    public void setStarVisibility(String starVisibility) {
        this.starVisibility = starVisibility;
    }

    public Boolean getUapSighting() {
        return uapSighting;
    }

    public void setUapSighting(Boolean uapSighting) {
        this.uapSighting = uapSighting;
    }

    public LocalDateTime getUapSightingDateTime() {
        return uapSightingDateTime;
    }

    public void setUapSightingDateTime(LocalDateTime uapSightingDateTime) {
        this.uapSightingDateTime = uapSightingDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PinDTO pinDTO)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getId(), pinDTO.getId()) && Objects.equals(getLatitude(), pinDTO.getLatitude()) && Objects.equals(getLongitude(), pinDTO.getLongitude()) && Objects.equals(getName(), pinDTO.getName()) && Objects.equals(getLocationType(), pinDTO.getLocationType()) && Objects.equals(isSafe, pinDTO.isSafe) && Objects.equals(getEasyAccess(), pinDTO.getEasyAccess()) && Objects.equals(getStarVisibility(), pinDTO.getStarVisibility()) && Objects.equals(getUapSighting(), pinDTO.getUapSighting()) && Objects.equals(getUapSightingDateTime(), pinDTO.getUapSightingDateTime()) && Objects.equals(getSignificantMoment(), pinDTO.getSignificantMoment()) && Objects.equals(getCreatedAt(), pinDTO.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getLatitude(), getLongitude(), getName(), getLocationType(), isSafe, getEasyAccess(), getStarVisibility(), getUapSighting(), getUapSightingDateTime(), getSignificantMoment(), getCreatedAt());
    }
}
