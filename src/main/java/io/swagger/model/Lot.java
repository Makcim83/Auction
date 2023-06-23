package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.CreateLot;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Lot
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-23T20:39:07.393983297Z[GMT]")


public class Lot   {
  @JsonProperty("title")
  private String title = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("startPrice")
  private Integer startPrice = null;

  @JsonProperty("bidPrice")
  private Integer bidPrice = null;

  public Lot title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   **/
  @Schema(example = "Chinese Vase", required = true, description = "")
      @NotNull

  @Size(min=3,max=64)   public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Lot description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   **/
  @Schema(example = "Chinese Vase of Ming dynasty", required = true, description = "")
      @NotNull

  @Size(min=1,max=4096)   public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Lot startPrice(Integer startPrice) {
    this.startPrice = startPrice;
    return this;
  }

  /**
   * Начальная цена лота
   * minimum: 1
   * @return startPrice
   **/
  @Schema(example = "100", required = true, description = "Начальная цена лота")
      @NotNull

  @Min(1)  public Integer getStartPrice() {
    return startPrice;
  }

  public void setStartPrice(Integer startPrice) {
    this.startPrice = startPrice;
  }

  public Lot bidPrice(Integer bidPrice) {
    this.bidPrice = bidPrice;
    return this;
  }

  /**
   * Цена каждой новой ставки по лоту
   * minimum: 1
   * @return bidPrice
   **/
  @Schema(example = "100", required = true, description = "Цена каждой новой ставки по лоту")
      @NotNull

  @Min(1)  public Integer getBidPrice() {
    return bidPrice;
  }

  public void setBidPrice(Integer bidPrice) {
    this.bidPrice = bidPrice;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lot lot = (Lot) o;
    return Objects.equals(this.title, lot.title) &&
        Objects.equals(this.description, lot.description) &&
        Objects.equals(this.startPrice, lot.startPrice) &&
        Objects.equals(this.bidPrice, lot.bidPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, description, startPrice, bidPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Lot {\n");
    
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    startPrice: ").append(toIndentedString(startPrice)).append("\n");
    sb.append("    bidPrice: ").append(toIndentedString(bidPrice)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
