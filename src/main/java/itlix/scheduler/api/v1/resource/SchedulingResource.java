package itlix.scheduler.api.v1.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import itlix.scheduler.api.v1.BasePath;
import itlix.scheduler.api.v1.ResponseMessages;
import itlix.scheduler.api.v1.dto.SchedulingDTO;
import itlix.scheduler.api.v1.mapper.SchedulingMapper;
import itlix.scheduler.service.scheduling.SchedulingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Andrey Franca 
 */
@Api(tags = "Scheduling")
@RestController
@RequestMapping(BasePath.BASE_PATH + "scheduling")
public class SchedulingResource {

    private static SchedulingMapper MAPPER = new SchedulingMapper();

    private SchedulingService schedulingService;

    public SchedulingResource(SchedulingService schedulingService) {
        this.schedulingService = schedulingService;
    }

    @PostMapping
    @ApiOperation(value = "${api.v1.scheduling.operation.create}")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = ResponseMessages.MESSAGE_201),
            @ApiResponse(code = 404, message = ResponseMessages.MESSAGE_404)
    })
    public ResponseEntity<SchedulingDTO> create(
            @ApiParam(value = "${api.v1.scheduling.model.dto}") @RequestBody SchedulingDTO schedulingDTO) {
        var scheduling = schedulingService.create(schedulingDTO);
        return new ResponseEntity<>(MAPPER.map(scheduling, SchedulingDTO.class), HttpStatus.CREATED);
    }

}
