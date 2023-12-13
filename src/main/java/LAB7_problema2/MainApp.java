package LAB7_problema2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainApp {
    public static Set<InstrumentMuzical> citire() {
        ObjectMapper mapper=new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
        try {
            File file=new File("src/main/instrumente.json");
            Set<InstrumentMuzical> carti= mapper
                    .readValue(file, new TypeReference<HashSet<InstrumentMuzical>>(){});
            return carti;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void scriere(Set<InstrumentMuzical> lista) {
        ObjectMapper mapper=new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
        try {
            File file=new File("src/main/instrumente.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
//        Set<InstrumentMuzical> instrumente= new HashSet<>( List.of(
//                new Chitara("Fender", 1000, TipChitara.ACUSTICA,6),
//                new Chitara("Ibanez",2000, TipChitara.CLASICA,12),
//                new Chitara("Fender", 1500, TipChitara.ELECTRICA, 12),
//                new SetTobe("Yamaha", 5000, TipTobe.ACUSTICE,12,12 ),
//                new SetTobe("Gewa", 4500, TipTobe.ELECTRONICE,6,8 ),
//                new SetTobe("Sonor", 6000, TipTobe.ACUSTICE,20,4 )
//        ));
        //scriere(instrumente);
//        Set<InstrumentMuzical> instrumente=citire();
//        System.out.println(instrumente);

    }
}
