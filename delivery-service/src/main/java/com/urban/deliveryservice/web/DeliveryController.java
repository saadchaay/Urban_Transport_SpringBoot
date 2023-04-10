package com.urban.deliveryservice.web;

import com.urban.deliveryservice.dtos.DeliveryInputDto;
import com.urban.deliveryservice.dtos.DeliveryOutputDto;
import com.urban.deliveryservice.exceptions.DeliveryFieldExistException;
import com.urban.deliveryservice.exceptions.DeliveryNotFoundException;
import com.urban.deliveryservice.exceptions.IncompleteInfos;
import com.urban.deliveryservice.services.DeliveryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/deliveries")
public class DeliveryController {

    private DeliveryServiceImpl dlService;

    @GetMapping
    public List<DeliveryOutputDto> all(){
        return dlService.listAll();
    }

    @GetMapping("/{id}")
    public DeliveryOutputDto one(@PathVariable Long id) throws DeliveryNotFoundException {
        return dlService.searchDelivery(id);
    }

    @PostMapping
    public DeliveryOutputDto save(@RequestBody DeliveryInputDto dlDto) throws IncompleteInfos {
        System.out.println("inside method");
        return dlService.addDelivery(dlDto);
    }

}
