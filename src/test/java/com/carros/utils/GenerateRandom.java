package com.carros.utils;

import com.carros.domain.Carro;
import com.carros.domain.dto.CarroDTO;

import java.util.Random;

public class GenerateRandom {

    private Random random = new Random();

    public String generateRandomString() {
        return String.valueOf(random.nextLong());
    }

    public Carro buildRandomCarro(){
        return Carro.builder()
                .id(random.nextLong())
                .nome(generateRandomString())
                .tipo(generateRandomString())
                .descricao(generateRandomString())
                .urlFoto(generateRandomString())
                .urlVideo(generateRandomString())
                .latitude(generateRandomString())
                .longitude(generateRandomString())
                .build();
    }

    public CarroDTO buildRandomCarroDTO(){
        return CarroDTO.builder()
                .id(random.nextLong())
                .nome(generateRandomString())
                .tipo(generateRandomString())
                .descricao(generateRandomString())
                .urlFoto(generateRandomString())
                .urlVideo(generateRandomString())
                .latitude(generateRandomString())
                .longitude(generateRandomString())
                .build();
    }

}
