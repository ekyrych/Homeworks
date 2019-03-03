package com.kyrychenko.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;

public class BeerMain {
    public static void main(String[] args) throws  IOException {
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

        ObjectMapper mapper = new ObjectMapper();
        JsonSchemaGenerator generator = new JsonSchemaGenerator(mapper);
        JsonSchema jsonSchema = generator.generateSchema(Beer.class);

        mapper.writeValue(new File("beer-schema.json"),jsonSchema);
        mapper.writeValue(new File("beer.json"),beer);

        JSONObject jsonSchemaFromFile = new JSONObject(
                new JSONTokener(BeerMain.class.getResourceAsStream("/beer-schema.json")));
        JSONObject jsonSubject = new JSONObject(
                new JSONTokener(BeerMain.class.getResourceAsStream("/beer.json")));

        Schema schema = SchemaLoader.load(jsonSchemaFromFile);
        try {
            schema.validate(jsonSubject);
        }catch (ValidationException ex){
            System.out.println(ex.getMessage());
        }

    }
}
