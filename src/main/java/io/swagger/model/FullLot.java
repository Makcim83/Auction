package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.Bid;
import io.swagger.model.Lot;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Полная информация о лоте, с учетом текущей цены Для подсчета текущей цены нужно сложить все текущие ставки то есть если было 10 ставок то текущая цена высчитывается по формуле 10 * bidPrice + startPrice
 */
@Schema(description = "Полная информация о лоте, с учетом текущей цены Для подсчета текущей цены нужно сложить все текущие ставки то есть если было 10 ставок то текущая цена высчитывается по формуле 10 * bidPrice + startPrice")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-23T20:39:07.393983297Z[GMT]")


public class FullLot extends Lot  {
  @JsonProperty("currentPrice")
  private Integer currentPrice = null;

  @JsonProperty("lastBid")
  private Bid lastBid = null;

  public FullLot currentPrice(Integer currentPrice) {
    this.currentPrice = currentPrice;
    return this;
  }

  /**
   * Текущая цена по лоту,  если торги по лоту еще не начаты - то подставляется стартовая цена
   * @return currentPrice
   **/
  @Schema(required = true, description = "Текущая цена по лоту,  если торги по лоту еще не начаты - то подставляется стартовая цена")
      @NotNull

    public Integer getCurrentPrice() {
    return currentPrice;
  }

  public void setCurrentPrice(Integer currentPrice) {
    this.currentPrice = currentPrice;
  }

  public FullLot lastBid(Bid lastBid) {
    this.lastBid = lastBid;
    return this;
  }

  /**
   * Get lastBid
   * @return lastBid
   **/
  @Schema(description = "")
  
    @Valid
    public Bid getLastBid() {
    return lastBid;
  }

  public void setLastBid(Bid lastBid) {
    this.lastBid = lastBid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FullLot fullLot = (FullLot) o;
    return Objects.equals(this.currentPrice, fullLot.currentPrice) &&
        Objects.equals(this.lastBid, fullLot.lastBid) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentPrice, lastBid, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FullLot {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    currentPrice: ").append(toIndentedString(currentPrice)).append("\n");
    sb.append("    lastBid: ").append(toIndentedString(lastBid)).append("\n");
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
