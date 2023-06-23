/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.46).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Bid;
import io.swagger.model.CreateLot;
import io.swagger.model.FullLot;
import io.swagger.model.IdBidBody;
import io.swagger.model.Lot;
import org.springframework.core.io.Resource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-06-23T20:39:07.393983297Z[GMT]")
@Validated
public interface LotApi {

    @Operation(
            summary = "Сделать ставку по лоту",
            description = "Создает новую ставку по лоту. Если лот в статусе CREATED или STOPPED, то должна вернутся ошибка",
            tags = {"Lots"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ставка создана"),

            @ApiResponse(
                    responseCode = "400",
                    description = "Лот в неверном статусе"),

            @ApiResponse(
                    responseCode = "404",
                    description = "Лот не найден")}
    )


    @RequestMapping(
            value = "/lot/{id}/bid",
            consumes = {"application/json"},
            method = RequestMethod.POST
    )
    ResponseEntity<Void> createBid(
            @Parameter(
                    in = ParameterIn.PATH,
                    description = "",
                    required = true,
                    schema = @Schema()
            )
            @PathVariable("id") Integer id,
            @Parameter(
                    in = ParameterIn.DEFAULT,
                    description = "Объект с именем ставившего на лот",
                    required = true,
                    schema = @Schema()
            ) @Valid @RequestBody IdBidBody body
    );


    @Operation(
            summary = "Создает новый лот",
            description = "Метод создания нового лота, если есть ошибки в полях объекта лота - то нужно вернуть статус с ошибкой",
            tags = {"Lots"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Лот успешно создан",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Lot.class)
                    )
            ),

            @ApiResponse(
                    responseCode = "400",
                    description = "Лот передан с ошибкой"
            )
    })


    @RequestMapping(value = "/lot",
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.POST
    )
    ResponseEntity<Lot> createLot(
            @Parameter(
                    in = ParameterIn.DEFAULT,
                    description = "",
                    required = true,
                    schema = @Schema()
            ) @Valid @RequestBody CreateLot body
    );


    @Operation(
            summary = "Получить все лоты, основываясь на фильтре статуса и номере страницы",
            description = "Возвращает все записи о лотах без информации о текущей цене и победителе постранично. Если страница не указана, то возвращается первая страница. Номера страниц начинаются с 0. Лимит на количество лотов на странице - 10 штук.",
            tags = {"Lots"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Список лотов",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Lot.class))
                    )
            )
    })
    @RequestMapping(value = "/lot",
            produces = {"application/json"},
            method = RequestMethod.GET
    )
    ResponseEntity<List<Lot>> findLots(
            @Parameter(
                    in = ParameterIn.QUERY,
                    description = "",
                    schema = @Schema(allowableValues = {"STARTED", "STOPPED", "CREATED"})
            ) @Valid @RequestParam(
                    value = "status",
                    required = false
            ) String status,

            @Min(0) @Parameter(
                    in = ParameterIn.QUERY,
                    description = "",
                    schema = @Schema(allowableValues = {"0"})
            ) @Valid @RequestParam(
                    value = "page",
                    required = false
            ) Integer page
    );


    @Operation(
            summary = "Экспортировать все лоты в файл CSV",
            description = "Экспортировать все лоты в формате id,title,status,lastBidder,currentPrice в одном файле CSV",
            tags = {"Lots"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "CSV Report",
                    content = @Content(
                            mediaType = "application/csv",
                            schema = @Schema(implementation = Resource.class)
                    )
            )
    })
    @RequestMapping(value = "/lot/export",
            produces = {"application/csv"},
            method = RequestMethod.GET
    )
    ResponseEntity<Resource> getCSVFile();


    @Operation(
            summary = "Получить информацию о первом ставившем на лот",
            description = "Возвращает первого ставившего на этот лот",
            tags = {"Lots"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Имя первого ставившего и дата первой ставки",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Bid.class)
                    )
            ),

            @ApiResponse(
                    responseCode = "404",
                    description = "Лот не найден"
            )
    })
    @RequestMapping(value = "/lot/{id}/first",
            produces = {"application/json"},
            method = RequestMethod.GET
    )
    ResponseEntity<Bid> getFirstBidder(
            @Parameter(
                    in = ParameterIn.PATH,
                    description = "",
                    required = true,
                    schema = @Schema()
            ) @PathVariable("id") Integer id
    );


    @Operation(
            summary = "Получить полную информацию о лоте",
            description = "Возвращает полную информацию о лоте с последним ставившим и текущей ценой",
            tags = {"Lots"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Полный лот по идентификатору",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = FullLot.class)
                    )
            ),

            @ApiResponse(
                    responseCode = "404",
                    description = "Лот не найден"
            )
    })
    @RequestMapping(value = "/lot/{id}",
            produces = {"application/json"},
            method = RequestMethod.GET
    )
    ResponseEntity<FullLot> getFullLot(
            @Parameter(
                    in = ParameterIn.PATH,
                    description = "",
                    required = true,
                    schema = @Schema()
            ) @PathVariable("id") Integer id
    );


    @Operation(
            summary = "Возвращает имя ставившего на данный лот наибольшее количество раз",
            description = "Наибольшее количество вычисляется из общего количества ставок на лот",
            tags = {"Lots"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Имя первого ставившего и дата его последней ставки",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Bid.class)
                    )
            ),

            @ApiResponse(
                    responseCode = "404",
                    description = "Лот не найден"
            )
    })
    @RequestMapping(value = "/lot/{id}/frequent",
            produces = {"application/json"},
            method = RequestMethod.GET
    )
    ResponseEntity<Bid> getMostFrequentBidder(
            @Parameter(
                    in = ParameterIn.PATH,
                    description = "",
                    required = true,
                    schema = @Schema()
            ) @PathVariable("id") Integer id
    );


    @Operation(
            summary = "Начать торги по лоту",
            description = "Переводит лот в состояние \"начато\", которое позволяет делать ставки на лот. Если лот уже находится в состоянии \"начато\", то ничего не делает и возвращает 200",
            tags = {"Lots"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Лот переведен в статус начато"
            ),

            @ApiResponse(
                    responseCode = "404",
                    description = "Лот не найден"
            )
    })
    @RequestMapping(value = "/lot/{id}/start",
            method = RequestMethod.POST
    )
    ResponseEntity<Void> lotIdStartPost(
            @Parameter(
                    in = ParameterIn.PATH,
                    description = "",
                    required = true,
                    schema = @Schema()
            ) @PathVariable("id") Integer id
    );


    @Operation(
            summary = "Остановить торги по лоту",
            description = "Переводит лот в состояние \"остановлен\", которое запрещает делать ставки на лот. Если лот уже находится в состоянии \"остановлен\", то ничего не делает и возвращает 200",
            tags = {"Lots"}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Лот перемещен в статус остановлен"
            ),

            @ApiResponse(
                    responseCode = "404",
                    description = "Лот не найден"
            )
    })
    @RequestMapping(value = "/lot/{id}/stop",
            method = RequestMethod.POST
    )
    ResponseEntity<Void> lotIdStopPost(
            @Parameter(
                    in = ParameterIn.PATH,
                    description = "",
                    required = true,
                    schema = @Schema()
            ) @PathVariable("id") Integer id
    );
}