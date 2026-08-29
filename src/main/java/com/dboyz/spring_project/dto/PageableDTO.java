package com.dboyz.spring_project.dto;

/**
 * PageableDTO
 */
public class PageableDTO {
  private int pageNumber;
  private int pageSize;
  private long totalElements;
  private int totalPages;

  // default constructor
  public PageableDTO() {
  }

  // constructor
  public PageableDTO(int pageNumber, int pageSize, long totalElements, int totalPages) {
    this.pageNumber = pageNumber;
    this.pageSize = pageSize;
    this.totalElements = totalElements;
    this.totalPages = totalPages;
  }

  // getters and setters
  public int getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(int pageNumber) {
    this.pageNumber = pageNumber;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public long getTotalElements() {
    return totalElements;
  }

  public void setTotalElements(long totalElements) {
    this.totalElements = totalElements;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(int totalPages) {
    this.totalPages = totalPages;
  }
}
