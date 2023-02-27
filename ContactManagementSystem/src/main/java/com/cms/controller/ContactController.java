package com.cms.controller;

import com.cms.request.ContactRequestModel;
import com.cms.response.BaseApiResponse;
import com.cms.response.ContactFilterModel;
import com.cms.response.ResponseBuilder;
import com.cms.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService service;

    //--------Post API to create contact-----------//
    @PostMapping("/create")
    public ResponseEntity<BaseApiResponse> createContact(@RequestBody ContactRequestModel requestModel){
        BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(service.createContact(requestModel));
        return new ResponseEntity<>(baseApiResponse, HttpStatus.OK);
    }

    //--------Get API to get contact by id------------//
    @GetMapping("/getById")
    public ResponseEntity<BaseApiResponse> getContactById(@RequestParam Integer id){
        BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(service.getContactById(id));
        return new ResponseEntity<>(baseApiResponse, HttpStatus.OK);
    }

    //--------Get API to get contact by id------------//
    @PostMapping("/getAll")
    public ResponseEntity<BaseApiResponse> getAllContacts(@RequestBody ContactFilterModel filterModel,
                                                          @RequestParam Integer page, @RequestParam Integer size){
        BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(service.getAllContacts(filterModel,page,size));
        return new ResponseEntity<>(baseApiResponse, HttpStatus.OK);
    }

    //--------Put API to update contact-----------//
    @PutMapping("/update")
    public ResponseEntity<BaseApiResponse> updateContact(@RequestBody ContactRequestModel requestModel){
        BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(service.updateContact(requestModel));
        return new ResponseEntity<>(baseApiResponse, HttpStatus.OK);
    }

    //--------Delete API to delete contact-----------//
    @DeleteMapping("/delete")
    public ResponseEntity<BaseApiResponse> deleteContact(@RequestParam Integer id){
        BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(service.deleteContact(id));
        return new ResponseEntity<>(baseApiResponse, HttpStatus.OK);
    }
}
