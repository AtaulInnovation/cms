package com.cms.service;

import com.cms.constants.AppConstants;
import com.cms.entity.Contact;
import com.cms.exception.ContactException;
import com.cms.repository.ContactRepository;
import com.cms.request.ContactRequestModel;
import com.cms.response.ContactFilterModel;
import com.cms.response.ContactResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    //------Method to create contact----------//

    public Object createContact(ContactRequestModel requestModel) {
        contactRepository.save(Contact.builder().firstName(requestModel.getFirstName())
                .lastName(requestModel.getLastName()).email(requestModel.getEmail())
                .phoneNumber(requestModel.getPhoneNumber()).active(true).build());

        return "Contact has been created successfully";
    }

    //---------Method to get contact response model by contact id------//

    public ContactResponseModel getContactById(Integer id) {
        return convertToResponseModel(findContact(id));
    }

    //---------Method to get contact by id------//

    public Contact findContact(Integer id){
        if(id==null){
            throw new ContactException(AppConstants.ErrorTypes.INVALID_INPUT_ERROR,
                    AppConstants.ErrorCodes.INVALID_INPUT_ERROR_CODE,
                    AppConstants.ErrorMessages.INVALID_NULL_ID);
        }
        return contactRepository.findById(id).orElseThrow(() -> new ContactException(
                AppConstants.ErrorTypes.CONTACT_NOT_FOUND_ERROR,
                AppConstants.ErrorCodes.CONTACT_NOT_FOUND_ERROR_CODE,
                AppConstants.ErrorMessages.CONTACT_NOT_FOUND));
    }


    //-----------Method to convert Contact Entity to Contact Response Model---------//

    public ContactResponseModel convertToResponseModel(Contact contact){
        return ContactResponseModel.builder().id(contact.getId()).firstName(contact.getFirstName())
                .lastName(contact.getLastName()).email(contact.getEmail())
                .phoneNumber(contact.getPhoneNumber()).build();
    }


    //--------Method to get list of contacts with aur without filter------------//

    public List<ContactResponseModel> getAllContacts(ContactFilterModel filterModel, Integer page, Integer size) {
        List<String> firstName = Collections.singletonList(filterModel.getFirstName());

        List<String> lastName = Collections.singletonList(filterModel.getLastName());

        List<String> email = Collections.singletonList(filterModel.getEmail());

        List<Contact> contacts = contactRepository.findContactsByFilter(firstName, lastName, email, PageRequest.of(page,size));
        if(contacts.isEmpty()){
            throw new ContactException(AppConstants.ErrorTypes.CONTACT_NOT_FOUND_ERROR,
                    AppConstants.ErrorCodes.CONTACT_NOT_FOUND_ERROR_CODE,
                    AppConstants.ErrorMessages.NO_ANY_CONTACT_FOUND);
        }
        return contacts.stream().map(this::convertToResponseModel).collect(Collectors.toList());
    }

    //----------Method to update a contact----------//

    public ContactResponseModel updateContact(ContactRequestModel requestModel) {
        Contact contact = findContact(requestModel.getId());
        contact.setFirstName(requestModel.getFirstName());
        contact.setLastName(requestModel.getLastName());
        contact.setEmail(requestModel.getEmail());
        contact.setPhoneNumber(requestModel.getPhoneNumber());
        return convertToResponseModel(contactRepository.save(contact));
    }


    //-------Method to delete a contact by id---------//

    public Object deleteContact(Integer id) {
        contactRepository.delete(findContact(id));
        return "Contact has been deleted successfully";
    }
}
