package com.urban.usersservice.dtos.transporter;

import com.urban.usersservice.dtos.PersonInputDto;
import com.urban.usersservice.models.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data @AllArgsConstructor @NoArgsConstructor @SuperBuilder
public class TransporterInputDto extends PersonInputDto {
    private Vehicle vehicle;

}
