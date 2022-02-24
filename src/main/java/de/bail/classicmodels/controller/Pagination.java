package de.bail.classicmodels.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Pagination {

    private int limit = 10;

    private int total;

    private int page;

    public void selectPage(int page) {
        setPage(page);
        fetchData();
    }

    public void prevPage() {
        setPage(getPage() - 1);
        fetchData();
    }

    public void nextPage() {
        setPage(getPage() + 1);
        fetchData();
    }

    public abstract void fetchData();

    public int getPageCount() {
        return (int) Math.ceil(total / (double) limit);
    }

    public List<Integer> getPageList() {
        return IntStream.range(0,getPageCount()).boxed().collect(Collectors.toList());
    }

    public int getLimit() {
        return limit;
    }

    public int getTotal() {
        return total;
    }

    public boolean isEmptyList() {
        return total == 0;
    }

    public int getPage() {
        return page;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
