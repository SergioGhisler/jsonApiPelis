package clases;

import java.util.ArrayList;

public class Popular {
    private float page;
    private float total_results;
    private float total_pages;
   private ArrayList< Pelicula > results = new ArrayList<Pelicula>();


    // Getter Methods

    public float getPage() {
        return page;
    }

    public float getTotal_results() {
        return total_results;
    }

    public float getTotal_pages() {
        return total_pages;
    }

    // Setter Methods

    public void setPage(float page) {
        this.page = page;
    }

    public void setTotal_results(float total_results) {
        this.total_results = total_results;
    }

    public void setTotal_pages(float total_pages) {
        this.total_pages = total_pages;
    }
}