package starter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import starter.model.entity.Information;
import starter.model.service.ServiceDataBase;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RestController// это позволяет работать в формате Json . Тут можем написать общий ЮРЛ для всех эндпоинтов которые будут
@RequestMapping("/names")  // Общая площадка для всяких tanya  и  ivan  ,т.е. для всех эндпоинтов по дефолту
public class HelloMomController {

    private final ServiceDataBase serviceDataBase;
    private final GoogleSheetsController googleSheetsController;

    @Autowired
    public HelloMomController(ServiceDataBase serviceDataBase, GoogleSheetsController googleSheetsController) {
        this.googleSheetsController = googleSheetsController;
        this.serviceDataBase = serviceDataBase;
    }

    @GetMapping("/getstring") // это мой эндпоинт
    public String getTheString(@RequestParam(value = "string", required = false) String name) {

        Information information = new Information();
        information.setInfo(name);
        serviceDataBase.saveInformation(information);

        return "String: " + information.getInfo() + "  was successfully saved to DataBase";

        /*
        http://localhost:8080/names/ivan?name=RUS&hear=Pasha-GOOd   - это запрос в строке браузера
        hi, PashaRUS Pasha-GOOd  - это ответ прогрммы
         */
    }

    @GetMapping("/savetosheet") // это мой эндпоинт Сохрвняет в гугл таблицу
    public String saveToSheet() throws IOException, GeneralSecurityException {
        System.out.println(" from database");
        List<Information> myList = serviceDataBase.findAllFromDataBase();
        googleSheetsController.methodForUpdate("1H8XZkhUn_z10k-7RcWFQt3QEJ-llPwiI3Gx8t9wMOMQ", "A1", myList);
        return "String was successfully sent to GoogleSheets," +
                "\n <a href= \"https://docs.google.com/spreadsheets/d/1H8XZkhUn_z10k-7RcWFQt3QEJ-llPwiI3Gx8t9wMOMQ/edit#gid=0\">see the result</a>";
    }
}
