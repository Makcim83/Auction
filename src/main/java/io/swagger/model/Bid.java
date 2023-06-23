package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Информация о ставке на лот
 */
@Schema(description = "Информация о ставке на лот")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-23T20:39:07.393983297Z[GMT]")


public class Bid   {
  @JsonProperty("bidderName")
  private String bidderName = null;

  @JsonProperty("bidDate")
  private OffsetDateTime bidDate = null;

  public Bid bidderName(String bidderName) {
    this.bidderName = bidderName;
    return this;
  }

  /**
   * Имя человека ставившего на лот
   * @return bidderName
   **/
  @Schema(description = "Имя человека ставившего на лот")
  
    public String getBidderName() {
    return bidderName;
  }

  public void setBidderName(String bidderName) {
    this.bidderName = bidderName;
  }

  public Bid bidDate(OffsetDateTime bidDate) {
    this.bidDate = bidDate;
    return this;
  }

  /**
   * Дата и время приема ставки
   * @return bidDate
   **/
  @Schema(description = "Дата и время приема ставки")
  
    @Valid
    public OffsetDateTime getBidDate() {
    return bidDate;
  }

  public void setBidDate(OffsetDateTime bidDate) {
    this.bidDate = bidDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Bid bid = (Bid) o;
    return Objects.equals(this.bidderName, bid.bidderName) &&
        Objects.equals(this.bidDate, bid.bidDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bidderName, bidDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Bid {\n");
    
    sb.append("    bidderName: ").append(toIndentedString(bidderName)).append("\n");
    sb.append("    bidDate: ").append(toIndentedString(bidDate)).append("\n");
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
