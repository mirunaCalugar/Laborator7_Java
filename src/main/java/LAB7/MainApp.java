package LAB7;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MainApp {
    public static Map<Integer,Carte> citire() {
        ObjectMapper mapper=new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        try {
            File file=new File("src/main/carti.json");
            Map<Integer,Carte> carti= mapper
                    .readValue(file, new TypeReference<Map<Integer,Carte>>(){});
            return carti;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void scriere(Map<Integer,Carte> lista) {
        ObjectMapper mapper=new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        try {
            File file=new File("src/main/carti.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void afiseazaColecție(Map<Integer, Carte> colectieCarti) {
        System.out.println("Colecție de cărți:");
        colectieCarti.forEach((id, carte) -> System.out.println(id + ": " + carte));
        System.out.println();
    }
    public static void main(String[] args) {

        Map <Integer,Carte> carti=citire();

       // afiseazaColecție(carti);

        Scanner scanner=new Scanner(System.in);
        int optiune;
        do{
            System.out.println("Meniu:");
            System.out.println("1. Afisare colectie");
            System.out.println("2. Stergere carte ");
            System.out.println("3. Adaugare Carte");
            System.out.println("4. Salvare JSON");
            System.out.println("5. Creaza SET");
            System.out.println("6. Ordonat alfabetic");
            System.out.println("7. Cea mai veche carte");
            System.out.print("Alege o opțiune: ");
            optiune = scanner.nextInt();

            switch (optiune){
                case 1:
                    afiseazaColecție(carti);
                    break;
                case 2:
                    int id;
                    System.out.println("Alege id-ul cartii care va urma sa fie stearsa");
                    id=scanner.nextInt();
                    carti.remove(id);
                    afiseazaColecție(carti);
                    break;
                case 3:
                    String titluNou;
                    String autorulNou;
                    int anNou;
                    System.out.println("Titlul cartii introduse");
                    titluNou=scanner.next();
                    System.out.println("Autorul cartii introduse");
                   autorulNou=scanner.next();
                    System.out.println("Anul cartii introduse");
                    anNou=scanner.nextInt();
                    Carte carteNoua=new Carte(titluNou,autorulNou,anNou);
                    carti.putIfAbsent(7,carteNoua);

                    break;
                case 4:
                    scriere(carti);
                    afiseazaColecție(carti);
                    break;
                case 5:
                    Set<Carte> set_carte=carti.values()
                            .stream()
                            .filter(carte -> carte.autorul().equalsIgnoreCase("Yuval Noah Harari"))
                            .collect(Collectors.toSet());
                    set_carte.stream().forEach(System.out::println);
                    break;
                case 6:
                    Set<Carte> set_sortat= carti.values()
                            .stream()
                            .sorted(Comparator.comparing(Carte::titlul))
                            .collect(Collectors.toCollection(LinkedHashSet::new));
                    set_sortat.stream().forEach(System.out::println);
                    break;
                case 7:
                    var cea_mai_veche=carti.values()
                            .stream()
                            .min(Comparator.comparing(Carte::anul));
                    cea_mai_veche.ifPresent(System.out::println);
                    break;
                default:break;





            }
        }while(optiune!=8);

    }
}
