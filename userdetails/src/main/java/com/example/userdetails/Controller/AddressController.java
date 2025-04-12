package com.example.userdetails.Controller;

import com.example.userdetails.DTO.AddressDTO;
import com.example.userdetails.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("saveAddress")
    public ResponseEntity<AddressDTO> createAddress(@RequestBody AddressDTO addressDTO) {
        AddressDTO savedAddressDTO = addressService.createAddress(addressDTO);
        return ResponseEntity.ok(savedAddressDTO);
    }

    @GetMapping("city/{city}")
    public ResponseEntity<List<AddressDTO>> getUsersByCity(@PathVariable String city) {
        List<AddressDTO> addresses = addressService.getUsersByCity(city);
        return ResponseEntity.ok(addresses);
    }

    @PutMapping("updateAddress/{id}")
    public ResponseEntity<AddressDTO> updateAddress(@PathVariable int id, @RequestBody AddressDTO addressDTO) {
        AddressDTO updatedAddressDTO = addressService.updateAddress(id, addressDTO);
        return ResponseEntity.ok(updatedAddressDTO);
    }
}
