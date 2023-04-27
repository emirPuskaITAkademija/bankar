package ba.bank.show;

import java.io.Serializable;

/**
 * Klasa koja predstavlja tabelu iz baze sakila zvanu shows.
 */
public class Show implements Serializable {
    private Integer showId;
    private String showTitle;
    private Short numSeasons;
    private Long initialYear;

    public Show() {
        super();
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public String getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }

    public Short getNumSeasons() {
        return numSeasons;
    }

    public void setNumSeasons(Short numSeasons) {
        this.numSeasons = numSeasons;
    }

    public Long getInitialYear() {
        return initialYear;
    }

    public void setInitialYear(Long initialYear) {
        this.initialYear = initialYear;
    }

    @Override
    public String toString() {
        return "Show{" +
                "showId=" + showId +
                ", showTitle='" + showTitle + '\'' +
                ", numSeasons=" + numSeasons +
                ", initialYear=" + initialYear +
                '}';
    }
}
