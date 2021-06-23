package starter.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import starter.model.entity.Information;
import starter.model.repositories.InformationRepository;

import java.util.List;

@Service   // & @Component - создает объект данного класса в Спринге автоматически

public class ServiceDataBase {
    private InformationRepository informationRepository;

    @Autowired
    public ServiceDataBase(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }



    public void saveInformation (Information infoEntity){
        informationRepository.save(infoEntity);
    }
    public  List<Information> findAllFromDataBase () {
        System.out.println(informationRepository.findAll());
        return  informationRepository.findAll();

             }
}
