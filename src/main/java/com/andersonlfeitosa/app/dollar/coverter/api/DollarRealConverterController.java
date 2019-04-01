package com.andersonlfeitosa.app.dollar.coverter.api;

import com.andersonlfeitosa.app.dollar.coverter.api.dto.DollarRealConversionRequest;
import com.andersonlfeitosa.app.dollar.coverter.api.dto.DollarRealConversionResponse;
import com.andersonlfeitosa.app.dollar.coverter.domain.AmericanCityTaxEnum;
import com.andersonlfeitosa.app.dollar.coverter.integration.QuotationRestService;
import com.andersonlfeitosa.app.dollar.coverter.integration.dto.QuotationResult;
import com.andersonlfeitosa.app.dollar.coverter.service.DollarRealConverterService;
import com.andersonlfeitosa.app.dollar.coverter.util.MoneyUtil;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@Api(value = "/")
public class DollarRealConverterController {

  private static final Logger LOGGER = LoggerFactory.getLogger(DollarRealConverterController.class);

  @Autowired
  private DollarRealConverterService service;

  @Autowired
  private QuotationRestService quotationRestService;

  @PostMapping("/api/converter")
  @ApiOperation(value = "Retorna o valor especificado convertido em Reais (R$).")
  @ApiResponses({
    @ApiResponse(code = 200, message = "Success", response = DollarRealConversionResponse.class),
    @ApiResponse(code = 400, message = "Bad Request", response = Exception.class),
    @ApiResponse(code = 500, message = "Internal Server Error", response = Exception.class)
  })
  public @ResponseBody
  DollarRealConversionResponse converter(
      @ApiParam(value = "O valor que será convertido em Reais (R$)", required = true)
      @RequestBody DollarRealConversionRequest dto) {
    return service.converter(dto);
  }

  @GetMapping("/api/dolar")
  @ApiOperation(value = "Retorna o valor especificado convertido em Reais (R$).")
  @ApiResponses({
    @ApiResponse(code = 200, message = "Success", response = QuotationResult.class),
    @ApiResponse(code = 400, message = "Bad Request", response = Exception.class),
    @ApiResponse(code = 500, message = "Internal Server Error", response = Exception.class)
  })
  public @ResponseBody
  QuotationResult dolar() {
    return quotationRestService.getQuotation();
  }

}
