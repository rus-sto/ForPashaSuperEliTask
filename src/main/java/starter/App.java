package starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
  "поднять REST сервис (он же сервер), на джава спринг, соблюдая структуру MVС,
отправить на эндпоинт строку=String,
сервер сохраняет эту строку в базу данных PostgresSQL
по запросу на другой эндпоинт - записывает строку из базы данных в гугл табличку"
   */
@SpringBootApplication

public class App {

//    private   final  ServiceDataBase serviceDataBase;

    //   @Autowired   //это dependency injection  -  внедряем в класс App - serviceDataBase
    // (т.е. все его зависимости и возможности. Иными словамт мы привязываем
    // Объект serviceDataBase созданный в Springе к нашей ссылке в классе App serviceDataBase

    //    public App(ServiceDataBase serviceDataBase) {
//        this.serviceDataBase = serviceDataBase;
//    }
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
