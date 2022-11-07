package com.labinvent.serversensorsmonitor.web.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;


@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)  // ??
public class MonitorResponse {
    protected LocalDateTime time;
    protected int statusCode;
    protected HttpStatus status;
    protected String message;
    protected Map<?, ?> data;
}
