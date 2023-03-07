package com.urban.usersservice.dtos.transporter;

import com.urban.usersservice.dtos.PersonInputDto;
import com.urban.usersservice.models.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class TransporterInputDto extends PersonInputDto {
    private Vehicle vehicle;

}
