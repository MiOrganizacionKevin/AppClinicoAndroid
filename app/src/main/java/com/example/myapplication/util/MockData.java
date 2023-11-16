package com.example.myapplication.util;

import com.example.myapplication.model.Doctor;
import com.example.myapplication.model.DoctorSpeciality;
import com.example.myapplication.model.FechaDiponibleEspecialidad;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MockData {

    public List<Doctor> getDoctoresDisponibles() {

        List<Doctor> listaDoctores = new ArrayList<>();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());


        try {
            String dateTimeDocto1 = "2023-10-11 13:00:00";
            String dateTimeDocto2 = "2023-10-11 15:00:00";
            String dateTimeDocto3 = "2023-10-11 16:00:00";
            String dateTimeDocto4 = "2023-10-11 18:00:00";
            String dateTimeDocto5 = "2023-10-11 20:00:00";

            Doctor mockDoctor1 = new Doctor(
                    "0011",
                    "Gallegos Santos",
                    "Activado",
                    "https://yt3.googleusercontent.com/YEJg4I4uBXLCtWiSek8LRh5KOLOIuajqbN8eIcg-KOJya9NE0SF85lURgekn0c0tt9RTcQ8ifg=s900-c-k-c0x00ffffff-no-rj",
                    (new DoctorSpeciality("", "Medicina General", "activado")),
                    new ArrayList<>(List.of(
                            new FechaDiponibleEspecialidad("", formatter.parse(dateTimeDocto3)),
                            new FechaDiponibleEspecialidad("", formatter.parse(dateTimeDocto4))
                        )
                    )
            );

            Doctor mockDoctor2 = new Doctor(
                    "0022",
                    "Vanessa García",
                    "Activado",
                    "https://img.freepik.com/fotos-gratis/trabalhadores-de-saude-previnem-o-conceito-de-virus-seguro-e-medicina-sorridente-e-atraente-medica-ou-enfermeira-de-uniforme-azul-apontando-os-dedos-para-a-esquerda-para-mostrar-anuncios-aos-pacientes-informacoes-importantes_1258-57267.jpg?w=2000",
                    (new DoctorSpeciality("", "Medicina General", "activado")),
                    new ArrayList<>(List.of(
                            new FechaDiponibleEspecialidad("", formatter.parse(dateTimeDocto1)),
                            new FechaDiponibleEspecialidad("", formatter.parse(dateTimeDocto2)),
                            new FechaDiponibleEspecialidad("", formatter.parse(dateTimeDocto3)),
                            new FechaDiponibleEspecialidad("", formatter.parse(dateTimeDocto4)),
                            new FechaDiponibleEspecialidad("", formatter.parse(dateTimeDocto5))
                        )
                    )
            );

            Doctor mockDoctor3 = new Doctor(
                    "0033",
                    "Steven López",
                    "Activado",
                    "https://cdn.euroinnova.edu.es/img/subidasEditor/doctor-5871743_640-1610073541.webp",
                    (new DoctorSpeciality("", "Medicina General", "activado")),
                    new ArrayList<>(List.of(
                            new FechaDiponibleEspecialidad("", formatter.parse(dateTimeDocto1)),
                            new FechaDiponibleEspecialidad("", formatter.parse(dateTimeDocto3)),
                            new FechaDiponibleEspecialidad("", formatter.parse(dateTimeDocto4)),
                            new FechaDiponibleEspecialidad("", formatter.parse(dateTimeDocto5))
                    )
                    )
            );

            listaDoctores.add(mockDoctor1);
            listaDoctores.add(mockDoctor2);
            listaDoctores.add(mockDoctor3);
            listaDoctores.add(mockDoctor2);
            listaDoctores.add(mockDoctor1);

            return listaDoctores;

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
