package cz.czechitas.webapp;

import java.io.*;
import java.nio.charset.*;
import java.util.*;
import org.springframework.core.io.support.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HlavniController {

    /**
     * Metoda, která vytvoří stránku index.html a zobrazí ji
     * @return drzrakNaDataAJmenoStranky
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView zobrazIndex() {
        ModelAndView drzakNaDataAJmenoStarnky = new ModelAndView("index");

        List<Clovek> seznamBezdomovcu = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            if ((i == 2) || (i == 4) || (i == 5) || (i == 8))
                seznamBezdomovcu.add(new Clovek("man" + i, "images/obliceje/man" + i + ".jpg", true));
            else
                seznamBezdomovcu.add(new Clovek("man" + i, "images/obliceje/man" + i + ".jpg", false));
        }

        /*
        Kamilova metoda na nasypání obrázků do seznamu
        ResourcePatternResolver prohledavacSlozek = new PathMatchingResourcePatternResolver();
        Resource[] resources = prohledavacSlozek.getResources("classpath:/static/images/obliceje/*");

        souborySObliceji = new ArrayList<>(resources.length);
        for (Resource resource : resources) {
            souborySObliceji.add(resource.getFilename());
        }
        */

        drzakNaDataAJmenoStarnky.addObject("seznamBezdomovcu", seznamBezdomovcu);

        return drzakNaDataAJmenoStarnky;
    }

    /**
     * Metoda, která zpracuje odpovědi získané z odeslaného formuláře a vytoří stránku vysledky.html
     * @param vstup <cz.czechitas.webapp.IndexForm>
     * @return drzrakNaDataAJmenoStranky
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView zpracujIndex(IndexForm vstup) {
        ModelAndView drzakNaDataAJmenoStarnky = new ModelAndView("vysledky");

        int celkemSpravnychOdpovedi = 0;
        if (vstup.getMan1() == 2)
            celkemSpravnychOdpovedi++;
        if (vstup.getMan2() == 1)
            celkemSpravnychOdpovedi++;
        if (vstup.getMan3() == 2)
            celkemSpravnychOdpovedi++;
        if (vstup.getMan4() == 1)
            celkemSpravnychOdpovedi++;
        if (vstup.getMan5() == 1)
            celkemSpravnychOdpovedi++;
        if (vstup.getMan6() == 2)
            celkemSpravnychOdpovedi++;
        if (vstup.getMan7() == 2)
            celkemSpravnychOdpovedi++;
        if (vstup.getMan8() == 1)
            celkemSpravnychOdpovedi++;

        drzakNaDataAJmenoStarnky.addObject("pocetSpravnychOdpovedi", celkemSpravnychOdpovedi);
        return drzakNaDataAJmenoStarnky;
    }

}
