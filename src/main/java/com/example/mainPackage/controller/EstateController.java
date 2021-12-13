package com.example.mainPackage.controller;


import com.example.mainPackage.entity.Estate;
import com.example.mainPackage.repository.ParameterRepository;
import com.example.mainPackage.requestBodyClassis.AddEstateRequest;
import com.example.mainPackage.requestBodyClassis.SaleRequest;
import com.example.mainPackage.requestBodyClassis.UpdateEstateRequest;
import com.example.mainPackage.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "estates/")
public class EstateController {


      private EstateService estateService;




      @Autowired
      public EstateController(EstateService estateService) {
            this.estateService = estateService;

      }



      @PostMapping(path = "add",consumes = "application/json",produces = "application/json")
      public Estate addEstate(@RequestBody AddEstateRequest addEstateRequest){


            return estateService.addEstate(addEstateRequest);


      }
      @GetMapping(path = "all",produces = "application/json")

      public List<Estate>available(){

           return estateService.availableEstates();

      }


      @GetMapping(path = "getByOwner",produces = "application/json")

      List<Estate>getByOwner(@RequestParam(name = "id") Long id){

            return estateService.getEstateByOwnerId(id);
      }


      @GetMapping(path = "getOneById",produces = "application/json")

            Estate getOneById(@RequestParam(name = "id") Long id){

            return estateService.getOneById(id);

      }


      @PutMapping(path = "update",consumes = "application/json",produces = "application/json")

            Estate editEstate(@RequestBody UpdateEstateRequest newEstate){


                  return estateService.updateEstate(newEstate);



      }

      @DeleteMapping(path = "delete")
            Estate deleteEstate(@RequestParam(name = "estate_id") Long estate_id,
                                @RequestParam(name = "owner_id") Long owner_id){

                  return estateService.deleteEstate(estate_id,owner_id);


      }


      @PostMapping(path = "sale",consumes = "application/json",produces = "application/json")

            Estate editEstate(@RequestBody SaleRequest request){

            return estateService.saleEstate(request);



      }


}
