package crypto.middleware.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crypto.middleware.repositories.CryptoRepository;

@Service
public class CryptoService {
    @Autowired
    CryptoRepository cryptoRepository;

}
