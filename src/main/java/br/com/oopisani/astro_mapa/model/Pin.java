package br.com.oopisani.astro_mapa.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;




@Entity
@Table(name = "pins")
public class Pin implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "location_type", length = 50)
    private String locationType; // Ex: "Beach", "Lookout", "Private Property"

    @Column(name = "is_safe")
    private Boolean isSafe; // Yes, No & I don't know

    @Column(name = "easy_access")
    private Boolean easyAccess; // Yes or No

    @Column(name = "star_visibility", length = 50)
    private String starVisibility; // Ex: "Low", "Medium", "High"

    @Column(name = "uap_sighting")
    private Boolean uapSighting; // Yes or No, if Yes, When?

    @Column(name = "uap_sighting_datetime")
    private LocalDateTime uapSightingDateTime; // Import from java.time.LocalDateTime

    @Column(name = "significant_moment", columnDefinition = "TEXT")
    private String significantMoment;

//    @Column(name = "bortle_level")
//    private Integer bortleLevel;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public Pin() {
    }

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
        if (!(o instanceof Pin pin)) return false;
        return Objects.equals(getId(), pin.getId()) && Objects.equals(getLatitude(), pin.getLatitude()) && Objects.equals(getLongitude(), pin.getLongitude()) && Objects.equals(getName(), pin.getName()) && Objects.equals(getLocationType(), pin.getLocationType()) && Objects.equals(isSafe, pin.isSafe) && Objects.equals(getEasyAccess(), pin.getEasyAccess()) && Objects.equals(getStarVisibility(), pin.getStarVisibility()) && Objects.equals(getUapSighting(), pin.getUapSighting()) && Objects.equals(getUapSightingDateTime(), pin.getUapSightingDateTime()) && Objects.equals(getSignificantMoment(), pin.getSignificantMoment()) && Objects.equals(getCreatedAt(), pin.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLatitude(), getLongitude(), getName(), getLocationType(), isSafe, getEasyAccess(), getStarVisibility(), getUapSighting(), getUapSightingDateTime(), getSignificantMoment(), getCreatedAt());
    }
}
