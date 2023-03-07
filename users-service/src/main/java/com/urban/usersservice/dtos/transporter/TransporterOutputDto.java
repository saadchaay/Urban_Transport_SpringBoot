package com.urban.usersservice.dtos.transporter;

import com.urban.usersservice.dtos.PersonOutputDto;
import com.urban.usersservice.models.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class TransporterOutputDto extends PersonOutputDto {
    private Long vehicleId;
    private Vehicle vehicle;
}
