package com.dboyz.spring_project.dto;

import java.util.List;

public class OrderHistoryResponse {
  private List<OrderDTO> content;
  private PageableDTO pageable;

  // default constructor
  public OrderHistoryResponse() {
  }

  // constructor
  public OrderHistoryResponse(List<OrderDTO> content, PageableDTO pageable) {
    this.content = content;
    this.pageable = pageable;
  }

  // getters and setters
  public List<OrderDTO> getContent() {
    return content;
  }

  public PageableDTO getPageable() {
    return pageable;
  }

  public void setContent(List<OrderDTO> content) {
    this.content = content;
  }

  public void setPageable(PageableDTO pageable) {
    this.pageable = pageable;
  }

}
