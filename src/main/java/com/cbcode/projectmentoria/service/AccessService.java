package com.cbcode.projectmentoria.service;

import com.cbcode.projectmentoria.model.Access;
import com.cbcode.projectmentoria.repository.AccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessService {

    @Autowired
    private AccessRepository accessRepository;

    public Access save(Access access) {
        /* TODO any type of validation*/

        return accessRepository.save(access);
    }
}
