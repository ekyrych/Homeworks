package com.kyrychenko.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Arrays;

public class BeerMain {
    public static void main(String[] args) throws JAXBException {
        Beer beer = new Beer();
        beer.setName("Hoegarden");
        beer.setType(BeerType.LIGHT);
        beer.setAlcohol(true);
        beer.setManufacturer("Holland");

        BeerIngredient water = new BeerIngredient();
        water.setName("water");
        water.setAmount(2.0);
        BeerIngredient malt = new BeerIngredient();
        malt.setName("malt");
        malt.setAmount(0.1);

        BeerChars volume = new BeerChars();
        volume.setName("volume");
        volume.setValue("2L");

        beer.setIngredients(Arrays.asList(water,malt));
        beer.setChars(Arrays.asList(volume));


        JAXBContext jaxbContext = JAXBContext.newInstance(Beer.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(beer, new File("beer.xml"));
        marshaller.marshal(beer, System.out);

        File file = new File("beer.xml");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Beer beer1 = (Beer) unmarshaller.unmarshal(file);
        System.out.println(beer1);
    }
}
