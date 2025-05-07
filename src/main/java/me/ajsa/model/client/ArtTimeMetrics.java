package me.ajsa.model.client;

public class ArtTimeMetrics {
    private float creationYear;
    private float creationMonth;
    private float creationDay;
    private float exhibitionHours;
    private float exhibitionMinutes;
    private float auctionSeconds;
    private float valuationMilliseconds;
    private String creationDateTime;
    private String exhibitionDate;
    private String auctionTime;
    private String galleryTimeZone;
    private String exhibitionDayOfWeek;
    private boolean daylightSaving;

    public ArtTimeMetrics() {
        super();
    }

    public ArtTimeMetrics(float creationYear, float creationMonth, float creationDay,
                          float exhibitionHours, float exhibitionMinutes, float auctionSeconds,
                          float valuationMilliseconds, String creationDateTime, String exhibitionDate,
                          String auctionTime, String galleryTimeZone, String exhibitionDayOfWeek,
                          boolean daylightSaving) {
        this.creationYear = creationYear;
        this.creationMonth = creationMonth;
        this.creationDay = creationDay;
        this.exhibitionHours = exhibitionHours;
        this.exhibitionMinutes = exhibitionMinutes;
        this.auctionSeconds = auctionSeconds;
        this.valuationMilliseconds = valuationMilliseconds;
        this.creationDateTime = creationDateTime;
        this.exhibitionDate = exhibitionDate;
        this.auctionTime = auctionTime;
        this.galleryTimeZone = galleryTimeZone;
        this.exhibitionDayOfWeek = exhibitionDayOfWeek;
        this.daylightSaving = daylightSaving;
    }

    // Getter methods
    public float getCreationYear() {
        return creationYear;
    }

    public float getCreationMonth() {
        return creationMonth;
    }

    public float getCreationDay() {
        return creationDay;
    }

    public float getExhibitionHours() {
        return exhibitionHours;
    }

    public float getExhibitionMinutes() {
        return exhibitionMinutes;
    }

    public float getAuctionSeconds() {
        return auctionSeconds;
    }

    public float getValuationMilliseconds() {
        return valuationMilliseconds;
    }

    public String getCreationDateTime() {
        return creationDateTime;
    }

    public String getExhibitionDate() {
        return exhibitionDate;
    }

    public String getAuctionTime() {
        return auctionTime;
    }

    public String getGalleryTimeZone() {
        return galleryTimeZone;
    }

    public String getExhibitionDayOfWeek() {
        return exhibitionDayOfWeek;
    }

    public boolean isDaylightSaving() {
        return daylightSaving;
    }

    // Setter methods
    public void setCreationYear(float creationYear) {
        this.creationYear = creationYear;
    }

    public void setCreationMonth(float creationMonth) {
        this.creationMonth = creationMonth;
    }

    public void setCreationDay(float creationDay) {
        this.creationDay = creationDay;
    }

    public void setExhibitionHours(float exhibitionHours) {
        this.exhibitionHours = exhibitionHours;
    }

    public void setExhibitionMinutes(float exhibitionMinutes) {
        this.exhibitionMinutes = exhibitionMinutes;
    }

    public void setAuctionSeconds(float auctionSeconds) {
        this.auctionSeconds = auctionSeconds;
    }

    public void setValuationMilliseconds(float valuationMilliseconds) {
        this.valuationMilliseconds = valuationMilliseconds;
    }

    public void setCreationDateTime(String creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public void setExhibitionDate(String exhibitionDate) {
        this.exhibitionDate = exhibitionDate;
    }

    public void setAuctionTime(String auctionTime) {
        this.auctionTime = auctionTime;
    }

    public void setGalleryTimeZone(String galleryTimeZone) {
        this.galleryTimeZone = galleryTimeZone;
    }

    public void setExhibitionDayOfWeek(String exhibitionDayOfWeek) {
        this.exhibitionDayOfWeek = exhibitionDayOfWeek;
    }

    public void setDaylightSaving(boolean daylightSaving) {
        this.daylightSaving = daylightSaving;
    }

    @Override
    public String toString() {
        return "ArtTimeMetrics [" +
                "creationYear=" + creationYear +
                ", creationMonth=" + creationMonth +
                ", creationDay=" + creationDay +
                ", exhibitionHours=" + exhibitionHours +
                ", exhibitionMinutes=" + exhibitionMinutes +
                ", auctionSeconds=" + auctionSeconds +
                ", valuationMilliseconds=" + valuationMilliseconds +
                ", creationDateTime=" + creationDateTime +
                ", exhibitionDate=" + exhibitionDate +
                ", auctionTime=" + auctionTime +
                ", galleryTimeZone=" + galleryTimeZone +
                ", exhibitionDayOfWeek=" + exhibitionDayOfWeek +
                ", daylightSaving=" + daylightSaving +
                "]";
    }
}
