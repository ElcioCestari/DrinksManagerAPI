package com.elciocestari.drinksmanagerapi.service;

import com.elciocestari.drinksmanagerapi.entity.Drink;
import com.elciocestari.drinksmanagerapi.exception.DrinkNotFoundException;
import com.elciocestari.drinksmanagerapi.repository.DrinkRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DrinkServiceTest {

    @Mock
    private DrinkRepository drinkRepository;

    @InjectMocks
    private DrinkService drinkService;

    @Test
    public void testSaveADrink() {

        Drink expectedDrink = Drink.builder()
                .name("skoll")
                .capacity(200.00)
                .price(2.04)
                .build();

        when(drinkRepository.save(expectedDrink))
                .thenReturn(expectedDrink);

        Drink actualDrink = drinkService.save(expectedDrink);

        assertEquals(expectedDrink.getName(), actualDrink.getName());
    }

    //TODO - AINDA NAO ESTOU CONSIGUINDO TESTAR UM METODO
    // COM RETORNO VOID.
    // NESSE CASO POIS O METHOD ESTA LANÇANDO UMA EXCEPTION
    // ANTES DE EU PODER REALIZAR O TESTE
    @Deprecated(forRemoval = true)
    @Test
    public void testDeleteDrinkVerifyIfParameterIdIsOk(){

        Drink drinkToBeDeleted = Drink.builder()
                .id(1L)
                .name("skoll")
                .capacity(200.00)
                .price(2.04)
                .build();

        ArgumentCaptor<Long> idCaptor = ArgumentCaptor.forClass(Long.class);

        doAnswer(invocation -> {
            return null;
        }).when(drinkRepository).deleteById(idCaptor.capture());

        try {
            drinkService.delete(drinkToBeDeleted.getId());
        } catch (DrinkNotFoundException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

        assertEquals(drinkToBeDeleted.getId(), idCaptor.getValue());

    }

    @Test
    public void testDeleteDrinkWithANoneExistetDrink(){

        assertThrows(DrinkNotFoundException.class, () ->{
            drinkService.delete(1L);
        });
    }
}
